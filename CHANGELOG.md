# Change Log
All notable changes to this project will be documented in this file.
This project adheres to [Semantic Versioning](http://semver.org/).
Formatted as described on http://keepachangelog.com/.

## [Unreleased]

## [1.3.0] - 2017-09-01

### Fixed

- Mutant api changed (#29)

## [1.2.0] - 2017-03-01

### Added

- Node to fetch all GPCRDB structures (#27)

### Fixed

- Use rowkey generator instead of custom rowkey (#28)

## [1.1.0] - 2017-01-12

### Added

- Test coverage (#25)
- Timeout option (#21)
- Workflow test for all nodes (#24)

### Changed

- Nicer message for Timeout and not found exceptions (#23)

### Fixed

- Change default port names to specific names (#22)

## [1.0.15] - 2016-10-18

### Fixed

- Protein with single structure produce error (#8)

## [1.0.14] - 2016-10-18

### Added

- Test workflow using WireMock server (#17)

### Fixed

- Protein with single structure produce error (#8)

## [1.0.13] - 2016-09-13

### Changed

- Client no longer needs to be modified after generation, now the Swagger spec is adjusted before generation (#16)

### Fixed

- Based client on okhttp+gson library, a non jaxrs based implementation (#16)

## [1.0.12] - 2016-07-18

### Changed

- Moved nodes under /community/3d-e-chem (#15)

## [1.0.11] - 2016-06-07

### Added

- Additional input and node configuration checks in line with KNIME specification

## [1.0.10] - 2016-05-20

### Changed

- Shortened maven modules names

### Fixed

- Optional publication when requesting structures of protein (#12)

## [1.0.9] - 2016-05-13

### Fixed

- Protein with single structure produce error (#8)

### Changed

- Input is case-insensitive (#10)

## [1.0.8] - 2016-04-18

### Added

- Node for retrieving protein similarity (#5)

## [1.0.7] - 2016-03-29

### Added

- Node for retrieving mutations of protein (#4)
- Node for retrieving interactions of structure with its ligands (#6)

## [1.0.6] - 2016-01-27

### Changed

- Return alternative numbers as map (#7)
