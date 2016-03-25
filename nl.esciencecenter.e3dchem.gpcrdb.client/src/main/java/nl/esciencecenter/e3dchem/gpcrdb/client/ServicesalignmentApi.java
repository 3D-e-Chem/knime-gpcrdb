package nl.esciencecenter.e3dchem.gpcrdb.client;

import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
import nl.esciencecenter.e3dchem.gpcrdb.client.ApiClient;
import nl.esciencecenter.e3dchem.gpcrdb.client.Configuration;
import nl.esciencecenter.e3dchem.gpcrdb.client.Pair;

import javax.ws.rs.core.GenericType;

import nl.esciencecenter.e3dchem.gpcrdb.client.model.InlineResponseDefault;

import java.util.*;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-03-25T11:18:53.274+01:00")
public class ServicesalignmentApi {
  private ApiClient apiClient;

  public ServicesalignmentApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ServicesalignmentApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * Get a full sequence alignment of a protein family including a consensus sequence
   * Get a full sequence alignment of a protein family including a consensus sequence&lt;br/&gt;/alignment/family/{slug}/&lt;br/&gt;{slug} is a protein family identifier, e.g. 001_001_001
   * @param slug 
   * @return InlineResponseDefault
   */
  public InlineResponseDefault familyAlignmentGET(String slug) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'slug' is set
    if (slug == null) {
      throw new ApiException(400, "Missing the required parameter 'slug' when calling familyAlignmentGET");
    }
    
    // create path and map variables
    String path = "/services/alignment/family/{slug}/".replaceAll("\\{format\\}","json")
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

    
    GenericType<InlineResponseDefault> returnType = new GenericType<InlineResponseDefault>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
  /**
   * Get a partial sequence alignment of a protein family
   * Get a partial sequence alignment of a protein family&lt;br/&gt;/alignment/family/{slug}/{segments}/&lt;br/&gt;{slug} is a protein family identifier, e.g. 001_001_001&lt;br/&gt;{segments} is a comma separated list of protein segment identifiers and/ or\n    generic GPCRdb numbers, e.g. TM2,TM3,ECL2,4x50
   * @param slug 
   * @param segments 
   * @return InlineResponseDefault
   */
  public InlineResponseDefault familyAlignmentPartialGET(String slug, String segments) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'slug' is set
    if (slug == null) {
      throw new ApiException(400, "Missing the required parameter 'slug' when calling familyAlignmentPartialGET");
    }
    
    // verify the required parameter 'segments' is set
    if (segments == null) {
      throw new ApiException(400, "Missing the required parameter 'segments' when calling familyAlignmentPartialGET");
    }
    
