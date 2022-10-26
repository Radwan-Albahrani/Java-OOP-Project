import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.Console;

public class Main
{
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws CloneNotSupportedException
    {
        List<Student> students = new ArrayList<Student>();
        List<Instructor> instructors = new ArrayList<Instructor>();
        List<Admin> admins = new ArrayList<Admin>();
        User currentUser = null;
        while (true)
        {
            while (true)
            {
                // Creating a menu for the user to choose from with login and register
                MainMenu();
                System.out.print("\n\nEnter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                currentUser = LoginWorkflow(students, instructors, admins, currentUser, choice);
                // Check if current user is null
                if (currentUser != null)
                {
                    break;
                }
            }
            // TODO after login, check if user is admin, instructor, or student
            System.out.println("Successfully Logged in!");
            // Student workflow
            if (currentUser instanceof Student)
            {
                while (true)
                {
                    // Create a menu for the student to view announcements, register course, view grades, drop courses, and logout.
                    studentMenu();

                    int choice = scanner.nextInt();
                    int exit = studentWorkFlow(currentUser, choice);
                    if (exit == 1)
                    {
                        break;
                    }
                }
            }

            else if (currentUser instanceof Instructor)
            {
                while (true)
                {
                    // Create a menu for the instructor to send announcements, select course, view student grades, set student grades and logout.
                    instructorMenu();

                    int choice = scanner.nextInt();
                    int exit = instructorWorkFlow(currentUser, choice);
                    if (exit == 1)
                    {
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

                    int choice = scanner.nextInt();
                    adminWorkFlow(currentUser, choice);
                }
            }
        }
    }

    private static void adminWorkFlow(User currentUser, int choice)
    {
    }

    private static void adminMenu()
    {
    }

    private static int instructorWorkFlow(User currentUser, int choice)
    {
        int exitcode = 0;
        switch (choice)
        {
            // Send announcements
            case 1:
                scanner.nextLine();
                System.out.print("Enter the announcement: ");
                String announcement = scanner.nextLine();
                ((Instructor) currentUser).sendAnnouncement(announcement);
                break;
            // Register instructor in a class
            case 2:
                while (true)
                {
                    if (((Instructor) currentUser).getCurrentClass() != null) {
                        System.out.println("You are already teaching a class");
                        break;
                    }
                    System.out.println("Enter the course name: ");
                    String courseName = scanner.nextLine();
                    Courses selectedCourse = null;
                    // Search for course in admin
                    for (Courses course : Admin.allCourses)
                    {
                        if (course.getCourseName().equals(courseName))
                        {
                            selectedCourse = course;
                            break;
                        }
                    }

                    if (selectedCourse != null)
                    {
                        ((Instructor) currentUser).registerCourse(selectedCourse);
                        break;
                    }
                    else
                    {
                        System.out.println("Course not found!");
                    }
                }
                break;
            // View student grades
            case 3:
                while (true)
                {
                    System.out.println("Enter the student name: ");
                    String studentName = scanner.nextLine();
                    Student selectedStudent = null;
                    // Search for student in instructor
                    for (Student student : ((Instructor) currentUser).students)
                    {
                        if (student.profile.getName().equals(studentName))
                        {
                            selectedStudent = student;
                            break;
                        }
                    }

                    if (selectedStudent != null)
                    {
                        for (Courses course : selectedStudent.courses)
                        {
                            System.out.println(course.getCourseName() + " " + course.getCourseGrade());
                        }
                        break;
                    }
                    else
                    {
                        System.out.println("Student not found!");
                    }
                }
                break;
            case 4:
                // TODO Set Student Grades
                break;
            case 5:
                exitcode = 1;
                break;
        }
        return exitcode;
    }

    private static void instructorMenu()
    {
        System.out.println("1. Send Announcement");
        System.out.println("2. Select Course");
        System.out.println("3. View Student Grades");
        System.out.println("4. Set Student Grades");
        System.out.println("5. Logout");

        System.out.print("\n\nEnter your choice: ");
    }

    private static int studentWorkFlow(User currentUser, int choice) throws CloneNotSupportedException
    {
        int exitCode = 0;
        switch (choice)
        {
            case 1:
                // Register Course
                registerCourse((Student) currentUser);
                break;
            case 2:
                // View Grades
                viewGrades((Student) currentUser);
                break;
            case 3:
                // Drop Courses
                dropCourses((Student) currentUser);
                break;
            case 4:
                // View announcements
                for (String announcements : Student.announcements)
                {
                    System.out.println(announcements);
                }
                break;
            case 5:
                // Logout
                System.out.println("Successfully logged out!");
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
                    int loginChoice = scanner.nextInt();
                    scanner.nextLine();

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
                    currentUser = login(loginChoice, students, instructors, admins);

                    // Check if current user is null
                    if (currentUser != null)
                    {
                        break;
                    }
                }
                break;

            case 2:
                User registered = getInformation();
                if (registered instanceof Student)
                {
                    students.add((Student) registered);
                }
                else if (registered instanceof Instructor)
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
                System.exit(0);
                break;

        }
        return currentUser;
    }

    private static void dropCourses(Student currentUser)
    {
        List<Courses> courses = currentUser.viewCourses();
        // List All courses
        for (int i = 0; i < courses.size(); i++)
        {
            System.out.println((i + 1) + ". " + courses.get(i).getCourseName());
        }

        // Select a course from the menu
        System.out.print("Enter the number of the course you want to drop: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        // Drop the course
        currentUser.dropCourses(courses.get(choice - 1));
    }

    private static void viewGrades(Student currentUser)
    {
        List<Courses> courses = currentUser.viewCourses();
        for (Courses course : courses)
        {
            System.out.println(course);
        }
    }

    private static void registerCourse(User currentUser) throws CloneNotSupportedException
    {
        // Get all Courses from admin class
        List<Courses> courses = Admin.allCourses;
        // List All courses
        for (int i = 0; i < courses.size(); i++)
        {
            System.out.println((i + 1) + ". " + courses.get(i).getCourseName());
        }

        // Select a course from the menu
        System.out.print("Enter the number of the course you want to register: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        // Add course to student
        currentUser.registerCourse((Courses) courses.get(choice - 1).clone());
    }

    private static void studentMenu()
    {
        System.out.println("Welcome to the Student Management system.");
        System.out.println("Select one of the following: ");
        System.out.println("1. Register Course");
        System.out.println("2. View courses");
        System.out.println("3. View Grades");
        System.out.println("4. View Announcements");
        System.out.println("5. Logout");

        System.out.println("\n\nPlease enter your choice: ");
    }

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

    private static String getPassword()
    {
        Console console = System.console();
        char[] hiddenPassword = console.readPassword();
        String password = new String(hiddenPassword);
        return password;
    }

    private static void LoginMenu()
    {
        System.out.println("Please choose one of the following options:");
        System.out.println("1. Admin");
        System.out.println("2. Instructor");
        System.out.println("3. Student");
        System.out.println("4. Exit");
    }

    private static void MainMenu()
    {
        System.out.println("Welcome to the University of Java");
        System.out.println("Please choose one of the following options:");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
    }

    public static int calculateAge(LocalDate dob)
    {
        // Get local date of now
        LocalDate curDate = LocalDate.now();
        // calculates the amount of time between two dates and returns the years
        if ((dob != null) && (curDate != null))
        {
            return Period.between(dob, curDate).getYears();
        }
        else
        {
            return 0;
        }
    }

    public static User getInformation()
    {
        // Variables
        String name, nationality, field, additionalField, email, phoneNumber = "", username, password = "";
        int age = 0;
        Gender gender = Gender.valueOf("M");
        LocalDate dob = null;
        boolean notParsed = false;

        // Asking if the user is an instructor or a student or an Admin
        System.out.println("Please select your role: ");
        System.out.println("1. Admin");
        System.out.println("2. Instructor");
        System.out.println("3. Student");

        System.out.print("\n\nYour choice: ");
        int role = scanner.nextInt();
        scanner.nextLine();

        // Validating role
        while (role != 1 && role != 2 && role != 3)
        {
            System.out.println("Please select a valid role: ");
            System.out.println("1. Admin");
            System.out.println("2. Instructor");
            System.out.println("3. Student");
            role = scanner.nextInt();
        }

        System.out.print("Enter your name: ");
        name = scanner.nextLine();

        while (!notParsed)
        {
            try
            {
                System.out.print("Enter date of birth in YYYY-MM-DD format: ");
                // reads the date of birth from the user
                String input = scanner.nextLine();
                dob = LocalDate.parse(input);
                age = calculateAge(dob);
                notParsed = true;
            }
            catch (Exception e)
            {
                System.out.println("Make sure you have the proper date format");
            }
        }

        System.out.print("Enter your nationality: ");
        nationality = scanner.nextLine();
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
        System.out.print("Enter your field: ");
        field = scanner.nextLine();
        System.out.print("Enter your additional field (If Any): ");
        additionalField = scanner.nextLine();
        email = "" + name.split(" ")[0] + User.numberOfUsers + "@university.com";
        username = "" + name.split(" ") + User.numberOfUsers;
        System.out.println("Your Username has been set to: " + username);
        System.out.print("Enter your password: ");
        password = getPassword();

        // Check role and create appropriate object
        if (role == 1)
        {
            User student = new Admin(0, username, password, name, nationality, field, additionalField, email, phoneNumber, dob, gender, age);
            return student;
        }
        else if (role == 2)
        {
            User instructor = new Instructor(1, username, password, name, nationality, field, additionalField, email, phoneNumber, dob, gender, age);
            return instructor;
        }
        else
        {
            User admin = new Student(2, username, password, name, nationality, field, additionalField, email, phoneNumber, dob, gender, age);
            return admin;
        }
    }
}
