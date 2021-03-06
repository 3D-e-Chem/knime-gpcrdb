/*
 * 
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package nl.esciencecenter.e3dchem.gpcrdb.client;

import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
import nl.esciencecenter.e3dchem.gpcrdb.client.model.MutationSerializer;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ServicesmutantsApi
 */
@Ignore
public class ServicesmutantsApiTest {

    private final ServicesmutantsApi api = new ServicesmutantsApi();

    
    /**
     * Get a list of mutants of single protein instance by entry name
     *
     * Get a list of mutants of single protein instance by entry name&lt;br/&gt;/mutant/{entry_name}/&lt;br/&gt;{entry_name} is a protein identifier from Uniprot, e.g. adrb2_human
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void mutantListGETTest() throws ApiException {
        String entryName = null;
        List<MutationSerializer> response = api.mutantListGET(entryName);

        // TODO: test validations
    }
    
}
