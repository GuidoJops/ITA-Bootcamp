FROM maven:latest
COPY . /app
WORKDIR /app
RUN mvn package -DskipTests
RUN mv /app/target/S05T02N02JanotaFuenteGuido.dados-0.0.1-SNAPSHOT.jar /app/target/diceGameApi.jar
ENTRYPOINT ["java", "-jar", "/app/target/diceGameApi.jar"]
