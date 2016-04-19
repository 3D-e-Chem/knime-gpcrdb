package nl.esciencecenter.e3dchem.gpcrdb.client;

import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
import nl.esciencecenter.e3dchem.gpcrdb.client.ApiClient;
import nl.esciencecenter.e3dchem.gpcrdb.client.Configuration;
import nl.esciencecenter.e3dchem.gpcrdb.client.Pair;

import javax.ws.rs.core.GenericType;

import nl.esciencecenter.e3dchem.gpcrdb.client.model.ResidueExtendedSerializer;
import nl.esciencecenter.e3dchem.gpcrdb.client.model.ResidueSerializer;

import java.util.*;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-03-25T11:18:53.274+01:00")
public class ServicesresiduesApi {
  private ApiClient apiClient;

  public ServicesresiduesApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ServicesresiduesApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * Get a list of residues of a protein, including alternative generic numbers
   * Get a list of residues of a protein, including alternative generic numbers&lt;br/&gt;/residues/extended/{entry_name}/&lt;br/&gt;{entry_name} is a protein identifier from Uniprot, e.g. adrb2_human
   * @param entryName 
   * @return ResidueExtendedSerializer
   */
  public List<ResidueExtendedSerializer> residuesExtendedListGET(String entryName) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'entryName' is set
    if (entryName == null) {
      throw new ApiException(400, "Missing the required parameter 'entryName' when calling residuesExtendedListGET");
    }
    
    // create path and map variables
    String path = "/services/residues/extended/{entry_name}/".replaceAll("\\{format\\}","json")
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

    
    GenericType<List<ResidueExtendedSerializer>> returnType = new GenericType<List<ResidueExtendedSerializer>>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
  /**
   * Get a list of residues of a protein
   * Get a list of residues of a protein&lt;br/&gt;/residues/{entry_name}/&lt;br/&gt;{entry_name} is a protein identifier from Uniprot, e.g. adrb2_human
   * @param entryName 
   * @return ResidueSerializer
   */
  public List<ResidueSerializer> residuesListGET(String entryName) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'entryName' is set
    if (entryName == null) {
      throw new ApiException(400, "Missing the required parameter 'entryName' when calling residuesListGET");
    }
    
    // create path and map variables
    String path = "/services/residues/{entry_name}/".replaceAll("\\{format\\}","json")
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

    
    GenericType<List<ResidueSerializer>> returnType = new GenericType<List<ResidueSerializer>>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
}
