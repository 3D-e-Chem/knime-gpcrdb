package nl.esciencecenter.e3dchem.gpcrdb;

import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeModel;
import org.knime.core.node.NodeSettingsRO;
import org.knime.core.node.NodeSettingsWO;
import org.knime.core.node.defaultnodesettings.SettingsModelInteger;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

import nl.esciencecenter.e3dchem.gpcrdb.client.ApiClient;
import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;

public abstract class GpcrdbNodeModel extends NodeModel {

	public static final String CFGKEY_BASEPATH = "Base path";
	public static final String DEFAULT_BASEPATH = "http://gpcrdb.org/";
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
}
