FROM centos:7
MAINTAINER test@126.com
ADD jdk-8u281-linux-x64.tar.gz /usr/local
ENV JAVA_HOME /usr/local/jdk1.8.0_281
ADD https://mirrors.bfsu.edu.cn/apache/tomcat/tomcat-8/v8.5.64/bin/apache-tomcat-8.5.64.tar.gz /usr/local
RUN tar -xvf /usr/local/apache-tomcat-8.5.64.tar.gz -C /usr/local/
ADD extjs4.2.5.tar /usr/local/apache-tomcat-8.5.64/webapps
#RUN tar -xvf /usr/local/apache-tomcat-8.5.64/webapps/extjs4.2.5.tar /usr/local/apache-tomcat-8.5.64/webapps
ENTRYPOINT ["/usr/local/aplsache-tomcat-8.5.64/bin/catalina.sh", "run"]
EXPOSE 8080