package oop.project.screens.AdminScreen.panels;



import oop.project.components.ThemedPanelAdmin;
import javax.swing.*;
import java.awt.*;

public class ViewProfile extends ThemedPanelAdmin
{
    public ViewProfile(int Width, int Height)
    {
        JLabel profileLabel = new JLabel("My Profile");
        profileLabel.setFont(new Font("Arial", Font.BOLD, 30));
        this.add(profileLabel);
    }
}