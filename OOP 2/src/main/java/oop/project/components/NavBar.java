package oop.project.components;

import javax.swing.*;

import oop.project.colors.ThemeColors;
import com.k33ptoo.utils.ComponentMoverUtil;

import java.awt.*;

import java.awt.event.ActionEvent;

public class NavBar extends JPanel
{
    public NavBar(JFrame frame)
    {
        int screenWidth = frame.getWidth();

        // Custom exit and minimize buttons
        JButton exitButton = new ExitButton();
        exitButton.setSize(53, 30);
        exitButton.setLocation(screenWidth - 53, 0);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        exitButton.setOpaque(false);

        exitButton.addActionListener((ActionEvent e) ->
        {
            System.exit(0);
        });

        JButton minimizeButton = new MinimizeButton();
        minimizeButton.setSize(53, 30);
        minimizeButton.setLocation(screenWidth - 106, 0);
        minimizeButton.setBorderPainted(false);
        minimizeButton.setContentAreaFilled(false);
        minimizeButton.setFocusPainted(false);
        minimizeButton.setOpaque(false);

        minimizeButton.addActionListener((ActionEvent e) ->
        {
            frame.setState(JFrame.ICONIFIED);
        });

        this.setSize(screenWidth, 30);
        this.setPreferredSize(new Dimension(screenWidth, 30));
        this.setLocation(0, 0);
        this.setOpaque(true);
        this.setLayout(null);
        this.setBackground(ThemeColors.MEDIUM_SEA_GREEN);
        this.add(exitButton);
        this.add(minimizeButton);
        frame.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.NORTH);

        resizeMoveFrame(frame, this);

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
