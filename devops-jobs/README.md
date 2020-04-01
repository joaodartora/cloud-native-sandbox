### First Run JFrog Script
1. First you need to download the JFrog files in the JFrog site.
2. Run the command ```chmod -x jfrogScript.sh```.
3. Run the command ```sudo ./jfrogScript.sh```.

# Job 01

### Download Github file
1. Jenkins does this through its own source code management tool. The repository link with the github application codes can be inserted by parameter.

### Run tests
1. The ```gradle test``` command allows the program to perform the unit tests. In case of an error, the program aborts execution.

### Publish to Artifactory
1. The Gradle ```clean artifactoryPublish``` command automatically publishes the generated *.war* file in the Artifactory, which was previously configured in Jenkins.

# Job 02

### Build docker image and publish in Dockerhub

1. All job steps are performed in the *.json* file used by Packer.
The Packer *.json* file is used to perform the image construction of the docker, inside it we can call an Ansible script, which is used to provision all the necessary configuration on the machine, even inside the Packer script we can perform the tagging and push the image created for Dockerhub.

# Job 03

### Pull the Dockerhub image and run it

1. To pull the docker image, use the command ```docker run -p {local_port}:{image_port} {user name}/{repo-name}:{image tag}```, this command looks for the image locally, in case you do not find it look at Dockerhub. It is necessary to give the ```docker login``` command passing Dockerhub username and password per parameter to be able to pull.
