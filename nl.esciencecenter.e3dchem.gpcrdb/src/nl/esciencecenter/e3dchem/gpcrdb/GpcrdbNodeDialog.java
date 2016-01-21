package nl.esciencecenter.e3dchem.gpcrdb;

import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;
import org.knime.core.node.defaultnodesettings.DialogComponentString;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

public class GpcrdbNodeDialog extends DefaultNodeSettingsPane {
	private SettingsModelString basePath = GpcrdbNodeModel.basePathSettings();
	
	protected void addBasePath() {
		addDialogComponent(new DialogComponentString(basePath, "Base path"));
	}
}
