package nl.esciencecenter.e3dchem.gpcrdb.client;

import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
import nl.esciencecenter.e3dchem.gpcrdb.client.ApiClient;
import nl.esciencecenter.e3dchem.gpcrdb.client.Configuration;
import nl.esciencecenter.e3dchem.gpcrdb.client.Pair;

import javax.ws.rs.core.GenericType;

import nl.esciencecenter.e3dchem.gpcrdb.client.model.InlineResponseDefault;

import java.util.*;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-01-19T13:05:55.822+01:00")
public class ServicesstructureApi {
  private ApiClient apiClient;

  public ServicesstructureApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ServicesstructureApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * Get a list of structures
   * Get a list of structures&lt;br/&gt;/structure/
   * @return InlineResponseDefault
   */
  public InlineResponseDefault structureListGET() throws ApiException {
    Object postBody = null;
    
    // create path and map variables
    String path = "/services/structure/".replaceAll("\\{format\\}","json");

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
   * Assign generic residue numbers (Ballesteros-Weinstein and GPCRdb schemes) to an uploaded pdb file
   * Assign generic residue numbers (Ballesteros-Weinstein and GPCRdb schemes) to an uploaded pdb file.&lt;br/&gt;/structure/assign_generic_numbers&lt;br/&gt;    e.g.\n    curl -X POST -F \&quot;pdb_file=@myfile.pdb\&quot; http://gpcrdb.org/services/structure/assign_generic_numbers
   * @return InlineResponseDefault
   */
  public InlineResponseDefault structureAssignGenericNumbersPOST() throws ApiException {
    Object postBody = null;
    
    // create path and map variables
    String path = "/services/structure/assign_generic_numbers".replaceAll("\\{format\\}","json");

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
    return apiClient.invokeAPI(path, "POST", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
  /**
   * Get a list of structures of a protein
   * Get a list of structures of a protein&lt;br/&gt;/structure/protein/{entry_name}
   * @param entryName 
   * @return InlineResponseDefault
   */
  public InlineResponseDefault structureListProteinGET(String entryName) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'entryName' is set
    if (entryName == null) {
      throw new ApiException(400, "Missing the required parameter 'entryName' when calling structureListProteinGET");
    }
    
    // create path and map variables
    String path = "/services/structure/protein/{entry_name}/".replaceAll("\\{format\\}","json")
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
   * Get a list of representative structures of a protein (one for each activation state)
   * Get a list of representative structures of a protein (one for each activation state)&lt;br/&gt;/structure/protein/{entry_name}/representative/
   * @param entryName 
   * @return InlineResponseDefault
   */
  public InlineResponseDefault representativeStructureListProteinGET(String entryName) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'entryName' is set
    if (entryName == null) {
      throw new ApiException(400, "Missing the required parameter 'entryName' when calling representativeStructureListProteinGET");
    }
    
    // create path and map variables
    String path = "/services/structure/protein/{entry_name}/representative/".replaceAll("\\{format\\}","json")
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
   * Get a list of representative structures (one for each protein and activation state)
   * Get a list of representative structures (one for each protein and activation state)&lt;br/&gt;/structure/representative/
   * @return InlineResponseDefault
   */
  public InlineResponseDefault representativeStructureListGET() throws ApiException {
    Object postBody = null;
    
    // create path and map variables
    String path = "/services/structure/representative/".replaceAll("\\{format\\}","json");

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
   * Get the most similar structure template for a protein using a 7TM alignment
   * Get the most similar structure template for a protein using a 7TM alignment&lt;br/&gt;/structure/template/{entry_name}/&lt;br/&gt;{entry_name} is a protein identifier from Uniprot, e.g. adrb2_human
   * @param entryName 
   * @return InlineResponseDefault
   */
  public InlineResponseDefault structureTemplateGET(String entryName) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'entryName' is set
    if (entryName == null) {
      throw new ApiException(400, "Missing the required parameter 'entryName' when calling structureTemplateGET");
    }
    
    // create path and map variables
    String path = "/services/structure/template/{entry_name}/".replaceAll("\\{format\\}","json")
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
   * Get the most similar structure template for a protein using a partial alignment
   * Get the most similar structure template for a protein using a partial alignment&lt;br/&gt;/structure/template/{entry_name}/{segments}/&lt;br/&gt;{entry_name} is a protein identifier from Uniprot, e.g. adrb2_human&lt;br/&gt;{segments} is a comma separated list of protein segment identifiers, e.g. TM3,TM5,TM6
   * @param entryName 
   * @param segments 
   * @return InlineResponseDefault
   */
  public InlineResponseDefault structureTemplatePartialGET(String entryName, String segments) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'entryName' is set
    if (entryName == null) {
      throw new ApiException(400, "Missing the required parameter 'entryName' when calling structureTemplatePartialGET");
    }
    
    // verify the required parameter 'segments' is set
    if (segments == null) {
      throw new ApiException(400, "Missing the required parameter 'segments' when calling structureTemplatePartialGET");
    }
    
    // create path and map variables
    String path = "/services/structure/template/{entry_name}/{segments}/".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "entry_name" + "\\}", apiClient.escapeString(entryName.toString()))
      .replaceAll("\\{" + "segments" + "\\}", apiClient.escapeString(segments.toString()));

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
   * Get a single structure instance
   * Get a single structure instance&lt;br/&gt;/structure/{pdb_code}/&lt;br/&gt;{pdb_code} is a structure identifier from the Protein Data Bank, e.g. 2RH1
   * @param pdbCode 
   * @return InlineResponseDefault
   */
  public InlineResponseDefault structureDetailGET(String pdbCode) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'pdbCode' is set
    if (pdbCode == null) {
      throw new ApiException(400, "Missing the required parameter 'pdbCode' when calling structureDetailGET");
    }
    
    // create path and map variables
    String path = "/services/structure/{pdb_code}/".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "pdb_code" + "\\}", apiClient.escapeString(pdbCode.toString()));

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
