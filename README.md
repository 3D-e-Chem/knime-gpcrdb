# GPCRDB node for KNIME

[![DOI](https://zenodo.org/badge/DOI/10.5281/zenodo.3257985.svg)](https://doi.org/10.5281/zenodo.3257985)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=3D-e-Chem_knime-gpcrdb&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=3D-e-Chem_knime-gpcrdb)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=3D-e-Chem_knime-gpcrdb&metric=coverage)](https://sonarcloud.io/summary/new_code?id=3D-e-Chem_knime-gpcrdb)

KNIME plugin for retrieving data from [https://gpcrdb.org](https://gpcrdb.org), GPCRdb website contains data, web tools and diagrams for G protein-coupled receptors (GPCRs).

## Installation

Requirements:

* KNIME, https://www.knime.org, version 5.1 or higher

Steps to get GPCRDB nodes inside KNIME:

1. Goto Help > Install new software ... menu
2. Press add button
3. Fill text fields with `https://3d-e-chem.github.io/updates/5.1`
4. Select --all sites-- in work with pulldown
5. Open KNIME 3D-e-Chem Contributions folder
6. Select GPCRDB
7. Install software & restart

## Usage

See example workflow in `examples` folder.

## Build

Requires Maven and JDK 8.

```shell
mvn verify
```

Jar has been made in `plugin/target` folder.
An Eclipse update site will be made in `p2/target/repository` repository.

## Development

Steps to get development environment setup based on https://github.com/knime/knime-sdk-setup#sdk-setup:

1. Install Java 17
2. Install Eclipse for [RCP and RAP developers](https://www.eclipse.org/downloads/packages/installer)
3. Configure Java 17 inside Eclipse Window > Preferences > Java > Installed JREs
4. Import this repo as an Existing Maven project
5. Activate target platform by going to Window > Preferences > Plug-in Development > Target Platform and check the `KNIME Analytics Platform (5.1) - nl.esciencecenter.e3dchem.knime.molviewer.targetplatform/KNIME-AP-5.1.target` target definition.

During import the Tycho Eclipse providers must be installed.

## New release

1. Update versions in pom files with `mvn org.eclipse.tycho:tycho-versions-plugin:set-version -DnewVersion=<version>-SNAPSHOT` command.
2. Commit and push changes
3. Create package with `mvn package`, will create update site in `p2/target/repository`
4. Test node by installing it from local update site
5. Append new release to 3D-e-Chem update site
    1. Make clone of [https://github.com/3D-e-Chem/3D-e-Chem.github.io](https://github.com/3D-e-Chem/3D-e-Chem.github.io) repo
    2. Append release to 3D-e-Chem update site with `mvn install -Dtarget.update.site=<3D-e-Chem repo/updates>`
6. Commit and push changes in this repo and 3D-e-Chem.github.io repo
7. Create a Github release
8. Update Zenodo entry
    1. Fix authors
    2. Fix license
9. Make nodes available to 3D-e-Chem KNIME feature by following steps at https://github.com/3D-e-Chem/knime-node-collection#new-release

## Create GPCRDB client

1. Download swagger code generator

  ```shell
  wget http://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.3.0/swagger-codegen-cli-2.3.0.jar
  ```

2. Download and unpack the swagger rewriter

3. Generate a Swagger spec for the client

  Install the swagger rewriter from https://github.com/3D-e-Chem/swagger-rewriter

  ```shell
  swagger-rewriter/bin/swagger-rewriter \
  https://gpcrdb.org/services/reference/api-docs/ \
  client-config/swagger-rewriter.config.yml \
  client-config/gpcrdb.swagger-spec.json
  ```

3.1 Optionally, make manual changes to client-config/gpcrdb.swagger-spec.json

4. Generate a client for GPCRDB web service using the rewritten spec

  ```shell
  java -jar swagger-codegen-cli-2.3.0.jar generate \
  --input-spec client-config/gpcrdb.swagger-spec.json \
  --output client \
  --lang java \
  --config client-config/swagger-codegen.config.json
  ```

5. Compile client

  ```shell
  cd client
  mvn package
  ```

6. Make client jar and it's dependencies available in plugin

  ```shell
  cp -r target/lib/* target/*jar ../plugin/lib/
  ```

7. Remove test dependencies

  ```shell
  rm plugin/lib/*-tests.jar plugin/lib/junit* plugin/lib/hamcrest*
  ```

8. Update `plugin/META-INF/MANIFEST.MF`, `plugin/build.properties` files to reflect contents of lib/

## Create stub recordings for integration tests

The test workflow are tested against a mocked web server and not the actual https://gpcrdb.org site.
The mock server is called [WireMock](http://WireMock.org/) and normally gives empty responses.
To have WireMock server return filled responses, stubs stored in `tests/src/test/resources/` directory must be provided.
The stubs can be recorded by starting a WireMock server in recording mode by:

```shell
java -jar tests/lib/wiremock-standalone-2.5.0.jar --proxy-all="https://gpcrdb.org/" \
--port=8089 --record-mappings --verbose --root-dir=tests/src/test/resources/
```

Then in a KNIME workflow in the GPCRDB nodes set the base path to http://localhost:8089.
Executing the workflow will fetch data from https://gpcrdb.org/ via the WireMock server and cause new stubs to be recorded in the `tests/src/test/resources/` directory.

To run the test workflows from inside KNIME desktop environment start the WireMock server in mock mode by:

```shell
java -jar tests/lib/wiremock-standalone-2.5.0.jar --port=8089 --verbose --root-dir=tests/src/test/resources/
```

Then import the test workflows in `tests/src/knime/` directory, select the workflow in the KNIME explorer and in the context menu (right-click) select `Run as workflow test`.

## References

* V Isberg, S Mordalski, C Munk, K Rataj, K Harpsøe, AS Hauser, B Vroling, AJ Bojarski, G Vriend, DE Gloriam. “GPCRdb: an information system for G protein-coupled receptors”, 2016, Nucleic Acids Res., 44, D356-D364. [10.1093/nar/gkv1178](http://dx.doi.org/10.1093/nar/gkv1178)
* V Isberg, B Vroling, R van der Kant, K Li, G Vriend* and DE Gloriam*, “GPCRDB: an information system for G protein-coupled receptors”, 2014, Nucleic Acids Res., 42 (D1), D422-D425. [10.1093/nar/gkv1178](http://dx.doi.org/10.1093/nar/gkv1178)
