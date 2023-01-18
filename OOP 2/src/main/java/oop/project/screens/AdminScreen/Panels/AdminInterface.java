package oop.project.screens.AdminScreen.Panels;

import javax.swing.*;

import oop.project.components.panels.TransparentPanel;

import java.awt.*;

public class AdminInterface extends TransparentPanel
{
    public AdminInterface(int Width, int Height)
    {

        JLabel GreetingsLabel = new JLabel("Greetings, Admin");
        GreetingsLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        this.add(GreetingsLabel);
    }
}
