FROM tomcat:10.0-jdk11
CMD ["catalina.sh","run"]
COPY ./target/pruebaTecnica-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/myapp.war
