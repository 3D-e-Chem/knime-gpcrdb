package nl.esciencecenter.e3dchem.gpcrdb.residues;

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

import nl.esciencecenter.e3dchem.knime.testing.TestFlowRunner;

public class ResiduesFlowTest {
	@Rule
	public ErrorCollector collector = new ErrorCollector();
	private TestFlowRunner runner;
	
	@Rule
	public WireMockRule wireMockRule = new WireMockRule(8089);

	@Before
	public void setUp() {
	    TestrunConfiguration runConfiguration = new TestrunConfiguration();
	    runConfiguration.setTestViews(false);
	    runConfiguration.setTestDialogs(true);
	    runner = new TestFlowRunner(collector, runConfiguration);
	}
	
	@Test
	public void test_it() throws IOException, InvalidSettingsException, CanceledExecutionException,
	        UnsupportedWorkflowVersionException, LockFailedException, InterruptedException {
	    File workflowDir = new File("src/knime/residues-test");
	    runner.runTestWorkflow(workflowDir);
	}
}
