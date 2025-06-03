# ------------------------
# 1단계: Build Stage
# ------------------------
FROM eclipse-temurin:17-jdk AS build
WORKDIR /app

# 의존성 캐싱을 위한 우선 복사
COPY .mvn .mvn
COPY mvnw pom.xml ./
RUN chmod +x mvnw && ./mvnw -q dependency:go-offline

# 실제 소스 복사 후 빌드
COPY src ./src
RUN ./mvnw -q clean package -DskipTests

# ------------------------
# 2단계: Runtime Stage
# ------------------------
FROM eclipse-temurin:17-jre
WORKDIR /app

# 빌드 결과 복사
COPY --from=build /app/target/*.jar taco.jar

EXPOSE 8085
ENTRYPOINT ["java", "-jar", "taco.jar"]
