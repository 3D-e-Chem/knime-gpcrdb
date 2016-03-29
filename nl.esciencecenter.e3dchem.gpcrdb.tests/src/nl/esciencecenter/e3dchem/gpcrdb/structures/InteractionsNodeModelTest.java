package nl.esciencecenter.e3dchem.gpcrdb.structures;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.knime.core.data.DataRow;
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
	public void testFetchInteractions() throws ApiException {
		String pdbCode = "3EML"; 
		InteractionsNodeModel model = new InteractionsNodeModel();
		ServicesstructureApi service = mock(ServicesstructureApi.class);
		List<StructureLigandInteractionSerializer> response = getSampleInteractions();
		when(service.structureLigandInteractionsGET(pdbCode)).thenReturn(response);
		model.setService(service );
		BufferedDataContainer container = mock(BufferedDataContainer.class);
		// http://gpcrdb.org/interaction/3EML
		// ZM 241385	L85	3.33x33	TM3	hydrophobic

		model.fetchInteractions(container, pdbCode);
		
		DataRow expectedRow = new DefaultRow(
				new RowKey("3EML - 85"),
				new StringCell(pdbCode),
				new StringCell("ZM 241385"),
				new LongCell(85L),
				new StringCell("L"),
				new StringCell("3.33x33"),
				new StringCell("hydrophobic")
			);
		verify(container).addRowToTable(expectedRow);
	}

	private List<StructureLigandInteractionSerializer> getSampleInteractions() {
		List<StructureLigandInteractionSerializer> response = new ArrayList<StructureLigandInteractionSerializer>();
		StructureLigandInteractionSerializer interaction = new StructureLigandInteractionSerializer();
		interaction.setPdbCode("3EML");
		interaction.setLigandName("ZM 241385");
		interaction.setSequenceNumber(85L);
		interaction.setAminoAcid("L");
		interaction.setDisplayGenericNumber("3.33x33");
		interaction.setInteractionType("hydrophobic");		
		response.add(interaction);
		return response ;
	}

}
