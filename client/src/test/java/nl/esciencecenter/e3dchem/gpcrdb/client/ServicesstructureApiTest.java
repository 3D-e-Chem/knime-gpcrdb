/**
 * 
 * No descripton provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package nl.esciencecenter.e3dchem.gpcrdb.client;

import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
import nl.esciencecenter.e3dchem.gpcrdb.client.model.StructureLigandInteractionSerializer;
import nl.esciencecenter.e3dchem.gpcrdb.client.model.Structure;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ServicesstructureApi
 */
public class ServicesstructureApiTest {

    private final ServicesstructureApi api = new ServicesstructureApi();

    
    /**
     * Get a list of representative structures (one for each protein and activation state)
     *
     * Get a list of representative structures (one for each protein and activation state)&lt;br/&gt;/structure/representative/
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void representativeStructureListGETTest() throws ApiException {
        // Object response = api.representativeStructureListGET();

        // TODO: test validations
    }
    
    /**
     * Get a list of representative structures of a protein (one for each activation state)
     *
     * Get a list of representative structures of a protein (one for each activation state)&lt;br/&gt;/structure/protein/{entry_name}/representative/
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void representativeStructureListProteinGETTest() throws ApiException {
        String entryName = null;
        // Object response = api.representativeStructureListProteinGET(entryName);

        // TODO: test validations
    }
    
    /**
     * Assign generic residue numbers (Ballesteros-Weinstein and GPCRdb schemes) to an uploaded pdb file
     *
     * Assign generic residue numbers (Ballesteros-Weinstein and GPCRdb schemes) to an uploaded pdb file.&lt;br/&gt;/structure/assign_generic_numbers&lt;br/&gt;    e.g.     curl -X POST -F \&quot;pdb_file&#x3D;@myfile.pdb\&quot; http://gpcrdb.org/services/structure/assign_generic_numbers
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void structureAssignGenericNumbersPOSTTest() throws ApiException {
        // Object response = api.structureAssignGenericNumbersPOST();

        // TODO: test validations
    }
    
    /**
     * Get a single structure instance
     *
     * Get a single structure instance&lt;br/&gt;/structure/{pdb_code}/&lt;br/&gt;{pdb_code} is a structure identifier from the Protein Data Bank, e.g. 2RH1
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void structureDetailGETTest() throws ApiException {
        String pdbCode = null;
        // Object response = api.structureDetailGET(pdbCode);

        // TODO: test validations
    }
    
    /**
     * Get a list of interactions between structure and ligand
     *
     * Get a list of interactions between structure and ligand&lt;br/&gt;/structure/{pdb_code}/interaction/&lt;br/&gt;{pdb_code} is a structure identifier from the Protein Data Bank, e.g. 2RH1
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void structureLigandInteractionsGETTest() throws ApiException {
        String pdbCode = null;
        // List<StructureLigandInteractionSerializer> response = api.structureLigandInteractionsGET(pdbCode);

        // TODO: test validations
    }
    
    /**
     * Get a list of structures
     *
     * Get a list of structures&lt;br/&gt;/structure/
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void structureListGETTest() throws ApiException {
        // Object response = api.structureListGET();

        // TODO: test validations
    }
    
    /**
     * Get a list of structures of a protein
     *
     * Get a list of structures of a protein&lt;br/&gt;/structure/protein/{entry_name}
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void structureListProteinGETTest() throws ApiException {
        String entryName = null;
        // List<Structure> response = api.structureListProteinGET(entryName);

        // TODO: test validations
    }
    
    /**
     * Get the most similar structure template for a protein using a 7TM alignment
     *
     * Get the most similar structure template for a protein using a 7TM alignment&lt;br/&gt;/structure/template/{entry_name}/&lt;br/&gt;{entry_name} is a protein identifier from Uniprot, e.g. adrb2_human
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void structureTemplateGETTest() throws ApiException {
        String entryName = null;
        // Object response = api.structureTemplateGET(entryName);

        // TODO: test validations
    }
    
    /**
     * Get the most similar structure template for a protein using a partial alignment
     *
     * Get the most similar structure template for a protein using a partial alignment&lt;br/&gt;/structure/template/{entry_name}/{segments}/&lt;br/&gt;{entry_name} is a protein identifier from Uniprot, e.g. adrb2_human&lt;br/&gt;{segments} is a comma separated list of protein segment identifiers, e.g. TM3,TM5,TM6
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void structureTemplatePartialGETTest() throws ApiException {
        String entryName = null;
        String segments = null;
        // Object response = api.structureTemplatePartialGET(entryName, segments);

        // TODO: test validations
    }
    
}