# Demo app for structured JSON logging in Spring Boot with Log4j2

This app provides examples of how to do structured, contextual logging in Spring Boot apps using Log4j2.

## Build and run

- From Command Line: `mvn spring-boot:run`
- From IntelliJ: Create a new Run Configuration of type "Maven", which runs `spring-boot:run`

## Verify

```shell
> curl localhost:8080/order/acme/123/items

[{"id":"1234","sku":"chair-blue","description":"Very comfy chair","quantity":null}]
```