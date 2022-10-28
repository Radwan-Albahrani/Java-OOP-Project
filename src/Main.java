
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.Console;

public class Main
{
    // Statuc Variables
    public static Scanner scanner = new Scanner(System.in);
    public static List<Admin> admins = null;
    public static String studentFileName = "./data/students.ser";
    public static String instructorFileName = "./data/instructors.ser";
    public static String adminFileName = "./data/admins.ser";

    // Main Method
    public static void main(String[] args) throws CloneNotSupportedException
    {
        // Get students from files if exists
        List<Student> students = OS.ReadFromFileStudents(studentFileName);
        List<Instructor> instructors = OS.ReadFromFileInstructors(instructorFileName);
        admins = OS.ReadFromFileAdmins(adminFileName);
        if (students == null)
        {
            students = new ArrayList<Student>();
            OS.WriteToFileStudent(students, studentFileName);
        }
        if (instructors == null)
        {
            instructors = new ArrayList<Instructor>();
            OS.WriteToFileInstructor(instructors, instructorFileName);
        }
        else
        {
            for (Instructor instructor : instructors)
            {
                instructor.populateStudents(students);
            }
        }
        if (admins == null)
        {
            admins = new ArrayList<Admin>();
            OS.WriteToFileAdmin(admins, adminFileName);
        }
        else
        {
            Admin.populateCourses(instructors);
        }

        // Get the maximum userID from users
        int maxUserID = 0;
        if (!(students.isEmpty() && admins.isEmpty() && instructors.isEmpty()))
        {

            for (Admin admin : admins)
            {
                if (admin.auth.getUserID() > maxUserID)
                    maxUserID = admin.auth.getUserID();
            }

            for (Instructor instructor : instructors)
            {
                if (instructor.auth.getUserID() > maxUserID)
                    maxUserID = instructor.auth.getUserID();
            }

            for (Student student : students)
            {
                if (student.auth.getUserID() > maxUserID)
                    maxUserID = student.auth.getUserID();
            }

            // Set The userId to the max
            User.numberOfUsers = maxUserID + 1;
        }

        // Get Logged in user
        User currentUser = null;
        while (true)
        {
            while (true)
            {
                // Creating a menu for the user to choose from with login and register
                MainMenu();
                System.out.print("Please enter your choice: ");
                // Try to get an Integer and tell user if its not an integer
                int choice = getInt();

                currentUser = LoginWorkflow(students, instructors, admins, currentUser, choice);
                // Check if current user is null
                if (currentUser != null)
                {
                    break;
                }
            }
            System.out.println("Successfully Logged in!");
            // Student workflow
            if (currentUser instanceof Student)
            {
                while (true)
                {
                    // Create a menu for the student to view announcements, register course, view grades, drop courses, and logout.
                    studentMenu();

                    int choice = getInt();
                    int exit = studentWorkFlow(currentUser, choice);
                    if (exit == 1)
                    {
                        OS.WriteToFileStudent(students, studentFileName);
                        currentUser = null;
                        break;
                    }
                }
            }

            else if (currentUser instanceof Instructor && !(currentUser instanceof Admin))
            {
                while (true)
                {
                    // Create a menu for the instructor to send announcements, select course, view student grades, set student grades and logout.
                    instructorMenu();

                    int choice = getInt();
                    int exit = instructorWorkFlow(currentUser, choice);
                    if (exit == 1)
                    {
                        OS.WriteToFileInstructor(instructors, instructorFileName);
                        currentUser = null;
                        break;
                    }
                }
            }

            else if (currentUser instanceof Admin)
            {
                while (true)
                {
                    // Create a menu for the admin to view announcements, register course, view grades, drop courses, and logout.
                    adminMenu();

                    int choice = getInt();
                    int exit = adminWorkFlow(currentUser, choice);
                    if (exit == 1)
                    {
                        OS.WriteToFileAdmin(admins, adminFileName);
                        currentUser = null;
                        break;
                    }
                }
            }
        }
    }

