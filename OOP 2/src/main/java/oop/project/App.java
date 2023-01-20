package oop.project;

// import oop.project.screens.AdminScreen.AdminScreen;
import oop.project.screens.InstructorScreen.InstructorScreen;
<<<<<<< HEAD
import oop.project.screens.LoginScreen.LoginScreen;
import oop.project.screens.StudentScreen.StudentScreen;
=======
// import oop.project.screens.LoginScreen.LoginScreen;
>>>>>>> eeb9a6040a5f60a930c52f1737cdbcc9dc0be707

public final class App
{
        public static String Path = "src/main/resources/images/";
        // public static String Path = "./classes/images/"; // PATH FOR JAR

        public static void main(String[] args)
        {
                // new AdminScreen();
                new InstructorScreen();
                new StudentScreen();
                // new LoginScreen();
                // new AdminScreen();
        }
}
