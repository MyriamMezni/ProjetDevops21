FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/ProjetDevops21-1.0.war ProjetDevops21-1.0.war
ENTRYPOINT ["java","-jar","/ProjetDevops21-1.0.war"]