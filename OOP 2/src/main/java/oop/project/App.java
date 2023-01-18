package oop.project;

import oop.project.screens.LoginScreen.LoginScreen;
import oop.project.screens.AdminScreen.AdminScreen;
import oop.project.screens.InstructorScreen.InstructorScreen;
import oop.project.screens.LoginScreen.LoginScreen;
import oop.project.screens.StudentScreen.StudentScreen;

public final class App
{
    public static String Path = "src/main/resources/images/";
    // public static String Path = "./classes/images/";

    public static void main(String[] args)
    {
        new LoginScreen();
<<<<<<< HEAD
        //new AdminScreen();
        new InstructorScreen();
        new StudentScreen();
        // new LoginScreen();
        // new AdminScreen();
=======
        new AdminScreen();
>>>>>>> 265bad2e34f5cd4c50255702f0424288ca52d854
        new InstructorScreen();
    }
}
