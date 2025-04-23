FROM openjdk:8u131-jdk-alpine
EXPOSE 8081
COPY ./target/trutime-management.jar trutime-management.jar 
ENTRYPOINT ["java","-jar","/trutime-service.jar"]