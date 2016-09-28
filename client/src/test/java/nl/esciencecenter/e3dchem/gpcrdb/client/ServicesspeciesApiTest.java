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
import nl.esciencecenter.e3dchem.gpcrdb.client.model.SpeciesSerializer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ServicesspeciesApi
 */
public class ServicesspeciesApiTest {

    private final ServicesspeciesApi api = new ServicesspeciesApi();

    
    /**
     * Get a single species instance
     *
     * Get a single species instance&lt;br/&gt;/species/{latin_name}/&lt;br/&gt;{latin_name} is a species identifier from Uniprot, e.g. Homo sapiens
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void speciesDetailGETTest() throws ApiException {
        String latinName = null;
        // SpeciesSerializer response = api.speciesDetailGET(latinName);

        // TODO: test validations
    }
    
    /**
     * Get a list of species
     *
     * Get a list of species&lt;br/&gt;/species/
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void speciesListGETTest() throws ApiException {
        // SpeciesSerializer response = api.speciesListGET();

        // TODO: test validations
    }
    
}