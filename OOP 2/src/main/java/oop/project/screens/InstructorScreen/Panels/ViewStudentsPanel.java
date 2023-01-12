package oop.project.screens.InstructorScreen.Panels;

import oop.project.components.TransparentPanel;

import javax.swing.*;
import java.awt.*;

public class ViewStudentsPanel extends TransparentPanel
{
    public ViewStudentsPanel(int Width, int Height)
    {
        // Student Panel Setup (Will replace Main Panel when Student Button is clicked)
        JLabel viewStudentsLabel = new JLabel("Here are all the students");
        viewStudentsLabel.setFont(new Font("Arial", Font.BOLD, 30));
        this.add(viewStudentsLabel);
    }
}
