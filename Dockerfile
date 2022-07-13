FROM java:8
COPY dreamIntoStar-1.0.jar .
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/dreamIntoStar-1.0.jar"]