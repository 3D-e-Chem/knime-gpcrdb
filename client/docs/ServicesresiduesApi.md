# ServicesresiduesApi

All URIs are relative to *https://gpcrdb.org*

Method | HTTP request | Description
------------- | ------------- | -------------
[**residuesExtendedListGET**](ServicesresiduesApi.md#residuesExtendedListGET) | **GET** /services/residues/extended/{entry_name}/ | Get a list of residues of a protein, including alternative generic numbers
[**residuesListGET**](ServicesresiduesApi.md#residuesListGET) | **GET** /services/residues/{entry_name}/ | Get a list of residues of a protein


<a name="residuesExtendedListGET"></a>
# **residuesExtendedListGET**
> List&lt;ResidueExtendedSerializer&gt; residuesExtendedListGET(entryName)

Get a list of residues of a protein, including alternative generic numbers

Get a list of residues of a protein, including alternative generic numbers&lt;br/&gt;/residues/extended/{entry_name}/&lt;br/&gt;{entry_name} is a protein identifier from Uniprot, e.g. adrb2_human

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesresiduesApi;


ServicesresiduesApi apiInstance = new ServicesresiduesApi();
String entryName = "entryName_example"; // String | 
try {
    List<ResidueExtendedSerializer> result = apiInstance.residuesExtendedListGET(entryName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesresiduesApi#residuesExtendedListGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entryName** | **String**|  |

### Return type

[**List&lt;ResidueExtendedSerializer&gt;**](ResidueExtendedSerializer.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="residuesListGET"></a>
# **residuesListGET**
> List&lt;ResidueSerializer&gt; residuesListGET(entryName)

Get a list of residues of a protein

Get a list of residues of a protein&lt;br/&gt;/residues/{entry_name}/&lt;br/&gt;{entry_name} is a protein identifier from Uniprot, e.g. adrb2_human

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesresiduesApi;


ServicesresiduesApi apiInstance = new ServicesresiduesApi();
String entryName = "entryName_example"; // String | 
try {
    List<ResidueSerializer> result = apiInstance.residuesListGET(entryName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesresiduesApi#residuesListGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entryName** | **String**|  |

### Return type

[**List&lt;ResidueSerializer&gt;**](ResidueSerializer.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

