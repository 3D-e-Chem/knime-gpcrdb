package nl.esciencecenter.e3dchem.gpcrdb.mutants;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.knime.core.data.DataCell;
import org.knime.core.data.DataColumnSpec;
import org.knime.core.data.DataColumnSpecCreator;
import org.knime.core.data.DataRow;
import org.knime.core.data.DataTableSpec;
import org.knime.core.data.RowKey;
import org.knime.core.data.def.DefaultRow;
import org.knime.core.data.def.DoubleCell;
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
import org.knime.core.node.defaultnodesettings.SettingsModelString;

import nl.esciencecenter.e3dchem.gpcrdb.GpcrdbNodeModel;
import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesmutantsApi;
import nl.esciencecenter.e3dchem.gpcrdb.client.model.MutationSerializer;

/**
 * This is the model implementation of Mutants. Get a list of mutants of a protein
 *
 */
public class MutantsNodeModel extends GpcrdbNodeModel {

    public static final String CFGKEY_INPUTCOLUMNNAME = "In Column";

    private final SettingsModelString m_inputColumnName = new SettingsModelString(CFGKEY_INPUTCOLUMNNAME, null);

    private ServicesmutantsApi service = new ServicesmutantsApi(getApiClient());

    /**
     * Constructor for the node model.
     */
    public MutantsNodeModel() {

        // TODO one incoming port and one outgoing port is assumed
        super(1, 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BufferedDataTable[] execute(final BufferedDataTable[] inData, final ExecutionContext exec) throws Exception {
        // the data table spec of the single output table,
        // the table will have three columns:
        DataColumnSpec[] allColSpecs = new DataColumnSpec[23];
        allColSpecs[0] = new DataColumnSpecCreator("Entry name", StringCell.TYPE).createSpec();
        allColSpecs[1] = new DataColumnSpecCreator("Sequence number", IntCell.TYPE).createSpec();
        allColSpecs[2] = new DataColumnSpecCreator("Mutation from", StringCell.TYPE).createSpec();
        allColSpecs[3] = new DataColumnSpecCreator("Mutation to", StringCell.TYPE).createSpec();
        allColSpecs[4] = new DataColumnSpecCreator("Ligand name", StringCell.TYPE).createSpec();
        allColSpecs[5] = new DataColumnSpecCreator("Ligand ID type", StringCell.TYPE).createSpec();
        allColSpecs[6] = new DataColumnSpecCreator("Ligand ID", StringCell.TYPE).createSpec();
        allColSpecs[7] = new DataColumnSpecCreator("Ligand Class", StringCell.TYPE).createSpec();
        allColSpecs[8] = new DataColumnSpecCreator("Measure type", StringCell.TYPE).createSpec();
        allColSpecs[9] = new DataColumnSpecCreator("Assay type", StringCell.TYPE).createSpec();
        allColSpecs[10] = new DataColumnSpecCreator("WT activity/affinity", DoubleCell.TYPE).createSpec();
        allColSpecs[11] = new DataColumnSpecCreator("Unit", StringCell.TYPE).createSpec();
        allColSpecs[12] = new DataColumnSpecCreator("Quantifier symbol", StringCell.TYPE).createSpec();
        allColSpecs[13] = new DataColumnSpecCreator("Quantitative", DoubleCell.TYPE).createSpec();
        allColSpecs[14] = new DataColumnSpecCreator("Qualitative", StringCell.TYPE).createSpec();
        allColSpecs[15] = new DataColumnSpecCreator("Receptor property", StringCell.TYPE).createSpec();
        allColSpecs[16] = new DataColumnSpecCreator("WT data", DoubleCell.TYPE).createSpec();
        allColSpecs[17] = new DataColumnSpecCreator("Quantitative symbol", StringCell.TYPE).createSpec();
        allColSpecs[18] = new DataColumnSpecCreator("Mutant effect", DoubleCell.TYPE).createSpec();
        allColSpecs[19] = new DataColumnSpecCreator("Mutant effect (%)", DoubleCell.TYPE).createSpec();
        allColSpecs[20] = new DataColumnSpecCreator("Qualitative effect", StringCell.TYPE).createSpec();
        allColSpecs[21] = new DataColumnSpecCreator("Agonist name", StringCell.TYPE).createSpec();
        allColSpecs[22] = new DataColumnSpecCreator("Reference", StringCell.TYPE).createSpec();

        // TODO add foldchange 
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

            fetchMutants(entryName, container);

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

    public void fetchMutants(String entryName, BufferedDataContainer container) throws ApiException {
    	entryName = entryName.toLowerCase();
        List<MutationSerializer> mutants = service.mutantListGET(entryName);
        long currentRow = 0;
        for (MutationSerializer mutant : mutants) {
            RowKey key = new RowKey(entryName + " - " + currentRow);
            // the cells of the current row, the types of the cells must
            // match
            // the column spec (see above)
            DataCell[] cells = new DataCell[23];
            cells[0] = new StringCell(mutant.getProtein());
            cells[1] = new IntCell(mutant.getMutationPos());
            cells[2] = new StringCell(mutant.getMutationFrom());
            cells[3] = new StringCell(mutant.getMutationTo());
            cells[4] = new StringCell(mutant.getLigandName());
            cells[5] = new StringCell(mutant.getLigandIdtype());
            cells[6] = new StringCell(mutant.getLigandId());
            cells[7] = new StringCell(mutant.getLigandClass());
            cells[8] = new StringCell(mutant.getExpType());
            cells[9] = new StringCell(mutant.getExpFunc());
            cells[10] = new DoubleCell(mutant.getExpWtValue());
            cells[11] = new StringCell(mutant.getExpWtUnit());
            cells[12] = new StringCell(mutant.getExpMuEffectSign());
            cells[13] = new DoubleCell(mutant.getExpMuEffectValue());
            cells[14] = new StringCell(mutant.getExpMuEffectQual());
            cells[15] = new StringCell(mutant.getOptType());
            cells[16] = new DoubleCell(mutant.getOptWt());
            cells[17] = new StringCell(mutant.getOptSign());
            cells[18] = new DoubleCell(mutant.getOptMu());
            cells[19] = new DoubleCell(mutant.getOptPercentage());
            cells[20] = new StringCell(mutant.getOptQual());
            cells[21] = new StringCell(mutant.getOptAgonist());
            cells[22] = new StringCell(mutant.getReference());
            DataRow row = new DefaultRow(key, cells);
            container.addRowToTable(row);
            currentRow++;
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

    public ServicesmutantsApi getService() {
        return service;
    }

    public void setService(ServicesmutantsApi service) {
        this.service = service;
    }

}
