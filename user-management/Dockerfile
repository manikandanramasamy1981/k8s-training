FROM ubuntu:15.04

RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y  software-properties-common && \
    add-apt-repository ppa:webupd8team/java -y && \
    apt-get update && \
    echo oracle-java7-installer shared/accepted-oracle-license-v1-1 select true | /usr/bin/debconf-set-selections && \
    apt-get install -y oracle-java8-installer && \
    apt-get clean
    
# Fetching latest version of Java
#FROM openjdk:8
 
# Setting up work directory
WORKDIR /app

# Copy the jar file into our app
COPY ./target/wfm-user-0.0.1.RELEASE.jar /app

# Exposing port 8080
EXPOSE 8085

# Starting the application
CMD ["java", "-jar", "wfm-user-0.0.1.RELEASE.jar"]