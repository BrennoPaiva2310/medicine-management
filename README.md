# medicine-management

# Project Name

This project is a Java 17 application that connects to an Oracle database running in Docker. Below are instructions to set up and run the environment.

## Prerequisites

* Docker installed
* Java 17 installed
* Maven or Gradle installed

## Oracle Database via Docker

### Pull the Docker image

```bash
docker pull gvenzl/oracle-xe:18-slim
```

### Run the Oracle container

```bash
docker run -d --name oracle-xe \
  -p 1521:1521 \
  -e ORACLE_PASSWORD=admin123 \
  gvenzl/oracle-xe:18-slim
```

### Connect to Oracle

```bash
docker exec -it oracle-xe sqlplus system/admin123@XE
```

## Java 17 Application

### Build

Maven:

```bash
mvn clean install
```

Gradle:

```bash
gradle build
```

### Run

```bash
java -jar target/your-app-name.jar
```

Update database connection properties in `application.properties` or `application.yml` as needed.

## Notes

* Data in the Oracle container is lost if the container is removed. Use Docker volumes for persistence.
* The application requires Java 17.
