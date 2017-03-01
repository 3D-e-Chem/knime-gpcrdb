package nl.esciencecenter.e3dchem.gpcrdb.proteins;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.knime.core.data.DataRow;
import org.knime.core.data.RowKey;
import org.knime.core.data.def.DefaultRow;
import org.knime.core.data.def.IntCell;
import org.knime.core.data.def.StringCell;
import org.knime.core.node.BufferedDataContainer;

import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesalignmentApi;
import nl.esciencecenter.e3dchem.gpcrdb.client.model.ProteinSimilarities;
import nl.esciencecenter.e3dchem.gpcrdb.client.model.ProteinSimilarity;

public class ProteinSimilarityNodeModelTest {
	private ProteinSimilarityNodeModel node;
	private ServicesalignmentApi service;

	@Before
	public void setUp() {
		node = new ProteinSimilarityNodeModel();
		service = mock(ServicesalignmentApi.class);
		node.setService(service);
	}
	
	@Test
	public void testFetchSimilarities_fullchunk() throws ApiException {
		String query = "adrb2_human";
		String segments = "TM1,TM2,TM3";
		List<String> subjects = Arrays.asList("5ht2a_human", "cxcr4_human");
		BufferedDataContainer container = mock(BufferedDataContainer.class);
		ProteinSimilarities response = new ProteinSimilarities();
		ProteinSimilarity ps1 = new ProteinSimilarity();
		ps1.setSimilarity(44);
		ps1.setIdentity(75);
		response.put("5ht2a_human", ps1);
		ProteinSimilarity ps2 = new ProteinSimilarity();
		ps2.setSimilarity(56);
		ps2.setIdentity(86);
		response.put("cxcr4_human", ps2);
		when(service.proteinSimilaritySearchAlignmentGET("adrb2_human,5ht2a_human,cxcr4_human", segments)).thenReturn(response);
		
		node.fetchSimilarities(query, segments, subjects, container);
		
		DataRow row1 = new DefaultRow(
			RowKey.createRowKey(0L),
			new StringCell("adrb2_human"),
			new StringCell("5ht2a_human"),
			new IntCell(44),
			new IntCell(75)
		);
		verify(container).addRowToTable(row1);
		DataRow row2 = new DefaultRow(
			RowKey.createRowKey(0L),
			new StringCell("adrb2_human"),
			new StringCell("cxcr4_human"),
			new IntCell(56),
			new IntCell(86)
		);
		verify(container).addRowToTable(row2);
	}

}
