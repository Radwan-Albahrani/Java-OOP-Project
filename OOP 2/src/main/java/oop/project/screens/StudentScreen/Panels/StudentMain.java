package oop.project.screens.StudentScreen.Panels;

import javax.swing.*;

import oop.project.API.DatabaseCon;
import oop.project.components.panels.TransparentPanel;

import java.awt.*;

public class StudentMain extends TransparentPanel
{
    public StudentMain(int Width, int Height)
    {
        JLabel welcomeLabel = new JLabel(
                "Welcome, " + DatabaseCon.currentUser.getFirstName() + " " + DatabaseCon.currentUser.getLastName());
        welcomeLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        this.add(welcomeLabel);

    }
}
