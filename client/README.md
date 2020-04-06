# nl.esciencecenter.e3dchem.gpcrdb.client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>nl.esciencecenter.e3dchem.gpcrdb</groupId>
    <artifactId>nl.esciencecenter.e3dchem.gpcrdb.client</artifactId>
    <version>2.0.3</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "nl.esciencecenter.e3dchem.gpcrdb:nl.esciencecenter.e3dchem.gpcrdb.client:2.0.3"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/nl.esciencecenter.e3dchem.gpcrdb.client-2.0.3.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import nl.esciencecenter.e3dchem.gpcrdb.client.*;
import nl.esciencecenter.e3dchem.gpcrdb.client.auth.*;
import nl.esciencecenter.e3dchem.gpcrdb.client.model.*;
import nl.esciencecenter.e3dchem.gpcrdb.client.ServicesalignmentApi;

import java.io.File;
import java.util.*;

public class ServicesalignmentApiExample {

    public static void main(String[] args) {
        
        ServicesalignmentApi apiInstance = new ServicesalignmentApi();
        String slug = "slug_example"; // String | 
        try {
            Object result = apiInstance.familyAlignmentGET(slug);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ServicesalignmentApi#familyAlignmentGET");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://gpcrdb.org*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ServicesalignmentApi* | [**familyAlignmentGET**](docs/ServicesalignmentApi.md#familyAlignmentGET) | **GET** /services/alignment/family/{slug}/ | Get a full sequence alignment of a protein family including a consensus sequence
*ServicesalignmentApi* | [**familyAlignmentGET_0**](docs/ServicesalignmentApi.md#familyAlignmentGET_0) | **GET** /services/alignment/family/{slug}/statistics/ | Get a full sequence alignment of a protein family including a consensus sequence
*ServicesalignmentApi* | [**familyAlignmentPartialGET**](docs/ServicesalignmentApi.md#familyAlignmentPartialGET) | **GET** /services/alignment/family/{slug}/{segments}/ | Get a partial sequence alignment of a protein family
*ServicesalignmentApi* | [**familyAlignmentPartialGET_0**](docs/ServicesalignmentApi.md#familyAlignmentPartialGET_0) | **GET** /services/alignment/family/{slug}/{segments}/statistics/ | Get a partial sequence alignment of a protein family
*ServicesalignmentApi* | [**familyAlignmentPartialSpeciesGET**](docs/ServicesalignmentApi.md#familyAlignmentPartialSpeciesGET) | **GET** /services/alignment/family/{slug}/{segments}/{latin_name}/ | Get a partial sequence alignment of a protein family
*ServicesalignmentApi* | [**familyAlignmentPartialSpeciesGET_0**](docs/ServicesalignmentApi.md#familyAlignmentPartialSpeciesGET_0) | **GET** /services/alignment/family/{slug}/{segments}/{latin_name}/statistics/ | Get a partial sequence alignment of a protein family
*ServicesalignmentApi* | [**proteinAlignmentGET**](docs/ServicesalignmentApi.md#proteinAlignmentGET) | **GET** /services/alignment/protein/{proteins}/ | Get a full sequence alignment of two or more proteins
*ServicesalignmentApi* | [**proteinAlignmentPartialGET**](docs/ServicesalignmentApi.md#proteinAlignmentPartialGET) | **GET** /services/alignment/protein/{proteins}/{segments}/ | Get a partial sequence alignment of two or more proteins
*ServicesalignmentApi* | [**proteinAlignmentStatisticsGET**](docs/ServicesalignmentApi.md#proteinAlignmentStatisticsGET) | **GET** /services/alignment/protein/{proteins}/statistics/ | Add a /statics at the end of an alignment in order to
*ServicesalignmentApi* | [**proteinAlignmentStatisticsGET_0**](docs/ServicesalignmentApi.md#proteinAlignmentStatisticsGET_0) | **GET** /services/alignment/protein/{proteins}/{segments}/statistics/ | Add a /statics at the end of an alignment in order to
*ServicesalignmentApi* | [**proteinSimilaritySearchAlignmentGET**](docs/ServicesalignmentApi.md#proteinSimilaritySearchAlignmentGET) | **GET** /services/alignment/similarity/{proteins}/{segments}/ | Get a segment sequence alignment of two or more proteins ranked by similarity
*ServicesmutantsApi* | [**mutantListGET**](docs/ServicesmutantsApi.md#mutantListGET) | **GET** /services/mutants/{entry_name}/ | Get a list of mutants of single protein instance by entry name
*ServicesplotApi* | [**helixBoxGET**](docs/ServicesplotApi.md#helixBoxGET) | **GET** /services/plot/helixbox/{entry_name}/ | Get SVG source code for a protein&#39;s helix box plot
*ServicesplotApi* | [**snakePlotGET**](docs/ServicesplotApi.md#snakePlotGET) | **GET** /services/plot/snake/{entry_name}/ | Get SVG source code for a protein&#39;s snake plot
*ServicesproteinApi* | [**proteinByAccessionDetailGET**](docs/ServicesproteinApi.md#proteinByAccessionDetailGET) | **GET** /services/protein/accession/{accession}/ | Get a single protein instance by accession
*ServicesproteinApi* | [**proteinDetailGET**](docs/ServicesproteinApi.md#proteinDetailGET) | **GET** /services/protein/{entry_name}/ | Get a single protein instance by entry name
*ServicesproteinfamilyApi* | [**proteinFamilyChildrenListGET**](docs/ServicesproteinfamilyApi.md#proteinFamilyChildrenListGET) | **GET** /services/proteinfamily/children/{slug}/ | Get a list of child families of a protein family
*ServicesproteinfamilyApi* | [**proteinFamilyDescendantListGET**](docs/ServicesproteinfamilyApi.md#proteinFamilyDescendantListGET) | **GET** /services/proteinfamily/descendants/{slug}/ | Get a list of descendant families of a protein family
*ServicesproteinfamilyApi* | [**proteinFamilyDetailGET**](docs/ServicesproteinfamilyApi.md#proteinFamilyDetailGET) | **GET** /services/proteinfamily/{slug}/ | Get a single protein family instance
*ServicesproteinfamilyApi* | [**proteinFamilyListGET**](docs/ServicesproteinfamilyApi.md#proteinFamilyListGET) | **GET** /services/proteinfamily/ | Get a list of protein families
*ServicesproteinfamilyApi* | [**proteinsInFamilyListGET**](docs/ServicesproteinfamilyApi.md#proteinsInFamilyListGET) | **GET** /services/proteinfamily/proteins/{slug}/ | Get a list of proteins in a protein family
*ServicesproteinfamilyApi* | [**proteinsInFamilySpeciesListGET**](docs/ServicesproteinfamilyApi.md#proteinsInFamilySpeciesListGET) | **GET** /services/proteinfamily/proteins/{slug}/{latin_name}/ | Get a list of proteins in a protein family
*ServicesresiduesApi* | [**residuesExtendedListGET**](docs/ServicesresiduesApi.md#residuesExtendedListGET) | **GET** /services/residues/extended/{entry_name}/ | Get a list of residues of a protein, including alternative generic numbers
*ServicesresiduesApi* | [**residuesListGET**](docs/ServicesresiduesApi.md#residuesListGET) | **GET** /services/residues/{entry_name}/ | Get a list of residues of a protein
*ServicesspeciesApi* | [**speciesDetailGET**](docs/ServicesspeciesApi.md#speciesDetailGET) | **GET** /services/species/{latin_name}/ | Get a single species instance
*ServicesspeciesApi* | [**speciesListGET**](docs/ServicesspeciesApi.md#speciesListGET) | **GET** /services/species/ | Get a list of species
*ServicesstructureApi* | [**representativeStructureListGET**](docs/ServicesstructureApi.md#representativeStructureListGET) | **GET** /services/structure/representative/ | Get a list of representative structures (one for each protein and activation state)
*ServicesstructureApi* | [**representativeStructureListProteinGET**](docs/ServicesstructureApi.md#representativeStructureListProteinGET) | **GET** /services/structure/protein/{entry_name}/representative/ | Get a list of representative structures of a protein (one for each activation state)
*ServicesstructureApi* | [**structureAssignGenericNumbersPOST**](docs/ServicesstructureApi.md#structureAssignGenericNumbersPOST) | **POST** /services/structure/assign_generic_numbers | Assign generic residue numbers (Ballesteros-Weinstein and GPCRdb schemes) to an uploaded pdb file
*ServicesstructureApi* | [**structureDetailGET**](docs/ServicesstructureApi.md#structureDetailGET) | **GET** /services/structure/{pdb_code}/ | Get a single structure instance
*ServicesstructureApi* | [**structureLigandInteractionsGET**](docs/ServicesstructureApi.md#structureLigandInteractionsGET) | **GET** /services/structure/{pdb_code}/interaction/ | Get a list of interactions between structure and ligand
*ServicesstructureApi* | [**structureListGET**](docs/ServicesstructureApi.md#structureListGET) | **GET** /services/structure/ | Get a list of structures
*ServicesstructureApi* | [**structureListProteinGET**](docs/ServicesstructureApi.md#structureListProteinGET) | **GET** /services/structure/protein/{entry_name}/ | Get a list of structures of a protein
*ServicesstructureApi* | [**structureSingleProteinGET**](docs/ServicesstructureApi.md#structureSingleProteinGET) | **GET** /services/structure/protein/{entry_name}/?single | Get the structure of a protein
*ServicesstructureApi* | [**structureTemplateGET**](docs/ServicesstructureApi.md#structureTemplateGET) | **GET** /services/structure/template/{entry_name}/ | Get the most similar structure template for a protein using a 7TM alignment
*ServicesstructureApi* | [**structureTemplatePartialGET**](docs/ServicesstructureApi.md#structureTemplatePartialGET) | **GET** /services/structure/template/{entry_name}/{segments}/ | Get the most similar structure template for a protein using a partial alignment


## Documentation for Models

 - [Ligand](docs/Ligand.md)
 - [MutationSerializer](docs/MutationSerializer.md)
 - [ParentProteinFamilySerializer](docs/ParentProteinFamilySerializer.md)
 - [ProteinFamilySerializer](docs/ProteinFamilySerializer.md)
 - [ProteinSerializer](docs/ProteinSerializer.md)
 - [ProteinSimilarities](docs/ProteinSimilarities.md)
 - [ProteinSimilarity](docs/ProteinSimilarity.md)
 - [ResidueExtendedSerializer](docs/ResidueExtendedSerializer.md)
 - [ResidueGenericNumberSerializer](docs/ResidueGenericNumberSerializer.md)
 - [ResidueSerializer](docs/ResidueSerializer.md)
 - [SpeciesSerializer](docs/SpeciesSerializer.md)
 - [Structure](docs/Structure.md)
 - [StructureLigandInteractionSerializer](docs/StructureLigandInteractionSerializer.md)
 - [WriteMutationSerializer](docs/WriteMutationSerializer.md)
 - [WriteParentProteinFamilySerializer](docs/WriteParentProteinFamilySerializer.md)
 - [WriteProteinFamilySerializer](docs/WriteProteinFamilySerializer.md)
 - [WriteProteinSerializer](docs/WriteProteinSerializer.md)
 - [WriteResidueExtendedSerializer](docs/WriteResidueExtendedSerializer.md)
 - [WriteResidueGenericNumberSerializer](docs/WriteResidueGenericNumberSerializer.md)
 - [WriteResidueSerializer](docs/WriteResidueSerializer.md)
 - [WriteSpeciesSerializer](docs/WriteSpeciesSerializer.md)
 - [WriteStructureLigandInteractionSerializer](docs/WriteStructureLigandInteractionSerializer.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



