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
import nl.esciencecenter.e3dchem.gpcrdb.client.model.ResidueExtendedSerializer;
import nl.esciencecenter.e3dchem.gpcrdb.client.model.ResidueSerializer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ServicesresiduesApi
 */
public class ServicesresiduesApiTest {

    private final ServicesresiduesApi api = new ServicesresiduesApi();

    
    /**
     * Get a list of residues of a protein, including alternative generic numbers
     *
     * Get a list of residues of a protein, including alternative generic numbers&lt;br/&gt;/residues/extended/{entry_name}/&lt;br/&gt;{entry_name} is a protein identifier from Uniprot, e.g. adrb2_human
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void residuesExtendedListGETTest() throws ApiException {
        String entryName = null;
        // List<ResidueExtendedSerializer> response = api.residuesExtendedListGET(entryName);

        // TODO: test validations
    }
    
    /**
     * Get a list of residues of a protein
     *
     * Get a list of residues of a protein&lt;br/&gt;/residues/{entry_name}/&lt;br/&gt;{entry_name} is a protein identifier from Uniprot, e.g. adrb2_human
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void residuesListGETTest() throws ApiException {
        String entryName = null;
        // List<ResidueSerializer> response = api.residuesListGET(entryName);

        // TODO: test validations
    }
    
}