    // ===================================== Menus =====================================
    private static void MainMenu()
    {
        System.out.println("Welcome to the University of Java");
        System.out.println("Please choose one of the following options:");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
    }

    private static void LoginMenu()
    {
        System.out.println("Please choose one of the following options:");
        System.out.println("1. Admin");
        System.out.println("2. Instructor");
        System.out.println("3. Student");
        System.out.println("4. Exit");
    }

    private static void adminMenu()
    {
        System.out.println("1. View Alerts");
        System.out.println("2. Create Course");
        System.out.println("3. Edit Course");
        System.out.println("4. Delete Course");
        System.out.println("5. Edit User Information.");
        System.out.println("6. Logout");

        System.out.print("\n\nEnter your choice: ");
    }

    private static void instructorMenu()
    {
        System.out.println("1. Send Announcement");
        System.out.println("2. Select Course");
        System.out.println("3. View Student Grades");
        System.out.println("4. Set Student Grades");
        System.out.println("5. Request Change");
        System.out.println("6. Logout");

        System.out.print("\n\nEnter your choice: ");
    }

    private static void studentMenu()
    {
        System.out.println("Welcome to the Student Management system.");
        System.out.println("Select one of the following: ");
        System.out.println("1. Register Course");
        System.out.println("2. View Courses");
        System.out.println("3. Drop Course");
        System.out.println("4. View Announcements");
        System.out.println("5. Request Change");
        System.out.println("6. Logout");

        System.out.print("\n\nPlease enter your choice: ");
    }

    // ===================================== Workflows =====================================
    private static int adminWorkFlow(User currentUser, int choice) throws CloneNotSupportedException
    {
        // TODO Admin Workflow
        int exitcode = 0;
        switch (choice)
        {
            case 1:
                // If alerts is empty, tell user there are no alerts
                if (((Admin) currentUser).alerts.isEmpty())
                {
                    System.out.println("There are no alerts!");
                }
                else
                {
                    // Print all alerts
                    System.out.println("Alerts: \n");
                    for (String alert : ((Admin) currentUser).alerts)
                    {
                        System.out.println(alert);
                    }
                }

                break;
            case 2:
                // Create new course
                System.out.print("Enter course name: ");
                String courseName = scanner.nextLine();
                System.out.print("Enter Credit Hours: ");
                int creditHours = getInt();
                Admin.createCourse(courseName, creditHours);
                System.out.println("Course Created Successfully!");
                break;

            case 3:
                // Display current courses
                for (int i = 0; i < Admin.allCourses.size(); i++)
                {
                    System.out.println(i + 1 + ". " + Admin.allCourses.get(i).getCourseName());

                }

                // Select the course to edit
                System.out.print("Enter course number to edit: ");
                int courseNumber = getInt();
                Courses SelectedCourse = Admin.allCourses.get(courseNumber - 1);
                // Index Check While loop
                while (courseNumber < 1 || courseNumber > Admin.allCourses.size())
                {
                    System.out.println("Please enter a valid course number!");
                    System.out.print("Enter course number to edit: ");
                    courseNumber = getInt();
                }

                // Get new information
                System.out.print("Enter new course name: ");
                String newCourseName = scanner.nextLine();
                System.out.print("Enter new Credit Hours: ");
                int newCreditHours = getInt();

                Admin.editCourse(SelectedCourse, newCourseName, newCreditHours);
                break;
            case 6:
                // Logout
                System.out.println("Logged out Successfully!");
                exitcode = 1;
                break;
            default:
                break;
        }
        return exitcode;
    }

