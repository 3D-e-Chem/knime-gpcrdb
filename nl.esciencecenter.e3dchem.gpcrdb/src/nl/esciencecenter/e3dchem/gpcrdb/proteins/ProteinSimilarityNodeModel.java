package nl.esciencecenter.e3dchem.gpcrdb.proteins;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.knime.core.data.DataCell;
import org.knime.core.data.DataColumnSpec;
import org.knime.core.data.DataColumnSpecCreator;
import org.knime.core.data.DataRow;
import org.knime.core.data.DataTableSpec;
import org.knime.core.data.RowKey;
import org.knime.core.data.def.DefaultRow;
import org.knime.core.data.def.IntCell;
import org.knime.core.data.def.StringCell;
import org.knime.core.node.BufferedDataContainer;
import org.knime.core.node.BufferedDataTable;
import org.knime.core.node.CanceledExecutionException;
import org.knime.core.node.ExecutionContext;
import org.knime.core.node.ExecutionMonitor;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeSettingsRO;
import org.knime.core.node.NodeSettingsWO;
import org.knime.core.node.defaultnodesettings.SettingsModelInteger;
import org.knime.core.node.defaultnodesettings.SettingsModelIntegerBounded;
import org.knime.core.node.defaultnodesettings.SettingsModelString;
import org.knime.core.node.defaultnodesettings.SettingsModelStringArray;

import nl.esciencecenter.e3dchem.gpcrdb.GpcrdbNodeModel;
import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesalignmentApi;
import nl.esciencecenter.e3dchem.gpcrdb.client.StringUtil;
import nl.esciencecenter.e3dchem.gpcrdb.client.model.ProteinSimilarity;

/**
 * This is the model implementation of StructuresOfProtein. Get a list of structures of a protein
 *
 */
public class ProteinSimilarityNodeModel extends GpcrdbNodeModel {
    public static final String CFGKEY_INCOLUMNNAME = "In Column";
    public static final String CFGKEY_SEGMENTS = "Segments";
    public static final String CFGKEY_CHUNKSIZE = "Chunk Size";

    private final SettingsModelString m_inColumnName = new SettingsModelString(CFGKEY_INCOLUMNNAME, null);
    private final SettingsModelStringArray m_segments = new SettingsModelStringArray(CFGKEY_SEGMENTS, null);
    private final SettingsModelInteger m_chunksize = new SettingsModelIntegerBounded(CFGKEY_CHUNKSIZE, 20, 1, 100);

    private ServicesalignmentApi service = new ServicesalignmentApi();

    /**
     * Constructor for the node model.
     */
    public ProteinSimilarityNodeModel() {

        // TODO one incoming port and one outgoing port is assumed
        super(2, 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BufferedDataTable[] execute(final BufferedDataTable[] inData, final ExecutionContext exec) throws Exception {
        service.setApiClient(getApiClient());

        // the data table spec of the single output table,
        // the table will have three columns:
        DataColumnSpec[] allColSpecs = new DataColumnSpec[4];
        allColSpecs[0] = new DataColumnSpecCreator("Query", StringCell.TYPE).createSpec();
        allColSpecs[1] = new DataColumnSpecCreator("Subject", StringCell.TYPE).createSpec();
        allColSpecs[2] = new DataColumnSpecCreator("Similarity", IntCell.TYPE).createSpec();
        allColSpecs[3] = new DataColumnSpecCreator("Identity", IntCell.TYPE).createSpec();

        DataTableSpec outputSpec = new DataTableSpec(allColSpecs);

        // the execution context will provide us with storage capacity, in this
        // case a data container to which we will add rows sequentially
        // Note, this container can also handle arbitrary big data tables, it
        // will buffer to disc if necessary.
        BufferedDataContainer container = exec.createDataContainer(outputSpec);

        System.err.println(m_segments.getStringArrayValue());
        String segments = StringUtil.join(m_segments.getStringArrayValue(), ",");

        BufferedDataTable queryTable = inData[0];
        BufferedDataTable subjectTable = inData[1];
        long rowCount = queryTable.size();
        long currentRow = 0;
        int columnIndex = queryTable.getDataTableSpec().findColumnIndex(m_inColumnName.getStringValue());
        int subjectColumnIndex = subjectTable.getDataTableSpec().findColumnIndex(m_inColumnName.getStringValue());

        List<String> subjects = new ArrayList<>();
        for (DataRow subjectRow : subjectTable) {
            subjects.add(((StringCell) subjectRow.getCell(subjectColumnIndex)).getStringValue().toLowerCase());
        }

        for (DataRow queryRow : queryTable) {
            String query = ((StringCell) queryRow.getCell(columnIndex)).getStringValue().toLowerCase();
            fetchSimilarities(query, segments, subjects, container);

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

	public void fetchSimilarities(String query, String segments, List<String> subjects,
			BufferedDataContainer container) throws ApiException {
		int chunkSize = m_chunksize.getIntValue();
		for (int i = 0; i < subjects.size(); i += chunkSize) {
			List<String> proteins = new ArrayList<>();
		    proteins.add(query);
		    if (i + chunkSize < subjects.size()) {
		        proteins.addAll(subjects.subList(i, i + chunkSize));
		    } else {
		        proteins.addAll(subjects.subList(i, subjects.size()));
		    }
		    Map<String, ProteinSimilarity> result = service.proteinSimilaritySearchAlignmentGET(
		            StringUtil.join(proteins.toArray(new String[proteins.size()]), ","), segments);
		    for (Entry<String, ProteinSimilarity> subject : result.entrySet()) {
		        // skip self
		        if (!query.equals(subject.getKey())) {
		            RowKey key = new RowKey(query + " vs " + subject.getKey());
		            // the cells of the current row, the types of the cells must
		            // match
		            // the column spec (see above)
		            DataCell[] cells = new DataCell[4];
		            cells[0] = new StringCell(query);
		            cells[1] = new StringCell(subject.getKey());
		            cells[2] = new IntCell(subject.getValue().getSimilarity());
		            cells[3] = new IntCell(subject.getValue().getIdentity());
		            DataRow row = new DefaultRow(key, cells);
		            container.addRowToTable(row);
		        }
		    }
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

        // TODO: check if user settings are available, fit to the incoming
        // table structure, and the incoming types are feasible for the node
        // to execute. If the node can execute in its current state return
        // the spec of its output data table(s) (if you can, otherwise an array
        // with null elements), or throw an exception with a useful user message

        return new DataTableSpec[] { null };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void saveSettingsTo(final NodeSettingsWO settings) {

        super.saveSettingsTo(settings);
        m_inColumnName.saveSettingsTo(settings);
        m_segments.saveSettingsTo(settings);
        m_chunksize.saveSettingsTo(settings);
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
        m_inColumnName.loadSettingsFrom(settings);
        m_segments.loadSettingsFrom(settings);
        m_chunksize.loadSettingsFrom(settings);
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
        m_inColumnName.validateSettings(settings);
        m_segments.validateSettings(settings);
        m_chunksize.validateSettings(settings);
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

	public ServicesalignmentApi getService() {
		return service;
	}

	public void setService(ServicesalignmentApi service) {
		this.service = service;
	}

}
