# Etapa de construção
FROM maven:3.9.9-eclipse-temurin-17 AS build

# Configurar diretório de trabalho
WORKDIR /app

# Copiar o código-fonte para o container
COPY . .

# Construir a aplicação e pular os testes
RUN mvn clean install -DskipTests

# Etapa de execução
FROM eclipse-temurin:17-jdk-jammy

# Expor a porta que a aplicação usará
EXPOSE 8080

# Copiar o arquivo WAR da etapa de build
COPY --from=build /app/target/cardapio-0.0.1-SNAPSHOT.war /app/app.war

# Definir o ponto de entrada
ENTRYPOINT ["java", "-jar", "/app/app.war"]
