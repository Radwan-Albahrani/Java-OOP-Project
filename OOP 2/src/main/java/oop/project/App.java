package oop.project;

import oop.project.screens.LoginScreen.LoginScreen;
import oop.project.screens.AdminScreen.AdminScreen;
import oop.project.screens.InstructorScreen.InstructorScreen;

public final class App
{
        public static String Path = "src/main/resources/images/";
        // public static String Path = "./classes/images/";

        public static void main(String[] args)
        {
                // new LoginScreen();
                // new AdminScreen();
                new InstructorScreen();
        }
}
