package oop.project.screens.AdminScreen.Panels;

import javax.swing.*;

import oop.project.API.DatabaseCon;
import oop.project.components.panels.TransparentPanel;
import oop.project.models.UserModel;

import java.awt.*;

public class AdminInterface extends TransparentPanel
{
    String name = DatabaseCon.currentUser.getFirstName() + " " + DatabaseCon.currentUser.getLastName();
    JLabel GreetingsLabel;

    public AdminInterface(int Width, int Height)
    {
        String greeting = "";
        if (DatabaseCon.currentUser != null)
        {
            greeting = "Greetings, " + name;
        }
        else
        {
            greeting = "Greetings, Admin";
        }

        GreetingsLabel = new JLabel(greeting);
        GreetingsLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        this.add(GreetingsLabel);
    }

    public void refreshName()
    {
        UserModel user = DatabaseCon.getOneUser(Long.toString(DatabaseCon.currentUser.getUserID()));
        name = user.getFirstName() + " " + user.getLastName();
        DatabaseCon.currentUser = user;
        GreetingsLabel.setText("Greetings, " + name);
        this.revalidate();
        this.repaint();

    }
}
