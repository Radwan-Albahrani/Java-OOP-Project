package oop.project.screens.AdminScreen.Panels;


import oop.project.screens.components.ThemedPanelAdmin;
import javax.swing.*;
import java.awt.*;

public class AdminInterface extends ThemedPanelAdmin
{
    public AdminInterface(int Width, int Height)
    {
        
        JLabel GreetingsLabel = new JLabel("Greetings, Admin");
        GreetingsLabel.setFont(new Font("Arial", Font.BOLD, 30));

        this.add(GreetingsLabel);
    }
}