    // create path and map variables
    String path = "/services/alignment/family/{slug}/{segments}/".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "slug" + "\\}", apiClient.escapeString(slug.toString()))
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
   * Get a partial sequence alignment of a protein family
   * Get a partial sequence alignment of a protein family&lt;br/&gt;/alignment/family/{slug}/{segments}/{species}&lt;br/&gt;{slug} is a protein family identifier, e.g. 001_001_001&lt;br/&gt;{segments} is a comma separated list of protein segment identifiers and/ or\n    generic GPCRdb numbers, e.g. TM2,TM3,ECL2,4x50&lt;br/&gt;{species} is a species identifier from Uniprot, e.g. Homo sapiens
   * @param slug 
   * @param segments 
   * @param latinName 
   * @return InlineResponseDefault
   */
  public InlineResponseDefault familyAlignmentPartialSpeciesGET(String slug, String segments, String latinName) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'slug' is set
    if (slug == null) {
      throw new ApiException(400, "Missing the required parameter 'slug' when calling familyAlignmentPartialSpeciesGET");
    }
    
    // verify the required parameter 'segments' is set
    if (segments == null) {
      throw new ApiException(400, "Missing the required parameter 'segments' when calling familyAlignmentPartialSpeciesGET");
    }
    
    // verify the required parameter 'latinName' is set
    if (latinName == null) {
      throw new ApiException(400, "Missing the required parameter 'latinName' when calling familyAlignmentPartialSpeciesGET");
    }
    
    // create path and map variables
    String path = "/services/alignment/family/{slug}/{segments}/{latin_name}/".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "slug" + "\\}", apiClient.escapeString(slug.toString()))
      .replaceAll("\\{" + "segments" + "\\}", apiClient.escapeString(segments.toString()))
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

    
    GenericType<InlineResponseDefault> returnType = new GenericType<InlineResponseDefault>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
  /**
   * Get a full sequence alignment of two or more proteins
   * Get a full sequence alignment of two or more proteins&lt;br/&gt;/alignment/protein/{proteins}/&lt;br/&gt;{proteins} is a comma separated list of protein identifiers, e.g. adrb2_human,5ht2a_human
   * @param proteins 
   * @return InlineResponseDefault
   */
  public InlineResponseDefault proteinAlignmentGET(String proteins) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'proteins' is set
    if (proteins == null) {
      throw new ApiException(400, "Missing the required parameter 'proteins' when calling proteinAlignmentGET");
    }
    
    // create path and map variables
    String path = "/services/alignment/protein/{proteins}/".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "proteins" + "\\}", apiClient.escapeString(proteins.toString()));

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
   * Get a partial sequence alignment of two or more proteins
   * Get a partial sequence alignment of two or more proteins&lt;br/&gt;/alignment/protein/{proteins}/{segments}/&lt;br/&gt;{proteins} is a comma separated list of protein identifiers, e.g. adrb2_human,5ht2a_human&lt;br/&gt;{segments} is a comma separated list of protein segment identifiers and/ or\n    generic GPCRdb numbers, e.g. TM2,TM3,ECL2,4x50
   * @param proteins 
   * @param segments 
   * @return InlineResponseDefault
   */
  public InlineResponseDefault proteinAlignmentPartialGET(String proteins, String segments) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'proteins' is set
    if (proteins == null) {
      throw new ApiException(400, "Missing the required parameter 'proteins' when calling proteinAlignmentPartialGET");
    }
    
    // verify the required parameter 'segments' is set
    if (segments == null) {
      throw new ApiException(400, "Missing the required parameter 'segments' when calling proteinAlignmentPartialGET");
    }
    
    // create path and map variables
    String path = "/services/alignment/protein/{proteins}/{segments}/".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "proteins" + "\\}", apiClient.escapeString(proteins.toString()))
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
   * Get a segment sequence alignment of two or more proteins ranked by similarity
   * Get a segment sequence alignment of two or more proteins ranked by similarity&lt;br/&gt;/alignment/similarity/{proteins}/&lt;br/&gt;{proteins} is a comma separated list of protein identifiers, e.g. adrb2_human,5ht2a_human,cxcr4_human,\n    where the first protein is the query protein and the following the proteins to compare it to&lt;br/&gt;{segments} is a comma separated list of protein segment identifiers and/ or\n    generic GPCRdb numbers, e.g. TM2,TM3,ECL2,4x50
   * @param proteins 
   * @param segments 
   * @return InlineResponseDefault
   */
  public InlineResponseDefault proteinSimilaritySearchAlignmentGET(String proteins, String segments) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'proteins' is set
    if (proteins == null) {
      throw new ApiException(400, "Missing the required parameter 'proteins' when calling proteinSimilaritySearchAlignmentGET");
    }
    
    // verify the required parameter 'segments' is set
    if (segments == null) {
      throw new ApiException(400, "Missing the required parameter 'segments' when calling proteinSimilaritySearchAlignmentGET");
    }
    
    // create path and map variables
    String path = "/services/alignment/similarity/{proteins}/{segments}/".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "proteins" + "\\}", apiClient.escapeString(proteins.toString()))
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
  
}
