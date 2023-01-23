package oop.project.screens.AdminScreen.Panels;

import javax.swing.*;

import oop.project.API.DatabaseCon;
import oop.project.components.panels.TransparentPanel;

import java.awt.*;

public class AdminInterface extends TransparentPanel
{
    public AdminInterface(int Width, int Height)
    {
        String greeting = "";
        if (DatabaseCon.currentUser != null)
        {
            greeting = "Greetings, " + DatabaseCon.currentUser.getFirstName() + " " + DatabaseCon.currentUser.getLastName();
        }
        else
        {
            greeting = "Greetings, Admin";
        }

        JLabel GreetingsLabel = new JLabel(greeting);
        GreetingsLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        this.add(GreetingsLabel);
    }
}
