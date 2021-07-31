FROM openjdk:11-jre
ARG PROFILE
ENV PROFILE_VAR=$PROFILE
VOLUME /tmp
# Add the built jar for docker image building
ADD target/spring-github-docker-0.0.1-SNAPSHOT.jar spring-github-docker.jar
ENTRYPOINT ["/bin/bash", "-c", "java","-jar","/spring-github-docker.jar"]
# DO NOT USE(The variable would not be substituted): ENTRYPOINT ["java","-Dspring.profiles.active=$PROFILE_VAR","-jar","/hello-world-docker-action.jar"]
# CAN ALSO USE: ENTRYPOINT java -Dspring.profiles.active=$PROFILE_VAR -jar /hello-world-docker-action.jar
EXPOSE 80
