package oop.project.screens.StudentScreen.Panels;

import javax.swing.*;
import java.awt.*;

import oop.project.components.TransparentPanel;

public class StudentMain extends TransparentPanel
{
    public StudentMain(int Width, int Height)
    {
        JLabel welcomeLabel = new JLabel("Welcome, Student");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));

        this.add(welcomeLabel);

    }
}
