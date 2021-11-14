FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/ProjetDevops21-1.0.jar ProjetDevops21-1.0.jar
ENTRYPOINT ["java","-jar","target/ProjetDevops21-1.0.jar"]