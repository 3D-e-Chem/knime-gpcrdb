# ServicesproteinfamilyApi

All URIs are relative to *http://gpcrdb.org/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proteinFamilyChildrenListGET**](ServicesproteinfamilyApi.md#proteinFamilyChildrenListGET) | **GET** /services/proteinfamily/children/{slug}/ | Get a list of child families of a protein family
[**proteinFamilyDescendantListGET**](ServicesproteinfamilyApi.md#proteinFamilyDescendantListGET) | **GET** /services/proteinfamily/descendants/{slug}/ | Get a list of descendant families of a protein family
[**proteinFamilyDetailGET**](ServicesproteinfamilyApi.md#proteinFamilyDetailGET) | **GET** /services/proteinfamily/{slug}/ | Get a single protein family instance
[**proteinFamilyListGET**](ServicesproteinfamilyApi.md#proteinFamilyListGET) | **GET** /services/proteinfamily/ | Get a list of protein families
[**proteinsInFamilyListGET**](ServicesproteinfamilyApi.md#proteinsInFamilyListGET) | **GET** /services/proteinfamily/proteins/{slug}/ | Get a list of proteins in a protein family
[**proteinsInFamilySpeciesListGET**](ServicesproteinfamilyApi.md#proteinsInFamilySpeciesListGET) | **GET** /services/proteinfamily/proteins/{slug}/{latin_name}/ | Get a list of proteins in a protein family


<a name="proteinFamilyChildrenListGET"></a>
# **proteinFamilyChildrenListGET**
> ProteinFamilySerializer proteinFamilyChildrenListGET(slug)

Get a list of child families of a protein family

Get a list of child families of a protein family&lt;br/&gt;/proteinfamily/children/{slug}/&lt;br/&gt;{slug} is a protein family identifier, e.g. 001_001_001

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesproteinfamilyApi;


ServicesproteinfamilyApi apiInstance = new ServicesproteinfamilyApi();
String slug = "slug_example"; // String | 
try {
    ProteinFamilySerializer result = apiInstance.proteinFamilyChildrenListGET(slug);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesproteinfamilyApi#proteinFamilyChildrenListGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **slug** | **String**|  |

### Return type

[**ProteinFamilySerializer**](ProteinFamilySerializer.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="proteinFamilyDescendantListGET"></a>
# **proteinFamilyDescendantListGET**
> ProteinFamilySerializer proteinFamilyDescendantListGET(slug)

Get a list of descendant families of a protein family

Get a list of descendant families of a protein family&lt;br/&gt;/proteinfamily/descendants/{slug}/&lt;br/&gt;{slug} is a protein family identifier, e.g. 001_001_001

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesproteinfamilyApi;


ServicesproteinfamilyApi apiInstance = new ServicesproteinfamilyApi();
String slug = "slug_example"; // String | 
try {
    ProteinFamilySerializer result = apiInstance.proteinFamilyDescendantListGET(slug);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesproteinfamilyApi#proteinFamilyDescendantListGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **slug** | **String**|  |

### Return type

[**ProteinFamilySerializer**](ProteinFamilySerializer.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="proteinFamilyDetailGET"></a>
# **proteinFamilyDetailGET**
> ProteinFamilySerializer proteinFamilyDetailGET(slug)

Get a single protein family instance

Get a single protein family instance&lt;br/&gt;/proteinfamily/{slug}/&lt;br/&gt;{slug} is a protein family identifier, e.g. 001_001_001

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesproteinfamilyApi;


ServicesproteinfamilyApi apiInstance = new ServicesproteinfamilyApi();
String slug = "slug_example"; // String | 
try {
    ProteinFamilySerializer result = apiInstance.proteinFamilyDetailGET(slug);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesproteinfamilyApi#proteinFamilyDetailGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **slug** | **String**|  |

### Return type

[**ProteinFamilySerializer**](ProteinFamilySerializer.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="proteinFamilyListGET"></a>
# **proteinFamilyListGET**
> List&lt;ProteinFamilySerializer&gt; proteinFamilyListGET()

Get a list of protein families

Get a list of protein families&lt;br/&gt;/proteinfamily/

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesproteinfamilyApi;


ServicesproteinfamilyApi apiInstance = new ServicesproteinfamilyApi();
try {
    List<ProteinFamilySerializer> result = apiInstance.proteinFamilyListGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesproteinfamilyApi#proteinFamilyListGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;ProteinFamilySerializer&gt;**](ProteinFamilySerializer.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="proteinsInFamilyListGET"></a>
# **proteinsInFamilyListGET**
> List&lt;ProteinSerializer&gt; proteinsInFamilyListGET(slug)

Get a list of proteins in a protein family

Get a list of proteins in a protein family&lt;br/&gt;/proteinfamily/proteins/{slug}/&lt;br/&gt;{slug} is a protein family identifier, e.g. 001_001_001

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesproteinfamilyApi;


ServicesproteinfamilyApi apiInstance = new ServicesproteinfamilyApi();
String slug = "slug_example"; // String | 
try {
    List<ProteinSerializer> result = apiInstance.proteinsInFamilyListGET(slug);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesproteinfamilyApi#proteinsInFamilyListGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **slug** | **String**|  |

### Return type

[**List&lt;ProteinSerializer&gt;**](ProteinSerializer.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="proteinsInFamilySpeciesListGET"></a>
# **proteinsInFamilySpeciesListGET**
> List&lt;ProteinSerializer&gt; proteinsInFamilySpeciesListGET(slug, latinName)

Get a list of proteins in a protein family

Get a list of proteins in a protein family&lt;br/&gt;/proteinfamily/proteins/{slug}/{species}&lt;br/&gt;{slug} is a protein family identifier, e.g. 001_001_001&lt;br/&gt;{latin_name} is a species identifier from Uniprot, e.g. Homo sapiens

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesproteinfamilyApi;


ServicesproteinfamilyApi apiInstance = new ServicesproteinfamilyApi();
String slug = "slug_example"; // String | 
String latinName = "latinName_example"; // String | 
try {
    List<ProteinSerializer> result = apiInstance.proteinsInFamilySpeciesListGET(slug, latinName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesproteinfamilyApi#proteinsInFamilySpeciesListGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **slug** | **String**|  |
 **latinName** | **String**|  |

### Return type

[**List&lt;ProteinSerializer&gt;**](ProteinSerializer.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

