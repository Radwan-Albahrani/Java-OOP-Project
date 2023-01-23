package oop.project;

import oop.project.screens.AdminScreen.AdminScreen;
import oop.project.screens.InstructorScreen.InstructorScreen;
import oop.project.screens.LoginScreen.LoginScreen;
import oop.project.screens.StudentScreen.StudentScreen;

public final class App
{
        public static String Path = "src/main/resources/images/";
        // public static String Path = "./classes/images/"; // PATH FOR JAR

        public static void main(String[] args)
        {
                new LoginScreen();
                // new InstructorScreen();
                // new StudentScreen();
                new AdminScreen();
        }
}
