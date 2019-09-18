# Starting off with the Jenkins base Image
FROM jenkins/jenkins:lts

COPY tandem_proxy.pem /usr/local/share/ca-certificates/
# if we want to install via apt
USER root
# RUN apt-get update && apt-get install -y ruby make more-thing-here
# drop back to the regular jenkins user - good practice
RUN update-ca-certificates
USER jenkins

# Installing the plugins we need using the in-built install-plugins.sh script
RUN /usr/local/bin/install-plugins.sh git matrix-auth workflow-aggregator docker-workflow blueocean credentials-binding
 
# Setting up environment variables for Jenkins admin user
ENV JENKINS_USER admin
ENV JENKINS_PASS admin
 
# Skip the initial setup wizard
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false
 
# Start-up scripts to set number of executors and creating the admin user
COPY executors.groovy /usr/share/jenkins/ref/init.groovy.d/
COPY default-user.groovy /usr/share/jenkins/ref/init.groovy.d/
 
VOLUME /var/jenkins_home