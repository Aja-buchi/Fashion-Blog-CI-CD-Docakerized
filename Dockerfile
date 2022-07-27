FROM openjdk:8
EXPOSE 8080
ADD target/new-springboot-images.jar new-springboot-images.jar
ENTRYPOINT ["java", "-jar", "/new-springboot-images.jar"]