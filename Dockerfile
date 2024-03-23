# Use a imagem oficial do OpenJDK 21 como base
FROM eclipse-temurin:21-jdk-alpine AS Builder

RUN apk add --no-cache bash procps curl tar

# common for all images
ENV MAVEN_HOME /usr/share/maven

COPY --from=maven:3.9.6-eclipse-temurin-11 ${MAVEN_HOME} ${MAVEN_HOME}
COPY --from=maven:3.9.6-eclipse-temurin-11 /usr/local/bin/mvn-entrypoint.sh /usr/local/bin/mvn-entrypoint.sh
COPY --from=maven:3.9.6-eclipse-temurin-11 /usr/share/maven/ref/settings-docker.xml /usr/share/maven/ref/settings-docker.xml

RUN ln -s ${MAVEN_HOME}/bin/mvn /usr/bin/mvn

ARG MAVEN_VERSION=3.9.6
ARG USER_HOME_DIR="/root"
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"

ENTRYPOINT ["/usr/local/bin/mvn-entrypoint.sh"]
CMD ["mvn"]

COPY pom.xml /usr/src/app/
COPY src /usr/src/app/src/

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /usr/src/app

RUN mvn clean install -DskipTests

FROM eclipse-temurin:21-jdk-alpine

# Copie o arquivo JAR da aplicação para dentro do contêiner
COPY --from=builder /usr/src/app/target/TCGOB-0.0.1.jar /usr/app/tcgob.jar
# Exemplo: Definir o diretório de trabalho e iniciar o aplicativo
WORKDIR /usr/app
# Comando para executar a aplicação Java
CMD ["java", "-jar", "tcgob.jar"]
