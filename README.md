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

## User Agent Parser

- https://www.uaparser.org
- https://github.com/ua-parser/uap-java

```xml
<dependency>
    <groupId>com.github.ua-parser</groupId>
    <artifactId>uap-java</artifactId>
    <version>1.4.3</version>
</dependency>
```

```java
import ua_parser.Client;
import ua_parser.Parser;

...

Parser uaParser = new Parser();
Client c = uaParser.parse(ua);

logger.debug("UA: {}", ua);
logger.debug("Device    : {}", c.device.family);    // => "iPhone"
logger.debug("UA family : {}", c.userAgent.family); // => "Mobile Safari"
logger.debug("UA major  : {}", c.userAgent.major);  // => "5"
logger.debug("UA minor  : {}", c.userAgent.minor);  // => "1"
logger.debug("OS family : {}", c.os.family);        // => "iOS"
logger.debug("OS major  : {}", c.os.major);         // => "5"
logger.debug("OS minor  : {}\n", c.os.minor);       // => "1"
```

- https://yauaa.basjes.nl
