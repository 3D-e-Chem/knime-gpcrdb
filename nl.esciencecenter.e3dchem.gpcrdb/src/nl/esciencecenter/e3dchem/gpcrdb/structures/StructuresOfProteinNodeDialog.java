package nl.esciencecenter.e3dchem.gpcrdb;

import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;
import org.knime.core.node.defaultnodesettings.DialogComponentNumber;
import org.knime.core.node.defaultnodesettings.SettingsModelIntegerBounded;

/**
 * <code>NodeDialog</code> for the "StructuresOfProtein" Node.
 * Get a list of structures of a protein
 *
 * This node dialog derives from {@link DefaultNodeSettingsPane} which allows
 * creation of a simple dialog with standard components. If you need a more 
 * complex dialog please derive directly from 
 * {@link org.knime.core.node.NodeDialogPane}.
 * 
 * @author Stefan Verhoeven
 */
public class StructuresOfProteinNodeDialog extends DefaultNodeSettingsPane {

    /**
     * New pane for configuring StructuresOfProtein node dialog.
     * This is just a suggestion to demonstrate possible default dialog
     * components.
     */
    protected StructuresOfProteinNodeDialog() {
        super();
        
        addDialogComponent(new DialogComponentNumber(
                new SettingsModelIntegerBounded(
                    StructuresOfProteinNodeModel.CFGKEY_COUNT,
                    StructuresOfProteinNodeModel.DEFAULT_COUNT,
                    Integer.MIN_VALUE, Integer.MAX_VALUE),
                    "Counter:", /*step*/ 1, /*componentwidth*/ 5));
                    
    }
}

