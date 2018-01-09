# ServicesspeciesApi

All URIs are relative to *http://gpcrdb.org*

Method | HTTP request | Description
------------- | ------------- | -------------
[**speciesDetailGET**](ServicesspeciesApi.md#speciesDetailGET) | **GET** /services/species/{latin_name}/ | Get a single species instance
[**speciesListGET**](ServicesspeciesApi.md#speciesListGET) | **GET** /services/species/ | Get a list of species


<a name="speciesDetailGET"></a>
# **speciesDetailGET**
> SpeciesSerializer speciesDetailGET(latinName)

Get a single species instance

Get a single species instance&lt;br/&gt;/species/{latin_name}/&lt;br/&gt;{latin_name} is a species identifier from Uniprot, e.g. Homo sapiens

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesspeciesApi;


ServicesspeciesApi apiInstance = new ServicesspeciesApi();
String latinName = "latinName_example"; // String | 
try {
    SpeciesSerializer result = apiInstance.speciesDetailGET(latinName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesspeciesApi#speciesDetailGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **latinName** | **String**|  |

### Return type

[**SpeciesSerializer**](SpeciesSerializer.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="speciesListGET"></a>
# **speciesListGET**
> SpeciesSerializer speciesListGET()

Get a list of species

Get a list of species&lt;br/&gt;/species/

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesspeciesApi;


ServicesspeciesApi apiInstance = new ServicesspeciesApi();
try {
    SpeciesSerializer result = apiInstance.speciesListGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesspeciesApi#speciesListGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**SpeciesSerializer**](SpeciesSerializer.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

