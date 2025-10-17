FROM openjdk:23
COPY ./target/seMethods-1.0-SNAPSHOT.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "seMethods-1.0-SNAPSHOT.jar", "db:3306", "10000"]