package nl.esciencecenter.e3dchem.gpcrdb.mutants;

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
import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesmutantsApi;
import nl.esciencecenter.e3dchem.gpcrdb.client.model.MutationSerializer;

public class MutantsNodeModelTest {

	@Test
	public void testFetchMutants() throws ApiException {
		String entryName = "hrh1_human";
		MutantsNodeModel model = new MutantsNodeModel();
		ServicesmutantsApi service = mock(ServicesmutantsApi.class);
		List<MutationSerializer> response = sampleMutantsResponse();
		when(service.mutantListGET(entryName)).thenReturn(response);
		model.setService(service);
		BufferedDataContainer container = mock(BufferedDataContainer.class);
		
		model.fetchMutants(entryName, container);
		
		DataRow expectedRow = new DefaultRow(
				new RowKey("hrh1_human - 0"),
				new StringCell(entryName),
				new LongCell(107L),
				new StringCell("D"),
				new StringCell("E"),
				new StringCell("K(d) (Binding - Radioligand saturation)"),
				new StringCell("[3H]-mepyramine"),
				new StringCell("8093027")
			);
		verify(container).addRowToTable(expectedRow);
	}

	private List<MutationSerializer> sampleMutantsResponse() {
		ArrayList<MutationSerializer> response = new ArrayList<MutationSerializer>();
		MutationSerializer mutant = new MutationSerializer();
		// 3.32x32	107	TM3	D => E	50.0↓	K(d) (Binding - Radioligand saturation)	[3H]-mepyramine	Ohta K et al (1994)
		mutant.setProtein("hrh1_human");
		mutant.setMutationPos(107L);
		mutant.setMutationFrom("D");
		mutant.setMutationTo("E");
		mutant.setExpType("K(d)");
		mutant.setExpFunc("Binding - Radioligand saturation");
		mutant.setLigandName("[3H]-mepyramine");
		mutant.setReference("8093027");
		response.add(mutant);
		return response;
	}

}
