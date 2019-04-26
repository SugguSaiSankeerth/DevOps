FROM tomcat

COPY target/DevOps.war /usr/local/tomcat/webapps/DevOps.war

# execute it
