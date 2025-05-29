# Stage 1: Build com Maven e JDK
FROM eclipse-temurin:21-jdk-alpine AS build

WORKDIR /app

# Instala dependências
RUN apk add --no-cache bash

# Copia os arquivos do projeto
COPY . .

# Executa o build (gera o jar na pasta target)
RUN ./mvnw clean package -DskipTests


# Stage 2: Runtime com JRE
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Instala netcat para esperar o banco
RUN apk add --no-cache netcat-openbsd

# Copia o JAR gerado no build
COPY --from=build /app/target/*SNAPSHOT.jar app.jar

# Copia o script de espera
COPY wait-for.sh wait-for.sh
RUN chmod +x wait-for.sh

EXPOSE 8080

# Executa o script de espera antes de subir o app
CMD ["./wait-for.sh", "db", "java", "-jar", "app.jar"]
