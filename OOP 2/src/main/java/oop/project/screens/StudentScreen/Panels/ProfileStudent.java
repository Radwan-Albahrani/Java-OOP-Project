package oop.project.screens.StudentScreen.Panels;

import oop.project.components.BlueButton;
import oop.project.components.TransparentPanel;
import oop.project.hooks.AddToBox;

import java.awt.*;
import javax.swing.*;
import com.k33ptoo.components.*;

public class ProfileStudent extends TransparentPanel
{
    public ProfileStudent(int Width, int Height)
    {
        JLabel profileLabel = new JLabel("Profile");
        profileLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        KButton ViewProfileButton = new BlueButton(" View Profile");
        ViewProfileButton.setPreferredSize(new Dimension(150, 50));

        JComponent[] ViewProfileComponents = {profileLabel, ViewProfileButton};
        Box ViewProfileBox = AddToBox.addToVerticalBox(ViewProfileComponents, 1);

        this.add(ViewProfileBox);
    }
}
