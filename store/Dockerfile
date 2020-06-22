ARG VERSION=1.0.0-SNAPSHOT
ARG BUILD_IMAGE=maven:3.6-openjdk-8
ARG RUNTIME_IMAGE=openjdk:8-jre-alpine

#####################################################
###  Stage: Compile                               ###
#####################################################

FROM ${BUILD_IMAGE} as build
WORKDIR /app
COPY pom.xml .
COPY . .
RUN mvn -e -B compile -DskipTests

#####################################################
###  Stage(Optional): Run Unit Tests              ###
#####################################################

FROM build as test
ARG SKIPTESTS=true
WORKDIR /app
RUN if [ "$SKIPTESTS" = "false" ] ; \
    then mvn -e -B test ; \
    fi

#####################################################
###  Stage: Package                               ###
#####################################################

FROM build as package
WORKDIR /app
RUN mvn -e -B clean package -DskipTests

#####################################################
### Stage: Run Image                              ###
#####################################################

FROM ${RUNTIME_IMAGE}
COPY --from=package app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar", "--spring.profiles.active=prod"]

