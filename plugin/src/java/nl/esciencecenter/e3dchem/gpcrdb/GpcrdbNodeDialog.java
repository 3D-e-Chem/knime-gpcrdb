package nl.esciencecenter.e3dchem.gpcrdb;

import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;
import org.knime.core.node.defaultnodesettings.DialogComponentNumber;
import org.knime.core.node.defaultnodesettings.DialogComponentString;
import org.knime.core.node.defaultnodesettings.SettingsModelInteger;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

public class GpcrdbNodeDialog extends DefaultNodeSettingsPane {
	private SettingsModelString basePath = GpcrdbNodeModel.basePathSettings();
	private SettingsModelInteger timeout = GpcrdbNodeModel.timeoutSettings();
	
	protected void addAdvancedSettings() {
		addDialogComponent(new DialogComponentString(basePath, "Base path"));
		addDialogComponent(new DialogComponentNumber(timeout, "Timeout (s)", 1));
	}
}
