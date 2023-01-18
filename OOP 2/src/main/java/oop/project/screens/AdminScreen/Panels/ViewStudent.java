package oop.project.screens.AdminScreen.Panels;

import javax.swing.*;

import oop.project.components.panels.TransparentPanel;

import java.awt.*;

public class ViewStudent extends TransparentPanel
{
    public ViewStudent(int Width, int Height)
    {
        // Student Panel Setup (Will replace Main Panel when Student Button is clicked)
        JLabel viewStudentsLabel = new JLabel("The students");
        viewStudentsLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        this.add(viewStudentsLabel);
    }
}