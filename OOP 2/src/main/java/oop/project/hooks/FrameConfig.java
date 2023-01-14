package oop.project.hooks;

import java.awt.Image;

import javax.swing.*;

import oop.project.App;

public class FrameConfig
{
    public static void set(JFrame frame, String title)
    {
        // Frame Setup
        frame.setTitle(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        Image icon = new ImageIcon(App.Path + "AppIcon.jpg").getImage();
        frame.setIconImage(icon);
        frame.setLayout(null);
        frame.setUndecorated(true);
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

    public static Image getPictureWithSize(String path, int width, int height)
    {
        Image image = new ImageIcon(App.Path + path).getImage();
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return scaledImage;
    }
}
