FROM openjdk:11
ADD target/demo.jar demo.jar
ENTRYPOINT ["java", "-jar", "demo.jar"]