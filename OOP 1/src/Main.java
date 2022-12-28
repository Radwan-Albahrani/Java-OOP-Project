import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    // Static Variables
    public static Scanner scanner = new Scanner(System.in);
    public static List<Admin> admins = null;
    public static List<Student> students = null;
    public static List<Instructor> instructors = null;
    public static String studentFileName = "./data/students.ser";
    public static String instructorFileName = "./data/instructors.ser";
    public static String adminFileName = "./data/admins.ser";
    public static boolean demonstrationMode = false;

    // Main Method
    public static void main(String[] args) throws CloneNotSupportedException, InterruptedException
    {
        // Get students from files if exists
        students = OS.ReadFromFileStudents(studentFileName);
        instructors = OS.ReadFromFileInstructors(instructorFileName);
        admins = OS.ReadFromFileAdmins(adminFileName);
        if (students == null)
        {
            students = new ArrayList<Student>();
            OS.WriteToFileStudent(students, studentFileName);
        }
        else
        {
            for(Student student : students)
            {
                if(!(student.getCourses().isEmpty()))
                {
                    student.populateCourseInfo();
                }
            }
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
                if (instructor.getCurrentClass() != null)
                {
                    instructor.populateStudents(students);
                }
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
        User.numberOfUsers = admins.size() + instructors.size() + students.size();

        // Get Logged in user
        User currentUser = null;
        while (true)
        {
            while (true)
            {
                // Creating a menu for the user to choose from with login and register
                Menus.MainMenu();
                System.out.print(ConsoleColors.YELLOW + "Please enter your choice: " + ConsoleColors.RESET);
                // Try to get an Integer and tell user if its not an integer
                int choice = SIS.getInt();

                currentUser = LoginWorkflow(students, instructors, admins, currentUser, choice);
                // Check if current user is null
                if (currentUser != null)
                {
                    break;
                }
            }
            System.out.println(ConsoleColors.GREEN + "Successfully Logged in!" + ConsoleColors.RESET);

            // Display Welcome Message to logged in user
            System.out.println("Welcome " + currentUser.getProfile().getName() + "!");

            // Student workflow
            if (currentUser instanceof Student)
            {
                while (true)
                {
                    // Create a menu for the student to view announcements, register course, view grades, drop courses, and logout.
                    Menus.studentMenu();

                    int choice = SIS.getInt();
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
                    Menus.instructorMenu();

                    int choice = SIS.getInt();
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
                    Menus.adminMenu();

                    int choice = SIS.getInt();
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

    // ===================================== Workflows =====================================
    private static int adminWorkFlow(User currentUser, int choice) throws InterruptedException
    {
        // Admin Workflow
        int exitcode = 0;
        switch (choice)
        {
            case 1:
                ((Admin) currentUser).viewAlerts();
                break;
            case 2:
                // Create new course
                System.out.print(ConsoleColors.BLUE + "Enter course name: " + ConsoleColors.RESET);
                String courseName = scanner.nextLine();

                // Make sure course name is not empty
                while (courseName.isEmpty())
                {
                    System.out.println(ConsoleColors.RED + "Course name cannot be empty!" + ConsoleColors.RESET);
                    System.out.print(ConsoleColors.BLUE + "Enter course name: " + ConsoleColors.RESET);
                    courseName = scanner.nextLine();
                }
                System.out.print(ConsoleColors.BLUE + "Enter Credit Hours: " + ConsoleColors.RESET);
                int creditHours = SIS.getInt();
                // Make sure credit hours is bigger than 0
                while (creditHours <= 0)
                {
                    System.out.println(ConsoleColors.RED + "Credit hours must be bigger than 0! " + ConsoleColors.RESET);
                    System.out.print(ConsoleColors.BLUE + "Enter Credit Hours: " + ConsoleColors.RESET);
                    creditHours = SIS.getInt();
                }
                Admin.createCourse(courseName, creditHours);
                System.out.println(ConsoleColors.GREEN + "Course Created Successfully!" + ConsoleColors.RESET);
                break;

            case 3:
                // If all courses is empty, break
                if (Admin.allCourses.isEmpty())
                {
                    System.out.println(ConsoleColors.RED + "There are no courses to view!" + ConsoleColors.RESET);
                    break;
                }

                // Display current courses
                for (int i = 0; i < Admin.allCourses.size(); i++)
                {
                    System.out.println(i + 1 + ". " + Admin.allCourses.get(i).getCourseName());

                }

                // Select the course to edit
                System.out.print(ConsoleColors.BLUE + "Enter course number to edit: " + ConsoleColors.RESET);
                int courseNumber = SIS.getInt();

                // Index Check While loop
                while (courseNumber < 1 || courseNumber > Admin.allCourses.size())
                {
                    System.out.println(ConsoleColors.RED + "Please enter a valid course number!" + ConsoleColors.RESET);
                    System.out.print(ConsoleColors.BLUE + "Enter course number to edit: " + ConsoleColors.RESET);
                    courseNumber = SIS.getInt();
                }

                // Select a course
                Courses SelectedCourse = Admin.allCourses.get(courseNumber - 1);

                // Get new information
                System.out.print(ConsoleColors.BLACK_BRIGHT + "Enter new course name: " + ConsoleColors.RESET);
                String newCourseName = scanner.nextLine();
                System.out.print(ConsoleColors.BLACK_BRIGHT + "Enter new Credit Hours: " + ConsoleColors.RESET);
                int newCreditHours = SIS.getInt();

                Admin.editCourse(SelectedCourse, newCourseName, newCreditHours);
                break;
            case 4:
                // Null Check
                if (Admin.allCourses.size() == 0)
                {
                    System.out.println(ConsoleColors.RED + "There are no courses to delete!" + ConsoleColors.RESET);
                    break;
                }
                else
                {
                    // Display current courses
                    for (int i = 0; i < Admin.allCourses.size(); i++)
                    {
                        System.out.println(i + 1 + ". " + Admin.allCourses.get(i).getCourseName());

                    }

                    // Select the course to delete
                    System.out.print(ConsoleColors.BLUE + "Enter course number to delete: " + ConsoleColors.RESET);
                    int courseNumberToDelete = SIS.getInt();

                    // Null Check While loop
                    while (courseNumberToDelete < 1 || courseNumberToDelete > Admin.allCourses.size())
                    {
                        System.out.println(ConsoleColors.RED + "Please enter a valid course number!" + ConsoleColors.RESET);
                        System.out.print(ConsoleColors.BLUE + "Enter course number to delete: " + ConsoleColors.RESET);
                        courseNumberToDelete = SIS.getInt();
                    }

                    // Select Course
                    Courses SelectedCourseToDelete = Admin.allCourses.get(courseNumberToDelete - 1);

                    // Index Check While loop
                    while (courseNumberToDelete < 1 || courseNumberToDelete > Admin.allCourses.size())
                    {
                        System.out.println(ConsoleColors.RED + "Please enter a valid course number!" + ConsoleColors.RESET);
                        System.out.print(ConsoleColors.BLUE + "Enter course number to delete: " + ConsoleColors.RESET);
                        courseNumberToDelete = SIS.getInt();
                    }

                    Admin.deleteCourse(SelectedCourseToDelete);
                }
                break;
            case 5:
                // Display Alerts
                ((Admin) currentUser).viewAlerts();
                // Let user choose between Student, instructor, or self
                Menus.editMenu();
                int editChoice = SIS.getInt();

                // Validate Choice
                while (editChoice < 1 || editChoice > 3)
                {
                    System.out.println(ConsoleColors.RED + "Please enter a valid choice!" + ConsoleColors.RESET);
                    System.out.print(ConsoleColors.YELLOW + "Enter your choice: " + ConsoleColors.RESET);
                    editChoice = SIS.getInt();
                }

                // If statement for either choice
                if (editChoice == 1)
                {
                    SIS.editStudentInfo(currentUser);

                }
                else if (editChoice == 2)
                {
                    SIS.editInstructorInfo(currentUser);

                }
                else if (editChoice == 3)
                {
                    SIS.editAdminInfo(currentUser);

                }
                break;
            case 6:
                currentUser.displayProfile();
                break;
            case 7:
                SIS.changePassword(currentUser);
                break;
            case 8:
                // Logout
                System.out.println(ConsoleColors.GREEN + "Logged out Successfully!" + ConsoleColors.RESET);
                Thread.sleep(1000);
                exitcode = 1;
                break;
            default:
                System.out.println(ConsoleColors.RED + "Please enter a valid choice!" + ConsoleColors.RESET);
                break;
        }
        return exitcode;
    }

    private static int instructorWorkFlow(User currentUser, int choice) throws InterruptedException
    {
        // Exit Variable
        int exitcode = 0;
        switch (choice)
        {
            // Send announcements
            case 1:
                ((Instructor) currentUser).sendAnnouncements();
                break;

            // Register instructor in a class
            case 2:
                // Register the course
                ((Instructor) currentUser).selectCourse();
                break;
            // View student grades
            case 3:
                ((Instructor) currentUser).displayAllStudents();
                break;
            case 4:
                ((Instructor) currentUser).setStudentGrades();
                break;
            case 5:
                // Request a Change from the admin
                currentUser.requestChange();
                break;
            case 6:
                currentUser.displayProfile();
                break;
            case 7:
                SIS.changePassword(currentUser);
                break;
            case 8:
                exitcode = 1;
                System.out.println(ConsoleColors.GREEN + "Logged out Successfully!" + ConsoleColors.RESET);
                Thread.sleep(1000);
                break;
            default:
                System.out.println(ConsoleColors.RED + "Please enter a valid choice!" + ConsoleColors.RESET);
                break;
        }
        return exitcode;
    }

    private static int studentWorkFlow(User currentUser, int choice) throws CloneNotSupportedException, InterruptedException
    {
        // Variable for exiting the workflow
        int exitCode = 0;
        switch (choice)
        {
            case 1:
                // Register Course
                ((Student) currentUser).registerCourse();
                break;
            case 2:
                // View Grades
                ((Student) currentUser).viewCourses();
                break;
            case 3:
                // Drop Courses
                ((Student) currentUser).dropCourses();
                break;
            case 4:
                // View announcements
                System.out.println(ConsoleColors.RED_BRIGHT + "Announcements: \n\n" + ConsoleColors.RESET);
                for (Courses course : ((Student) currentUser).getCourses())
                {
                    for (String announcement : course.getCourseInfo().getAnnouncements())
                    {
                        System.out.println(announcement);
                    }
                }
                break;
            case 5:
                currentUser.requestChange();
                break;
            case 6:
                currentUser.displayProfile();
                break;
            case 7:
                SIS.changePassword(currentUser);
                break;
            case 8:
                // Logout
                System.out.println(ConsoleColors.GREEN + "Logged out Successfully!" + ConsoleColors.RESET);
                Thread.sleep(1000);
                exitCode = 1;
                break;
            default:
                System.out.println(ConsoleColors.RED + "Please enter a valid choice!" + ConsoleColors.RESET);
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
                    Menus.LoginMenu();
                    System.out.print(ConsoleColors.YELLOW + "\n\nEnter your choice: " + ConsoleColors.RESET);
                    int loginChoice = SIS.getInt();

                    // If admins are empty, then there are no admins
                    if (admins.isEmpty() && loginChoice == 1)
                    {
                        System.out.println(ConsoleColors.RED + "There are no admins!" + ConsoleColors.RESET);
                        break;
                    }

                    // If instructors are empty, then there are no instructors
                    else if (instructors.isEmpty() && loginChoice == 2)
                    {
                        System.out.println(ConsoleColors.RED + "There are no instructors!" + ConsoleColors.RESET);
                        break;
                    }

                    // If students are empty, then there are no students
                    else if (students.isEmpty() && loginChoice == 3)
                    {
                        System.out.println(ConsoleColors.RED + "There are no students!" + ConsoleColors.RESET);
                        break;
                    }

                    else if (loginChoice == 4)
                    {
                        break;
                    }
                    currentUser = SIS.login(loginChoice, students, instructors, admins);

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

                System.out.print(ConsoleColors.YELLOW + "\n\nYour choice: " + ConsoleColors.RESET);
                int role = SIS.getInt();

                User registered = SIS.getInformation(role);
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
                    break;
                }

                break;
            case 3:
                System.out.println(ConsoleColors.BLUE + "Thank you for using the University of Java" + ConsoleColors.RESET);
                OS.WriteToFileAdmin(admins, adminFileName);
                OS.WriteToFileInstructor(instructors, instructorFileName);
                OS.WriteToFileStudent(students, studentFileName);
                System.exit(0);
                break;
            default:
                System.out.println(ConsoleColors.RED + "Please enter a valid choice!" + ConsoleColors.RESET);
                break;

        }
        return currentUser;
    }

}
