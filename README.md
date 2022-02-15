# Demo app for structured JSON logging in Spring Boot with Log4j2

This app provides examples of how to do structured, contextual logging in Spring Boot apps using Log4j2.

If you're here to check out the code, the main controller is located here: [OrderController](./src/main/java/com/zachelrath/springboot/structuredloggingdemo/OrderController.java). 

## Build and run

- From Command Line: `mvn spring-boot:run`
- From IntelliJ: Create a new Run Configuration of type "Maven", which runs `spring-boot:run`

## Verify

```shell
> curl localhost:8080/order/acme/123/items

[{"id":"1234","sku":"chair-blue","description":"Very comfy chair","quantity":null}]
```

This should log the following structured JSON logs to the console, containing the context `retailer` and `orderNumber` in the thread `contextMap`: 

```shell
{
  "instant" : {
    "epochSecond" : 1636639189,
    "nanoOfSecond" : 190833000
  },
  "thread" : "http-nio-8080-exec-1",
  "level" : "INFO",
  "loggerName" : "com.zachelrath.springboot.structuredloggingdemo.OrderController",
  "message" : "Getting items",
  "endOfBatch" : false,
  "loggerFqcn" : "org.apache.logging.log4j.spi.AbstractLogger",
  "contextMap" : {
    "orderNumber" : "123",
    "retailer" : "acme"
  },
  "threadId" : 24,
  "threadPriority" : 5
}
{
  "instant" : {
    "epochSecond" : 1644940436,
    "nanoOfSecond" : 805370000
  },
  "thread" : "http-nio-8080-exec-1",
  "level" : "INFO",
  "loggerName" : "com.zachelrath.springboot.structuredloggingdemo.OrderController",
  "message" : {
    "totalItems" : 1,
    "items" : [ {
      "id" : "1234",
      "sku" : "chair-blue",
      "description" : "Very comfy chair"
    } ]
  },
  "endOfBatch" : false,
  "loggerFqcn" : "org.apache.logging.log4j.spi.AbstractLogger",
  "contextMap" : {
    "orderNumber" : "123",
    "retailer" : "acme"
  },
  "threadId" : 27,
  "threadPriority" : 5
}

```