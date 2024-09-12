FROM tomcat:9.0-jdk17

RUN rm -rf /usr/local/tomcat/webapps/ROOT

COPY target/cardapio-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
