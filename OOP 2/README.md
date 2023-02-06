# Java Project

The aim of this project is to create a Student Information System (SIS) using Java. The primary audience/user(s) of this system will be:

1. Admin
2. Instructors
3. Students

## Step 1: Setting up the database

- Open MySQL Workbench
- Make a server connection with the following credentials:
  - Hostname: localhost
  - Port: 3306
  - Username: doesn't matter
  - Password: doesn't matter
- Go to src/main/resources/Database and open the file called "create_database.sql"
- Copy the contents of the file
- Open a new query tab in MySQL Workbench
- Paste the contents of the file into the query tab
- Run all the queries in the file

## Step 2: Running the program

### NetBeans

To Run the program. Make sure you have NetBeans installed on your computer, then do the following:

- Open NetBeans
- Click on File
- Click on Open Project
- Navigate to the folder where you saved the project
- Click on the project folder
- Click on Open Project
- Click on Run Project

### Command Line

To Run the program from the command line, do the following:

- Open a command prompt
- Navigate to the folder where you saved the project
- Navigate to the Jar file included with the project
- Type the following command: java -jar "Java Project.jar"

Note: This would ONLY work if you have java version 17 or higher installed.
