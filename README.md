# FINAL CC3S2 - 20221

[![build](https://github.com/glozanoa/final-CC3S2-20221/actions/workflows/build.yml/badge.svg)](https://github.com/glozanoa/final-CC3S2-20221/actions/workflows/build.yml)
[![pmd](https://github.com/glozanoa/final-CC3S2-20221/actions/workflows/pmd.yml/badge.svg)](https://github.com/glozanoa/final-CC3S2-20221/actions/workflows/pmd.yml)


**Members of group 11:**  
* Hannu Portillo - 20185508K
* Guillermo Borjas - 20090312A
* Gustavo Lozano - 20161317K

## Quickstart

#### Get `multipod` options
```bash
./gradlew multipod --args=-h
```

#### Pull a docker image

```bash
./gradlew multipod --args="-T DOCKER pull python slim"
```

#### Run unit tests

```bash
./gradlew test
```

#### Build

```bash
# include pmd and checkstyle tasks
./gradlew build

# exclude pmd and checkstyle tasks (ONLY BUILD)
./gradlew build -x check
```

#### Documentation

```bash
./gradlew javadoc
```

#### Static Analysis

* PMD
```bash
./gradlew pmdMain pmdTest
```

* Checkstyle (Google Code Style)
```bash
./gradlew checkstyleMain checkstyleTest
```

#### Code Coverage

```bash
# html and xml coverage reports are generated at build/reports/jacoco
./gradlew jacocoTestReport
```
