FROM openjdk:15-alpine
EXPOSE 8080
COPY /build/libs/AlfaProject-1.0-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "AlfaProject-1.0-SNAPSHOT.jar"]