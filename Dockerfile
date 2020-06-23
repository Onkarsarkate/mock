FROM openjdk:8
ADD target/weather.jar weather.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","weather.java"]