package nl.esciencecenter.e3dchem.gpcrdb.client;

import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
import nl.esciencecenter.e3dchem.gpcrdb.client.ApiClient;
import nl.esciencecenter.e3dchem.gpcrdb.client.Configuration;
import nl.esciencecenter.e3dchem.gpcrdb.client.Pair;

import javax.ws.rs.core.GenericType;

import nl.esciencecenter.e3dchem.gpcrdb.client.model.SpeciesSerializer;

import java.util.*;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-03-25T11:18:53.274+01:00")
public class ServicesspeciesApi {
  private ApiClient apiClient;

  public ServicesspeciesApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ServicesspeciesApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * Get a list of species
   * Get a list of species&lt;br/&gt;/species/
   * @return SpeciesSerializer
   */
  public SpeciesSerializer speciesListGET() throws ApiException {
    Object postBody = null;
    
    // create path and map variables
    String path = "/services/species/".replaceAll("\\{format\\}","json");

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

    
    GenericType<SpeciesSerializer> returnType = new GenericType<SpeciesSerializer>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
  /**
   * Get a single species instance
   * Get a single species instance&lt;br/&gt;/species/{latin_name}/&lt;br/&gt;{latin_name} is a species identifier from Uniprot, e.g. Homo sapiens
   * @param latinName 
   * @return SpeciesSerializer
   */
  public SpeciesSerializer speciesDetailGET(String latinName) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'latinName' is set
    if (latinName == null) {
      throw new ApiException(400, "Missing the required parameter 'latinName' when calling speciesDetailGET");
    }
    
    // create path and map variables
    String path = "/services/species/{latin_name}/".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "latin_name" + "\\}", apiClient.escapeString(latinName.toString()));

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

    
    GenericType<SpeciesSerializer> returnType = new GenericType<SpeciesSerializer>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
}
