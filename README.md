# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.0-SNAPSHOT/maven-plugin/reference/html/)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.6.4/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.4/reference/htmlsingle/#boot-features-developing-web-applications)
* [Flyway Migration](https://docs.spring.io/spring-boot/docs/2.6.4/reference/htmlsingle/#howto-execute-flyway-database-migrations-on-startup)
* [Querydsl](http://querydsl.com/)
* [Blaze-persistence](https://persistence.blazebit.com/documentation/1.6/core/manual/en_US/index.html)
* [Blaze-persistence-Javadoc](https://javadoc.io/doc/com.blazebit/blaze-persistence-integration-querydsl-expressions/latest)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute
the `main` method in the `jooq.demo.com.DemoJooqApplication` class from your IDE.

Alternatively you can use
the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html)
like so:

```shell
mvn spring-boot:run
```

## Now we can access the API document at:

```
http://localhost:8080/swagger-ui.html
```
