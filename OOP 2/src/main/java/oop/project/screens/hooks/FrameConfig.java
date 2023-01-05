package oop.project.screens.hooks;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

import javax.swing.*;

import oop.project.App;
import oop.project.screens.colors.ThemeColors;
import oop.project.screens.components.*;

public class FrameConfig
{
    public static void set(JFrame frame, String title)
    {
        // Frame Setup
        frame.setTitle(title);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        frame.setSize(screenWidth, screenHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        Image icon = new ImageIcon(App.Path + "AppIcon.jpg").getImage();
        frame.setIconImage(icon);
        frame.setLayout(null);
    }

    public static void setBackground(JFrame frame, String path)
    {
        // Background Setup
        Image backgroundImage = new ImageIcon(App.Path + path).getImage();
        int width = frame.getWidth();
        int height = frame.getHeight();
        Image scaledBackgroundImage = backgroundImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(scaledBackgroundImage));
        frame.setContentPane(background);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;

        // Custom exit and minimize buttons
        frame.setUndecorated(true);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        JButton exitButton = new ExitButton();
        exitButton.setSize(50, 50);
        exitButton.setLocation(screenWidth - 100, 0);
        exitButton.setBorderPainted(true);
        exitButton.setContentAreaFilled(true);
        exitButton.setFocusPainted(true);
        exitButton.setOpaque(true);

        exitButton.addActionListener((ActionEvent e) ->
        {
            System.exit(0);
        });

        JButton minimizeButton = new MinimizeButton();
        minimizeButton.setSize(50, 50);
        minimizeButton.setLocation(screenWidth - 150, 0);
        minimizeButton.setBorderPainted(true);
        minimizeButton.setContentAreaFilled(true);
        minimizeButton.setFocusPainted(true);
        minimizeButton.setOpaque(true);

        minimizeButton.addActionListener((ActionEvent e) ->
        {
            frame.setState(JFrame.ICONIFIED);
        });

        JPanel navBar = new JPanel();
        navBar.setSize(screenWidth, 50);
        navBar.setLocation(0, 0);
        navBar.setOpaque(true);
        navBar.setLayout(null);
        navBar.setBackground(ThemeColors.MEDIUM_SEA_GREEN);
        navBar.add(exitButton);
        navBar.add(minimizeButton);
        frame.setLayout(new BorderLayout());
        frame.add(navBar, BorderLayout.NORTH);

    }

    public static JLabel getPicture(String path, double scale)
    {
        Image image = new ImageIcon(App.Path + path).getImage();
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        Image scaledImage = image.getScaledInstance((int) (width * scale), (int) (height * scale), Image.SCALE_SMOOTH);
        JLabel picture = new JLabel(new ImageIcon(scaledImage));
        return picture;
    }
}
