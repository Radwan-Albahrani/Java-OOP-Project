import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.Console;

public class Main
{
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        List<Student> students = new ArrayList<Student>();
        List<Instructor> instructors = new ArrayList<Instructor>();
        List<Admin> admins = new ArrayList<Admin>();
        User currentUser = null;
        while (true)
        {
            // Creating a menu for the user to choose from with login and register
            MainMenu();
            System.out.print("\n\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

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
            // Check if current user is null
            if (currentUser != null)
            {
                break;
            }
        }
        // TODO after login, check if user is admin, instructor, or student
        System.out.println("Successfully Logged in!");
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

        // Asking for information
        System.out.print("Enter your username: ");
        username = scanner.nextLine();
        System.out.print("Enter your password: ");
        password = getPassword();
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
