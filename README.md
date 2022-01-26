
# OpenAPI

## Generate Spring Server

Install the OpenAPI CLI generator:

```
npm install @openapitools/openapi-generator-cli -g
```

Generate Spring sever code using the Spring generator:
```
openapi-generator-cli generate -i ./resources/openapi.yml -o ./openapi/src -g spring
```

See the following links for guides on the available generators:

* [OpenAPITools](https://github.com/OpenAPITools/openapi-generator)

* [Spring Generator Guide](https://github.com/OpenAPITools/openapi-generator/blob/master/docs/generators/spring.md)

# AsyncAPI

## Generate Spring Kafka Client

Install the asyncapi generator and templates:

```
npm install -g @asyncapi/generator
npm install -g @asyncapi/java-spring-template 
npm install -g @asyncapi/html-template
```

Generate the Kafka client code to publish an event.
Note we use inverseOpertations so the publish definition in the spec creates a publisher rather than a subscriber method.

```
ag ./resources/asyncapi.yaml @asyncapi/java-spring-template -p inverseOperations=true -o ./asyncapi/src
```

[AsyncAPI Spring Template Guide](https://github.com/asyncapi/java-spring-template)

## Generate Documentation

You can use either the OpenAPI or AsyncAPI generators to generate documentation.
In this example we'll use the AsyncAPI HTML template:

```
ag ./resources/asyncapi.yaml @asyncapi/html-template -o ./docs
```
We can then publish this generated HTML to GitHub Pages, see example [here](https://github.devops.worldpay.local/pages/farrows520/logicaldate-service-gen/) for this repo. 

# Merge

The generated code bases were then merged by simply copying the Kafka client code (less of it) to the Spring OpenAPI code base.

## Kafka
Remember to copy over the Spring application property for Kafka:
```
spring.kafka.bootstrap-servers=kafka:9092
```

To run a local Kafka broker see the docker-compose file for Kafka in the docker/kafka/ directory at the root of this project.

# Run Application

Run the main class (Swagger2SpringBoot in this example).
Use curl or similar to invoke the end points:

curl -XPOST http://localhost:8081/v1/lds/{app}/{group}/incrementDate

curl -XGET -H "Accept: application/json" http://localhost:8081/v1/lds/{app}/{group}


