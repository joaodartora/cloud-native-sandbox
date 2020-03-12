FROM ubuntu:18.04

RUN apt-get -y update
RUN apt-get -y install openjdk-8-jdk
RUN apt-get -y install wget
RUN mkdir /home/tomcat
RUN wget http://mirror.nbtelecom.com.br/apache/tomcat/tomcat-8/v8.5.41/bin/apache-tomcat-8.5.41.tar.gz -O /tmp/tomcat.tar.gz
RUN cd /tmp && tar xvfz tomcat.tar.gz
RUN cp -Rv /tmp/* /home/tomcat/

EXPOSE 8080

COPY ./build/libs/Tema-6-1.0-SNAPSHOT.war /home/tomcat/apache-tomcat-8.5.41/webapps/

CMD /home/tomcat/apache-tomcat-8.5.41/bin/catalina.sh run
