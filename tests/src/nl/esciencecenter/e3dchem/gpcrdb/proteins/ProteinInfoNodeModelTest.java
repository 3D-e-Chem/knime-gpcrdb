package nl.esciencecenter.e3dchem.gpcrdb.proteins;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.knime.core.data.DataCell;
import org.knime.core.data.DataRow;
import org.knime.core.data.RowKey;
import org.knime.core.data.def.DefaultRow;
import org.knime.core.data.def.StringCell;
import org.knime.core.node.BufferedDataContainer;

import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesproteinApi;
import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesproteinfamilyApi;
import nl.esciencecenter.e3dchem.gpcrdb.client.model.ProteinSerializer;

public class ProteinInfoNodeModelTest {
	private ProteinInfoNodeModel node;
	private ServicesproteinApi service4proteins;
	private ServicesproteinfamilyApi services4families;

	@Before
	public void setUp() {
		node = new ProteinInfoNodeModel();
		service4proteins = mock(ServicesproteinApi.class);
		services4families = mock(ServicesproteinfamilyApi.class);
		node.setService4proteins(service4proteins);
		node.setServices4families(services4families);
	}

	@Test
	public void testFetchProteinByUniprotId() throws ApiException {

		String idtype = ProteinInfoNodeModel.IDTYPE_UNIPROTID;
		BufferedDataContainer container = mock(BufferedDataContainer.class);
		ProteinSerializer response = sampleProtein();
		String entryName = response.getEntryName();
		when(service4proteins.proteinDetailGET(entryName)).thenReturn(response);

		node.fetchProteins(entryName, idtype, container);

		DataRow expectedRow = sampleRow(response);
		verify(container).addRowToTable(expectedRow);
	}

	@Test
	public void testFetchProteinByUniprotId_upperCase() throws ApiException {

		String idtype = ProteinInfoNodeModel.IDTYPE_UNIPROTID;
		BufferedDataContainer container = mock(BufferedDataContainer.class);
		ProteinSerializer response = sampleProtein();
		String entryName = response.getEntryName();
		when(service4proteins.proteinDetailGET(entryName)).thenReturn(response);

		node.fetchProteins("ADRB2_HUMAN", idtype, container);

		DataRow expectedRow = sampleRow(response);
		verify(container).addRowToTable(expectedRow);
	}

	@Test
	public void testFetchProteinByUniprotAccession() throws ApiException {

		String idtype = ProteinInfoNodeModel.IDTYPE_UNIPROTACC;
		BufferedDataContainer container = mock(BufferedDataContainer.class);
		ProteinSerializer response = sampleProtein();
		String accession = response.getAccession();
		when(service4proteins.proteinByAccessionDetailGET(accession)).thenReturn(response);

		node.fetchProteins(accession, idtype, container);

		DataRow expectedRow = sampleRow(response);
		verify(container).addRowToTable(expectedRow);
	}

	@Test
	public void testFetchProteinByFamily() throws ApiException {
		String idtype = ProteinInfoNodeModel.IDTYPE_FAMILIYSLUG;
		BufferedDataContainer container = mock(BufferedDataContainer.class);
		ProteinSerializer response = sampleProtein();
		String family = response.getFamily();
		List<ProteinSerializer> responses = new ArrayList<ProteinSerializer>(2);
		responses.add(response);
		responses.add(response);
		when(services4families.proteinsInFamilyListGET(family)).thenReturn(responses);

		node.fetchProteins(family, idtype, container);

		DataRow expectedRow = sampleRow(response);
		verify(container, times(2)).addRowToTable(expectedRow);
	}

	private DataRow sampleRow(ProteinSerializer response) {
		RowKey key = new RowKey(response.getEntryName());
		DataCell[] cells = new DataCell[8];
		cells[0] = new StringCell(response.getEntryName());
		cells[1] = new StringCell(response.getAccession());
		cells[2] = new StringCell(response.getName());
		cells[3] = new StringCell(response.getFamily());
		cells[4] = new StringCell(response.getSpecies());
		cells[5] = new StringCell(response.getSource());
		cells[6] = new StringCell(response.getResidueNumberingScheme());
		cells[7] = new StringCell(response.getSequence());
		DataRow row = new DefaultRow(key, cells);
		return row;
	}

	/**
	 * Response by "http://grpcrdb.org/services/protein/adrb2_human/" :
	 * 
	 * <pre>
	 * {
	 *   "entry_name": "adrb2_human",
	 *   "name": "&beta;<sub>2</sub>-adrenoceptor",
	 *   "accession": "P07550",
	 *   "family": "001_001_003_008",
	 *   "species": "Homo sapiens",
	 *   "source": "SWISSPROT",
	 *   "residue_numbering_scheme": "GPCRdb(A)",
	 *   "sequence": "MGQPGNGSAFLLAPNGSHAPDHDVTQERDEVWVVGMGIVMSLIVLAIVFGNVLVITAIAKFERLQTVTNYFITSLACADLVMGLAVVPFGAAHILMKMWTFGNFWCEFWTSIDVLCVTASIETLCVIAVDRYFAITSPFKYQSLLTKNKARVIILMVWIVSGLTSFLPIQMHWYRATHQEAINCYANETCCDFFTNQAYAIASSIVSFYVPLVIMVFVYSRVFQEAKRQLQKIDKSEGRFHVQNLSQVEQDGRTGHGLRRSSKFCLKEHKALKTLGIIMGTFTLCWLPFFIVNIVHVIQDNLIRKEVYILLNWIGYVNSGFNPLIYCRSPDFRIAFQELLCLRRSSLKAYGNGYSSNGNTGEQSGYHVEQEKENKLLCEDLPGTEDFVGHQGTVPSDNIDSQGRNCSTNDSLL"
	 * }
	 * </pre>
	 * 
	 * @throws ApiException
	 */
	public ProteinSerializer sampleProtein() {
		ProteinSerializer response = new ProteinSerializer();
		response.setEntryName("adrb2_human");
		response.setAccession("P07550");
		response.setFamily("001_001_003_008");
		response.setName("&beta;<sub>2</sub>-adrenoceptor");
		response.setSpecies("Homo sapiens");
		response.setSource("SWISSPROT");
		response.setResidueNumberingScheme("GPCRdb(A)");
		response.setSequence(
				"MGQPGNGSAFLLAPNGSHAPDHDVTQERDEVWVVGMGIVMSLIVLAIVFGNVLVITAIAKFERLQTVTNYFITSLACADLVMGLAVVPFGAAHILMKMWTFGNFWCEFWTSIDVLCVTASIETLCVIAVDRYFAITSPFKYQSLLTKNKARVIILMVWIVSGLTSFLPIQMHWYRATHQEAINCYANETCCDFFTNQAYAIASSIVSFYVPLVIMVFVYSRVFQEAKRQLQKIDKSEGRFHVQNLSQVEQDGRTGHGLRRSSKFCLKEHKALKTLGIIMGTFTLCWLPFFIVNIVHVIQDNLIRKEVYILLNWIGYVNSGFNPLIYCRSPDFRIAFQELLCLRRSSLKAYGNGYSSNGNTGEQSGYHVEQEKENKLLCEDLPGTEDFVGHQGTVPSDNIDSQGRNCSTNDSLL");
		return response;
	}

}
