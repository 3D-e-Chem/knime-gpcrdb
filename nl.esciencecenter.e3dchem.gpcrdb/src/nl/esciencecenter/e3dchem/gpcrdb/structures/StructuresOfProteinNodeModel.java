package nl.esciencecenter.e3dchem.gpcrdb.structures;

import java.io.File;
import java.io.IOException;

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
import org.knime.core.node.defaultnodesettings.SettingsModelIntegerBounded;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

import nl.esciencecenter.e3dchem.gpcrdb.client.ApiClient;
import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesproteinApi;
import nl.esciencecenter.e3dchem.gpcrdb.client.model.ProteinSerializer;

import org.knime.core.node.ExecutionContext;
import org.knime.core.node.ExecutionMonitor;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeLogger;
import org.knime.core.node.NodeModel;
import org.knime.core.node.NodeSettingsRO;
import org.knime.core.node.NodeSettingsWO;


/**
 * This is the model implementation of StructuresOfProtein.
 * Get a list of structures of a protein
 *
 */
public class StructuresOfProteinNodeModel extends NodeModel {
    
    // the logger instance
    private static final NodeLogger logger = NodeLogger
            .getLogger(StructuresOfProteinNodeModel.class);

	static final String CFGKEY_BASEPATH = "Base path";

	static final String DEFAULT_BASEPATH = "http://gpcrdb.org/";

	public static final String CFGKEY_INPUTCOLUMNNAME = "In Column";

	private final SettingsModelString m_basePath = new SettingsModelString(StructuresOfProteinNodeModel.CFGKEY_BASEPATH, StructuresOfProteinNodeModel.DEFAULT_BASEPATH);
	
	private final SettingsModelString m_inputColumnName = new SettingsModelString(CFGKEY_INPUTCOLUMNNAME, null);
    

    /**
     * Constructor for the node model.
     */
    protected StructuresOfProteinNodeModel() {
    
        // TODO one incoming port and one outgoing port is assumed
        super(1, 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BufferedDataTable[] execute(final BufferedDataTable[] inData,
            final ExecutionContext exec) throws Exception {

        ApiClient client = new ApiClient();
        client.setBasePath(m_basePath.getStringValue());
        client.addDefaultHeader("Accept", "application/json");
        ServicesproteinApi service = new ServicesproteinApi(client);
        
               
        // the data table spec of the single output table, 
        // the table will have three columns:
        DataColumnSpec[] allColSpecs = new DataColumnSpec[4];
        allColSpecs[0] = 
            new DataColumnSpecCreator("Accession", StringCell.TYPE).createSpec();
        allColSpecs[1] = 
                new DataColumnSpecCreator("Family", StringCell.TYPE).createSpec();
        allColSpecs[2] = 
                new DataColumnSpecCreator("Name", StringCell.TYPE).createSpec();
        allColSpecs[3] = 
                new DataColumnSpecCreator("Entry name", StringCell.TYPE).createSpec();
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
	        String entryName = ((StringCell) inrow.getCell(columnIndex)).getStringValue();
	        
			ProteinSerializer result = service.proteinDetailGET(entryName);
	
	        RowKey key = new RowKey("Row " + entryName);
	        // the cells of the current row, the types of the cells must match
	        // the column spec (see above)
	        DataCell[] cells = new DataCell[4];
	        cells[0] = new StringCell(result.getAccession()); 
	        cells[1] = new StringCell(result.getFamily()); 
	        cells[2] = new StringCell(result.getName());
	        cells[3] = new StringCell(result.getEntryName());
	        DataRow row = new DefaultRow(key, cells);
	        container.addRowToTable(row);
	        
	        // check if the user cancelled the execution
	        exec.checkCanceled();
	        // report progress
	        exec.setProgress((double)currentRow / rowCount, 
	               " processing row " + currentRow);
	        currentRow++;
		}
            
        // once we are done, we close the container and return its table
        container.close();
        BufferedDataTable out = container.getTable();
        return new BufferedDataTable[]{out};
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
    protected DataTableSpec[] configure(final DataTableSpec[] inSpecs)
            throws InvalidSettingsException {
        
        // TODO: check if user settings are available, fit to the incoming
        // table structure, and the incoming types are feasible for the node
        // to execute. If the node can execute in its current state return
        // the spec of its output data table(s) (if you can, otherwise an array
        // with null elements), or throw an exception with a useful user message

        return new DataTableSpec[]{null};
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void saveSettingsTo(final NodeSettingsWO settings) {

        m_basePath.saveSettingsTo(settings);
        m_inputColumnName.saveSettingsTo(settings);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void loadValidatedSettingsFrom(final NodeSettingsRO settings)
            throws InvalidSettingsException {
            
        // TODO load (valid) settings from the config object.
        // It can be safely assumed that the settings are valided by the 
        // method below.
        
   
        m_basePath.loadSettingsFrom(settings);
        m_inputColumnName.loadSettingsFrom(settings);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void validateSettings(final NodeSettingsRO settings)
            throws InvalidSettingsException {
            
        // TODO check if the settings could be applied to our model
        // e.g. if the count is in a certain range (which is ensured by the
        // SettingsModel).
        // Do not actually set any values of any member variables.

        m_basePath.validateSettings(settings);
        m_inputColumnName.validateSettings(settings);

    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void loadInternals(final File internDir,
            final ExecutionMonitor exec) throws IOException,
            CanceledExecutionException {
        
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
    protected void saveInternals(final File internDir,
            final ExecutionMonitor exec) throws IOException,
            CanceledExecutionException {
       
        // TODO save internal models. 
        // Everything written to output ports is saved automatically (data
        // returned by the execute method, models saved in the saveModelContent,
        // and user settings saved through saveSettingsTo - is all taken care 
        // of). Save here only the other internals that need to be preserved
        // (e.g. data used by the views).

    }

}

