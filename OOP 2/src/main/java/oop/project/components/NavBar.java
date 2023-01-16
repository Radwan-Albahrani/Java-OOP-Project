package oop.project.components;

import javax.swing.*;
import javax.swing.border.LineBorder;

import oop.project.colors.ThemeColors;
import com.k33ptoo.utils.ComponentMoverUtil;
import com.k33ptoo.utils.ComponentResizerUtil;

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

        JPanel navBar = new JPanel();
        navBar.setSize(screenWidth, 30);
        navBar.setLocation(0, 0);
        navBar.setOpaque(true);
        navBar.setLayout(null);
        navBar.setBackground(ThemeColors.MEDIUM_SEA_GREEN);
        navBar.add(exitButton);
        navBar.add(minimizeButton);
        frame.setLayout(new BorderLayout());
        frame.add(navBar, BorderLayout.NORTH);
        
        resizeMoveFrame(frame);
        
    }

    private static void resizeMoveFrame(JFrame frame) {
        //Resize and move
        SwingUtilities.invokeLater(() -> {
   
            //Drag around your frame using below
   
            ComponentMoverUtil.moveFrame(frame, false, frame.getComponents());
   
           // Use below if you want to resize your frame
            ComponentResizerUtil cr = new ComponentResizerUtil();
            frame.getRootPane().setBorder(new LineBorder(Color.gray));
            cr.setSnapSize(new Dimension(5, 5));
            cr.setDragInsets(new Insets(5, 5, 5, 5));
          
            //always register frame to resize
            cr.registerComponent(frame); 
   
        });
    } 
   
}
