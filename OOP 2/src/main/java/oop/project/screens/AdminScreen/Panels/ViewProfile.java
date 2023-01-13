package oop.project.screens.AdminScreen.Panels;

import oop.project.components.TransparentPanel;
import javax.swing.*;
import java.awt.*;

public class ViewProfile extends TransparentPanel
{
    public ViewProfile(int Width, int Height)
    {
        JLabel profileLabel = new JLabel("My Profile");
        profileLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        this.add(profileLabel);
    }
}