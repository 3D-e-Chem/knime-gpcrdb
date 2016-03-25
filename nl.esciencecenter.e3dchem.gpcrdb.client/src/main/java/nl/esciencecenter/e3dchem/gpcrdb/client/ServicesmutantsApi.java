package nl.esciencecenter.e3dchem.gpcrdb.client;

import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
import nl.esciencecenter.e3dchem.gpcrdb.client.ApiClient;
import nl.esciencecenter.e3dchem.gpcrdb.client.Configuration;
import nl.esciencecenter.e3dchem.gpcrdb.client.Pair;

import javax.ws.rs.core.GenericType;

import nl.esciencecenter.e3dchem.gpcrdb.client.model.MutationSerializer;

import java.util.*;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-03-25T11:18:53.274+01:00")
public class ServicesmutantsApi {
  private ApiClient apiClient;

  public ServicesmutantsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ServicesmutantsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * Get a list of mutants of single protein instance by entry name
   * Get a list of mutants of single protein instance by entry name&lt;br/&gt;/mutant/{entry_name}/&lt;br/&gt;{entry_name} is a protein identifier from Uniprot, e.g. adrb2_human
   * @param entryName 
   * @return MutationSerializer
   */
  public MutationSerializer mutantListGET(String entryName) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'entryName' is set
    if (entryName == null) {
      throw new ApiException(400, "Missing the required parameter 'entryName' when calling mutantListGET");
    }
    
    // create path and map variables
    String path = "/services/mutants/{entry_name}/".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "entry_name" + "\\}", apiClient.escapeString(entryName.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    

    

    

    final String[] accepts = {
      
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };

    
    GenericType<MutationSerializer> returnType = new GenericType<MutationSerializer>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
}
