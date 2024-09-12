# Etapa de construção
FROM maven:3.9.0-openjdk-17 AS build

# Configurar diretório de trabalho
WORKDIR /app

# Copiar o código-fonte para o container
COPY . .

# Construir a aplicação
RUN mvn clean install

# Etapa de execução
FROM openjdk:17-jdk-slim

# Expor a porta que a aplicação usará
EXPOSE 8080

# Copiar o arquivo WAR da etapa de build
COPY --from=build /app/target/cardapio-0.0.1-SNAPSHOT.war /app/app.war

# Definir o ponto de entrada
ENTRYPOINT ["java", "-jar", "/app/app.war"]
