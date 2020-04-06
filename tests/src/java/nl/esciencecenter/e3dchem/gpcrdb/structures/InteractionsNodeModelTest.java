package nl.esciencecenter.e3dchem.gpcrdb.structures;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.knime.core.data.DataRow;
import org.knime.core.data.MissingCell;
import org.knime.core.data.RowKey;
import org.knime.core.data.def.DefaultRow;
import org.knime.core.data.def.LongCell;
import org.knime.core.data.def.StringCell;
import org.knime.core.node.BufferedDataContainer;

import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesstructureApi;
import nl.esciencecenter.e3dchem.gpcrdb.client.model.StructureLigandInteractionSerializer;

public class InteractionsNodeModelTest {

    @Test
    public void testFetchInteractions_filled() throws ApiException {
        String pdbCode = "3EML";
        InteractionsNodeModel model = new InteractionsNodeModel();
        ServicesstructureApi service = mock(ServicesstructureApi.class);
        List<StructureLigandInteractionSerializer> response = getSampleInteractions();
        when(service.structureLigandInteractionsGET(pdbCode)).thenReturn(response);
        model.setService(service);
        BufferedDataContainer container = mock(BufferedDataContainer.class);
        // https://gpcrdb.org/interaction/3EML
        // ZM 241385 L85 3.33x33 TM3 hydrophobic

        model.fetchInteractions(container, pdbCode);

        DataRow expectedRow = new DefaultRow(RowKey.createRowKey(0L), new StringCell("3EML"), new StringCell("ZM 241385"),
                new LongCell(85L), new StringCell("L"), new StringCell("3.33x33"), new StringCell("hydrophobic"));
        verify(container).addRowToTable(expectedRow);
    }
    
    @Test
    public void testFetchInteractions_filled_lowercase() throws ApiException {
        String pdbCode = "3eml";
        InteractionsNodeModel model = new InteractionsNodeModel();
        ServicesstructureApi service = mock(ServicesstructureApi.class);
        List<StructureLigandInteractionSerializer> response = getSampleInteractions();
        when(service.structureLigandInteractionsGET("3EML")).thenReturn(response);
        model.setService(service);
        BufferedDataContainer container = mock(BufferedDataContainer.class);
        // https://gpcrdb.org/interaction/3EML
        // ZM 241385 L85 3.33x33 TM3 hydrophobic

        model.fetchInteractions(container, pdbCode);

        DataRow expectedRow = new DefaultRow(RowKey.createRowKey(0L), new StringCell("3EML"), new StringCell("ZM 241385"),
                new LongCell(85L), new StringCell("L"), new StringCell("3.33x33"), new StringCell("hydrophobic"));
        verify(container).addRowToTable(expectedRow);
    }

    private List<StructureLigandInteractionSerializer> getSampleInteractions() {
        List<StructureLigandInteractionSerializer> response = new ArrayList<StructureLigandInteractionSerializer>();
        // {
        // "pdb_code": "3EML",
        // "ligand_name": "ZM 241385",
        // "amino_acid": "L",
        // "sequence_number": 85,
        // "display_generic_number": "3.33x33",
        // "interaction_type": "accessible"
        // },
        StructureLigandInteractionSerializer interaction = new StructureLigandInteractionSerializer();
        interaction.setPdbCode("3EML");
        interaction.setLigandName("ZM 241385");
        interaction.setSequenceNumber(85);
        interaction.setAminoAcid("L");
        interaction.setDisplayGenericNumber("3.33x33");
        interaction.setInteractionType("hydrophobic");
        response.add(interaction);
        return response;
    }

    @Test
    public void testFetchInteractions_nogeneric_missingcell() throws ApiException {
        String pdbCode = "3EML";
        InteractionsNodeModel model = new InteractionsNodeModel();
        ServicesstructureApi service = mock(ServicesstructureApi.class);
        List<StructureLigandInteractionSerializer> response = getSampleNoGenericInteractions();
        when(service.structureLigandInteractionsGET(pdbCode)).thenReturn(response);
        model.setService(service);
        BufferedDataContainer container = mock(BufferedDataContainer.class);
        // https://gpcrdb.org/interaction/3EML
        // ZM 241385    H264            ECL3    aromatic (face-to-edge)

        model.fetchInteractions(container, pdbCode);

        DataRow expectedRow = new DefaultRow(RowKey.createRowKey(0L), new StringCell(pdbCode), new StringCell("ZM 241385"),
                new LongCell(264L), new StringCell("H"), new MissingCell("Position has no generic number"),
                new StringCell("aromatic (face-to-face)"));
        verify(container).addRowToTable(expectedRow);
    }

    private List<StructureLigandInteractionSerializer> getSampleNoGenericInteractions() {
        List<StructureLigandInteractionSerializer> response = new ArrayList<StructureLigandInteractionSerializer>();
        // {
        // "pdb_code": "3EML",
        // "ligand_name": "ZM 241385",
        // "amino_acid": "F",
        // "sequence_number": 168,
        // "display_generic_number": null,
        // "interaction_type": "accessible"
        // },
        StructureLigandInteractionSerializer interaction = new StructureLigandInteractionSerializer();
        interaction.setPdbCode("3EML");
        interaction.setLigandName("ZM 241385");
        interaction.setSequenceNumber(264);
        interaction.setAminoAcid("H");
        interaction.setDisplayGenericNumber(null);
        interaction.setInteractionType("aromatic (face-to-face)");
        response.add(interaction);
        return response;
    }
}
