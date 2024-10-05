# Getting Started

## Rest Client auto generation

You can automatically generate a REST client for your Spring Boot application based on the Swagger (OpenAPI) documentation
using several tools. 

One of the most commonly used options is **OpenAPI Generator** or **Swagger Codegen**. 
These tools can generate client code that you can use directly in your Spring Boot application.

### Install OpenAPI Generator

#### Install via Homebrew (macOS)
<code> brew install openapi-generator </code>

#### Or, via npm
<code> npm install @openapitools/openapi-generator-cli -g </code>

#### Or, download the standalone JAR
1. Download OpenAPI Generator
   1. <code> https://repo1.maven.org/maven2/org/openapitools/openapi-generator-cli/7.8.0/openapi-generator-cli-7.8.0.jar </code>

### Generate the client
<code> java -jar openapi-generator-cli-7.8.0.jar generate -g java -i https://petstore.swagger.io/v2/swagger.json -o ./generated-client --library resttemplate </code>

### Add the generated code in the application
1. After running the above command, the generated client code will be available in the <code>./generated-client directory.</code>
1. Copy the generated code (typically under <code>src/main/java</code>) to your Spring Boot project.
2. Dependencies that might be needed for the current example:
   1. <code>implementation 'javax.annotation:javax.annotation-api:1.2-b01'</code>
   2. <code>implementation 'com.google.code.findbugs:jsr305:3.0.2'</code>