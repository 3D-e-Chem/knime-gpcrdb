package nl.esciencecenter.e3dchem.gpcrdb.structures;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.knime.core.node.CanceledExecutionException;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.workflow.UnsupportedWorkflowVersionException;
import org.knime.core.util.LockFailedException;
import org.knime.testing.core.TestrunConfiguration;

import com.github.tomakehurst.wiremock.junit.WireMockRule;

import nl.esciencecenter.e3dchem.gpcrdb.client.ApiClient;
import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesstructureApi;
import nl.esciencecenter.e3dchem.knime.testing.TestFlowRunner;

public class StructuresOfProteinFlowTest {
	@Rule
	public ErrorCollector collector = new ErrorCollector();
	private TestFlowRunner runner;

	@Rule
	public WireMockRule wireMockRule = new WireMockRule(8089);

	@Before
	public void setUp() {
		TestrunConfiguration runConfiguration = new TestrunConfiguration();
		runner = new TestFlowRunner(collector, runConfiguration);
	}

	@Test
	public void test_simple() throws IOException, InvalidSettingsException, CanceledExecutionException,
			UnsupportedWorkflowVersionException, LockFailedException, InterruptedException {
		File workflowDir = new File("src/knime/structures-of-protein-test");
		runner.runTestWorkflow(workflowDir);
	}

	@Test
	public void test_singlestructure() throws ApiException {
		ApiClient apiClient = new ApiClient();
		apiClient.setBasePath("http://localhost:8089");
		apiClient.addDefaultHeader("Accept", "application/json");
		ServicesstructureApi service = new ServicesstructureApi(apiClient);

		String entryName = "oprk_human";
		try {
			service.structureListProteinGET(entryName);
		} catch (Exception e) {
			if (e.getMessage().contains("Expected BEGIN_ARRAY but was BEGIN_OBJECT")) {
				service.structureSingleProteinGET(entryName);
			} else {
				throw e;
			}
		}

		assertEquals(1, 1);
	}
}