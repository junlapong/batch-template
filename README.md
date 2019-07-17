# batch-template
Java Batch Template
[![Build Status](https://travis-ci.org/junlapong/batch-template.svg?branch=master)](https://travis-ci.org/junlapong/batch-template) [![CircleCI](https://circleci.com/gh/junlapong/batch-template.svg?style=shield)](https://circleci.com/gh/junlapong/batch-template)

## Create bundle jar
```
mvn package
```
## Run
```
run-batch.bat 2016-05-30
```
### Example Output
```
[13:53:39.257 ICT] INFO  [main] com.company.app.MainApp.main() - [ BATCH START: Mon May 30 13:53:39 ICT 2016]
[13:53:39.276 ICT] DEBUG [main] com.company.app.MainApp.main() - args 1: 2016-05-30
[13:53:39.277 ICT] INFO  [main] com.company.app.module.ModuleService.sayHello() - Hello BAY
[13:53:39.277 ICT] INFO  [main] com.company.app.MainApp.main() - [   BATCH END: Mon May 30 13:53:39 ICT 2016]
EXIT CODE: 0
```

## Notes

- https://www.uaparser.org
- https://github.com/ua-parser/uap-java
- https://yauaa.basjes.nl
