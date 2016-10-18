package nl.esciencecenter.e3dchem.gpcrdb.structures;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.knime.core.data.DataCell;
import org.knime.core.data.DataRow;
import org.knime.core.data.MissingCell;
import org.knime.core.data.RowKey;
import org.knime.core.data.def.DefaultRow;
import org.knime.core.data.def.DoubleCell;
import org.knime.core.data.def.StringCell;
import org.knime.core.data.json.JSONCellFactory;
import org.knime.core.node.BufferedDataContainer;

import com.fasterxml.jackson.core.JsonProcessingException;

import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesstructureApi;
import nl.esciencecenter.e3dchem.gpcrdb.client.model.Ligand;
import nl.esciencecenter.e3dchem.gpcrdb.client.model.Structure;

public class StructuresOfProteinNodeModelTest {

    @Test
    public void testFetchStructures_filled() throws ApiException, JsonProcessingException {
        String entryName = "adrb2_human";
        StructuresOfProteinNodeModel model = new StructuresOfProteinNodeModel();
        ServicesstructureApi service = mock(ServicesstructureApi.class);
        List<Structure> response = getSampleStructures();
        when(service.structureListProteinGET(entryName)).thenReturn(response);
        BufferedDataContainer container = mock(BufferedDataContainer.class);

        model.fetchStructures(service, container, entryName);

		DataRow expectedRow = expectedContainer();
        verify(container).addRowToTable(expectedRow);
    }

    @Test
    public void testFetchStructures_filled_lowercase() throws ApiException, JsonProcessingException {
        String entryName = "ADRB2_HUMAN";
        StructuresOfProteinNodeModel model = new StructuresOfProteinNodeModel();
        ServicesstructureApi service = mock(ServicesstructureApi.class);
        List<Structure> response = getSampleStructures();
        when(service.structureListProteinGET("adrb2_human")).thenReturn(response);
        BufferedDataContainer container = mock(BufferedDataContainer.class);

        model.fetchStructures(service, container, entryName);

		DataRow expectedRow = expectedContainer();
        verify(container).addRowToTable(expectedRow);
    }

	@Test
    public void testFetchStructures_nullpublication() throws ApiException, JsonProcessingException {
    	String entryName = "ADRB2_HUMAN";
        StructuresOfProteinNodeModel model = new StructuresOfProteinNodeModel();
        ServicesstructureApi service = mock(ServicesstructureApi.class);
        List<Structure> response = getSampleStructures();
        response.get(0).setPublication(null);
        when(service.structureListProteinGET("adrb2_human")).thenReturn(response);
        BufferedDataContainer container = mock(BufferedDataContainer.class);

        model.fetchStructures(service, container, entryName);

		DataRow expectedRow = expectedContainer(new MissingCell("Publication missing"));
        verify(container).addRowToTable(expectedRow);
    }

	@Test
	public void testFetchStructures_singleStructure_AlternateEndpoint() throws ApiException {
        String entryName = "adrb2_human";
        StructuresOfProteinNodeModel model = new StructuresOfProteinNodeModel();
        ServicesstructureApi service = mock(ServicesstructureApi.class);
        List<Structure> response = getSampleStructures();
        when(service.structureListProteinGET(entryName)).thenThrow(new IllegalStateException("Expected BEGIN_ARRAY but was BEGIN_OBJECT at line 1 column 2 path $"));
        when(service.structureSingleProteinGET(entryName)).thenReturn(response.get(0));
        BufferedDataContainer container = mock(BufferedDataContainer.class);

        model.fetchStructures(service, container, entryName);

		DataRow expectedRow = expectedContainer();
        verify(container).addRowToTable(expectedRow);
	}

	protected DataRow expectedContainer() {
		return expectedContainer(new StringCell("http://dx.doi.org/10.1126/SCIENCE.1150577"));
	}

    protected DataRow expectedContainer(DataCell publication) {
		RowKey key = new RowKey("adrb2_human - 2RH1");
		DataCell[] cells = new DataCell[10];
		cells[0] = new StringCell("2007-10-30");
		cells[1] = new StringCell("A");
		cells[2] = new StringCell("X-ray diffraction");
		cells[3] = new StringCell("Homo sapiens");
		cells[4] = new StringCell("adrb2_human");
		cells[5] = new DoubleCell((float) 2.4);
		JSONCellFactory jsoncellify = new JSONCellFactory();
		cells[6] = jsoncellify.createCell("[{\"name\": \"Carazolol\",\"type\": \"Small molecule\",\"function\": \"Inverse agonist\"}]");
		cells[7] = publication;
		cells[8] = new StringCell("2RH1");
		cells[9] = new StringCell("001_001_003_008");
		DataRow expectedRow = new DefaultRow(key, cells);
		return expectedRow;
	}
    
    private List<Structure> getSampleStructures() {
		//        [{
		//            "family": "001_001_003_008",
		//            "pdb_code": "2RH1",
		//            "publication_date": "2007-10-30",
		//            "resolution": 2.4,
		//            "species": "Homo sapiens",
		//            "protein": "adrb2_human",
		//            "type": "X-ray diffraction",
		//            "preferred_chain": "A",
		//            "publication": "http://dx.doi.org/10.1126/SCIENCE.1150577",
		//            "ligands": [
		//              {
		//                "name": "Carazolol",
		//                "type": "Small molecule",
		//                "function": "Inverse agonist"
		//              }
		//            ]
		//          }]
        
        Structure structure = new Structure();
        structure.setFamily("001_001_003_008");
        structure.setPdbCode("2RH1");
        structure.setPublicationDate("2007-10-30");
        structure.setResolution((float) 2.4);
        structure.setSpecies("Homo sapiens");
        structure.setProtein("adrb2_human");
        structure.setType("X-ray diffraction");
        structure.setPreferredChain("A");
        structure.setPublication("http://dx.doi.org/10.1126/SCIENCE.1150577");
        List<Ligand> ligands = new ArrayList<Ligand>(1);
        Ligand ligand = new Ligand();
        ligand.setName("Carazolol");
        ligand.setType("Small molecule");
        ligand.setFunction("Inverse agonist");
		ligands.add(ligand);
		structure.setLigands(ligands);
        List<Structure> response = new ArrayList<Structure>();
		response.add(structure);
        return response;
    }

}
