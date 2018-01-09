# ServicesproteinApi

All URIs are relative to *http://gpcrdb.org*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proteinByAccessionDetailGET**](ServicesproteinApi.md#proteinByAccessionDetailGET) | **GET** /services/protein/accession/{accession}/ | Get a single protein instance by accession
[**proteinDetailGET**](ServicesproteinApi.md#proteinDetailGET) | **GET** /services/protein/{entry_name}/ | Get a single protein instance by entry name


<a name="proteinByAccessionDetailGET"></a>
# **proteinByAccessionDetailGET**
> ProteinSerializer proteinByAccessionDetailGET(accession)

Get a single protein instance by accession

Get a single protein instance by accession&lt;br/&gt;/protein/accession/{accession}/&lt;br/&gt;{accession} is a protein identifier from Uniprot, e.g. P07550

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesproteinApi;


ServicesproteinApi apiInstance = new ServicesproteinApi();
String accession = "accession_example"; // String | 
try {
    ProteinSerializer result = apiInstance.proteinByAccessionDetailGET(accession);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesproteinApi#proteinByAccessionDetailGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accession** | **String**|  |

### Return type

[**ProteinSerializer**](ProteinSerializer.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="proteinDetailGET"></a>
# **proteinDetailGET**
> ProteinSerializer proteinDetailGET(entryName)

Get a single protein instance by entry name

Get a single protein instance by entry name&lt;br/&gt;/protein/{entry_name}/&lt;br/&gt;{entry_name} is a protein identifier from Uniprot, e.g. adrb2_human

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesproteinApi;


ServicesproteinApi apiInstance = new ServicesproteinApi();
String entryName = "entryName_example"; // String | 
try {
    ProteinSerializer result = apiInstance.proteinDetailGET(entryName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesproteinApi#proteinDetailGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entryName** | **String**|  |

### Return type

[**ProteinSerializer**](ProteinSerializer.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