    private static int instructorWorkFlow(User currentUser, int choice)
    {
        // Exit Variable
        int exitcode = 0;
        switch (choice)
        {
            // Send announcements
            case 1:
                System.out.print("Enter the announcement: ");
                String announcement = scanner.nextLine();
                announcement = "Instructor Name: " + ((Instructor) currentUser).profile.getName() + "\nCourse: "
                        + ((Instructor) currentUser).getCurrentClass().getCourseName() + "\nAnnouncement: " + announcement;
                ((Instructor) currentUser).sendAnnouncement(announcement);
                break;

            // Register instructor in a class
            case 2:
                while (true)
                {
                    if (((Instructor) currentUser).getCurrentClass() != null)
                    {
                        System.out.println("You are already teaching a class");
                        break;
                    }

                    // Get All courses
                    List<Courses> allCourses = Admin.allCourses;

                    // If courses is empty then there are no courses to register in
                    if (allCourses.isEmpty())
                    {
                        System.out.println("There are no courses to register in!");
                        break;
                    }

                    // Clean out all courses so that the instructor is not in the list
                    for (int i = 0; i < allCourses.size(); i++)
                    {
                        if (allCourses.get(i).getInstructor() != null)
                        {
                            allCourses.remove(i);
                        }
                    }

                    // Display the rest of the courses
                    for (int i = 0; i < allCourses.size(); i++)
                    {
                        System.out.println(i + 1 + ". " + allCourses.get(i).getCourseName());
                    }

                    // Selecting A course
                    System.out.print("\n\nEnter the course number to register: ");
                    int courseNumber = getInt();

                    // Index Check
                    while (courseNumber < 1 || courseNumber > allCourses.size())
                    {
                        System.out.println("Invalid Choice");
                        System.out.print("Enter the number of the course you want Register: ");
                        choice = getInt();
                    }

                    // Register the course
                    ((Instructor) currentUser).registerCourse(allCourses.get(courseNumber - 1));
                    System.out.println("Course Registered Successfully!");
                    break;
                }
                break;
            // View student grades
            case 3:
                while (true)
                {
                    // Display All Students the instructor is teaching
                    List<Student> students = ((Instructor) currentUser).viewStudents();
                    if (students.isEmpty())
                    {
                        System.out.println("You are not teaching any students!");
                        break;
                    }
                    for (int i = 0; i < students.size(); i++)
                    {
                        System.out.println(i + 1 + ". " + students.get(i).profile.getName() + " " + students.get(i).auth.getUserID());
                    }

                    // Selecting A student
                    System.out.print("Enter the student number to view grades: ");
                    int studentNumber = getInt();

                    // Index Check
                    while (studentNumber < 1 || studentNumber > students.size())
                    {
                        System.out.println("Invalid Choice!");
                        System.out.print("Enter the number of the student you want to view: ");
                        studentNumber = getInt();
                    }

                    // Display the student grades for the course the instructor is teaching
                    Student selectedStudent = students.get(studentNumber - 1);
                    for (Courses course : selectedStudent.courses)
                    {
                        if (course.getInstructor() == currentUser)
                        {
                            System.out.println("Course: " + course.getCourseName());
                            System.out.println("Grade: " + course.getCourseGrade());
                        }

                    }
                    break;

                }
                break;
            case 4:
                // Select a student from the available students
                List<Student> students = ((Instructor) currentUser).viewStudents();
                // Get class
                Courses currentClass = ((Instructor) currentUser).getCurrentClass();

                // Check if students is empty
                if (students.isEmpty())
                {
                    System.out.println("You are not teaching any students!");
                    break;
                }
                // List all students
                for (int i = 0; i < students.size(); i++)
                {
                    System.out.println(i + 1 + ". " + students.get(i).profile.getName());
                }

                // Select a student
                System.out.print("Select a student: ");
                int studentIndex = getInt();
                // Index Check While loop
                while (studentIndex < 1 || studentIndex > students.size())
                {
                    System.out.println("Please enter a valid student number!");
                    System.out.print("Select a student: ");
                    studentIndex = getInt();
                }
                Student selectedStudent = students.get(studentIndex - 1);

                // Ask what grade to set
                System.out.print("Enter the Percentage grade: ");
                Double grade = getDouble();

                // Check if grade is between 0 and 100. If not, ask again
                while (grade < 0 || grade > 100)
                {
                    System.out.println("Enter the Percentage grade (Must be between 0 and 100): ");
                    grade = getDouble();
                }
                // Search for that class in student and set its grade
                for (Courses course : selectedStudent.courses)
                {
                    if (course.getCourseName().equals(currentClass.getCourseName()))
                    {
                        course.setCoursePercents(grade);
                        break;
                    }
                }
                break;
            case 5:
                // Request a Change from the admin
                System.out.print("Type out an email to the admin for a change request: ");
                String email = scanner.nextLine();
                email = "From: " + currentUser.profile.getName() + "\nEmail: " + currentUser.profile.getEmail() + "\nID: "
                        + currentUser.auth.getUserID() + "\nRequest: " + email;
                for (Admin admin : admins)
                {
                    admin.alerts.add(email);
                }
                System.out.println("Change Requested Successfully");
                break;
            case 6:
                exitcode = 1;
                System.out.println("Logged out Successfully!");
                break;
        }
        return exitcode;
    }

