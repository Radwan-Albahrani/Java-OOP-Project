package oop.project.hooks;

import oop.project.colors.ThemeColors;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import javax.swing.*;
import javax.swing.border.*;
import oop.project.App;

public class FrameConfig
{
    public static void set(JFrame frame, String title)
    {

        // Frame Setup
        frame.setTitle(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 900);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        try (InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(App.Path + "AppIcon.jpg"))
        {
            if (in == null)
            {
                System.out.println(App.Path + "AppIcon.jpg");
            }
            BufferedImage image = ImageIO.read(in);
            Image icon = new ImageIcon(image).getImage();
            frame.setIconImage(icon);
            frame.setLayout(null);
            frame.setUndecorated(true);
            frame.getRootPane().setBorder(new LineBorder(ThemeColors.MEDIUM_SEA_GREEN, 6));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void set(JFrame frame, String title, int Width, int Height) // Custom size
    {
        // Frame Setup
        set(frame, title);
        frame.setSize(Width, Height);
    }

    public static void setBackground(JFrame frame, String path)
    {
        // Background Setup
        try (InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(App.Path + path))
        {
            if (in == null)
            {
                System.out.println(App.Path + path);
            }
            BufferedImage image = ImageIO.read(in);
            Image backgroundImage = new ImageIcon(image).getImage();
            int width = frame.getWidth();
            int height = frame.getHeight();
            Image scaledBackgroundImage = backgroundImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            JLabel background = new JLabel(new ImageIcon(scaledBackgroundImage));
            frame.setContentPane(background);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static JLabel getPicture(String path, double scale)
    {
        String fullPath = App.Path + path;
        try (InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(fullPath))
        {
            if (in == null)
            {
                System.out.println(fullPath);
            }
            BufferedImage toolImage = ImageIO.read(in);
            Image image = new ImageIcon(toolImage).getImage();
            int width = image.getWidth(null);
            int height = image.getHeight(null);
            Image scaledImage = image.getScaledInstance((int) (width * scale), (int) (height * scale), Image.SCALE_SMOOTH);
            JLabel picture = new JLabel(new ImageIcon(scaledImage));
            return picture;
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        return null;

    }

    public static ImageIcon getPictureIcon(String path, double scale)
    {
        String fullPath = App.Path + path;
        try (InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(fullPath))
        {
            if (in == null)
            {
                System.out.println(fullPath);
            }
            BufferedImage toolImage = ImageIO.read(in);
            Image image = new ImageIcon(toolImage).getImage();
            int width = image.getWidth(null);
            int height = image.getHeight(null);
            Image scaledImage = image.getScaledInstance((int) (width * scale), (int) (height * scale), Image.SCALE_SMOOTH);
            ImageIcon picture = new ImageIcon(scaledImage);
            return picture;
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        return null;

    }

    public static Image getPictureWithSize(String path, int width, int height)
    {
        try (InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(App.Path + path))
        {
            if (in == null)
            {
                System.out.println(App.Path + path);
            }
            BufferedImage toolImage = ImageIO.read(in);
            Image image = new ImageIcon(toolImage).getImage();
            Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return scaledImage;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
