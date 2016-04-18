package nl.esciencecenter.e3dchem.gpcrdb.proteins;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.knime.core.node.BufferedDataContainer;

import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesalignmentApi;
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
		Map<String, ProteinSimilarity> response = new HashMap<String, ProteinSimilarity>();
		ProteinSimilarity ps1 = new ProteinSimilarity();
		ps1.setIdentity(75);
		ps1.setSimilarity(44);
		response.put("5ht2a_human", ps1);
		ProteinSimilarity ps2 = new ProteinSimilarity();
		ps2.setIdentity(86);
		ps2.setSimilarity(56);
		response.put("cxcr4_human", ps2);
		when(service.proteinSimilaritySearchAlignmentGET("adrb2_human,5ht2a_human,cxcr4_human", segments)).thenReturn(response);
		
		node.fetchSimilarities(query, segments, subjects, container);
		
		// TODO verify container filled
	}

}
