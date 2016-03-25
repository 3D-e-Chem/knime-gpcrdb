package nl.esciencecenter.e3dchem.gpcrdb.structures;

import org.knime.core.data.StringValue;
import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;
import org.knime.core.node.defaultnodesettings.DialogComponentColumnNameSelection;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

import nl.esciencecenter.e3dchem.gpcrdb.GpcrdbNodeDialog;

/**
 * <code>NodeDialog</code> for the "Interactions" Node. Get a list of interactions between structure and ligand.
 *
 * This node dialog derives from {@link DefaultNodeSettingsPane} which allows
 * creation of a simple dialog with standard components. If you need a more
 * complex dialog please derive directly from
 * {@link org.knime.core.node.NodeDialogPane}.
 * 
 */
public class InteractionsNodeDialog extends GpcrdbNodeDialog {

	/**
	 * New pane for configuring StructuresOfProtein node dialog. This is just a
	 * suggestion to demonstrate possible default dialog components.
	 */
	protected InteractionsNodeDialog() {
		super();

		addDialogComponent(new DialogComponentColumnNameSelection(
				new SettingsModelString(InteractionsNodeModel.CFGKEY_INPUTSTRUCTURECOLUMNNAME, null),
				"Column with PDB identifiers", 0, StringValue.class));

		addDialogComponent(new DialogComponentColumnNameSelection(
				new SettingsModelString(InteractionsNodeModel.CFGKEY_INPUTLIGANDCOLUMNNAME, null),
				"Column with ligand names", 0, StringValue.class));

		createNewTab("Advanced");

		addBasePath();
	}
}
