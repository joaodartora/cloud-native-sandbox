
# Follow this instructions to run the application on the Apache Tomcat server:

# Creating the .war file
1. Run the command 'gradle wrapper'inside the project folder;
2. Run the command './gradlew clean build' inside the project folder;

# Starting Apache Tomcat server with the created file
1. Go to the ~/build/libs folder, where you will find the {project_name}.war file
2. Copy the {project_name}.war file to the ~/apache-tomcat-{version}/webapps
3. Run the command 'bin/catalina.sh into the ~/apache-tomcat-{version}

# Using the application via browser
1. In your browser type http://localhost:8080/{project_name} to view the index page
2. Type http://localhost:8080/{project_name}/calculator to access the calculator page
3. Type http://localhost:8080/{project_name}/calculator?firstNumber=x&secondNumber=y&operation=z
4. Change x and y to some number, and z to an operation between SUM | SUB | MULTI | DIV | POW
5. Example: http://localhost:8080/Tema-3-1.0-SNAPSHOT/calculator?firstNumber=50&secondNumber=5&operation=DIV
