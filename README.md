# GPCRDB node for Knime

[![Build Status](https://travis-ci.org/3D-e-Chem/knime-gpcrdb.svg?branch=master)](https://travis-ci.org/3D-e-Chem/knime-gpcrdb)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/116701411bee4b92a9f265f1a0a9efaf)](https://www.codacy.com/app/NLeSC/knime-gpcrdb)
[![DOI](https://zenodo.org/badge/doi/10.5281/zenodo.45265.svg)](http://dx.doi.org/10.5281/zenodo.45265)

Knime plugin for retrieving data from http://gpcrdb.org, GPCRdb website contains data, web tools and diagrams for G protein-coupled receptors (GPCRs).

# Installation

Requirements:

* KNIME, https://www.knime.org

Steps to get GPCRDB nodes inside KNIME:

1. Goto Help > Install new software ... menu
2. Press add button
3. Fill text fields with `https://3d-e-chem.github.io/updates`
4. Select --all sites-- in work with pulldown
5. Open KNIME 3D-e-Chem Contributions folder
6. Select GPCRDB
7. Install sofware & restart

# Usage

See example workflow in `examples` folder.

# Build

```
mvn verify
```

Jar has been made in `nl.esciencecenter.e3dchem.gpcrdb/target` folder.
An Eclipse update site will be made in `nl.esciencecenter.e3dchem.gpcrdb.p2/target/repository` repository.

# Development

Steps to get development enviroment setup:

1. Download KNIME SDK from https://www.knime.org/downloads/overview
2. Install/Extract/start KNIME SDK
3. Start SDK
4. Install m2e (Maven integration for Eclipse) + Knime JSON-Processing

    1. Goto Help > Install new software ...
    2. Make sure Update site is http://update.knime.org/analytics-platform/3.1 in the pull down list otherwise add it
    3. Select --all sites-- in work with pulldown
    4. Select m2e (Maven integration for Eclipse)
    5. Select `Knime JSON-Processing`
    6. Install software & restart

5. Import this repo as an Existing Maven project

During import the Tycho Eclipse providers must be installed.

# New release

1. Update versions in pom files with `mvn org.eclipse.tycho:tycho-versions-plugin:set-version -DnewVersion=<version>` command.
2. Manually update version of "source" feature in `nl.esciencecenter.e3dchem.p2/category.xml` file.
3. Commit and push changes
3. Create package with `mvn package`, will create update site in `nl.esciencecenter.e3dchem.gpcrdb.p2/target/repository`
4. Append new release to 3D-e-Chem update site
  1. Make clone of https://github.com/3D-e-Chem/3D-e-Chem.github.io repo
  2. Append release to 3D-e-Chem update site with `mvn install -Dtarget.update.site=<3D-e-Chem repo/updates>`
5. Commit and push changes in this repo and 3D-e-Chem.github.io repo

## Offline Knime update site

If Knime update site can not be contacted then use a local version.

1. Download zip of update site from https://www.knime.org/downloads/update
2. Unzip it
3. To maven commands add `-Dknime.update.site=file://<path to update site directory>`

# Create GPCRDB client

1. Download swagger code generator
```
wget http://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.1.5/swagger-codegen-cli-2.1.5.jar
```

2. Generate a client for GPCRDB web service
```
java -jar swagger-codegen-cli-2.1.5.jar generate \
-i http://gpcrdb.org/services/reference/api-docs/ \
-l java -o nl.esciencecenter.e3dchem.gpcrdb.client \
--api-package nl.esciencecenter.e3dchem.gpcrdb.client \
--artifact-id nl.esciencecenter.e3dchem.gpcrdb.client \
--artifact-version 1.0.0 \
--group-id nl.esciencecenter.e3dchem \
--library jersey2 \
--type-mappings slug=String \
--model-package nl.esciencecenter.e3dchem.gpcrdb.client.model \
--invoker-package nl.esciencecenter.e3dchem.gpcrdb.client
```
3. Compile client
```
cd nl.esciencecenter.e3dchem.gpcrdb.client
mvn package
```

4. Make client jar and it's dependencies available in plugin
```
cp -r target/lib/* target/*jar ../nl.esciencecenter.e3dchem.gpcrdb/lib/
```

5. Update MANIFEST.MF build.properties to reflect contents of lib/

# References

* V Isberg, S Mordalski, C Munk, K Rataj, K Harpsøe, AS Hauser, B Vroling, AJ Bojarski, G Vriend, DE Gloriam. “GPCRdb: an information system for G protein-coupled receptors”, 2016, Nucleic Acids Res., 44, D356-D364. [10.1093/nar/gkv1178](http://dx.doi.org/10.1093/nar/gkv1178)
* V Isberg, B Vroling, R van der Kant, K Li, G Vriend* and DE Gloriam*, “GPCRDB: an information system for G protein-coupled receptors”, 2014, Nucleic Acids Res., 42 (D1), D422-D425. [10.1093/nar/gkv1178](http://dx.doi.org/10.1093/nar/gkv1178)
