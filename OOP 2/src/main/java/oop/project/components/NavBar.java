package oop.project.components;

import javax.swing.*;

import oop.project.colors.ThemeColors;

import java.awt.*;

import java.awt.event.ActionEvent;

public class NavBar extends JPanel
{
    public NavBar(JFrame frame)
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;

        // Custom exit and minimize buttons
        JButton exitButton = new ExitButton();
        exitButton.setSize(25, 25);
        exitButton.setLocation(screenWidth - 25, 0);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        exitButton.setOpaque(false);

        exitButton.addActionListener((ActionEvent e) ->
        {
            System.exit(0);
        });

        JButton minimizeButton = new MinimizeButton();
        minimizeButton.setSize(25, 25);
        minimizeButton.setLocation(screenWidth - 50, 0);
        minimizeButton.setBorderPainted(false);
        minimizeButton.setContentAreaFilled(false);
        minimizeButton.setFocusPainted(false);
        minimizeButton.setOpaque(false);

        minimizeButton.addActionListener((ActionEvent e) ->
        {
            frame.setState(JFrame.ICONIFIED);
        });

        JPanel navBar = new JPanel();
        navBar.setSize(screenWidth, 25);
        navBar.setLocation(0, 0);
        navBar.setOpaque(true);
        navBar.setLayout(null);
        navBar.setBackground(ThemeColors.MEDIUM_SEA_GREEN);
        navBar.add(exitButton);
        navBar.add(minimizeButton);
        frame.setLayout(new BorderLayout());
        frame.add(navBar, BorderLayout.NORTH);
    }

}
