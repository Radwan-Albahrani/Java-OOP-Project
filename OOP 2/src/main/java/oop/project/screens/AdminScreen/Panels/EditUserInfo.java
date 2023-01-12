package oop.project.screens.AdminScreen.Panels;



import oop.project.components.ThemedPanelAdmin;

import javax.swing.*;
import java.awt.*;

public class EditUserInfo extends ThemedPanelAdmin
{
    public EditUserInfo(int Width, int Height)
    {
        JLabel Edit_User_info = new JLabel("Edit Information");
        Edit_User_info.setFont(new Font("Arial", Font.BOLD, 30));
        this.add(Edit_User_info);
    }
}








