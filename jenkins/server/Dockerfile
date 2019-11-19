# Starting off with the Jenkins base Image
FROM jenkins/jenkins:lts

USER root
# Install Docker CLI
RUN apt-get update && apt-get install -y apt-transport-https ca-certificates
RUN curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add -
# RUN apt-key adv --keyserver hkp://p80.pool.sks-keyservers.net:80 --recv-keys 58118E89F3A912897C070ADBF76221572C52609D
RUN echo "deb [arch=amd64] https://download.docker.com/linux/debian stretch stable" > /etc/apt/sources.list.d/docker.list
RUN apt-get update && apt-get install -y docker-ce --allow-unauthenticated
RUN echo "jenkins ALL=NOPASSWD: ALL" >> /etc/sudoers

RUN usermod -aG docker jenkins

USER jenkins
# Installing the plugins we need using the in-built install-plugins.sh script
RUN /usr/local/bin/install-plugins.sh git matrix-auth workflow-aggregator docker-workflow blueocean credentials-binding mstest
 
# Setting up environment variables for Jenkins admin user
ENV JENKINS_USER admin
ENV JENKINS_PASS admin
ENV MASTER_EXECUTORS "1"
 
# Skip the initial setup wizard
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false
 
# Start-up scripts to set number of executors and creating the admin user
COPY executors.groovy /usr/share/jenkins/ref/init.groovy.d/
COPY default-user.groovy /usr/share/jenkins/ref/init.groovy.d/
 
VOLUME /var/jenkins_home