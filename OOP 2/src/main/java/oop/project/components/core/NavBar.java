package oop.project.components.core;

import javax.swing.*;

import oop.project.API.DatabaseCon;
import oop.project.colors.ThemeColors;
import oop.project.hooks.FrameConfig;

import com.k33ptoo.utils.ComponentMoverUtil;

import java.awt.*;

import java.awt.event.ActionEvent;

public class NavBar extends JPanel
{
    public NavBar(JFrame frame, boolean dispose)
    {
        int screenWidth = frame.getWidth();

        // Custom exit and minimize buttons
        JButton exitButton = new ExitButton();
        exitButton.setSize(53, 30);
        exitButton.setLocation(screenWidth - 55, 0);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        exitButton.setOpaque(false);

        if (dispose) // Dispose the frame
        {
            exitButton.addActionListener((ActionEvent e) ->
            {
                frame.dispose();
            });
        }
        else // Exit the program
        {
            exitButton.addActionListener((ActionEvent e) ->
            {
                try
                {
                    DatabaseCon.closeDatabase();
                }
                catch (Exception ex)
                {
                    System.err.println("Error closing database: " + ex.getMessage());
                }
                System.exit(0);
            });
        }

        JButton minimizeButton = new MinimizeButton();
        minimizeButton.setSize(53, 30);
        minimizeButton.setLocation(screenWidth - 108, 0);
        minimizeButton.setBorderPainted(false);
        minimizeButton.setContentAreaFilled(false);
        minimizeButton.setFocusPainted(false);
        minimizeButton.setOpaque(false);

        // LOGO
        Image image = FrameConfig.getPictureWithSize("AppIconRemoved.png", 40, 40);
        JLabel logo = new JLabel(new ImageIcon(image));
        logo.setSize(30, 29);
        logo.setLocation(5, 2);
        logo.setOpaque(false);

        minimizeButton.addActionListener((ActionEvent e) ->
        {
            frame.setState(JFrame.ICONIFIED);
        });

        JPanel navBar = new JPanel();
        navBar.setSize(screenWidth - 6, 30);
        navBar.setLocation(-6, 0);
        navBar.setOpaque(true);
        navBar.setLayout(null);
        navBar.setBackground(ThemeColors.MEDIUM_SEA_GREEN);
        navBar.add(exitButton);
        navBar.add(minimizeButton);
        navBar.add(logo);
        frame.setLayout(new BorderLayout());
        frame.add(navBar, BorderLayout.NORTH);

        resizeMoveFrame(frame, navBar);

    }

    public NavBar(JFrame frame)
    {
        this(frame, false);
    }

    private static void resizeMoveFrame(JFrame frame, JPanel panel)
    {
        // Resize and move
        SwingUtilities.invokeLater(() ->
        {
            // Drag around your frame using below
            ComponentMoverUtil.moveFrame(frame, false, panel);
        });
    }

}
