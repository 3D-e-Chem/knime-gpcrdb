package nl.esciencecenter.e3dchem.gpcrdb.residues;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.knime.core.data.DataCell;
import org.knime.core.data.DataColumnSpec;
import org.knime.core.data.DataColumnSpecCreator;
import org.knime.core.data.DataRow;
import org.knime.core.data.DataTableSpec;
import org.knime.core.data.MissingCell;
import org.knime.core.data.RowKey;
import org.knime.core.data.def.DefaultRow;
import org.knime.core.data.def.LongCell;
import org.knime.core.data.def.StringCell;
import org.knime.core.data.json.JSONCell;
import org.knime.core.data.json.JSONCellFactory;
import org.knime.core.node.BufferedDataContainer;
import org.knime.core.node.BufferedDataTable;
import org.knime.core.node.CanceledExecutionException;
import org.knime.core.node.ExecutionContext;
import org.knime.core.node.ExecutionMonitor;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeSettingsRO;
import org.knime.core.node.NodeSettingsWO;
import org.knime.core.node.defaultnodesettings.SettingsModelBoolean;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

import com.google.gson.Gson;

import nl.esciencecenter.e3dchem.gpcrdb.GpcrdbNodeModel;
import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesresiduesApi;
import nl.esciencecenter.e3dchem.gpcrdb.client.model.ResidueExtendedSerializer;
import nl.esciencecenter.e3dchem.gpcrdb.client.model.ResidueGenericNumberSerializer;
import nl.esciencecenter.e3dchem.gpcrdb.client.model.ResidueSerializer;

/**
 * This is the model implementation of StructuresOfProtein. Get a list of
 * structures of a protein
 *
 */
public class ResiduesNodeModel extends GpcrdbNodeModel {

	public static final String CFGKEY_INPUTCOLUMNNAME = "In Column";

	public static final String CFGKEY_EXTENDED = "Extended";

	public static final boolean DEFAULT_EXTENDED = false;

	private final SettingsModelString m_inputColumnName = new SettingsModelString(CFGKEY_INPUTCOLUMNNAME, null);

	private final SettingsModelBoolean m_extended = createExtendedModel();

	private Gson jsonify = new Gson();

	private JSONCellFactory jsoncellify = new JSONCellFactory();

	/**
	 * Constructor for the node model.
	 */
	public ResiduesNodeModel() {

		// TODO one incoming port and one outgoing port is assumed
		super(1, 1);
	}