    private static int studentWorkFlow(User currentUser, int choice) throws CloneNotSupportedException
    {
        // Variable for exiting the workflow
        int exitCode = 0;
        switch (choice)
        {
            case 1:
                // Register Course
                registerCourse((Student) currentUser);
                break;
            case 2:
                // View Grades
                viewCourses((Student) currentUser);
                break;
            case 3:
                // Drop Courses
                dropCourses((Student) currentUser);
                break;
            case 4:
                // View announcements
                System.out.println("Announcements: \n\n");
                for (String announcements : Student.announcements)
                {
                    System.out.println(announcements);
                }
                break;
            case 5:
                // Request a Change from the admin
                System.out.print("Type out an email to the admin for a change request: ");
                String email = scanner.nextLine();
                email = "From: " + currentUser.profile.getName() + "\nEmail: " + currentUser.profile.getEmail() + "\nID: "
                        + currentUser.auth.getUserID() + "\nRequest: " + email;
                for (Admin admin : admins)
                {
                    admin.alerts.add(email);
                }
                System.out.println("Change Requested Successfully");
                break;
            case 6:
                // Logout
                System.out.println("Logged out Successfully!");
                exitCode = 1;
                break;
        }
        return exitCode;
    }

    private static User LoginWorkflow(List<Student> students, List<Instructor> instructors, List<Admin> admins, User currentUser, int choice)
    {
        // Switch statement for choice
        switch (choice)
        {
            case 1:
                while (true)
                {
                    // Login as Admin, Instructor, or Student
                    LoginMenu();
                    System.out.print("\n\nEnter your choice: ");
                    int loginChoice = getInt();

                    // If admins are empty, then there are no admins
                    if (admins.isEmpty() && loginChoice == 1)
                    {
                        System.out.println("There are no admins!");
                        break;
                    }

                    // If instructors are empty, then there are no instructors
                    else if (instructors.isEmpty() && loginChoice == 2)
                    {
                        System.out.println("There are no instructors!");
                        break;
                    }

                    // If students are empty, then there are no students
                    else if (students.isEmpty() && loginChoice == 3)
                    {
                        System.out.println("There are no students!");
                        break;
                    }

                    else if (loginChoice == 4)
                    {
                        break;
                    }
                    currentUser = login(loginChoice, students, instructors, admins);

                    // Check if current user is null
                    if (currentUser != null)
                    {
                        break;
                    }
                }
                break;

            case 2:
                // Asking if the user is an instructor or a student or an Admin
                System.out.println("Please select your role: ");
                System.out.println("1. Admin");
                System.out.println("2. Instructor");
                System.out.println("3. Student");
                System.out.println("4. Exit");

                System.out.print("\n\nYour choice: ");
                int role = getInt();
                // TODO change this to getInformation after testing
                User registered = testGetInformation(role);
                if (registered == null)
                {
                     System.out.println("There are no admins in this system.");
                }
                if (registered instanceof Student)
                {
                    students.add((Student) registered);
                }
                else if (registered instanceof Instructor && !(registered instanceof Admin))
                {
                    instructors.add((Instructor) registered);
                }
                else if (registered instanceof Admin)
                {
                    admins.add((Admin) registered);
                }
                else
                {
                    System.out.println("Error: User is not a student or instructor");
                }

                break;
            case 3:
                System.out.println("Thank you for using the University of Java");
                OS.WriteToFileAdmin(admins, adminFileName);
                OS.WriteToFileInstructor(instructors, instructorFileName);
                OS.WriteToFileStudent(students, studentFileName);
                System.exit(0);
                break;

        }
        return currentUser;
    }

