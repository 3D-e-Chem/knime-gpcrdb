package nl.esciencecenter.e3dchem.gpcrdb.structures;

import java.util.List;

import org.knime.core.data.DataTableSpec;
import org.knime.core.node.BufferedDataContainer;
import org.knime.core.node.BufferedDataTable;
import org.knime.core.node.ExecutionContext;
import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesstructureApi;
import nl.esciencecenter.e3dchem.gpcrdb.client.model.Structure;

/**
 * This is the model implementation of Structures. Get a list of structures.
 *
 */
public class StructuresNodeModel extends AbstractStructuresNodeModel {

	protected StructuresNodeModel() {
		super(0, 1);
	}

	@Override
	protected BufferedDataTable[] execute(BufferedDataTable[] inData, ExecutionContext exec) throws Exception {
		ServicesstructureApi service = new ServicesstructureApi(getApiClient());
		DataTableSpec outputSpec = structuresTableSpec();
		BufferedDataContainer container = exec.createDataContainer(outputSpec);
		List<Structure> structures = service.structureListGET();
		exec.setProgress(0.9);
		// check if the user cancelled the execution
		exec.checkCanceled();
		rest2knime(container, structures);
		exec.setProgress(1.0);
		// once we are done, we close the container and return its table
		container.close();
		BufferedDataTable out = container.getTable();
		return new BufferedDataTable[] { out };
	}
}
