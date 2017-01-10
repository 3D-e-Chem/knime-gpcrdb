package nl.esciencecenter.e3dchem.gpcrdb.proteinfamilies;

import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;

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
public class ProteinFamiliesNodeDialog extends GpcrdbNodeDialog {
	/**
	 * New pane for configuring StructuresOfProtein node dialog. This is just a
	 * suggestion to demonstrate possible default dialog components.
	 */
	protected ProteinFamiliesNodeDialog() {
		super();

		addAdvancedSettings();
		
	}
}
