# Stage 1: Build với Maven
FROM maven:3.3.2-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
# Tải dependencies trước (tận dụng cache Docker layer)
RUN mvn dependency:go-offline -B
COPY src ./src
# Build ứng dụng (bỏ qua test)
RUN mvn package -DskipTests

# Stage 2: Chạy ứng dụng với JDK
FROM openjdk:17-jdk-slim
WORKDIR /app
# Copy file JAR từ stage build
COPY --from=build /app/target/spring-boot-starter-parent.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]