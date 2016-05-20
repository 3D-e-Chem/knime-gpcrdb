package nl.esciencecenter.e3dchem.gpcrdb.structures;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesstructureApi;
import nl.esciencecenter.e3dchem.gpcrdb.client.model.StructureLigandInteractionSerializer;

/**
 * This is the model implementation of Interactions. Get a list of interactions between structure and ligand.
 *
 */
public class InteractionsNodeModel extends GpcrdbNodeModel {

    public static final String CFGKEY_INPUTSTRUCTURECOLUMNNAME = "Structure name Column";

    private final SettingsModelString m_inputStructureColumnName = new SettingsModelString(CFGKEY_INPUTSTRUCTURECOLUMNNAME, null);
    private ServicesstructureApi service = new ServicesstructureApi(getApiClient());

    /**
     * Constructor for the node model.
     */
    public InteractionsNodeModel() {

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
        DataTableSpec outputSpec = createOutputSpec();

        // the execution context will provide us with storage capacity, in this
        // case a data container to which we will add rows sequentially
        // Note, this container can also handle arbitrary big data tables, it
        // will buffer to disc if necessary.
        BufferedDataContainer container = exec.createDataContainer(outputSpec);

        BufferedDataTable table = inData[0];
        long rowCount = table.size();
        long currentRow = 0;
        int structureColumnIndex = table.getDataTableSpec().findColumnIndex(m_inputStructureColumnName.getStringValue());

        for (DataRow inrow : table) {
            String pdbCode = ((StringCell) inrow.getCell(structureColumnIndex)).getStringValue();

            fetchInteractions(container, pdbCode);

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

    public void fetchInteractions(BufferedDataContainer container, String pdbCode) throws ApiException {
    	pdbCode = pdbCode.toUpperCase();
        List<StructureLigandInteractionSerializer> interactions = service.structureLigandInteractionsGET(pdbCode);
        long currentRow = 0;
        for (StructureLigandInteractionSerializer interaction : interactions) {
            DataCell[] cells = new DataCell[6];
            cells[0] = new StringCell(pdbCode);
            cells[1] = new StringCell(interaction.getLigandName());
            cells[2] = new LongCell(interaction.getSequenceNumber());
            cells[3] = new StringCell(interaction.getAminoAcid());
            if (interaction.getDisplayGenericNumber() == null) {
                cells[4] = new MissingCell("Position has no generic number");
            } else {
                cells[4] = new StringCell(interaction.getDisplayGenericNumber());
            }
            cells[5] = new StringCell(interaction.getInteractionType());

            RowKey key = new RowKey(pdbCode + " - " + interaction.getSequenceNumber() + " - " + currentRow);
            // the cells of the current row, the types of the cells must
            // match
            // the column spec (see above)
            DataRow row = new DefaultRow(key, cells);
            container.addRowToTable(row);
            currentRow++;
        }
    }

    private DataTableSpec createOutputSpec() {
        DataColumnSpec[] allColSpecs = new DataColumnSpec[6];
        allColSpecs[0] = new DataColumnSpecCreator("PDB code", StringCell.TYPE).createSpec();
        allColSpecs[1] = new DataColumnSpecCreator("Ligand", StringCell.TYPE).createSpec();
        allColSpecs[2] = new DataColumnSpecCreator("Sequence number", LongCell.TYPE).createSpec();
        allColSpecs[3] = new DataColumnSpecCreator("Amino acid", StringCell.TYPE).createSpec();
        allColSpecs[4] = new DataColumnSpecCreator("Generic number", StringCell.TYPE).createSpec();
        allColSpecs[5] = new DataColumnSpecCreator("Interaction type", StringCell.TYPE).createSpec();
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
        m_inputStructureColumnName.saveSettingsTo(settings);
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
        m_inputStructureColumnName.loadSettingsFrom(settings);
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
        m_inputStructureColumnName.validateSettings(settings);
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

    public ServicesstructureApi getService() {
        return service;
    }

    public void setService(ServicesstructureApi service) {
        this.service = service;
    }

}
