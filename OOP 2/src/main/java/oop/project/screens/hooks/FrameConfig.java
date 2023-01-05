package oop.project.screens.hooks;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;

import oop.project.App;

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