    // ===================================== Methods =====================================
    // Method to drop a course from a student
    private static void dropCourses(Student currentUser)
    {
        // Get Courses from current user
        List<Courses> courses = currentUser.getCourses();

        // List All courses
        for (int i = 0; i < courses.size(); i++)
        {
            System.out.println((i + 1) + ". " + courses.get(i).getCourseName());
        }

        // Select a course from the menu
        System.out.print("Enter the number of the course you want to drop: ");
        int choice = getInt();

        // Index Check
        while (choice < 1 || choice > courses.size())
        {
            System.out.print("Enter the number of the course you want to drop: ");
            choice = getInt();
        }

        // Drop the course
        currentUser.dropCourses(courses.get(choice - 1));
    }

    // Method to view all courses of a student
    private static void viewCourses(Student currentUser)
    {
        // Get all courses from the current user and print them along with grades
        List<Courses> courses = currentUser.getCourses();
        System.out.println("Courses: \n");
        for (Courses course : courses)
        {
            System.out.println("Course name: " + course.getCourseName() + "\nCourse Percent: " + course.getCoursePercent());
        }

        // Print out the GPA at the end
        System.out.println("GPA: " + currentUser.getGpa());
    }

    // Method to register a course for a student
    private static void registerCourse(User currentUser) throws CloneNotSupportedException
    {
        // Get all Courses from admin class
        List<Courses> courses = Admin.allCourses;

        // If courses is empty exit
        if (courses.isEmpty())
        {
            System.out.println("There are no courses!");
            return;
        }

        // Clean courses list if course has no instructor
        for (int i = 0; i < courses.size(); i++)
        {
            if (courses.get(i).getInstructor() == null)
            {
                courses.remove(i);
            }
        }

        // If course is already registered, remove it from list of courses
        for (int i = 0; i < courses.size(); i++)
        {
            if (currentUser instanceof Student)
            {
                if (((Student) currentUser).isRegistered(courses.get(i)))
                {
                    courses.remove(i);
                }
            }
        }

        // If courses is empty exit
        if (courses.isEmpty())
        {
            System.out.println("There are no courses!");
            return;
        }
        // List All courses that have instructors
        for (int i = 0; i < courses.size(); i++)
        {
            System.out.println((i + 1) + ". " + courses.get(i).getCourseName() + " - " + courses.get(i).getInstructor().profile.getName());
        }

        // Select a course from the menu
        System.out.print("Enter the number of the course you want to register: ");
        int choice = getInt();

        // Index Check
        while (choice < 1 || choice > courses.size())
        {
            System.out.print("Enter the number of the course you want to drop: ");
            choice = getInt();
        }
        // Add course to student
        currentUser.registerCourse((Courses) courses.get(choice - 1).clone());
        System.out.println("Course Registered Successfully!");
    }

