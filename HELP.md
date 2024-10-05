# Auto generate petstore client
You can automate the client generation process in your Spring Boot project by using OpenAPI Generator Maven or Gradle plugins.
These plugins allow you to generate the client code automatically during your build process,
without manually running commands or copying files.

##  Use OpenAPI Generator with Gradle Plugin
1. Add Plugin and Configuration to <code>build.gradle</code>
    1. Dependencies that might be needed in the context of the current Pets example
       ```
        implementation 'javax.annotation:javax.annotation-api:1.3.2'
        implementation 'org.openapitools:jackson-databind-nullable:0.2.6'
        implementation 'com.google.code.findbugs:jsr305:3.0.2'
       ```
    2. Example of the build.gradle file

         ```
         import org.apache.commons.io.FileUtils
         import java.net.URL
         
         plugins {
             id 'org.openapi.generator' version '7.0.0' // Use the latest version
         }
         
         repositories {
             mavenCentral()
         }
         
         dependencies {
             implementation 'commons-io:commons-io:2.8.0'
         }
         
         task downloadSwaggerSpec {
             doLast {
                 def swaggerUrl = new URL("https://petstore.swagger.io/v2/swagger.json")
                 def outputFile = file("${buildDir}/swagger/swagger.json")
                 outputFile.parentFile.mkdirs() // Create directory if it doesn't exist
                 FileUtils.copyURLToFile(swaggerUrl, outputFile)
             }
         }
         
         openApiGenerate {
             generatorName = "java"
             inputSpec = "${buildDir}/swagger/swagger.json" // Use the downloaded file
             outputDir = "$buildDir/generated"
             apiPackage = "com.example.client.api"
             modelPackage = "com.example.client.model"
             configOptions = [
                 library: "resttemplate"
             ]
         }
         
         // Make openApiGenerate dependent on downloadSwaggerSpec
         tasks.openApiGenerate.dependsOn downloadSwaggerSpec
         
         sourceSets {
             main {
                 java {
                     srcDir "$buildDir/generated/src/main/java"
                 }
             }
         }
         
         ```
3. Run ```./gradlew openApiGenerate``` to generate the files