package oop.project.screens.InstructorScreen.Panels;

import oop.project.screens.components.ThemedPanelInstructor;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends ThemedPanelInstructor
{
    public MainPanel(int Width, int Height)
    {
        // TODO: Change to actual name
        // TODO: if the instructor is not in a course, show a message saying they are not in a course
        JLabel welcomeLabel = new JLabel("Welcome, Instructor");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));

        this.add(welcomeLabel);
    }
}