    // Method to login  as an admin, instructor, or student
    private static User login(int loginChoice, List<Student> students, List<Instructor> instructors, List<Admin> admins)
    {
        User currentUser = null;
        switch (loginChoice)
        {
            case 1:
                // If admins are empty then return null
                if (admins.isEmpty())
                {
                    System.out.println("No admins registered");
                    return null;
                }
                // Login as Admin
                System.out.print("Enter your username: ");
                String username = scanner.nextLine();
                System.out.print("Enter your password: ");
                String password = getPassword();
                for (Admin admin : admins)
                {
                    if (admin.auth.getUsername().equals(username) && admin.auth.getPassword().equals(password))
                    {
                        // Get this admin from the admins arraylist
                        currentUser = admin;
                        break;
                    }
                }
                break;
            case 2:
                // If instructors are empty then return null
                if (instructors.isEmpty())
                {
                    System.out.println("No instructors registered");
                    return null;
                }
                // Login as Instructor
                System.out.print("Enter your username: ");
                username = scanner.nextLine();
                System.out.print("Enter your password: ");
                password = getPassword();
                for (Instructor instructor : instructors)
                {
                    if (instructor.auth.getUsername().equals(username) && instructor.auth.getPassword().equals(password))
                    {
                        // Get this instructor from the instructors arraylist
                        currentUser = instructor;
                        break;
                    }
                }
                break;
            case 3:
                // If students are empty then return null
                if (students.isEmpty())
                {
                    System.out.println("No students registered");
                    return null;
                }
                // Login as Student
                System.out.print("Enter your username: ");
                username = scanner.nextLine();
                System.out.print("Enter your password: ");
                password = getPassword();
                for (Student student : students)
                {
                    if (student.auth.getUsername().equals(username) && student.auth.getPassword().equals(password))
                    {
                        // Get this student from the students arraylist
                        currentUser = student;
                        break;
                    }
                }
                break;
            default:
                break;
        }
        // Check if current user is null
        if (currentUser == null)
        {
            System.out.println("Invalid username or password");
            return null;
        }
        else
        {
            return currentUser;
        }
    }

    // Method to get password in a hidden way
    private static String getPassword()
    {
        Console console = System.console();
        char[] hiddenPassword = console.readPassword();
        String password = new String(hiddenPassword);
        return password;
    }

    // Method to calculate age based on date of birth
    public static int calculateAge(LocalDate dob)
    {
        // Get local date of now
        LocalDate curDate = LocalDate.now();
        // calculates the amount of time between two dates and returns the years
        if ((dob != null) && (curDate != null) && (dob.isBefore(curDate)))
        {
            return Period.between(dob, curDate).getYears();
        }
        else
        {
            return 0;
        }
    }

    // TESTER METHOD REMOVE WHEN DONE
    public static User testGetInformation(int role)
    {
        if (role == 1)
        {
            User admin = new Admin(0, "admin" + User.numberOfUsers, "123", "admin" + User.numberOfUsers, "admin", "admin", "admin", "admin", "admin",
                    LocalDate.now(), Gender.F, 0);
            System.out.println("Username: " + admin.auth.getUsername());
            System.out.println("Password: " + admin.auth.getPassword());
            return admin;
        }

        else if (role == 2)
        {
            User instructor = new Instructor(0, "instructor" + User.numberOfUsers, "123", "instructor" + User.numberOfUsers, "instructor", "instructor",
                    "instructor", "instructor", "instructor", LocalDate.now(), Gender.F, 0);
            System.out.println("Username: " + instructor.auth.getUsername());
            System.out.println("Password: " + instructor.auth.getPassword());
            return instructor;
        }
        else
        {
            User student = new Student(0, "student" + User.numberOfUsers, "123", "student" + User.numberOfUsers, "student", "student", "student", "student",
                    "student", LocalDate.now(), Gender.F, 0);
            System.out.println("Username: " + student.auth.getUsername());
            System.out.println("Password: " + student.auth.getPassword());
            return student;
        }
    }

