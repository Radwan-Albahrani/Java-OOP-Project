package oop.project.screens.AdminScreen.Panels;

import oop.project.components.TransparentPanel;

import javax.swing.*;
import java.awt.*;

public class EditUserInfo extends TransparentPanel
{
    public EditUserInfo(int Width, int Height)
    {
        JLabel Edit_User_info = new JLabel("Edit Information");
        Edit_User_info.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        this.add(Edit_User_info);
    }
}
