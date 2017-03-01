package nl.esciencecenter.e3dchem.gpcrdb.proteins;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import org.knime.core.node.ExecutionContext;
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
					RowKey key = RowKey.createRowKey(container.size());
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
    protected DataTableSpec[] configure(final DataTableSpec[] inSpecs) throws InvalidSettingsException {
    	// check Uniprot columns
    	if (inSpecs.length == 2 && inSpecs[0] != null && inSpecs[1] != null){
        	int columnIndexOne = inSpecs[0].findColumnIndex(m_inColumnName.getStringValue());
        	int columnIndexTwo = inSpecs[1].findColumnIndex(m_inColumnName.getStringValue());
        	if (columnIndexOne < 0 || columnIndexTwo < 0){
        		throw new InvalidSettingsException("No valid input column selected");
        	}
        }
    	
    	// check segment identifiers
    	if (m_segments.getStringArrayValue().length == 0){
    		throw new InvalidSettingsException("No segment identifiers selected");    		
    	}

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
        super.validateSettings(settings);
        m_inColumnName.validateSettings(settings);
        m_segments.validateSettings(settings);
        m_chunksize.validateSettings(settings);
    }

	public ServicesalignmentApi getService() {
		return service;
	}

	public void setService(ServicesalignmentApi service) {
		this.service = service;
	}

}
