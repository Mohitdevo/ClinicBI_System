FROM tomcat:10.1-jdk21

COPY ClinicBI_system.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]