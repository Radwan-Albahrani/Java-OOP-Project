import java.io.Console;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class SIS
{

    // Edit Admin Information
    static void editAdminInfo(User currentUser)
    {
        Admin adminToEdit = (Admin) currentUser;

        // Null Check
        if (adminToEdit == null)
        {
            System.out.println(ConsoleColors.RED + "Admin not found!" + ConsoleColors.RESET);
            return;
        }

        // Display Profile
        System.out.println(ConsoleColors.BLUE + "Admin Profile: " + ConsoleColors.RESET);
        List<String> profile = adminToEdit.viewProfile();
        for (String line : profile)
        {
            System.out.println(line);
        }

        // Select the field to edit
        Menus.editMenuExact();
        int editChoiceExact = SIS.getInt();

        // Check Choice
        while (editChoiceExact < 1 || editChoiceExact > 7)
        {
            System.out.println(ConsoleColors.RED + "Please enter a valid choice!" + ConsoleColors.RESET);
            System.out.print(ConsoleColors.YELLOW + "Enter your choice: " + ConsoleColors.RESET);
            editChoiceExact = SIS.getInt();
        }

        if (editChoiceExact == 7)
        {
            System.out.println("Exiting...");
            return;
        }

        // Get Value Based on Choice
        String newValue = "";
        LocalDate dob = null;
        boolean valid = false;
        while (!valid)
        {
            switch (editChoiceExact)
            {
                case 1:
                    System.out.print(ConsoleColors.BLUE + "Enter new Name: " + ConsoleColors.RESET);
                    newValue = Main.scanner.nextLine();
                    break;
                case 2:
                    System.out.print(ConsoleColors.BLUE + "Enter new Nationality: " + ConsoleColors.RESET);
                    newValue = Main.scanner.nextLine();
                    break;
                case 3:
                    System.out.print(ConsoleColors.BLUE + "Enter new Phone Number: " + ConsoleColors.RESET);
                    newValue = Main.scanner.nextLine();
                    break;
                case 4:
                    System.out.print(ConsoleColors.BLUE + "Enter new Date of Birth: " + ConsoleColors.RESET);
                    dob = SIS.getDateOfBirth();
                    break;
                case 5:
                    System.out.print(ConsoleColors.BLUE + "Enter new Field: " + ConsoleColors.RESET);
                    newValue = Main.scanner.nextLine();
                    break;
                case 6:
                    System.out.print(ConsoleColors.BLUE + "Enter new Additional Field: " + ConsoleColors.RESET);
                    newValue = Main.scanner.nextLine();
                    break;
            }

            // Check if valid
            if (editChoiceExact == 4)
            {
                if (dob != null)
                {
                    valid = true;
                }
            }
            else
            {
                if (!newValue.equals(""))
                {
                    // Check if it has any digits
                    if (newValue.matches(".*\\d.*"))
                    {
                        System.out.println(ConsoleColors.RED + "Invalid Input! Please enter a valid input! Cannot have digits" + ConsoleColors.RESET);
                    }
                    else
                    {
                        valid = true;
                    }
                }
            }

        }
        int age = SIS.calculateAge(dob);
        if (editChoiceExact == 4)
        {
            ((Admin) currentUser).editProfile(adminToEdit, dob, age);
            System.out.println(ConsoleColors.GREEN + "Profile Edited Successfully!" + ConsoleColors.RESET);
            System.out.println("New Profile: ");
            List<String> newProfile = adminToEdit.viewProfile();
            for (String line : newProfile)
            {
                System.out.println(line);
            }
        }
        else
        {
            ((Admin) currentUser).editProfile(adminToEdit, editChoiceExact, newValue);
            System.out.println(ConsoleColors.GREEN + "Profile Edited Successfully!" + ConsoleColors.RESET);
            System.out.println("New Profile: ");
            List<String> newProfile = adminToEdit.viewProfile();
            for (String line : newProfile)
            {
                System.out.println(line);
            }
        }
    }

    // Edit Instructor Information
    static void editInstructorInfo(User currentUser)
    {
        // Get User ID of user to edit
        System.out.print(ConsoleColors.BLUE + "Enter Instructor User ID: " + ConsoleColors.RESET);
        int instructorID = SIS.getInt();

        // Find the instructor
        Instructor instructorToEdit = null;
        for (Instructor instructor : Main.instructors)
        {
            if (instructor.getAuth().getUserID() == instructorID)
            {
                instructorToEdit = instructor;
                break;
            }
        }

        // Null Check
        if (instructorToEdit == null)
        {
            System.out.println(ConsoleColors.RED + "Instructor not found!" + ConsoleColors.RESET);
            return;
        }

        // Display Profile
        System.out.println(ConsoleColors.BLUE + "Instructor Profile: " + ConsoleColors.RESET);
        List<String> profile = instructorToEdit.viewProfile();
        for (String line : profile)
        {
            System.out.println(line);
        }

        // Select the field to edit
        Menus.editMenuExact();
        int editChoiceExact = SIS.getInt();

        // Check Choice
        while (editChoiceExact < 1 || editChoiceExact > 7)
        {
            System.out.println(ConsoleColors.RED + "Please enter a valid choice!" + ConsoleColors.RESET);
            System.out.print(ConsoleColors.YELLOW + "Enter your choice: " + ConsoleColors.RESET);
            editChoiceExact = SIS.getInt();
        }

        if (editChoiceExact == 7)
        {
            System.out.println("Exiting...");
            return;
        }

        // Get Value Based on Choice
        String newValue = "";
        LocalDate dob = null;
        boolean valid = false;
        while (!valid)
        {
            switch (editChoiceExact)
            {
                case 1:
                    System.out.print(ConsoleColors.BLUE + "Enter new Name: " + ConsoleColors.RESET);
                    newValue = Main.scanner.nextLine();
                    break;
                case 2:
                    System.out.print(ConsoleColors.BLUE + "Enter new Nationality: " + ConsoleColors.RESET);
                    newValue = Main.scanner.nextLine();
                    break;
                case 3:
                    System.out.print(ConsoleColors.BLUE + "Enter new Phone Number: " + ConsoleColors.RESET);
                    newValue = Main.scanner.nextLine();
                    break;
                case 4:
                    System.out.print(ConsoleColors.BLUE + "Enter new Date of Birth: " + ConsoleColors.RESET);
                    dob = SIS.getDateOfBirth();
                    break;
                case 5:
                    System.out.print(ConsoleColors.BLUE + "Enter new Field: " + ConsoleColors.RESET);
                    newValue = Main.scanner.nextLine();
                    break;
                case 6:
                    System.out.print(ConsoleColors.BLUE + "Enter new Additional Field: " + ConsoleColors.RESET);
                    newValue = Main.scanner.nextLine();
                    break;
            }

            // Check if valid
            if (editChoiceExact == 4)
            {
                if (dob != null)
                {
                    valid = true;
                }
            }
            else
            {
                if (!newValue.equals(""))
                {
                    // Check if it has any digits
                    if (newValue.matches(".*\\d.*"))
                    {
                        System.out.println(ConsoleColors.RED + "Invalid Input! Please enter a valid input! Cannot have digits" + ConsoleColors.RESET);
                    }
                    else
                    {
                        valid = true;
                    }
                }
            }

        }

        // Edit the instructor
        int age = SIS.calculateAge(dob);
        if (editChoiceExact == 4)
        {
            ((Admin) currentUser).editProfile(instructorToEdit, dob, age);
            System.out.println(ConsoleColors.GREEN + "Profile Edited Successfully!" + ConsoleColors.RESET);
            System.out.println("New Profile: ");
            List<String> newProfile = instructorToEdit.viewProfile();
            for (String line : newProfile)
            {
                System.out.println(line);
            }
        }
        else
        {
            ((Admin) currentUser).editProfile(instructorToEdit, editChoiceExact, newValue);
            System.out.println(ConsoleColors.GREEN + "Profile Edited Successfully!" + ConsoleColors.RESET);
            System.out.println("New Profile: ");
            List<String> newProfile = instructorToEdit.viewProfile();
            for (String line : newProfile)
            {
                System.out.println(line);
            }
        }
    }

    // Edit Student Information
    static void editStudentInfo(User currentUser)
    {
        // Get User ID of user to edit
        System.out.print(ConsoleColors.BLUE + "Enter Student User ID: " + ConsoleColors.RESET);
        int studentID = SIS.getInt();

        // Find the student
        Student studentToEdit = null;
        for (Student student : Main.students)
        {
            if (student.getAuth().getUserID() == studentID)
            {
                studentToEdit = student;
                break;
            }
        }

        // Null Check
        if (studentToEdit == null)
        {
            System.out.println(ConsoleColors.RED + "Student not found!" + ConsoleColors.RESET);
            return;
        }

        // Display Profile
        System.out.println(ConsoleColors.BLUE + "Student Profile: " + ConsoleColors.RESET);
        List<String> profile = studentToEdit.viewProfile();
        for (String line : profile)
        {
            System.out.println(line);
        }

        // Select the field to edit
        Menus.editMenuExact();
        int editChoiceExact = SIS.getInt();

        // Check Choice
        while (editChoiceExact < 1 || editChoiceExact > 7)
        {
            System.out.println(ConsoleColors.RED + "Please enter a valid choice!" + ConsoleColors.RESET);
            System.out.print(ConsoleColors.YELLOW + "Enter your choice: " + ConsoleColors.RESET);
            editChoiceExact = SIS.getInt();
        }

        // Exit if exiting
        if (editChoiceExact == 7)
        {
            System.out.println("Exiting...");
            return;
        }

        // Get Value Based on Choice
        String newValue = "";
        LocalDate dob = null;
        boolean valid = false;
        while (!valid)
        {
            switch (editChoiceExact)
            {
                case 1:
                    System.out.print(ConsoleColors.BLUE + "Enter new Name: " + ConsoleColors.RESET);
                    newValue = Main.scanner.nextLine();
                    break;
                case 2:
                    System.out.print(ConsoleColors.BLUE + "Enter new Nationality: " + ConsoleColors.RESET);
                    newValue = Main.scanner.nextLine();
                    break;
                case 3:
                    System.out.print(ConsoleColors.BLUE + "Enter new Phone Number: " + ConsoleColors.RESET);
                    newValue = Main.scanner.nextLine();
                    break;
                case 4:
                    System.out.print(ConsoleColors.BLUE + "Enter new Date of Birth: " + ConsoleColors.RESET);
                    dob = SIS.getDateOfBirth();
                    break;
                case 5:
                    System.out.print(ConsoleColors.BLUE + "Enter new Field: " + ConsoleColors.RESET);
                    newValue = Main.scanner.nextLine();
                    break;
                case 6:
                    System.out.print(ConsoleColors.BLUE + "Enter new Additional Field: " + ConsoleColors.RESET);
                    newValue = Main.scanner.nextLine();
                    break;
            }

            // Check if valid
            if (editChoiceExact == 4)
            {
                if (dob != null)
                {
                    valid = true;
                }
            }
            else
            {
                if (!newValue.equals(""))
                {
                    // Check if it has any digits
                    if (newValue.matches(".*\\d.*"))
                    {
                        System.out.println(ConsoleColors.RED + "Invalid Input! Please enter a valid input! Cannot have digits" + ConsoleColors.RESET);
                    }
                    else
                    {
                        valid = true;
                    }
                }
            }

        }
        int age = SIS.calculateAge(dob);
        // Edit the student
        if (editChoiceExact == 4)
        {
            ((Admin) currentUser).editProfile(studentToEdit, dob, age);
            System.out.println(ConsoleColors.GREEN + "Profile Edited Successfully!" + ConsoleColors.RESET);
            System.out.println("New Profile: ");
            List<String> newProfile = studentToEdit.viewProfile();
            for (String line : newProfile)
            {
                System.out.println(line);
            }
        }
        else
        {
            ((Admin) currentUser).editProfile(studentToEdit, editChoiceExact, newValue);
            System.out.println(ConsoleColors.GREEN + "Profile Edited Successfully!" + ConsoleColors.RESET);
            System.out.println("New Profile: ");
            List<String> newProfile = studentToEdit.viewProfile();
            for (String line : newProfile)
            {
                System.out.println(line);
            }
        }
    }

    // Method to login as an admin, instructor, or student
    static User login(int loginChoice, List<Student> students, List<Instructor> instructors, List<Admin> admins)
    {
        User currentUser = null;
        String username;
        String password;
        switch (loginChoice)
        {
            case 1:
                // If admins are empty then return null
                if (admins.isEmpty())
                {
                    System.out.println(ConsoleColors.RED + "No admins registered" + ConsoleColors.RESET);
                    return null;
                }
                // Login as Admin
                System.out.print(ConsoleColors.BLUE + "Enter your username: " + ConsoleColors.RESET);
                username = Main.scanner.nextLine();
                System.out.print(ConsoleColors.BLUE + "Enter your password: " + ConsoleColors.RESET);
                password = SIS.getPassword();
                for (Admin admin : admins)
                {
                    if (admin.getAuth().getUsername().equals(username) && admin.getAuth().getPassword().equals(password))
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
                    System.out.println(ConsoleColors.RED + "No instructors registered" + ConsoleColors.RESET);
                    return null;
                }
                // Login as Instructor
                System.out.print(ConsoleColors.BLUE + "Enter your username: " + ConsoleColors.RESET);
                username = Main.scanner.nextLine();
                System.out.print(ConsoleColors.BLUE + "Enter your password: " + ConsoleColors.RESET);
                password = SIS.getPassword();
                for (Instructor instructor : instructors)
                {
                    if (instructor.getAuth().getUsername().equals(username) && instructor.getAuth().getPassword().equals(password))
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
                    System.out.println(ConsoleColors.RED + "No students registered" + ConsoleColors.RESET);
                    return null;
                }
                // Login as Student
                System.out.print(ConsoleColors.BLUE + "Enter your username: " + ConsoleColors.RESET);
                username = Main.scanner.nextLine();
                System.out.print(ConsoleColors.BLUE + "Enter your password: " + ConsoleColors.RESET);
                password = SIS.getPassword();
                for (Student student : students)
                {
                    if (student.getAuth().getUsername().equals(username) && student.getAuth().getPassword().equals(password))
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
            System.out.println(ConsoleColors.RED + "Invalid username or password" + ConsoleColors.RESET);
            return null;
        }
        else
        {
            return currentUser;
        }
    }

    // Method to get password in a hidden way
    static String getPassword()
    {
        Console console = System.console();
        char[] hiddenPassword = console.readPassword();
        String password = new String(hiddenPassword);
        return password;
    }

    // Method to calculate age based on date of birth
    static int calculateAge(LocalDate dob)
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

    // Method to get information from the user
    static User getInformation(int role)
    {
        // Variables
        String name, nationality, field, additionalField, email, phoneNumber = "", username, password = "";
        int age = 0;
        Gender gender = Gender.valueOf("M");
        LocalDate dob = null;
        boolean notParsed;

        // Validating role
        while (role != 1 && role != 2 && role != 3 && role != 4)
        {
            System.out.println(ConsoleColors.RED + "Invalid choice" + ConsoleColors.RESET);
            System.out.print(ConsoleColors.YELLOW + "Please enter your choice: " + ConsoleColors.RESET);
            role = SIS.getInt();
        }

        // Only allow user creation if at least one admin exists
        if (Main.admins.isEmpty() && role != 1)
        {
            System.out.println(ConsoleColors.RED + "No admins registered! Please register as an admin First!" + ConsoleColors.RESET);
            return null;
        }

        // Exits the method if the user enters 4
        if (role == 4)
        {
            return null;
        }

        System.out.print(ConsoleColors.BLUE + "Enter your name: " + ConsoleColors.RESET);
        name = Main.scanner.nextLine();

        notParsed = false;
        while (!notParsed)
        {
            // nationality cannot be empty
            while (name.isEmpty())
            {
                System.out.println(ConsoleColors.RED + "Name cannot be empty" + ConsoleColors.RESET);
                System.out.print(ConsoleColors.BLUE + "Enter your Name: " + ConsoleColors.RESET);
                name = Main.scanner.nextLine();
            }
            notParsed = true;
            // nationality cannot have any digits
            if(name.matches(".*\\d.*"))
            {
                notParsed = false;
            }

            if (!notParsed)
            {
                System.out.println(ConsoleColors.RED + "Cannot contain Digits!" + ConsoleColors.RESET);
                System.out.print(ConsoleColors.BLUE + "Enter your Name: " + ConsoleColors.RESET);
                name = Main.scanner.nextLine();
            }
        }
        // Get date of birth and validate it
        dob = SIS.getDateOfBirth();
        age = calculateAge(dob);

        // Get Nationality
        System.out.print(ConsoleColors.BLUE + "Enter your nationality: " + ConsoleColors.RESET);
        nationality = Main.scanner.nextLine();

        // nationality cannot be empty or have digits
        notParsed = false;
        while (!notParsed)
        {
            // nationality cannot be empty
            while (nationality.isEmpty())
            {
                System.out.println(ConsoleColors.RED + "Nationality cannot be empty" + ConsoleColors.RESET);
                System.out.print(ConsoleColors.BLUE + "Enter your Nationality: " + ConsoleColors.RESET);
                nationality = Main.scanner.nextLine();
            }
            notParsed = true;
            // nationality cannot have any digits
            if(nationality.matches(".*\\d.*"))
            {
                notParsed = false;
            }

            if (!notParsed)
            {
                System.out.println(ConsoleColors.RED + "Cannot contain Digits!" + ConsoleColors.RESET);
                System.out.print(ConsoleColors.BLUE + "Enter your Nationality: " + ConsoleColors.RESET);
                nationality = Main.scanner.nextLine();
            }
        }

        // Get phone number and make sure its the proper format
        notParsed = false;
        while (!notParsed)
        {
            try
            {
                System.out.print(ConsoleColors.BLUE + "Enter your phone number: " + ConsoleColors.RESET);
                phoneNumber = Main.scanner.nextLine();
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
                System.out.println(ConsoleColors.RED + "Make sure you have the proper phone number" + ConsoleColors.RESET);
            }
        }

        // Get Gender and make sure it is either M or F
        notParsed = false;
        while (!notParsed)
        {
            try
            {
                System.out.print(ConsoleColors.BLUE + "Enter your gender: " + ConsoleColors.RESET);
                gender = Gender.valueOf(("" + Main.scanner.next().charAt(0)));
                notParsed = true;
            }
            catch (Exception e)
            {
                System.out.println(ConsoleColors.RED + "Only M or F are allowed" + ConsoleColors.RESET);
            }
        }
        Main.scanner.nextLine();

        // Get field
        System.out.print(ConsoleColors.BLUE + "Enter your field: " + ConsoleColors.RESET);
        field = Main.scanner.nextLine();

        notParsed = false;
        while (!notParsed)
        {
            // nationality cannot be empty
            while (field.isEmpty())
            {
                System.out.println(ConsoleColors.RED + "Field cannot be empty" + ConsoleColors.RESET);
                System.out.print(ConsoleColors.BLUE + "Enter your Field: " + ConsoleColors.RESET);
                field = Main.scanner.nextLine();
            }
            notParsed = true;
            if(field.matches(".*\\d.*"))
            {
                notParsed = false;
            }

            if (!notParsed)
            {
                System.out.println(ConsoleColors.RED + "Cannot contain Digits!" + ConsoleColors.RESET);
                System.out.print(ConsoleColors.BLUE + "Enter your Field: " + ConsoleColors.RESET);
                field = Main.scanner.nextLine();
            }
        }

        // Field cannot have any digits

        // Get Additional Field
        System.out.print(ConsoleColors.BLUE + "Enter your additional field (If Any): " + ConsoleColors.RESET);
        additionalField = Main.scanner.nextLine();

        // Set Arbitrary Username and email fields
        email = "" + name.split(" ")[0] + User.numberOfUsers + "@university.com";
        username = "" + name.split(" ")[0] + User.numberOfUsers;
        System.out.println(ConsoleColors.GREEN + "Your Username has been set to: " + ConsoleColors.RESET + username);
        System.out.println(ConsoleColors.GREEN + "Your Email has been set to: " + ConsoleColors.RESET + email);

        // Get Password
        System.out.print(ConsoleColors.BLUE + "Enter your password: " + ConsoleColors.RESET);
        password = getPassword();

        // Confirming password
        System.out.print(ConsoleColors.BLUE + "Confirm your password: " + ConsoleColors.RESET);
        String confirmPassword = getPassword();

        // If passwords dont match, ask again
        while (!password.equals(confirmPassword))
        {
            System.out.println(ConsoleColors.RED + "Passwords don't match" + ConsoleColors.RESET);
            System.out.print(ConsoleColors.BLUE + "Enter your password: " + ConsoleColors.RESET);
            password = getPassword();
            System.out.print(ConsoleColors.BLUE + "Confirm your password: " + ConsoleColors.RESET);
            confirmPassword = getPassword();
        }

        // Check role and create appropriate object
        if (role == 1)
        {
            User admin = new Admin(0, username, password, name, nationality, field, additionalField, email, phoneNumber, dob, gender, age);
            System.out.println(ConsoleColors.GREEN + "Registration as Admin Successful!" + ConsoleColors.RESET);
            return admin;
        }
        else if (role == 2)
        {
            User instructor = new Instructor(1, username, password, name, nationality, field, additionalField, email, phoneNumber, dob, gender, age);
            System.out.println(ConsoleColors.GREEN + "Registration As Instructor Successful!" + ConsoleColors.RESET);
            return instructor;
        }
        else
        {
            User student = new Student(2, username, password, name, nationality, field, additionalField, email, phoneNumber, dob, gender, age);
            System.out.println(ConsoleColors.GREEN + "Registration as Student Successful!" + ConsoleColors.RESET);
            return student;
        }

    }

    // Method to get date of birth
    static LocalDate getDateOfBirth()
    {
        boolean notParsed = false;
        LocalDate dob = null;
        while (!notParsed)
        {
            try
            {
                System.out.print(ConsoleColors.BLUE + "Enter date of birth in YYYY-MM-DD format: " + ConsoleColors.RESET);
                // reads the date of birth from the user
                String input = Main.scanner.nextLine();
                dob = LocalDate.parse(input);
                // Check if dob is before now
                if (dob.isAfter(LocalDate.now()))
                {
                    throw new Exception();
                }
                notParsed = true;

            }
            catch (Exception e)
            {
                System.out.println(ConsoleColors.RED + "Make sure you have the proper date format" + ConsoleColors.RESET);
            }
        }
        return dob;
    }

    // Method to get an integer
    static int getInt()
    {
        int choice = 0;
        boolean notParsed = false;
        do
        {
            try
            {
                choice = Integer.parseInt(Main.scanner.nextLine());
                notParsed = false;
            }
            catch (NumberFormatException e)
            {
                System.out.println(ConsoleColors.RED + "Please enter a valid number!" + ConsoleColors.RESET);
                System.out.print(ConsoleColors.YELLOW + "Enter Your Choice: " + ConsoleColors.RESET);
                notParsed = true;
            }
        } while (notParsed);

        return choice;
    }

    // Method to get a double
    static double getDouble()
    {
        double choice = 0;
        boolean notParsed = false;
        do
        {
            try
            {
                choice = Double.parseDouble(Main.scanner.nextLine());
                notParsed = false;
            }
            catch (NumberFormatException e)
            {
                System.out.println(ConsoleColors.RED + "Please enter a valid number!" + ConsoleColors.RESET);
                System.out.print(ConsoleColors.YELLOW + "Enter The correct Percentage: " + ConsoleColors.RESET);
                notParsed = true;
            }
        } while (notParsed);

        return choice;
    }

    public static void changePassword(User currentUser)
    {
        // Set Password
        System.out.print(ConsoleColors.BLUE + "Enter New Password: " + ConsoleColors.RESET);
        String newPassword = SIS.getPassword();
        // Confirm Password
        System.out.print(ConsoleColors.BLUE + "Confirm New Password: " + ConsoleColors.RESET);
        String confirmPassword = SIS.getPassword();
        if (newPassword.equals(confirmPassword))
        {
            currentUser.getAuth().setPassword(newPassword);
            System.out.println(ConsoleColors.GREEN + "Password Changed Successfully!" + ConsoleColors.RESET);
        }
        else
        {
            System.out.println(ConsoleColors.RED + "Passwords do not match!" + ConsoleColors.RESET);
        }
    }
}
