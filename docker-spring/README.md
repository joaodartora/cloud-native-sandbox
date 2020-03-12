# Follow this instructions to run the Docker container application on the browser

# Create the .war file
1. Go to the project folder
2. Run the command 'gradle wrapper'
3. Run the command './gradlew clean build'

# Create the calculator docker image
1. Run the command 'sudo docker image build -t calculator .' in the project folder to create the application image

# Running the calculator container
1. Use the command 'sudo docker images' to verify if the 'calculator' image is correctly created
2. Use the command 'sudo docker run -it -p 8080:8080 calculator' to run the calculator docker container

# Using the application via browser
1. In your browser type http://localhost:8080/{project_name} to view the index page
2. Type http://localhost:8080/{project_name}/calculator to access the calculator page
3. Type http://localhost:8080/{project_name}/calculator?firstNumber=x&secondNumber=y&operation=z
4. Change x and y to some number, and z to an operation between SUM | SUB | MULTI | DIV | POW
5. Example: http://localhost:8080/Tema-6-1.0-SNAPSHOT/calculator?firstNumber=50&secondNumber=5&operation=DIV

# Administrating the container

1. To see if the calculator container is running enter the command 'sudo docker ps'
2. To stop the calculator container enter 'sudo docker stop {calculator container id}'
