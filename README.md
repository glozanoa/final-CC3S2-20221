# FINAL CC3S2 - 20221

**Members of group 11:**  
* Hannu Portillo - 20185508K
* Guillermo Borjas - 20090312A
* Gustavo Lozano - 20161317K

## Quickstart

#### Run multipods
* CLI version
```bash
./gradlew minimal 

# show options
 ./gradlew minimal --args="-h"
```

* GUI version

```bash
./gradlew run
```

#### Run unit tests
```bash
./gradlew test
```

#### Build Game

```bash
# include pmd and checkstyle tasks
./gradlew build

# exclude pmd and checkstyle tasks (ONLY BUILD)
./gradlew build -x check
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
