package nl.esciencecenter.e3dchem.gpcrdb.structures;

import java.util.ArrayList;
import java.util.List;

import org.knime.core.data.DataRow;
import org.knime.core.data.DataTableSpec;
import org.knime.core.data.def.StringCell;
import org.knime.core.node.BufferedDataContainer;
import org.knime.core.node.BufferedDataTable;
import org.knime.core.node.ExecutionContext;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeSettingsRO;
import org.knime.core.node.NodeSettingsWO;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesstructureApi;
import nl.esciencecenter.e3dchem.gpcrdb.client.model.Structure;

/**
 * This is the model implementation of StructuresOfProtein. Get a list of
 * structures of a protein
 *
 */
public class StructuresOfProteinNodeModel extends AbstractStructuresNodeModel {

	public static final String CFGKEY_INPUTCOLUMNNAME = "In Column";

	private final SettingsModelString m_inputColumnName = new SettingsModelString(CFGKEY_INPUTCOLUMNNAME, null);

	/**
	 * Constructor for the node model.
	 */
	public StructuresOfProteinNodeModel() {
		super(1, 1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected BufferedDataTable[] execute(final BufferedDataTable[] inData, final ExecutionContext exec)
			throws Exception {

		ServicesstructureApi service = new ServicesstructureApi(getApiClient());

		DataTableSpec outputSpec = structuresTableSpec();

		// the execution context will provide us with storage capacity, in this
		// case a data container to which we will add rows sequentially
		// Note, this container can also handle arbitrary big data tables, it
		// will buffer to disc if necessary.
		BufferedDataContainer container = exec.createDataContainer(outputSpec);

		BufferedDataTable table = inData[0];
		long rowCount = table.size();
		long currentRow = 0;
		int columnIndex = table.getDataTableSpec().findColumnIndex(m_inputColumnName.getStringValue());

		for (DataRow inrow : table) {
			String entryName = ((StringCell) inrow.getCell(columnIndex)).getStringValue();

			fetchStructures(service, container, entryName);

			// check if the user cancelled the execution
			exec.checkCanceled();
			// report progress
			exec.setProgress((double) currentRow / rowCount, " processing row " + currentRow);
			currentRow++;
		}

		// once we are done, we close the container and return its table
		container.close();
		BufferedDataTable out = container.getTable();
		return new BufferedDataTable[] { out };
	}

	public void fetchStructures(ServicesstructureApi service, BufferedDataContainer container, String entryName)
			throws ApiException {
		String entryNameLC = entryName.toLowerCase();
		List<Structure> structures = new ArrayList<Structure>();
		try {
			structures = service.structureListProteinGET(entryNameLC);
		// Tried ApiException, IllegalStateException and JsonSyntaxException, 
		// but they are not thrown by structureListProteinGET, so do a broad catch
		} catch (Exception e) {
			if (e.getMessage().contains("Expected BEGIN_ARRAY but was BEGIN_OBJECT")) {
				// service returned a object instead of an array
				// fetch again, but expect a single structure
				structures.add(service.structureSingleProteinGET(entryNameLC));
			} else {
				throw e;
			}
		}

		rest2knime(container, structures);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected DataTableSpec[] configure(final DataTableSpec[] inSpecs) throws InvalidSettingsException {

    	if (inSpecs.length > 0 && inSpecs[0] != null){
        	int columnIndex = inSpecs[0].findColumnIndex(m_inputColumnName.getStringValue());
        	if (columnIndex < 0){
        		throw new InvalidSettingsException("No valid input column selected");
        	}
        }

		return super.configure(inSpecs);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void saveSettingsTo(final NodeSettingsWO settings) {
		super.saveSettingsTo(settings);
		m_inputColumnName.saveSettingsTo(settings);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void loadValidatedSettingsFrom(final NodeSettingsRO settings) throws InvalidSettingsException {
		super.loadValidatedSettingsFrom(settings);
		m_inputColumnName.loadSettingsFrom(settings);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void validateSettings(final NodeSettingsRO settings) throws InvalidSettingsException {
		super.validateSettings(settings);
		m_inputColumnName.validateSettings(settings);

	}
}
