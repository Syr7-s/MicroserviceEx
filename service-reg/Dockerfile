FROM maven:3.8.4-jdk-8 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml -Dmaven.test.skip=true clean package

FROM openjdk:8-alpine
LABEL "Isa SAYAR"="isa.sayar1725@gmail.com"
COPY --from=build /usr/src/app/target/service-registry.jar /usr/app/service-registry.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","/usr/app/spring-registry.jar"]

#FROM openjdk:8
#MAINTAINER Isa SAYAR <isa.sayar.1725@gmail.com>
#ADD target/service-registry.jar service-registry.jar
#EXPOSE 8761
#ENTRYPOINT ["java","-jar","service-registry.jar"]
