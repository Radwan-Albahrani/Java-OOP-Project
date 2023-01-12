package oop.project.screens.AdminScreen.panels;



import oop.project.components.ThemedPanelAdmin;

import javax.swing.*;
import java.awt.*;

public class ViewStudent extends ThemedPanelAdmin
{
    public ViewStudent(int Width, int Height)
    {
        // Student Panel Setup (Will replace Main Panel when Student Button is clicked)
        JLabel viewStudentsLabel = new JLabel("The students");
        viewStudentsLabel.setFont(new Font("Arial", Font.BOLD, 30));
        this.add(viewStudentsLabel);
    }
}