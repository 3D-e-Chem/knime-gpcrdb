# ServicesplotApi

All URIs are relative to *https://gpcrdb.org*

Method | HTTP request | Description
------------- | ------------- | -------------
[**helixBoxGET**](ServicesplotApi.md#helixBoxGET) | **GET** /services/plot/helixbox/{entry_name}/ | Get SVG source code for a protein&#39;s helix box plot
[**snakePlotGET**](ServicesplotApi.md#snakePlotGET) | **GET** /services/plot/snake/{entry_name}/ | Get SVG source code for a protein&#39;s snake plot


<a name="helixBoxGET"></a>
# **helixBoxGET**
> Object helixBoxGET(entryName)

Get SVG source code for a protein&#39;s helix box plot

Get SVG source code for a protein&#39;s helix box plot&lt;br/&gt;/plot/helixbox/{entry_name}/&lt;br/&gt;{entry_name} is a protein identifier from Uniprot, e.g. adrb2_human

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesplotApi;


ServicesplotApi apiInstance = new ServicesplotApi();
String entryName = "entryName_example"; // String | 
try {
    Object result = apiInstance.helixBoxGET(entryName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesplotApi#helixBoxGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entryName** | **String**|  |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="snakePlotGET"></a>
# **snakePlotGET**
> Object snakePlotGET(entryName)

Get SVG source code for a protein&#39;s snake plot

Get SVG source code for a protein&#39;s snake plot&lt;br/&gt;/plot/snake/{entry_name}/&lt;br/&gt;{entry_name} is a protein identifier from Uniprot, e.g. adrb2_human

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesplotApi;


ServicesplotApi apiInstance = new ServicesplotApi();
String entryName = "entryName_example"; // String | 
try {
    Object result = apiInstance.snakePlotGET(entryName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesplotApi#snakePlotGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entryName** | **String**|  |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

