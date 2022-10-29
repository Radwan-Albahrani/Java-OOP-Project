public class Menus
{

    // ===================================== Menus =====================================
    static void MainMenu()
    {
        System.out.println(ConsoleColors.BLUE + "Welcome to the University of Java" + ConsoleColors.RESET);
        System.out.println(
                ConsoleColors.PURPLE + "===========================================================================================" + ConsoleColors.RESET);
        System.out.println("Please choose one of the following options:");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.println(
                ConsoleColors.PURPLE + "===========================================================================================" + ConsoleColors.RESET);
    }

    static void LoginMenu()
    {
        System.out.println(
                ConsoleColors.PURPLE + "===========================================================================================" + ConsoleColors.RESET);
        System.out.println("Please choose one of the following options:");
        System.out.println("1. Admin");
        System.out.println("2. Instructor");
        System.out.println("3. Student");
        System.out.println("4. Exit");
        System.out.println(
                ConsoleColors.PURPLE + "===========================================================================================" + ConsoleColors.RESET);
    }

    static void adminMenu()
    {
        System.out.println(ConsoleColors.BLUE_BRIGHT + "Welcome to the Admin Management system." + ConsoleColors.RESET);
        System.out.println(
                ConsoleColors.PURPLE + "===========================================================================================" + ConsoleColors.RESET);
        System.out.println("1. View Alerts");
        System.out.println("2. Create Course");
        System.out.println("3. Edit Course");
        System.out.println("4. Delete Course");
        System.out.println("5. Edit User Information.");
        System.out.println("6. View Profile");
        System.out.println("7. Change Password");
        System.out.println("8. Logout");

        System.out.println(
                ConsoleColors.PURPLE + "===========================================================================================" + ConsoleColors.RESET);
        System.out.print(ConsoleColors.YELLOW + "\n\nEnter your choice: " + ConsoleColors.RESET);
    }

    static void instructorMenu()
    {
        System.out.println(ConsoleColors.YELLOW_BOLD + "Welcome to the Instructor Management system." + ConsoleColors.RESET);
        System.out.println(
                ConsoleColors.PURPLE + "===========================================================================================" + ConsoleColors.RESET);
        System.out.println("1. Send Announcement");
        System.out.println("2. Select Course");
        System.out.println("3. View Student Grades");
        System.out.println("4. Set Student Grades");
        System.out.println("5. Request Change");
        System.out.println("6. View Profile");
        System.out.println("7. Change Password");
        System.out.println("8. Logout");

        System.out.println(
                ConsoleColors.PURPLE + "===========================================================================================" + ConsoleColors.RESET);
        System.out.print(ConsoleColors.YELLOW + "\n\nEnter your choice: " + ConsoleColors.RESET);
    }

    static void studentMenu()
    {
        System.out.println(ConsoleColors.BLUE + "Welcome to the Student Management system." + ConsoleColors.RESET);
        System.out.println(
                ConsoleColors.PURPLE + "===========================================================================================" + ConsoleColors.RESET);
        System.out.println("Select one of the following: ");
        System.out.println("1. Register Course");
        System.out.println("2. View Courses");
        System.out.println("3. Drop Course");
        System.out.println("4. View Announcements");
        System.out.println("5. Request Change");
        System.out.println("6. View Profile");
        System.out.println("7. Change Password");
        System.out.println("8. Logout");

        System.out.println(
                ConsoleColors.PURPLE + "===========================================================================================" + ConsoleColors.RESET);
        System.out.print(ConsoleColors.YELLOW + "\n\nPlease enter your choice: " + ConsoleColors.RESET);
    }

    static void editMenuExact()
    {
        System.out.println(
                ConsoleColors.PURPLE + "===========================================================================================" + ConsoleColors.RESET);
        System.out.println("Select the field to edit: ");
        System.out.println("1. Name");
        System.out.println("2. Nationality");
        System.out.println("3. Phone Number");
        System.out.println("4. Birthday");
        System.out.println("5. Field");
        System.out.println("6. Additional Field");
        System.out.println("7. Exit");

        System.out.println(
                ConsoleColors.PURPLE + "===========================================================================================" + ConsoleColors.RESET);
        System.out.print(ConsoleColors.YELLOW + "Enter your choice: " + ConsoleColors.RESET);
    }

    static void editMenu()
    {
        System.out.println(
                ConsoleColors.PURPLE + "===========================================================================================" + ConsoleColors.RESET);
        System.out.println("Select From the following: ");
        System.out.println("1. Edit Student Information");
        System.out.println("2. Edit Instructor Information");
        System.out.println("3. Edit My Information");

        System.out.println(
                ConsoleColors.PURPLE + "===========================================================================================" + ConsoleColors.RESET);
        System.out.print(ConsoleColors.YELLOW + "\n\nEnter your choice: ");
    }

}
