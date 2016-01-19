package nl.esciencecenter.e3dchem.gpcrdb.client;

import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
import nl.esciencecenter.e3dchem.gpcrdb.client.ApiClient;
import nl.esciencecenter.e3dchem.gpcrdb.client.Configuration;
import nl.esciencecenter.e3dchem.gpcrdb.client.Pair;

import javax.ws.rs.core.GenericType;

import nl.esciencecenter.e3dchem.gpcrdb.client.model.ProteinFamilySerializer;
import nl.esciencecenter.e3dchem.gpcrdb.client.model.ProteinSerializer;

import java.util.*;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-01-19T13:05:55.822+01:00")
public class ServicesproteinfamilyApi {
  private ApiClient apiClient;

  public ServicesproteinfamilyApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ServicesproteinfamilyApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * Get a list of protein families
   * Get a list of protein families&lt;br/&gt;/proteinfamily/
   * @return ProteinFamilySerializer
   */
  public ProteinFamilySerializer proteinFamilyListGET() throws ApiException {
    Object postBody = null;
    
    // create path and map variables
    String path = "/services/proteinfamily/".replaceAll("\\{format\\}","json");

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

    
    GenericType<ProteinFamilySerializer> returnType = new GenericType<ProteinFamilySerializer>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
  /**
   * Get a list of child families of a protein family
   * Get a list of child families of a protein family&lt;br/&gt;/proteinfamily/children/{slug}/&lt;br/&gt;{slug} is a protein family identifier, e.g. 001_001_001
   * @param slug 
   * @return ProteinFamilySerializer
   */
  public ProteinFamilySerializer proteinFamilyChildrenListGET(String slug) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'slug' is set
    if (slug == null) {
      throw new ApiException(400, "Missing the required parameter 'slug' when calling proteinFamilyChildrenListGET");
    }
    
    // create path and map variables
    String path = "/services/proteinfamily/children/{slug}/".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "slug" + "\\}", apiClient.escapeString(slug.toString()));

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

    
    GenericType<ProteinFamilySerializer> returnType = new GenericType<ProteinFamilySerializer>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
  /**
   * Get a list of descendant families of a protein family
   * Get a list of descendant families of a protein family&lt;br/&gt;/proteinfamily/descendants/{slug}/&lt;br/&gt;{slug} is a protein family identifier, e.g. 001_001_001
   * @param slug 
   * @return ProteinFamilySerializer
   */
  public ProteinFamilySerializer proteinFamilyDescendantListGET(String slug) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'slug' is set
    if (slug == null) {
      throw new ApiException(400, "Missing the required parameter 'slug' when calling proteinFamilyDescendantListGET");
    }
    
    // create path and map variables
    String path = "/services/proteinfamily/descendants/{slug}/".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "slug" + "\\}", apiClient.escapeString(slug.toString()));

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

    
    GenericType<ProteinFamilySerializer> returnType = new GenericType<ProteinFamilySerializer>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
  /**
   * Get a list of proteins in a protein family
   * Get a list of proteins in a protein family&lt;br/&gt;/proteinfamily/proteins/{slug}/&lt;br/&gt;{slug} is a protein family identifier, e.g. 001_001_001
   * @param slug 
   * @return ProteinSerializer
   */
  public ProteinSerializer proteinsInFamilyListGET(String slug) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'slug' is set
    if (slug == null) {
      throw new ApiException(400, "Missing the required parameter 'slug' when calling proteinsInFamilyListGET");
    }
    
    // create path and map variables
    String path = "/services/proteinfamily/proteins/{slug}/".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "slug" + "\\}", apiClient.escapeString(slug.toString()));

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
   * Get a single protein family instance
   * Get a single protein family instance&lt;br/&gt;/proteinfamily/{slug}/&lt;br/&gt;{slug} is a protein family identifier, e.g. 001_001_001
   * @param slug 
   * @return ProteinFamilySerializer
   */
  public ProteinFamilySerializer proteinFamilyDetailGET(String slug) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'slug' is set
    if (slug == null) {
      throw new ApiException(400, "Missing the required parameter 'slug' when calling proteinFamilyDetailGET");
    }
    
    // create path and map variables
    String path = "/services/proteinfamily/{slug}/".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "slug" + "\\}", apiClient.escapeString(slug.toString()));

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

    
    GenericType<ProteinFamilySerializer> returnType = new GenericType<ProteinFamilySerializer>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
}
