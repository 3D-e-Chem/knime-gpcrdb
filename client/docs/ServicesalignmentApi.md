# ServicesalignmentApi

All URIs are relative to *https://gpcrdb.org*

Method | HTTP request | Description
------------- | ------------- | -------------
[**familyAlignmentGET**](ServicesalignmentApi.md#familyAlignmentGET) | **GET** /services/alignment/family/{slug}/ | Get a full sequence alignment of a protein family including a consensus sequence
[**familyAlignmentGET_0**](ServicesalignmentApi.md#familyAlignmentGET_0) | **GET** /services/alignment/family/{slug}/statistics/ | Get a full sequence alignment of a protein family including a consensus sequence
[**familyAlignmentPartialGET**](ServicesalignmentApi.md#familyAlignmentPartialGET) | **GET** /services/alignment/family/{slug}/{segments}/ | Get a partial sequence alignment of a protein family
[**familyAlignmentPartialGET_0**](ServicesalignmentApi.md#familyAlignmentPartialGET_0) | **GET** /services/alignment/family/{slug}/{segments}/statistics/ | Get a partial sequence alignment of a protein family
[**familyAlignmentPartialSpeciesGET**](ServicesalignmentApi.md#familyAlignmentPartialSpeciesGET) | **GET** /services/alignment/family/{slug}/{segments}/{latin_name}/ | Get a partial sequence alignment of a protein family
[**familyAlignmentPartialSpeciesGET_0**](ServicesalignmentApi.md#familyAlignmentPartialSpeciesGET_0) | **GET** /services/alignment/family/{slug}/{segments}/{latin_name}/statistics/ | Get a partial sequence alignment of a protein family
[**proteinAlignmentGET**](ServicesalignmentApi.md#proteinAlignmentGET) | **GET** /services/alignment/protein/{proteins}/ | Get a full sequence alignment of two or more proteins
[**proteinAlignmentPartialGET**](ServicesalignmentApi.md#proteinAlignmentPartialGET) | **GET** /services/alignment/protein/{proteins}/{segments}/ | Get a partial sequence alignment of two or more proteins
[**proteinAlignmentStatisticsGET**](ServicesalignmentApi.md#proteinAlignmentStatisticsGET) | **GET** /services/alignment/protein/{proteins}/statistics/ | Add a /statics at the end of an alignment in order to
[**proteinAlignmentStatisticsGET_0**](ServicesalignmentApi.md#proteinAlignmentStatisticsGET_0) | **GET** /services/alignment/protein/{proteins}/{segments}/statistics/ | Add a /statics at the end of an alignment in order to
[**proteinSimilaritySearchAlignmentGET**](ServicesalignmentApi.md#proteinSimilaritySearchAlignmentGET) | **GET** /services/alignment/similarity/{proteins}/{segments}/ | Get a segment sequence alignment of two or more proteins ranked by similarity


<a name="familyAlignmentGET"></a>
# **familyAlignmentGET**
> Object familyAlignmentGET(slug)

Get a full sequence alignment of a protein family including a consensus sequence

Get a full sequence alignment of a protein family including a consensus sequence&lt;br/&gt;/alignment/family/{slug}/&lt;br/&gt;{slug} is a protein family identifier, e.g. 001_001_001

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesalignmentApi;


ServicesalignmentApi apiInstance = new ServicesalignmentApi();
String slug = "slug_example"; // String | 
try {
    Object result = apiInstance.familyAlignmentGET(slug);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesalignmentApi#familyAlignmentGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **slug** | **String**|  |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="familyAlignmentGET_0"></a>
# **familyAlignmentGET_0**
> Object familyAlignmentGET_0(slug)

Get a full sequence alignment of a protein family including a consensus sequence

Get a full sequence alignment of a protein family including a consensus sequence&lt;br/&gt;/alignment/family/{slug}/&lt;br/&gt;{slug} is a protein family identifier, e.g. 001_001_001

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesalignmentApi;


ServicesalignmentApi apiInstance = new ServicesalignmentApi();
String slug = "slug_example"; // String | 
try {
    Object result = apiInstance.familyAlignmentGET_0(slug);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesalignmentApi#familyAlignmentGET_0");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **slug** | **String**|  |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="familyAlignmentPartialGET"></a>
# **familyAlignmentPartialGET**
> Object familyAlignmentPartialGET(slug, segments)

Get a partial sequence alignment of a protein family

Get a partial sequence alignment of a protein family&lt;br/&gt;/alignment/family/{slug}/{segments}/&lt;br/&gt;{slug} is a protein family identifier, e.g. 001_001_001&lt;br/&gt;{segments} is a comma separated list of protein segment identifiers and/ or     generic GPCRdb numbers, e.g. TM2,TM3,ECL2,4x50

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesalignmentApi;


ServicesalignmentApi apiInstance = new ServicesalignmentApi();
String slug = "slug_example"; // String | 
String segments = "segments_example"; // String | 
try {
    Object result = apiInstance.familyAlignmentPartialGET(slug, segments);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesalignmentApi#familyAlignmentPartialGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **slug** | **String**|  |
 **segments** | **String**|  |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="familyAlignmentPartialGET_0"></a>
# **familyAlignmentPartialGET_0**
> Object familyAlignmentPartialGET_0(slug, segments)

Get a partial sequence alignment of a protein family

Get a partial sequence alignment of a protein family&lt;br/&gt;/alignment/family/{slug}/{segments}/&lt;br/&gt;{slug} is a protein family identifier, e.g. 001_001_001&lt;br/&gt;{segments} is a comma separated list of protein segment identifiers and/ or     generic GPCRdb numbers, e.g. TM2,TM3,ECL2,4x50

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesalignmentApi;


ServicesalignmentApi apiInstance = new ServicesalignmentApi();
String slug = "slug_example"; // String | 
String segments = "segments_example"; // String | 
try {
    Object result = apiInstance.familyAlignmentPartialGET_0(slug, segments);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesalignmentApi#familyAlignmentPartialGET_0");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **slug** | **String**|  |
 **segments** | **String**|  |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="familyAlignmentPartialSpeciesGET"></a>
# **familyAlignmentPartialSpeciesGET**
> Object familyAlignmentPartialSpeciesGET(slug, segments, latinName)

Get a partial sequence alignment of a protein family

Get a partial sequence alignment of a protein family&lt;br/&gt;/alignment/family/{slug}/{segments}/{species}&lt;br/&gt;{slug} is a protein family identifier, e.g. 001_001_001&lt;br/&gt;{segments} is a comma separated list of protein segment identifiers and/ or     generic GPCRdb numbers, e.g. TM2,TM3,ECL2,4x50&lt;br/&gt;{species} is a species identifier from Uniprot, e.g. Homo sapiens

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesalignmentApi;


ServicesalignmentApi apiInstance = new ServicesalignmentApi();
String slug = "slug_example"; // String | 
String segments = "segments_example"; // String | 
String latinName = "latinName_example"; // String | 
try {
    Object result = apiInstance.familyAlignmentPartialSpeciesGET(slug, segments, latinName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesalignmentApi#familyAlignmentPartialSpeciesGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **slug** | **String**|  |
 **segments** | **String**|  |
 **latinName** | **String**|  |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="familyAlignmentPartialSpeciesGET_0"></a>
# **familyAlignmentPartialSpeciesGET_0**
> Object familyAlignmentPartialSpeciesGET_0(slug, segments, latinName)

Get a partial sequence alignment of a protein family

Get a partial sequence alignment of a protein family&lt;br/&gt;/alignment/family/{slug}/{segments}/{species}&lt;br/&gt;{slug} is a protein family identifier, e.g. 001_001_001&lt;br/&gt;{segments} is a comma separated list of protein segment identifiers and/ or     generic GPCRdb numbers, e.g. TM2,TM3,ECL2,4x50&lt;br/&gt;{species} is a species identifier from Uniprot, e.g. Homo sapiens

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesalignmentApi;


ServicesalignmentApi apiInstance = new ServicesalignmentApi();
String slug = "slug_example"; // String | 
String segments = "segments_example"; // String | 
String latinName = "latinName_example"; // String | 
try {
    Object result = apiInstance.familyAlignmentPartialSpeciesGET_0(slug, segments, latinName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesalignmentApi#familyAlignmentPartialSpeciesGET_0");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **slug** | **String**|  |
 **segments** | **String**|  |
 **latinName** | **String**|  |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="proteinAlignmentGET"></a>
# **proteinAlignmentGET**
> Object proteinAlignmentGET(proteins)

Get a full sequence alignment of two or more proteins

Get a full sequence alignment of two or more proteins&lt;br/&gt;/alignment/protein/{proteins}/&lt;br/&gt;{proteins} is a comma separated list of protein identifiers, e.g. adrb2_human,5ht2a_human

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesalignmentApi;


ServicesalignmentApi apiInstance = new ServicesalignmentApi();
String proteins = "proteins_example"; // String | 
try {
    Object result = apiInstance.proteinAlignmentGET(proteins);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesalignmentApi#proteinAlignmentGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **proteins** | **String**|  |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="proteinAlignmentPartialGET"></a>
# **proteinAlignmentPartialGET**
> Object proteinAlignmentPartialGET(proteins, segments)

Get a partial sequence alignment of two or more proteins

Get a partial sequence alignment of two or more proteins&lt;br/&gt;/alignment/protein/{proteins}/{segments}/&lt;br/&gt;{proteins} is a comma separated list of protein identifiers, e.g. adrb2_human,5ht2a_human&lt;br/&gt;{segments} is a comma separated list of protein segment identifiers and/ or     generic GPCRdb numbers, e.g. TM2,TM3,ECL2,4x50

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesalignmentApi;


ServicesalignmentApi apiInstance = new ServicesalignmentApi();
String proteins = "proteins_example"; // String | 
String segments = "segments_example"; // String | 
try {
    Object result = apiInstance.proteinAlignmentPartialGET(proteins, segments);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesalignmentApi#proteinAlignmentPartialGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **proteins** | **String**|  |
 **segments** | **String**|  |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="proteinAlignmentStatisticsGET"></a>
# **proteinAlignmentStatisticsGET**
> Object proteinAlignmentStatisticsGET(proteins)

Add a /statics at the end of an alignment in order to

Add a /statics at the end of an alignment in order to      receive an additional residue property statistics output e.g.:&lt;br/&gt;/alignment/protein/{proteins}/{segments}/statistics&lt;br/&gt;{proteins} is a comma separated list of protein identifiers, e.g. adrb2_human,5ht2a_human&lt;br/&gt;{segments} is a comma separated list of protein segment identifiers and/ or     generic GPCRdb numbers, e.g. TM2,TM3,ECL2,4x50

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesalignmentApi;


ServicesalignmentApi apiInstance = new ServicesalignmentApi();
String proteins = "proteins_example"; // String | 
try {
    Object result = apiInstance.proteinAlignmentStatisticsGET(proteins);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesalignmentApi#proteinAlignmentStatisticsGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **proteins** | **String**|  |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="proteinAlignmentStatisticsGET_0"></a>
# **proteinAlignmentStatisticsGET_0**
> Object proteinAlignmentStatisticsGET_0(proteins, segments)

Add a /statics at the end of an alignment in order to

Add a /statics at the end of an alignment in order to      receive an additional residue property statistics output e.g.:&lt;br/&gt;/alignment/protein/{proteins}/{segments}/statistics&lt;br/&gt;{proteins} is a comma separated list of protein identifiers, e.g. adrb2_human,5ht2a_human&lt;br/&gt;{segments} is a comma separated list of protein segment identifiers and/ or     generic GPCRdb numbers, e.g. TM2,TM3,ECL2,4x50

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesalignmentApi;


ServicesalignmentApi apiInstance = new ServicesalignmentApi();
String proteins = "proteins_example"; // String | 
String segments = "segments_example"; // String | 
try {
    Object result = apiInstance.proteinAlignmentStatisticsGET_0(proteins, segments);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesalignmentApi#proteinAlignmentStatisticsGET_0");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **proteins** | **String**|  |
 **segments** | **String**|  |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="proteinSimilaritySearchAlignmentGET"></a>
# **proteinSimilaritySearchAlignmentGET**
> ProteinSimilarities proteinSimilaritySearchAlignmentGET(proteins, segments)

Get a segment sequence alignment of two or more proteins ranked by similarity

Get a segment sequence alignment of two or more proteins ranked by similarity&lt;br/&gt;/alignment/similarity/{proteins}/&lt;br/&gt;{proteins} is a comma separated list of protein identifiers, e.g. adrb2_human,5ht2a_human,cxcr4_human,     where the first protein is the query protein and the following the proteins to compare it to&lt;br/&gt;{segments} is a comma separated list of protein segment identifiers and/ or     generic GPCRdb numbers, e.g. TM2,TM3,ECL2,4x50

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesalignmentApi;


ServicesalignmentApi apiInstance = new ServicesalignmentApi();
String proteins = "proteins_example"; // String | 
String segments = "segments_example"; // String | 
try {
    ProteinSimilarities result = apiInstance.proteinSimilaritySearchAlignmentGET(proteins, segments);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesalignmentApi#proteinSimilaritySearchAlignmentGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **proteins** | **String**|  |
 **segments** | **String**|  |

### Return type

[**ProteinSimilarities**](ProteinSimilarities.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

