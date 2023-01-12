package oop.project.screens.AdminScreen.Panels;

import oop.project.components.TransparentPanel;
import javax.swing.*;
import java.awt.*;

public class AdminInterface extends TransparentPanel
{
    public AdminInterface(int Width, int Height)
    {

        JLabel GreetingsLabel = new JLabel("Greetings, Admin");
        GreetingsLabel.setFont(new Font("Arial", Font.BOLD, 30));

        this.add(GreetingsLabel);
    }
}
