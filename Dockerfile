FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
RUN ls -la
RUN ls -la target/ || echo "target directory not found"
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

