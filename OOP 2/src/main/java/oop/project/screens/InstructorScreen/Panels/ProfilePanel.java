package oop.project.screens.InstructorScreen.Panels;

import oop.project.components.TransparentPanel;

import javax.swing.*;
import java.awt.*;

public class ProfilePanel extends TransparentPanel
{
    public ProfilePanel(int Width, int Height)
    {
        JLabel profileLabel = new JLabel("Profile");
        profileLabel.setFont(new Font("Arial", Font.BOLD, 30));
        this.add(profileLabel);
    }
}
