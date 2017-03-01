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
import org.knime.core.data.def.DoubleCell;
import org.knime.core.data.def.StringCell;
import org.knime.core.data.json.JSONCell;
import org.knime.core.data.json.JSONCellFactory;
import org.knime.core.node.BufferedDataContainer;
import org.knime.core.node.InvalidSettingsException;

import com.google.gson.Gson;

import nl.esciencecenter.e3dchem.gpcrdb.GpcrdbNodeModel;
import nl.esciencecenter.e3dchem.gpcrdb.client.model.Ligand;
import nl.esciencecenter.e3dchem.gpcrdb.client.model.Structure;

public abstract class AbstractStructuresNodeModel extends GpcrdbNodeModel {

	public AbstractStructuresNodeModel(int nrInDataPorts, int nrOutDataPorts) {
		super(nrInDataPorts, nrOutDataPorts);
	}

	protected DataTableSpec structuresTableSpec() {
		// the data table spec of the single output table,
		DataColumnSpec[] allColSpecs = new DataColumnSpec[10];
		allColSpecs[0] = new DataColumnSpecCreator("Publication date", StringCell.TYPE).createSpec();
		allColSpecs[1] = new DataColumnSpecCreator("Preferred chain", StringCell.TYPE).createSpec();
		allColSpecs[2] = new DataColumnSpecCreator("Type", StringCell.TYPE).createSpec();
		allColSpecs[3] = new DataColumnSpecCreator("Species", StringCell.TYPE).createSpec();
		allColSpecs[4] = new DataColumnSpecCreator("Protein", StringCell.TYPE).createSpec();
		allColSpecs[5] = new DataColumnSpecCreator("Resolution", DoubleCell.TYPE).createSpec();
		allColSpecs[6] = new DataColumnSpecCreator("Ligands", JSONCell.TYPE).createSpec();
		allColSpecs[7] = new DataColumnSpecCreator("Publication", StringCell.TYPE).createSpec();
		allColSpecs[8] = new DataColumnSpecCreator("PDB code", StringCell.TYPE).createSpec();
		allColSpecs[9] = new DataColumnSpecCreator("Family", StringCell.TYPE).createSpec();
		DataTableSpec outputSpec = new DataTableSpec(allColSpecs);
		return outputSpec;
	}

	protected void rest2knime(BufferedDataContainer container, List<Structure> structures) {
		for (Structure structure : structures) {
			RowKey key = RowKey.createRowKey(container.size());
			// the cells of the current row, the types of the cells must
			// match
			// the column spec (see above)
			DataCell[] cells = new DataCell[10];
			cells[0] = new StringCell(structure.getPublicationDate());
			cells[1] = new StringCell(structure.getPreferredChain());
			cells[2] = new StringCell(structure.getType());
			cells[3] = new StringCell(structure.getSpecies());
			cells[4] = new StringCell(structure.getProtein());
			cells[5] = new DoubleCell(structure.getResolution());
			cells[6] = string2jsoncell(structure.getLigands());
			String publication = structure.getPublication();
			if (publication == null) {
				cells[7] = new MissingCell("Publication missing");
			} else {
				cells[7] = new StringCell(publication);
			}
			cells[8] = new StringCell(structure.getPdbCode());
			cells[9] = new StringCell(structure.getFamily());
			DataRow row = new DefaultRow(key, cells);
			container.addRowToTable(row);
		}
	}

	protected DataCell string2jsoncell(List<Ligand> ligands) {
		Gson jsonify = new Gson();
		JSONCellFactory jsoncellify = new JSONCellFactory();
		String ligandsjson = jsonify.toJson(ligands);
		return jsoncellify.createCell(ligandsjson);
	}

	@Override
	protected DataTableSpec[] configure(DataTableSpec[] inSpecs) throws InvalidSettingsException {
		return new DataTableSpec[] { structuresTableSpec() };
	}

}