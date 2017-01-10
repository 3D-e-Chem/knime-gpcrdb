package nl.esciencecenter.e3dchem.gpcrdb.mutants;

import org.knime.core.data.StringValue;
import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;
import org.knime.core.node.defaultnodesettings.DialogComponentColumnNameSelection;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

import nl.esciencecenter.e3dchem.gpcrdb.GpcrdbNodeDialog;

/**
 * <code>NodeDialog</code> for the "Mutants" Node. Get a list of
 * mutants of a protein
 *
 * This node dialog derives from {@link DefaultNodeSettingsPane} which allows
 * creation of a simple dialog with standard components. If you need a more
 * complex dialog please derive directly from
 * {@link org.knime.core.node.NodeDialogPane}.
 * 
 */
public class MutantsNodeDialog extends GpcrdbNodeDialog {

	/**
	 * New pane for configuring Mutants node dialog. This is just a
	 * suggestion to demonstrate possible default dialog components.
	 */
	protected MutantsNodeDialog() {
		super();

		addDialogComponent(new DialogComponentColumnNameSelection(
				new SettingsModelString(MutantsNodeModel.CFGKEY_INPUTCOLUMNNAME, null),
				"Column with Uniprot identifiers", 0, StringValue.class));

		createNewTab("Advanced");

		addAdvancedSettings();
	}
}
