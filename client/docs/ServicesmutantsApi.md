# ServicesmutantsApi

All URIs are relative to *http://gpcrdb.org/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**mutantListGET**](ServicesmutantsApi.md#mutantListGET) | **GET** /services/mutants/{entry_name}/ | Get a list of mutants of single protein instance by entry name


<a name="mutantListGET"></a>
# **mutantListGET**
> List&lt;MutationSerializer&gt; mutantListGET(entryName)

Get a list of mutants of single protein instance by entry name

Get a list of mutants of single protein instance by entry name&lt;br/&gt;/mutant/{entry_name}/&lt;br/&gt;{entry_name} is a protein identifier from Uniprot, e.g. adrb2_human

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesmutantsApi;


ServicesmutantsApi apiInstance = new ServicesmutantsApi();
String entryName = "entryName_example"; // String | 
try {
    List<MutationSerializer> result = apiInstance.mutantListGET(entryName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesmutantsApi#mutantListGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entryName** | **String**|  |

### Return type

[**List&lt;MutationSerializer&gt;**](MutationSerializer.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

