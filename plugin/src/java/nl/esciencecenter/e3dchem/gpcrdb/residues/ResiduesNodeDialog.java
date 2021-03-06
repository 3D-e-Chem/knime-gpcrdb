package nl.esciencecenter.e3dchem.gpcrdb.residues;

import org.knime.core.data.StringValue;
import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;
import org.knime.core.node.defaultnodesettings.DialogComponentBoolean;
import org.knime.core.node.defaultnodesettings.DialogComponentColumnNameSelection;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

import nl.esciencecenter.e3dchem.gpcrdb.GpcrdbNodeDialog;

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
public class ResiduesNodeDialog extends GpcrdbNodeDialog {

	/**
	 * New pane for configuring StructuresOfProtein node dialog. This is just a
	 * suggestion to demonstrate possible default dialog components.
	 */
	protected ResiduesNodeDialog() {
		super();

		addDialogComponent(new DialogComponentColumnNameSelection(
				new SettingsModelString(ResiduesNodeModel.CFGKEY_INPUTCOLUMNNAME, null),
				"Column with Uniprot identifiers", 0, StringValue.class));

		addDialogComponent(
				new DialogComponentBoolean(ResiduesNodeModel.createExtendedModel(), "Include alternative numbers"));

		createNewTab("Advanced");

		addAdvancedSettings();
	}
}