    // Method to get information from the user
    public static User getInformation(int role)
    {
        // Variables
        String name, nationality, field, additionalField, email, phoneNumber = "", username, password = "";
        int age = 0;
        Gender gender = Gender.valueOf("M");
        LocalDate dob = null;
        boolean notParsed;

        // Only allow user creation if at least one admin exists 
        if (admins.isEmpty())
        {
            return null;
        }

        // Validating role
        while (role != 1 && role != 2 && role != 3 && role != 4)
        {
            System.out.println("Invalid choice");
            System.out.print("Please enter your choice: ");
            role = getInt();
        }
        if (role == 4)
        {
            return null;
        }

        System.out.print("Enter your name: ");
        name = scanner.nextLine();

        // While name is empty, Ask again
        while (name.isEmpty())
        {
            System.out.print("Please enter a valid name: ");
            name = scanner.nextLine();
        }
        // Get date of birth and validate it
        notParsed = false;
        while (!notParsed)
        {
            try
            {
                System.out.print("Enter date of birth in YYYY-MM-DD format: ");
                // reads the date of birth from the user
                String input = scanner.nextLine();
                dob = LocalDate.parse(input);
                age = calculateAge(dob);
                if (age <= 0)
                {
                    System.out.println("Please enter a valid date of birth");
                }
                else
                {
                    notParsed = true;
                }
            }
            catch (Exception e)
            {
                System.out.println("Make sure you have the proper date format");
            }
        }

        // Get Nationality
        System.out.print("Enter your nationality: ");
        nationality = scanner.nextLine();

        // nationality cannot be empty
        while (nationality.isEmpty())
        {
            System.out.println("Nationality cannot be empty");
            System.out.print("Enter your Nationality: ");
            field = scanner.nextLine();
        }

        // Get phone number and make sure its the proper format
        notParsed = false;
        while (!notParsed)
        {
            try
            {
                System.out.print("Enter your phone number: ");
                phoneNumber = scanner.nextLine();
                if (phoneNumber.length() != 10)
                {
                    throw new Exception();
                }
                for (int i = 0; i < phoneNumber.length(); i++)
                {
                    if (Character.isLetter((phoneNumber.charAt(i))))
                    {
                        throw new Exception();
                    }

                }
                notParsed = true;
            }
            catch (Exception e)
            {
                System.out.println("Make sure you have the proper phone number");
            }
        }

        // Get Gender and make sure it is either M or F
        notParsed = false;
        while (!notParsed)
        {
            try
            {
                System.out.print("Enter your gender: ");
                gender = Gender.valueOf(("" + scanner.next().charAt(0)));
                notParsed = true;
            }
            catch (Exception e)
            {
                System.out.println("Only M or F are allowed");
            }
        }
        scanner.nextLine();

        // Get field
        System.out.print("Enter your field: ");
        field = scanner.nextLine();

        // Field Cannot be empty
        while (field.isEmpty())
        {
            System.out.println("Field cannot be empty");
            System.out.print("Enter your field: ");
            field = scanner.nextLine();
        }

        // Get Additional Field
        System.out.print("Enter your additional field (If Any): ");
        additionalField = scanner.nextLine();

        // Set Arbitrary Username and email fields
        email = "" + name.split(" ")[0] + User.numberOfUsers + "@university.com";
        username = "" + name.split(" ")[0] + User.numberOfUsers;
        System.out.println("Your Username has been set to: " + username);

        // Get Password
        System.out.print("Enter your password: ");
        password = getPassword();

        // Check role and create appropriate object
        if (role == 1)
        {
            User admin = new Admin(0, username, password, name, nationality, field, additionalField, email, phoneNumber, dob, gender, age);
            System.out.println("Registration as Admin Successful!");
            return admin;
        }
        else if (role == 2)
        {
            User instructor = new Instructor(1, username, password, name, nationality, field, additionalField, email, phoneNumber, dob, gender, age);
            System.out.println("Registration As Instructor Successful!");
            return instructor;
        }
        else
        {
            User student = new Student(2, username, password, name, nationality, field, additionalField, email, phoneNumber, dob, gender, age);
            System.out.println("Registration as Student Successful!");
            return student;
        }

    }

    // Method to get an integer
    private static int getInt()
    {
        int choice = 0;
        boolean notParsed = false;
        do
        {
            try
            {
                choice = Integer.parseInt(scanner.nextLine());
                notParsed = false;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Please enter a valid number!");
                System.out.print("Enter Your Choice: ");
                notParsed = true;
            }
        } while (notParsed);

        return choice;
    }

    // Method to get a double
    private static double getDouble()
    {
        double choice = 0;
        boolean notParsed = false;
        do
        {
            try
            {
                choice = Double.parseDouble(scanner.nextLine());
                notParsed = false;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Please enter a valid number!");
                System.out.print("Enter Your Choice: ");
                notParsed = true;
            }
        } while (notParsed);

        return choice;
    }
}
