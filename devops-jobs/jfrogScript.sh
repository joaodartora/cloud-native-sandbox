wget 'https://api.bintray.com/content/jfrog/artifactory/jfrog-artifactory-oss-$latest.zip;bt_package=jfrog-artifactory-oss-zip' -O artifactory.zip
unzip artifactory/
sudo artifactory/bin/./installService.sh
sudo service artifactory start
