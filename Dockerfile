FROM openjdk:8
ADD target/demo.jar demo.jar
ENTRYPOINT ["java", "-jar", "demo.jar"]