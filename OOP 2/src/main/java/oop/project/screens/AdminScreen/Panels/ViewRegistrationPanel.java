package oop.project.screens.AdminScreen.Panels;

import oop.project.components.ThemedPanelAdmin;

import javax.swing.*;
import java.awt.*;

public class ViewRegistrationPanel extends ThemedPanelAdmin
{
    public ViewRegistrationPanel(int Width, int Height)
    {
        // Student Panel Setup (Will replace Main Panel when Student Button is clicked)
        JLabel viewStudentsLabel = new JLabel("The registrations");
        viewStudentsLabel.setFont(new Font("Arial", Font.BOLD, 30));
        this.add(viewStudentsLabel);
    }
}
