package nl.esciencecenter.e3dchem.gpcrdb.proteins;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.knime.core.data.DataCell;
import org.knime.core.data.DataColumnSpec;
import org.knime.core.data.DataColumnSpecCreator;
import org.knime.core.data.DataRow;
import org.knime.core.data.DataTableSpec;
import org.knime.core.data.RowKey;
import org.knime.core.data.def.DefaultRow;
import org.knime.core.data.def.StringCell;
import org.knime.core.node.BufferedDataContainer;
import org.knime.core.node.BufferedDataTable;
import org.knime.core.node.CanceledExecutionException;
import org.knime.core.node.ExecutionContext;
import org.knime.core.node.ExecutionMonitor;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeSettingsRO;
import org.knime.core.node.NodeSettingsWO;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

import nl.esciencecenter.e3dchem.gpcrdb.GpcrdbNodeModel;
import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesproteinApi;
import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesproteinfamilyApi;
import nl.esciencecenter.e3dchem.gpcrdb.client.model.ProteinSerializer;

/**
 * This is the model implementation of StructuresOfProtein. Get a list of
 * structures of a protein
 *
 */
public class ProteinInfoNodeModel extends GpcrdbNodeModel {
	public static final String CFGKEY_INPUTCOLUMNNAME = "In Column";

	public static final String IDTYPE_UNIPROTID = "Uniprot id";

	public static final String IDTYPE_UNIPROTACC = "Uniprot accesion";

	public static final String IDTYPE_FAMILIYSLUG = "Protein family slug";

	public static final String[] LIST_IDENTIFIERTYPES = new String[] { IDTYPE_UNIPROTID, IDTYPE_UNIPROTACC,
			IDTYPE_FAMILIYSLUG };

	private static final String CFGKEY_IDTYPE = "In column type";

	private static final String DEFAULT_IDTYPE = IDTYPE_UNIPROTID;

	private final SettingsModelString m_inputColumnName = new SettingsModelString(CFGKEY_INPUTCOLUMNNAME, null);
	private final SettingsModelString m_idtype = ProteinInfoNodeModel.getIdentifierType();

	private ServicesproteinApi service4proteins = new ServicesproteinApi();

	private ServicesproteinfamilyApi services4families = new ServicesproteinfamilyApi();

	/**
	 * Constructor for the node model.
	 */
	public ProteinInfoNodeModel() {

		// TODO one incoming port and one outgoing port is assumed
		super(1, 1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected BufferedDataTable[] execute(final BufferedDataTable[] inData, final ExecutionContext exec)
			throws Exception {

		// the data table spec of the single output table,
		// the table will have three columns:
		DataColumnSpec[] allColSpecs = new DataColumnSpec[8];
		allColSpecs[0] = new DataColumnSpecCreator("Entry name", StringCell.TYPE).createSpec();
		allColSpecs[1] = new DataColumnSpecCreator("Accession", StringCell.TYPE).createSpec();
		allColSpecs[2] = new DataColumnSpecCreator("Name", StringCell.TYPE).createSpec();
		allColSpecs[3] = new DataColumnSpecCreator("Family", StringCell.TYPE).createSpec();
		allColSpecs[4] = new DataColumnSpecCreator("Species", StringCell.TYPE).createSpec();
		allColSpecs[5] = new DataColumnSpecCreator("Source", StringCell.TYPE).createSpec();
		allColSpecs[6] = new DataColumnSpecCreator("Residue numbering scheme", StringCell.TYPE).createSpec();
		allColSpecs[7] = new DataColumnSpecCreator("Sequence", StringCell.TYPE).createSpec();

		DataTableSpec outputSpec = new DataTableSpec(allColSpecs);

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
			String id = ((StringCell) inrow.getCell(columnIndex)).getStringValue();
			String idtype = m_idtype.getStringValue();

			try {
				fetchProteins(id, idtype, container);
			} catch (ApiException e) {
				handleApiException(e, id);
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

	public void fetchProteins(String id, String idtype, BufferedDataContainer container) throws ApiException {
		// make sure services use current apiclient
		service4proteins.setApiClient(getApiClient());
		services4families.setApiClient(getApiClient());

		List<ProteinSerializer> proteins = new ArrayList<ProteinSerializer>(1);
		if (IDTYPE_UNIPROTID.equals(idtype)) {
			proteins.add(service4proteins.proteinDetailGET(id.toLowerCase()));
		} else if (IDTYPE_UNIPROTACC.equals(idtype)) {
			proteins.add(service4proteins.proteinByAccessionDetailGET(id));
		} else if (IDTYPE_FAMILIYSLUG.equals(idtype)) {
			proteins = services4families.proteinsInFamilyListGET(id);
		}

		for (ProteinSerializer protein : proteins) {
			RowKey key = new RowKey(protein.getEntryName());
			// the cells of the current row, the types of the cells must
			// match
			// the column spec (see above)
			DataCell[] cells = new DataCell[8];
			cells[0] = new StringCell(protein.getEntryName());
			cells[1] = new StringCell(protein.getAccession());
			cells[2] = new StringCell(protein.getName());
			cells[3] = new StringCell(protein.getFamily());
			cells[4] = new StringCell(protein.getSpecies());
			cells[5] = new StringCell(protein.getSource());
			cells[6] = new StringCell(protein.getResidueNumberingScheme());
			cells[7] = new StringCell(protein.getSequence());
			DataRow row = new DefaultRow(key, cells);
			container.addRowToTable(row);
		}
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
		m_idtype.saveSettingsTo(settings);

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
		m_idtype.loadSettingsFrom(settings);
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
		m_idtype.validateSettings(settings);
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

	public static SettingsModelString getIdentifierType() {
		return new SettingsModelString(CFGKEY_IDTYPE, DEFAULT_IDTYPE);
	}

	public ServicesproteinApi getService4proteins() {
		return service4proteins;
	}

	public void setService4proteins(ServicesproteinApi service4proteins) {
		this.service4proteins = service4proteins;
	}

	public ServicesproteinfamilyApi getServices4families() {
		return services4families;
	}

	public void setServices4families(ServicesproteinfamilyApi services4families) {
		this.services4families = services4families;
	}

}