	static SettingsModelBoolean createExtendedModel() {
		final SettingsModelBoolean model = new SettingsModelBoolean(ResiduesNodeModel.CFGKEY_EXTENDED,
				ResiduesNodeModel.DEFAULT_EXTENDED);
		return model;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected BufferedDataTable[] execute(final BufferedDataTable[] inData, final ExecutionContext exec)
			throws Exception {

		ServicesresiduesApi service = new ServicesresiduesApi(getApiClient());

		// the data table spec of the single output table,
		// the table will have three columns:
		DataTableSpec outputSpec = createOutputSpec();

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

			if (m_extended.getBooleanValue()) {
				fetchResiduesExtended(service, container, entryName);
			} else {
				fetchResidues(service, container, entryName);
			}

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

	private void fetchResidues(ServicesresiduesApi service, BufferedDataContainer container, String entryName)
			throws ApiException {
		entryName = entryName.toLowerCase();
		List<ResidueSerializer> result = service.residuesListGET(entryName);
		for (ResidueSerializer residue : result) {
			DataCell[] cells = new DataCell[5];
			cells[0] = new StringCell(entryName);
			cells[1] = new LongCell(residue.getSequenceNumber());
			cells[2] = new StringCell(residue.getAminoAcid());
			cells[3] = new StringCell(residue.getProteinSegment());
			if (residue.getDisplayGenericNumber() == null) {
				cells[4] = new MissingCell("Position has no generic number");
			} else {
				cells[4] = new StringCell(residue.getDisplayGenericNumber());
			}

			RowKey key = new RowKey("Row " + entryName + " - " + residue.getSequenceNumber());
			// the cells of the current row, the types of the cells must
			// match
			// the column spec (see above)
			DataRow row = new DefaultRow(key, cells);
			container.addRowToTable(row);
		}
	}

	public void fetchResiduesExtended(ServicesresiduesApi service, BufferedDataContainer container, String entryName)
			throws ApiException {
		String entryNameLc = entryName.toLowerCase();
		List<ResidueExtendedSerializer> result = service.residuesExtendedListGET(entryNameLc);
		for (ResidueExtendedSerializer residue : result) {
			DataCell[] cells = new DataCell[6];
			cells[0] = new StringCell(entryNameLc);
			cells[1] = new LongCell(residue.getSequenceNumber());
			cells[2] = new StringCell(residue.getAminoAcid());
			cells[3] = new StringCell(residue.getProteinSegment());
			if (residue.getDisplayGenericNumber() == null) {
				cells[4] = new MissingCell("Position has no generic number");
			} else {
				cells[4] = new StringCell(residue.getDisplayGenericNumber());
			}
			Map<String, String> alternatives = new HashMap<String, String>();
			for (ResidueGenericNumberSerializer alternative : residue.getAlternativeGenericNumbers()) {
				alternatives.put(alternative.getScheme(), alternative.getLabel());
			}
			String alternativeNumbers = jsonify.toJson(alternatives);
			cells[5] = jsoncellify.createCell(alternativeNumbers);

			RowKey key = new RowKey(entryNameLc + " - " + residue.getSequenceNumber());
			// the cells of the current row, the types of the cells must
			// match
			// the column spec (see above)
			DataRow row = new DefaultRow(key, cells);
			container.addRowToTable(row);
		}
	}

	private DataTableSpec createOutputSpec() {
		int columnSize = 5;
		if (m_extended.getBooleanValue()) {
			columnSize = 6;
		}
		DataColumnSpec[] allColSpecs = new DataColumnSpec[columnSize];
		allColSpecs[0] = new DataColumnSpecCreator("Protein", StringCell.TYPE).createSpec();
		allColSpecs[1] = new DataColumnSpecCreator("Sequence number", LongCell.TYPE).createSpec();
		allColSpecs[2] = new DataColumnSpecCreator("Amino acid", StringCell.TYPE).createSpec();
		allColSpecs[3] = new DataColumnSpecCreator("Protein segment", StringCell.TYPE).createSpec();
		allColSpecs[4] = new DataColumnSpecCreator("Generic number", StringCell.TYPE).createSpec();
		if (m_extended.getBooleanValue()) {
			allColSpecs[5] = new DataColumnSpecCreator("Alternative generic numbers", JSONCell.TYPE).createSpec();
		}

		DataTableSpec outputSpec = new DataTableSpec(allColSpecs);
		return outputSpec;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void reset() {
		// TODO Code executed on reset.
		// Models build during execute are cleared here.
		// Also data handled in load/saveInternals will be erased here.
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

		return new DataTableSpec[] { null };
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void saveSettingsTo(final NodeSettingsWO settings) {

		super.saveSettingsTo(settings);
		m_inputColumnName.saveSettingsTo(settings);
		m_extended.saveSettingsTo(settings);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void loadValidatedSettingsFrom(final NodeSettingsRO settings) throws InvalidSettingsException {

		// TODO load (valid) settings from the config object.
		// It can be safely assumed that the settings are valided by the
		// method below.

		super.loadValidatedSettingsFrom(settings);
		m_inputColumnName.loadSettingsFrom(settings);
		m_extended.loadSettingsFrom(settings);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void validateSettings(final NodeSettingsRO settings) throws InvalidSettingsException {

		// TODO check if the settings could be applied to our model
		// e.g. if the count is in a certain range (which is ensured by the
		// SettingsModel).
		// Do not actually set any values of any member variables.

		super.validateSettings(settings);
		m_inputColumnName.validateSettings(settings);
		m_extended.validateSettings(settings);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void loadInternals(final File internDir, final ExecutionMonitor exec)
			throws IOException, CanceledExecutionException {

		// TODO load internal data.
		// Everything handed to output ports is loaded automatically (data
		// returned by the execute method, models loaded in loadModelContent,
		// and user settings set through loadSettingsFrom - is all taken care
		// of). Load here only the other internals that need to be restored
		// (e.g. data used by the views).

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void saveInternals(final File internDir, final ExecutionMonitor exec)
			throws IOException, CanceledExecutionException {

		// TODO save internal models.
		// Everything written to output ports is saved automatically (data
		// returned by the execute method, models saved in the saveModelContent,
		// and user settings saved through saveSettingsTo - is all taken care
		// of). Save here only the other internals that need to be preserved
		// (e.g. data used by the views).

	}

}