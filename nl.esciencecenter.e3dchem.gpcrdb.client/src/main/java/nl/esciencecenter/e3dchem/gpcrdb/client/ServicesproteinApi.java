package nl.esciencecenter.e3dchem.gpcrdb.client;

import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
import nl.esciencecenter.e3dchem.gpcrdb.client.ApiClient;
import nl.esciencecenter.e3dchem.gpcrdb.client.Configuration;
import nl.esciencecenter.e3dchem.gpcrdb.client.Pair;

import javax.ws.rs.core.GenericType;

import nl.esciencecenter.e3dchem.gpcrdb.client.model.ProteinSerializer;

import java.util.*;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-01-19T13:05:55.822+01:00")
public class ServicesproteinApi {
  private ApiClient apiClient;

  public ServicesproteinApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ServicesproteinApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * Get a single protein instance by accession
   * Get a single protein instance by accession&lt;br/&gt;/protein/accession/{accession}/&lt;br/&gt;{accession} is a protein identifier from Uniprot, e.g. P07550
   * @param accession 
   * @return ProteinSerializer
   */
  public ProteinSerializer proteinByAccessionDetailGET(String accession) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'accession' is set
    if (accession == null) {
      throw new ApiException(400, "Missing the required parameter 'accession' when calling proteinByAccessionDetailGET");
    }
    
    // create path and map variables
    String path = "/services/protein/accession/{accession}/".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "accession" + "\\}", apiClient.escapeString(accession.toString()));

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

    
    GenericType<ProteinSerializer> returnType = new GenericType<ProteinSerializer>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
  /**
   * Get a single protein instance by entry name
   * Get a single protein instance by entry name&lt;br/&gt;/protein/{entry_name}/&lt;br/&gt;{entry_name} is a protein identifier from Uniprot, e.g. adrb2_human
   * @param entryName 
   * @return ProteinSerializer
   */
  public ProteinSerializer proteinDetailGET(String entryName) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'entryName' is set
    if (entryName == null) {
      throw new ApiException(400, "Missing the required parameter 'entryName' when calling proteinDetailGET");
    }
    
    // create path and map variables
    String path = "/services/protein/{entry_name}/".replaceAll("\\{format\\}","json")
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

    
    GenericType<ProteinSerializer> returnType = new GenericType<ProteinSerializer>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
}
