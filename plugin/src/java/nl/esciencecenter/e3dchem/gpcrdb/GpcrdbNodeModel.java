package nl.esciencecenter.e3dchem.gpcrdb;

import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

import org.knime.core.node.CanceledExecutionException;
import org.knime.core.node.ExecutionMonitor;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeModel;
import org.knime.core.node.NodeSettingsRO;
import org.knime.core.node.NodeSettingsWO;
import org.knime.core.node.defaultnodesettings.SettingsModelInteger;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

import static java.net.HttpURLConnection.HTTP_NOT_FOUND;

import java.io.File;
import java.io.IOException;

import nl.esciencecenter.e3dchem.gpcrdb.client.ApiClient;
import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;

public abstract class GpcrdbNodeModel extends NodeModel {

	public static final String CFGKEY_BASEPATH = "Base path";
	public static final String DEFAULT_BASEPATH = "https://gpcrdb.org";
	private final SettingsModelString m_basePath = basePathSettings();

	public static final String CFGKEY_TIMEOUT = "Timeout";
	public static final int DEFAULT_TIMEOUT = 10;
	private final SettingsModelInteger m_timeout = timeoutSettings();

	private ApiClient apiClient;

	public static SettingsModelString basePathSettings() {
		return new SettingsModelString(CFGKEY_BASEPATH, DEFAULT_BASEPATH);
	}

	public static SettingsModelInteger timeoutSettings() {
		return new SettingsModelInteger(CFGKEY_TIMEOUT, DEFAULT_TIMEOUT);
	}

	protected GpcrdbNodeModel(int nrInDataPorts, int nrOutDataPorts) {
		super(nrInDataPorts, nrOutDataPorts);
		apiClient = new ApiClient();
		apiClient.setBasePath(m_basePath.getStringValue());
		apiClient.addDefaultHeader("Accept", "application/json");
		updateHttpClientTimeout();
	}

	private void updateHttpClientTimeout() {
		apiClient.getHttpClient().setConnectTimeout(m_timeout.getIntValue(), TimeUnit.SECONDS);
		apiClient.getHttpClient().setReadTimeout(m_timeout.getIntValue(), TimeUnit.SECONDS);
		apiClient.getHttpClient().setWriteTimeout(m_timeout.getIntValue(), TimeUnit.SECONDS);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void saveSettingsTo(final NodeSettingsWO settings) {
		m_basePath.saveSettingsTo(settings);
		m_timeout.saveSettingsTo(settings);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void loadValidatedSettingsFrom(final NodeSettingsRO settings) throws InvalidSettingsException {
		m_basePath.loadSettingsFrom(settings);
		apiClient.setBasePath(m_basePath.getStringValue());
		if (settings.containsKey(CFGKEY_TIMEOUT)) {
			m_timeout.loadSettingsFrom(settings);
		} else {
			// timeout setting was added later,
			// to not get warnings when a old workflow is loaded which is missing the timeout setting
			// set it to a default
			m_timeout.setIntValue(DEFAULT_TIMEOUT);
		}
		updateHttpClientTimeout();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void validateSettings(final NodeSettingsRO settings) throws InvalidSettingsException {
		m_basePath.validateSettings(settings);
		m_timeout.validateSettings(settings);
	}

	protected void handleApiException(ApiException e, String thing) throws ApiException {
		Throwable cause = e.getCause();
		if (e.getCode() == HTTP_NOT_FOUND) {
			throw new ApiException("Item '" + thing + "' could not be found on GPCRDB server, please check if item is correct");
		}
		if (cause == null) {
			throw e;
		}
		if (cause instanceof SocketTimeoutException) {
			throw new ApiException("GPCRDB webservice server timed out: Increase timeout in advanced tab of options dialog or try again later when server is less busy");
		}
		throw e;
	}

	public ApiClient getApiClient() {
		return apiClient;
	}

	public void setApiClient(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public String getBasePath() {
		return m_basePath.getStringValue();
	}

	public void setBasePath(String basePath) {
		m_basePath.setStringValue(basePath);
		apiClient.setBasePath(m_basePath.getStringValue());
	}

	public int getTimeout() {
		return m_timeout.getIntValue();
	}

	public void setTimeout(int timeout) {
		m_timeout.setIntValue(timeout);
		updateHttpClientTimeout();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void reset() {
		// TODO Code executed on reset.
		// Models build during execute are cleared here.
		// Also data handled in load/saveInternals will be erased here.
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void loadInternals(final File internDir, final ExecutionMonitor exec)
			throws IOException, CanceledExecutionException {

		// TODO load internal data.
		// Everything handed to output ports is loaded automatically (data
		// returned by the execute method, models loaded in loadModelContent,
		// and user settings set through loadSettingsFrom - is all taken care
		// of). Load here only the other internals that need to be restored
		// (e.g. data used by the views).

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void saveInternals(final File internDir, final ExecutionMonitor exec)
			throws IOException, CanceledExecutionException {

		// TODO save internal models.
		// Everything written to output ports is saved automatically (data
		// returned by the execute method, models saved in the saveModelContent,
		// and user settings saved through saveSettingsTo - is all taken care
		// of). Save here only the other internals that need to be preserved
		// (e.g. data used by the views).

	}
}
