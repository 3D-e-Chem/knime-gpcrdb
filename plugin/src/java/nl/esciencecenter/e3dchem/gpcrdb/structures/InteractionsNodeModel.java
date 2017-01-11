package nl.esciencecenter.e3dchem.gpcrdb.structures;

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
import org.knime.core.node.ExecutionContext;
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

            try {
                fetchInteractions(container, pdbCode);
			} catch (ApiException e) {
				handleApiException(e, pdbCode);
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

    public void fetchInteractions(BufferedDataContainer container, String pdbCode) throws ApiException {
        String pdbCodeLC = pdbCode.toUpperCase();
        List<StructureLigandInteractionSerializer> interactions = service.structureLigandInteractionsGET(pdbCodeLC);
        long currentRow = 0;
        for (StructureLigandInteractionSerializer interaction : interactions) {
            DataCell[] cells = new DataCell[6];
            cells[0] = new StringCell(pdbCodeLC);
            cells[1] = new StringCell(interaction.getLigandName());
            cells[2] = new LongCell(interaction.getSequenceNumber());
            cells[3] = new StringCell(interaction.getAminoAcid());
            if (interaction.getDisplayGenericNumber() == null) {
                cells[4] = new MissingCell("Position has no generic number");
            } else {
                cells[4] = new StringCell(interaction.getDisplayGenericNumber());
            }
            cells[5] = new StringCell(interaction.getInteractionType());

            RowKey key = new RowKey(pdbCodeLC + " - " + interaction.getSequenceNumber() + " - " + currentRow);
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
    protected DataTableSpec[] configure(final DataTableSpec[] inSpecs) throws InvalidSettingsException {

    	if (inSpecs.length > 0 && inSpecs[0] != null){
        	int columnIndex = inSpecs[0].findColumnIndex(m_inputStructureColumnName.getStringValue());
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
        m_inputStructureColumnName.saveSettingsTo(settings);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void loadValidatedSettingsFrom(final NodeSettingsRO settings) throws InvalidSettingsException {
        super.loadValidatedSettingsFrom(settings);
        m_inputStructureColumnName.loadSettingsFrom(settings);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void validateSettings(final NodeSettingsRO settings) throws InvalidSettingsException {
        super.validateSettings(settings);
        m_inputStructureColumnName.validateSettings(settings);
    }

    public ServicesstructureApi getService() {
        return service;
    }

    public void setService(ServicesstructureApi service) {
        this.service = service;
    }
}
