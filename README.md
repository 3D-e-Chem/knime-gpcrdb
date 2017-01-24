# GPCRDB node for KNIME

[![Build Status](https://travis-ci.org/3D-e-Chem/knime-gpcrdb.svg?branch=master)](https://travis-ci.org/3D-e-Chem/knime-gpcrdb)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/116701411bee4b92a9f265f1a0a9efaf)](https://www.codacy.com/app/3D-e-Chem/knime-gpcrdb?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=3D-e-Chem/knime-gpcrdb&amp;utm_campaign=Badge_Grade)
[![Codacy Badge](https://api.codacy.com/project/badge/Coverage/116701411bee4b92a9f265f1a0a9efaf)](https://www.codacy.com/app/3D-e-Chem/knime-gpcrdb?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=3D-e-Chem/knime-gpcrdb&amp;utm_campaign=Badge_Coverage)
[![DOI](https://zenodo.org/badge/19641/3D-e-Chem/knime-gpcrdb.svg)](https://zenodo.org/badge/latestdoi/19641/3D-e-Chem/knime-gpcrdb)

KNIME plugin for retrieving data from http://gpcrdb.org, GPCRdb website contains data, web tools and diagrams for G protein-coupled receptors (GPCRs).

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
7. Install software & restart

# Usage

See example workflow in `examples` folder.

# Build

```
mvn verify
```

Jar has been made in `plugin/target` folder.
An Eclipse update site will be made in `p2/target/repository` repository.

# Development

Steps to get development environment setup:

1. Download KNIME SDK from https://www.knime.org/downloads/overview
2. Install/Extract/start KNIME SDK
3. Start SDK
4. Install m2e (Maven integration for Eclipse) + KNIME JSON-Processing + 3D-e-Chem node category

    1. Goto Help > Install new software ...
    2. Make sure the following Update sites are in the pull down list otherwise add them

        * http://download.eclipse.org/releases/mars
        * http://download.eclipse.org/eclipse/updates/4.5
        * http://update.knime.org/analytics-platform/3.1
        * https://3d-e-chem.github.io/updates

    3. Select --all sites-- in work with pulldown
    4. Select `m2e - Maven integration for Eclipse`
    5. Select `KNIME JSON-Processing`
    6. Select `Splash & node category for 3D-e-Chem KNIME nodes`
    7. Install software & restart

5. Import this repo as an Existing Maven project
6. Import `client/` directory in repo as an Existing Maven project.

During import the Tycho Eclipse providers must be installed.

# New release

1. Update versions in pom files with `mvn org.eclipse.tycho:tycho-versions-plugin:set-version -DnewVersion=<version>` command.
2. Manually update version of "source" feature in `p2/category.xml` file.
3. Commit and push changes
3. Create package with `mvn package`, will create update site in `p2/target/repository`
4. Append new release to 3D-e-Chem update site
  1. Make clone of https://github.com/3D-e-Chem/3D-e-Chem.github.io repo
  2. Append release to 3D-e-Chem update site with `mvn install -Dtarget.update.site=<3D-e-Chem repo/updates>`
5. Commit and push changes in this repo and 3D-e-Chem.github.io repo
6. Make nodes available to 3D-e-Chem KNIME feature by following steps at https://github.com/3D-e-Chem/knime-node-collection#new-release

# Create GPCRDB client

1. Download swagger code generator
```
wget http://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.2.1/swagger-codegen-cli-2.2.1.jar
```

2. Download and unpack the swagger rewriter

3. Generate a Swagger spec for the client

Install the swagger rewriter from https://github.com/3D-e-Chem/swagger-rewriter
```
swagger-rewriter/bin/swagger-rewriter \
http://gpcrdb.org/services/reference/api-docs/ \
client-config/swagger-rewriter.config.yml \
client-config/gpcrdb.swagger-spec.json
```

3.1 Optionally, make manual changes to client-config/gpcrdb.swagger-spec.json

4. Generate a client for GPCRDB web service using the rewritten spec
```
java -jar swagger-codegen-cli-2.2.1.jar generate \
--input-spec client-config/gpcrdb.swagger-spec.json \
--output client \
--lang java \
--config client-config/swagger-codegen.config.json
```
5. Compile client
```
cd client
mvn package
```

6. Make client jar and it's dependencies available in plugin
```
cp -r target/lib/* target/*jar ../plugin/lib/
```

7. Remove test dependencies

```
rm plugin/lib/*-tests.jar plugin/lib/junit* plugin/lib/hamcrest*
```

8. Update `plugin/META-INF/MANIFEST.MF`, `plugin/build.properties` files to reflect contents of lib/

# Create stub recordings for integration tests

The test workflow are tested against a mocked web server and not the actual http://www.gpcrdb.org site.
The mock server is called [WireMock](http://WireMock.org/) and normally gives empty responses.
To have WireMock server return filled responses, stubs stored in `tests/src/test/resources/` directory must be provided.
The stubs can be recorded by starting a WireMock server in recording mode by:
```
java -jar tests/lib/wiremock-standalone-2.5.0.jar --proxy-all="http://gpcrdb.org/" \
--port=8089 --record-mappings --verbose --root-dir=tests/src/test/resources/
```

Then in a KNIME workflow in the GPCRDB nodes set the base path to http://localhost:8089.
Executing the workflow will fetch data from http://gpcrdb.org/ via the WireMock server and cause new stubs to be recorded in the `tests/src/test/resources/` directory.

To run the test workflows from inside KNIME desktop enviroment start the WireMock server in mock mode by:

```
java -jar tests/lib/wiremock-standalone-2.5.0.jar --port=8089 --verbose --root-dir=tests/src/test/resources/
```
Then import the test workflows in `tests/src/knime/` directory, select the workflow in the KNIME explorer and in the context menu (right-click) select `Run as workflow test`.

# References

* V Isberg, S Mordalski, C Munk, K Rataj, K Harpsøe, AS Hauser, B Vroling, AJ Bojarski, G Vriend, DE Gloriam. “GPCRdb: an information system for G protein-coupled receptors”, 2016, Nucleic Acids Res., 44, D356-D364. [10.1093/nar/gkv1178](http://dx.doi.org/10.1093/nar/gkv1178)
* V Isberg, B Vroling, R van der Kant, K Li, G Vriend* and DE Gloriam*, “GPCRDB: an information system for G protein-coupled receptors”, 2014, Nucleic Acids Res., 42 (D1), D422-D425. [10.1093/nar/gkv1178](http://dx.doi.org/10.1093/nar/gkv1178)
