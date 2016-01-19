package nl.esciencecenter.e3dchem.gpcrdb.client;

import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
import nl.esciencecenter.e3dchem.gpcrdb.client.ApiClient;
import nl.esciencecenter.e3dchem.gpcrdb.client.Configuration;
import nl.esciencecenter.e3dchem.gpcrdb.client.Pair;

import javax.ws.rs.core.GenericType;

import nl.esciencecenter.e3dchem.gpcrdb.client.model.InlineResponseDefault;

import java.util.*;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-01-19T13:05:55.822+01:00")
public class ServicesplotApi {
  private ApiClient apiClient;

  public ServicesplotApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ServicesplotApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * Get SVG source code for a protein&#39;s helix box plot
   * Get SVG source code for a protein&#39;s helix box plot&lt;br/&gt;/plot/helixbox/{entry_name}/&lt;br/&gt;{entry_name} is a protein identifier from Uniprot, e.g. adrb2_human
   * @param entryName 
   * @return InlineResponseDefault
   */
  public InlineResponseDefault helixBoxGET(String entryName) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'entryName' is set
    if (entryName == null) {
      throw new ApiException(400, "Missing the required parameter 'entryName' when calling helixBoxGET");
    }
    
    // create path and map variables
    String path = "/services/plot/helixbox/{entry_name}/".replaceAll("\\{format\\}","json")
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

    
    GenericType<InlineResponseDefault> returnType = new GenericType<InlineResponseDefault>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
  /**
   * Get SVG source code for a protein&#39;s snake plot
   * Get SVG source code for a protein&#39;s snake plot&lt;br/&gt;/plot/snake/{entry_name}/&lt;br/&gt;{entry_name} is a protein identifier from Uniprot, e.g. adrb2_human
   * @param entryName 
   * @return InlineResponseDefault
   */
  public InlineResponseDefault snakePlotGET(String entryName) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'entryName' is set
    if (entryName == null) {
      throw new ApiException(400, "Missing the required parameter 'entryName' when calling snakePlotGET");
    }
    
    // create path and map variables
    String path = "/services/plot/snake/{entry_name}/".replaceAll("\\{format\\}","json")
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

    
    GenericType<InlineResponseDefault> returnType = new GenericType<InlineResponseDefault>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
}
