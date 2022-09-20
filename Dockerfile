#Load JDK 8
FROM openjdk:8

#Adding jar file to Docker Container
# Jar file renamed to cricketer-app.jar in the Docker container
ADD /target/springboot-demo-1.0.jar cricketer-app.jar

#Make port 8080 available
EXPOSE 8080

#Start the docker by running jar file
ENTRYPOINT [ "java","-jar","cricketer-app.jar" ]

