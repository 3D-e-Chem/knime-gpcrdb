package nl.esciencecenter.e3dchem.gpcrdb.mutants;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.knime.core.data.DataCell;
import org.knime.core.data.DataRow;
import org.knime.core.data.RowKey;
import org.knime.core.data.def.DefaultRow;
import org.knime.core.data.def.DoubleCell;
import org.knime.core.data.def.IntCell;
import org.knime.core.data.def.StringCell;
import org.knime.core.node.BufferedDataContainer;

import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesmutantsApi;
import nl.esciencecenter.e3dchem.gpcrdb.client.model.MutationSerializer;

public class MutantsNodeModelTest {

    @Test
    public void testFetchMutants() throws ApiException {
        String entryName = "hrh1_human";
        MutantsNodeModel model = new MutantsNodeModel();
        ServicesmutantsApi service = mock(ServicesmutantsApi.class);
        List<MutationSerializer> response = sampleMutantsResponse();
        when(service.mutantListGET(entryName)).thenReturn(response);
        model.setService(service);
        BufferedDataContainer container = mock(BufferedDataContainer.class);

        model.fetchMutants(entryName, container);

        verifyContainer(container);
    }


    @Test
    public void testFetchMutants_upperCase() throws ApiException {
        String entryName = "HRH1_HUMAN";
        MutantsNodeModel model = new MutantsNodeModel();
        ServicesmutantsApi service = mock(ServicesmutantsApi.class);
        List<MutationSerializer> response = sampleMutantsResponse();
        when(service.mutantListGET("hrh1_human")).thenReturn(response);
        model.setService(service);
        BufferedDataContainer container = mock(BufferedDataContainer.class);

        model.fetchMutants(entryName, container);

        verifyContainer(container);
    }


	private void verifyContainer(BufferedDataContainer container) {
		DataCell[] expectedCells = new DataCell[23];
        expectedCells[0] = new StringCell("hrh1_human");
        expectedCells[1] = new IntCell(107);
        expectedCells[2] = new StringCell("D");
        expectedCells[3] = new StringCell("E");
        expectedCells[4] = new StringCell("[3H]-mepyramine");
        expectedCells[5] = new StringCell("ChEMBL Compound ID");
        expectedCells[6] = new StringCell("CHEMBL511");
        expectedCells[7] = new StringCell("Binding - unknown pharmacological activity");
        expectedCells[8] = new StringCell("K(d)");
        expectedCells[9] = new StringCell("Binding - Radioligand saturation");
        expectedCells[10] = new DoubleCell((float) 1.04);
        expectedCells[11] = new StringCell("nM");
        expectedCells[12] = new StringCell("=");
        expectedCells[13] = new DoubleCell(0);
        expectedCells[14] = new StringCell("Abolished effect");
        expectedCells[15] = new StringCell("Surface expression");
        expectedCells[16] = new DoubleCell((float) 1.54);
        expectedCells[17] = new StringCell("");
        expectedCells[18] = new DoubleCell(0);
        expectedCells[19] = new DoubleCell(0);
        expectedCells[20] = new StringCell("Abolishment");
        expectedCells[21] = new StringCell("");
        expectedCells[22] = new StringCell("8093027");

        DataRow expectedRow = new DefaultRow(RowKey.createRowKey(0L), expectedCells);
        verify(container).addRowToTable(expectedRow);
	}
    
    private List<MutationSerializer> sampleMutantsResponse() {
        ArrayList<MutationSerializer> response = new ArrayList<MutationSerializer>();

        //		{
        //		    "reference": "8093027",
        //		    "protein": "hrh1_human",
        //		    "mutation_pos": 107,
        //		    "mutation_from": "D",
        //		    "mutation_to": "A",
        //		    "ligand_name": "[3H]-mepyramine",
        //		    "ligand_idtype": "ChEMBL Compound ID",
        //		    "ligand_id": "CHEMBL511",
        //		    "ligand_class": "Binding - unknown pharmacological activity",
        //		    "exp_type": "K(d)",
        //		    "exp_func": "Binding - Radioligand saturation",
        //		    "exp_wt_value": 1.04,
        //		    "exp_wt_unit": "nM",
        //		    "exp_mu_effect_sign": "=",
        //		    "exp_mu_effect_type": "",
        //		    "exp_mu_effect_value": 0,
        //		    "exp_mu_effect_qual": "Abolished effect",
        //		    "exp_mu_effect_ligand_prop": "",
        //		    "exp_mu_ligand_ref": "[3H]-mepyramine (radioligand)",
        //		    "opt_type": "Surface expression",
        //		    "opt_wt": 1.54,
        //		    "opt_mu": 0,
        //		    "opt_sign": "",
        //		    "opt_percentage": 0,
        //		    "opt_qual": "Abolishment",
        //		    "opt_agonist": "",
        //		    "added_date": "2016-03-23"
        //		  },
        MutationSerializer mutant = new MutationSerializer();
        mutant.setProtein("hrh1_human");
        mutant.setMutationPos(107);
        mutant.setMutationFrom("D");
        mutant.setMutationTo("E");
        mutant.setLigandName("[3H]-mepyramine");
        mutant.setLigandIdtype("ChEMBL Compound ID");
        mutant.setLigandId("CHEMBL511");
        mutant.setLigandClass("Binding - unknown pharmacological activity");
        mutant.setExpType("K(d)");
        mutant.setExpFunc("Binding - Radioligand saturation");
        mutant.setExpWtValue((float) 1.04);
        mutant.setExpWtUnit("nM");
        mutant.setExpMuEffectSign("=");
        mutant.setExpMuEffectValue((float) 0);
        mutant.setExpMuEffectQual("Abolished effect");
        mutant.setOptType("Surface expression");
        mutant.setOptWt((float) 1.54);
        mutant.setOptSign("");
        mutant.setOptMu((float) 0);
        mutant.setOptPercentage((float) 0);
        mutant.setOptQual("Abolishment");
        mutant.setOptAgonist("");
        mutant.setReference("8093027");
        response.add(mutant);
        return response;
    }

}
