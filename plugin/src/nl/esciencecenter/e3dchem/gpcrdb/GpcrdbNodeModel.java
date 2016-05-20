package nl.esciencecenter.e3dchem.gpcrdb;

import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeModel;
import org.knime.core.node.NodeSettingsRO;
import org.knime.core.node.NodeSettingsWO;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

import nl.esciencecenter.e3dchem.gpcrdb.client.ApiClient;


public abstract class GpcrdbNodeModel extends NodeModel {

	static final String CFGKEY_BASEPATH = "Base path";

	static final String DEFAULT_BASEPATH = "http://gpcrdb.org/";

	private final SettingsModelString m_basePath = basePathSettings();

	private ApiClient apiClient;

	public static SettingsModelString basePathSettings() {
		return new SettingsModelString(CFGKEY_BASEPATH,	DEFAULT_BASEPATH);
	}
	
	protected GpcrdbNodeModel(int nrInDataPorts, int nrOutDataPorts) {
		super(nrInDataPorts, nrOutDataPorts);
		apiClient = new ApiClient();
		apiClient.setBasePath(m_basePath.getStringValue());
		apiClient.addDefaultHeader("Accept", "application/json");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void saveSettingsTo(final NodeSettingsWO settings) {
		m_basePath.saveSettingsTo(settings);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void loadValidatedSettingsFrom(final NodeSettingsRO settings) throws InvalidSettingsException {
		m_basePath.loadSettingsFrom(settings);
		apiClient.setBasePath(m_basePath.getStringValue());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void validateSettings(final NodeSettingsRO settings) throws InvalidSettingsException {
		m_basePath.validateSettings(settings);
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
	}
}


