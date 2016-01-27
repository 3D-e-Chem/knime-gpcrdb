package nl.esciencecenter.e3dchem.gpcrdb.residues;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.knime.core.data.DataRow;
import org.knime.core.data.RowKey;
import org.knime.core.data.def.DefaultRow;
import org.knime.core.data.def.IntCell;
import org.knime.core.data.def.StringCell;
import org.knime.core.data.json.JSONCellFactory;
import org.knime.core.node.BufferedDataContainer;

import com.fasterxml.jackson.core.JsonProcessingException;

import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesresiduesApi;
import nl.esciencecenter.e3dchem.gpcrdb.client.model.AlternativeGenericNumber;
import nl.esciencecenter.e3dchem.gpcrdb.client.model.ResidueExtendedSerializer;

public class ResiduesNodeModelTest {

	@Test
	public void testFetchResiduesExtended() throws JsonProcessingException, ApiException {
		String entryName = "adrb2_human";
		ServicesresiduesApi service = mock(ServicesresiduesApi.class);
		ResiduesNodeModel model = new ResiduesNodeModel();
		List<ResidueExtendedSerializer> response = sampleExtendedResidueResponse();
		when(service.residuesExtendedListGET(entryName)).thenReturn(response);
		
		BufferedDataContainer container = mock(BufferedDataContainer.class);
		model.fetchResiduesExtended(service, container, entryName);
		
		JSONCellFactory jsoncellify = new JSONCellFactory();
		DataRow expectedRow = new DefaultRow(
			new RowKey("adrb2_human - 1"),
			new StringCell(entryName),
			new IntCell(1),
			new StringCell("G"),
			new StringCell("TM"),
			new StringCell("113"),
			jsoncellify.createCell("{\"Oliviera\": \"T113\"}")
		);
		verify(container).addRowToTable(expectedRow);
	}

	public List<ResidueExtendedSerializer> sampleExtendedResidueResponse() {
		List<ResidueExtendedSerializer> response = new ArrayList<ResidueExtendedSerializer>();
		ResidueExtendedSerializer residue = new ResidueExtendedSerializer();
		residue.setSequenceNumber(1);
		residue.setAminoAcid("G");
		residue.setProteinSegment("TM");
		residue.setDisplayGenericNumber("113");
		List<AlternativeGenericNumber> alternativeGenericNumbers = new ArrayList<AlternativeGenericNumber>();
		AlternativeGenericNumber anum = new AlternativeGenericNumber();
		anum.setScheme("Oliviera");
		anum.setLabel("T113");
		alternativeGenericNumbers.add(anum);
		residue.setAlternativeGenericNumbers(alternativeGenericNumbers);
		response.add(residue);
		return response;
	}

}
