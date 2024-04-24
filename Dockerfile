# Use a Java runtime as the base image
FROM openjdk:21-slim-buster

VOLUME /tmp

# Copy the built JAR file into the container
ADD build/libs/mockup.jar mockup.jar

# Expose the default port for the app
EXPOSE 8080

# Start the app when the container launches
ENTRYPOINT ["java", "-jar", "mockup.jar"]
#ENTRYPOINT ["java", "-jar", "mockup.jar", "--spring.config.additional-location=file:/home/config/application-mockup-configuration.yml", "-Dvault.local.config=/storage/vault-configuration.yml"]

