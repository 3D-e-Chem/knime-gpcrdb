package nl.esciencecenter.e3dchem.gpcrdb.proteins;

import java.util.Arrays;

import org.knime.core.data.StringValue;
import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;
import org.knime.core.node.defaultnodesettings.DialogComponentColumnNameSelection;
import org.knime.core.node.defaultnodesettings.DialogComponentNumber;
import org.knime.core.node.defaultnodesettings.DialogComponentStringListSelection;
import org.knime.core.node.defaultnodesettings.SettingsModelIntegerBounded;
import org.knime.core.node.defaultnodesettings.SettingsModelString;
import org.knime.core.node.defaultnodesettings.SettingsModelStringArray;

import nl.esciencecenter.e3dchem.gpcrdb.GpcrdbNodeDialog;

/**
 * <code>NodeDialog</code> for the "StructuresOfProtein" Node. Get a list of structures of a protein
 *
 * This node dialog derives from {@link DefaultNodeSettingsPane} which allows creation of a simple dialog with standard
 * components. If you need a more complex dialog please derive directly from {@link org.knime.core.node.NodeDialogPane}.
 * 
 */
public class ProteinSimilarityNodeDialog extends GpcrdbNodeDialog {
    private static final String[] segment_choices = new String[] {
            // Helix
            "TM1", "TM2", "TM3", "TM4", "TM5", "TM6", "TM7", "H8",
            // Loop
            "ICL1", "ECL1", "ICL2", "ECL2", "ICL3", "ECL3", "ICL4",
            // Terminus
            "C-term", "N-term" };

    /**
     * New pane for configuring StructuresOfProtein node dialog. This is just a suggestion to demonstrate possible default dialog
     * components.
     */
    protected ProteinSimilarityNodeDialog() {
        super();

        addDialogComponent(new DialogComponentColumnNameSelection(
                new SettingsModelString(ProteinSimilarityNodeModel.CFGKEY_INCOLUMNNAME, null), "Column with Uniprot identifiers",
                0, StringValue.class));

        addDialogComponent(new DialogComponentStringListSelection(
                new SettingsModelStringArray(ProteinSimilarityNodeModel.CFGKEY_SEGMENTS, null), "Column with Segment identifiers",
                Arrays.asList(segment_choices), true, segment_choices.length));

        createNewTab("Advanced");

        addDialogComponent(new DialogComponentNumber(
                new SettingsModelIntegerBounded(ProteinSimilarityNodeModel.CFGKEY_CHUNKSIZE, 20, 1, 100), "Chunk Size", 1));

        addBasePath();
    }
}
