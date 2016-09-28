# ServicesstructureApi

All URIs are relative to *http://gpcrdb.org/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**representativeStructureListGET**](ServicesstructureApi.md#representativeStructureListGET) | **GET** /services/structure/representative/ | Get a list of representative structures (one for each protein and activation state)
[**representativeStructureListProteinGET**](ServicesstructureApi.md#representativeStructureListProteinGET) | **GET** /services/structure/protein/{entry_name}/representative/ | Get a list of representative structures of a protein (one for each activation state)
[**structureAssignGenericNumbersPOST**](ServicesstructureApi.md#structureAssignGenericNumbersPOST) | **POST** /services/structure/assign_generic_numbers | Assign generic residue numbers (Ballesteros-Weinstein and GPCRdb schemes) to an uploaded pdb file
[**structureDetailGET**](ServicesstructureApi.md#structureDetailGET) | **GET** /services/structure/{pdb_code}/ | Get a single structure instance
[**structureLigandInteractionsGET**](ServicesstructureApi.md#structureLigandInteractionsGET) | **GET** /services/structure/{pdb_code}/interaction/ | Get a list of interactions between structure and ligand
[**structureListGET**](ServicesstructureApi.md#structureListGET) | **GET** /services/structure/ | Get a list of structures
[**structureListProteinGET**](ServicesstructureApi.md#structureListProteinGET) | **GET** /services/structure/protein/{entry_name}/ | Get a list of structures of a protein
[**structureTemplateGET**](ServicesstructureApi.md#structureTemplateGET) | **GET** /services/structure/template/{entry_name}/ | Get the most similar structure template for a protein using a 7TM alignment
[**structureTemplatePartialGET**](ServicesstructureApi.md#structureTemplatePartialGET) | **GET** /services/structure/template/{entry_name}/{segments}/ | Get the most similar structure template for a protein using a partial alignment


<a name="representativeStructureListGET"></a>
# **representativeStructureListGET**
> Object representativeStructureListGET()

Get a list of representative structures (one for each protein and activation state)

Get a list of representative structures (one for each protein and activation state)&lt;br/&gt;/structure/representative/

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesstructureApi;


ServicesstructureApi apiInstance = new ServicesstructureApi();
try {
    Object result = apiInstance.representativeStructureListGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesstructureApi#representativeStructureListGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="representativeStructureListProteinGET"></a>
# **representativeStructureListProteinGET**
> Object representativeStructureListProteinGET(entryName)

Get a list of representative structures of a protein (one for each activation state)

Get a list of representative structures of a protein (one for each activation state)&lt;br/&gt;/structure/protein/{entry_name}/representative/

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesstructureApi;


ServicesstructureApi apiInstance = new ServicesstructureApi();
String entryName = "entryName_example"; // String | 
try {
    Object result = apiInstance.representativeStructureListProteinGET(entryName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesstructureApi#representativeStructureListProteinGET");
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

<a name="structureAssignGenericNumbersPOST"></a>
# **structureAssignGenericNumbersPOST**
> Object structureAssignGenericNumbersPOST()

Assign generic residue numbers (Ballesteros-Weinstein and GPCRdb schemes) to an uploaded pdb file

Assign generic residue numbers (Ballesteros-Weinstein and GPCRdb schemes) to an uploaded pdb file.&lt;br/&gt;/structure/assign_generic_numbers&lt;br/&gt;    e.g.     curl -X POST -F \&quot;pdb_file&#x3D;@myfile.pdb\&quot; http://gpcrdb.org/services/structure/assign_generic_numbers

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesstructureApi;


ServicesstructureApi apiInstance = new ServicesstructureApi();
try {
    Object result = apiInstance.structureAssignGenericNumbersPOST();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesstructureApi#structureAssignGenericNumbersPOST");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="structureDetailGET"></a>
# **structureDetailGET**
> Object structureDetailGET(pdbCode)

Get a single structure instance

Get a single structure instance&lt;br/&gt;/structure/{pdb_code}/&lt;br/&gt;{pdb_code} is a structure identifier from the Protein Data Bank, e.g. 2RH1

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesstructureApi;


ServicesstructureApi apiInstance = new ServicesstructureApi();
String pdbCode = "pdbCode_example"; // String | 
try {
    Object result = apiInstance.structureDetailGET(pdbCode);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesstructureApi#structureDetailGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pdbCode** | **String**|  |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="structureLigandInteractionsGET"></a>
# **structureLigandInteractionsGET**
> List&lt;StructureLigandInteractionSerializer&gt; structureLigandInteractionsGET(pdbCode)

Get a list of interactions between structure and ligand

Get a list of interactions between structure and ligand&lt;br/&gt;/structure/{pdb_code}/interaction/&lt;br/&gt;{pdb_code} is a structure identifier from the Protein Data Bank, e.g. 2RH1

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesstructureApi;


ServicesstructureApi apiInstance = new ServicesstructureApi();
String pdbCode = "pdbCode_example"; // String | 
try {
    List<StructureLigandInteractionSerializer> result = apiInstance.structureLigandInteractionsGET(pdbCode);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesstructureApi#structureLigandInteractionsGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pdbCode** | **String**|  |

### Return type

[**List&lt;StructureLigandInteractionSerializer&gt;**](StructureLigandInteractionSerializer.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="structureListGET"></a>
# **structureListGET**
> Object structureListGET()

Get a list of structures

Get a list of structures&lt;br/&gt;/structure/

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesstructureApi;


ServicesstructureApi apiInstance = new ServicesstructureApi();
try {
    Object result = apiInstance.structureListGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesstructureApi#structureListGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="structureListProteinGET"></a>
# **structureListProteinGET**
> List&lt;Structure&gt; structureListProteinGET(entryName)

Get a list of structures of a protein

Get a list of structures of a protein&lt;br/&gt;/structure/protein/{entry_name}

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesstructureApi;


ServicesstructureApi apiInstance = new ServicesstructureApi();
String entryName = "entryName_example"; // String | 
try {
    List<Structure> result = apiInstance.structureListProteinGET(entryName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesstructureApi#structureListProteinGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entryName** | **String**|  |

### Return type

[**List&lt;Structure&gt;**](Structure.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="structureTemplateGET"></a>
# **structureTemplateGET**
> Object structureTemplateGET(entryName)

Get the most similar structure template for a protein using a 7TM alignment

Get the most similar structure template for a protein using a 7TM alignment&lt;br/&gt;/structure/template/{entry_name}/&lt;br/&gt;{entry_name} is a protein identifier from Uniprot, e.g. adrb2_human

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesstructureApi;


ServicesstructureApi apiInstance = new ServicesstructureApi();
String entryName = "entryName_example"; // String | 
try {
    Object result = apiInstance.structureTemplateGET(entryName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesstructureApi#structureTemplateGET");
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

<a name="structureTemplatePartialGET"></a>
# **structureTemplatePartialGET**
> Object structureTemplatePartialGET(entryName, segments)

Get the most similar structure template for a protein using a partial alignment

Get the most similar structure template for a protein using a partial alignment&lt;br/&gt;/structure/template/{entry_name}/{segments}/&lt;br/&gt;{entry_name} is a protein identifier from Uniprot, e.g. adrb2_human&lt;br/&gt;{segments} is a comma separated list of protein segment identifiers, e.g. TM3,TM5,TM6

### Example
```java
// Import classes:
//import nl.esciencecenter.e3dchem.gpcrdb.client.ApiException;
//import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesstructureApi;


ServicesstructureApi apiInstance = new ServicesstructureApi();
String entryName = "entryName_example"; // String | 
String segments = "segments_example"; // String | 
try {
    Object result = apiInstance.structureTemplatePartialGET(entryName, segments);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServicesstructureApi#structureTemplatePartialGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entryName** | **String**|  |
 **segments** | **String**|  |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

