package nl.esciencecenter.e3dchem.gpcrdb.client;

import static org.junit.Assert.*;

import org.junit.Test;

import nl.esciencecenter.e3dchem.gpcrdb.client.model.ProteinSerializer;

public class ApiClientTest {

	@Test
	public void testApiClient() throws ApiException {
		ApiClient client = new ApiClient();
        String basePath = "http://192.168.14.1:8000/";
		client.setBasePath(basePath);
        client.setDebugging(true);
        client.addDefaultHeader("Accept", "application/json");
//        client.addDefaultHeader("Accept", "application/json");
//        String[] accepts = new String[]{"application/json"};
//        client.selectHeaderAccept(accepts);
        
        ServicesproteinApi service = new ServicesproteinApi(client);
        String entryName = "adrb2_human";
        
        ProteinSerializer result = service.proteinDetailGET(entryName);
     
        assertEquals(result.getEntryName(), entryName);
	}

}
