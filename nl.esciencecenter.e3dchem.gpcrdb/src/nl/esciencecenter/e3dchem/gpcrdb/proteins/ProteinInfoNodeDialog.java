package nl.esciencecenter.e3dchem.gpcrdb.proteins;

import org.knime.core.data.StringValue;
import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;
import org.knime.core.node.defaultnodesettings.DialogComponentColumnNameSelection;
import org.knime.core.node.defaultnodesettings.DialogComponentString;
import org.knime.core.node.defaultnodesettings.DialogComponentStringSelection;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

/**
 * <code>NodeDialog</code> for the "StructuresOfProtein" Node. Get a list of
 * structures of a protein
 *
 * This node dialog derives from {@link DefaultNodeSettingsPane} which allows
 * creation of a simple dialog with standard components. If you need a more
 * complex dialog please derive directly from
 * {@link org.knime.core.node.NodeDialogPane}.
 * 
 */
public class ProteinInfoNodeDialog extends DefaultNodeSettingsPane {

	/**
	 * New pane for configuring StructuresOfProtein node dialog. This is just a
	 * suggestion to demonstrate possible default dialog components.
	 */
	protected ProteinInfoNodeDialog() {
		super();

		addDialogComponent(new DialogComponentColumnNameSelection(
				new SettingsModelString(ProteinInfoNodeModel.CFGKEY_INPUTCOLUMNNAME, null), "Column with identifiers",
				0, StringValue.class));

		addDialogComponent(new DialogComponentStringSelection(ProteinInfoNodeModel.getIdentifierType(),
				"Type of identifier", ProteinInfoNodeModel.LIST_IDENTIFIERTYPES));

		createNewTab("Advanced");

		addDialogComponent(new DialogComponentString(
				new SettingsModelString(ProteinInfoNodeModel.CFGKEY_BASEPATH, ProteinInfoNodeModel.DEFAULT_BASEPATH),
				"Base path"));

	}
}
