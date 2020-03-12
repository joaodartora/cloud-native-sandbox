# Github API and Twitter API Consumer

# Follow this instructions to run the GitHub and Twitter API's

# Setting the environment variables

1. Before you can build the jar for each service, you'll need to set up environment variables for:

* consumerKey
* consumerSecret
* accessToken
* accessSecret

2. You can do that by accessing the the application.properties file on the '/twitter-service/src/main/resources' folder and setting your twitter tokens

# Creating the .jar file
1. Go to the project folder
2. Run the command 'gradle wrapper' and the command './gradlew clean build' on each folder (twitter-service| github-service| totalizer-service)

# Creating the docker images
1. Run the command 'sudo docker build -t {application_name} .' on each folder (twitter-service| github-service| totalizer-service), using the respective names (twitter | github | totalizer)

# Running the docker compose
1. In the project folder, where is the the docker-compose.yml file, run the command 'sudo docker-compose up' to run all the docker containers

# Using the Twitter application
1. In your browser, type 'http://localhost:8181/twitter/{twitter_user}' to see the number of tweets from the specified user

# Using the GitHub application
1. In your browser, type 'http://localhost:8282/github/{github_user}' to see the number of repositories from the specified user

# Using the Twitter and GitHub application
1. In your browser, type 'http://localhost:8080/totalizer/twitter/{twitter_user}/github/{github_user' to see the number of tweets and github repositories from the specified users, respectively
