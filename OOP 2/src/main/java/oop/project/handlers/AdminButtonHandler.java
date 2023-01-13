package oop.project.handlers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;

import oop.project.hooks.FrameConfig;
import oop.project.screens.AdminScreen.AdminScreen;
import oop.project.screens.LoginScreen.LoginScreen;

import java.util.*;

public class AdminButtonHandler implements ActionListener
{
    Dictionary<String, JPanel> panels;
    JFrame frame;
    Box user_info;
    Box mainButtonBox;

    // Constructor
    public AdminButtonHandler(JFrame frame, Dictionary<String, JPanel> panels, Box user_info,
            Box mainButtonBox)
    {
        this.frame = frame;
        this.panels = panels;
        this.user_info = user_info;
        this.mainButtonBox = mainButtonBox;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // Get the clicked button
        String buttonClicked = e.getActionCommand().trim();

        // if the button clicked is Main Menu, Replace button panel and add the main panel
        if (buttonClicked.equals("Main Menu"))
        {
            panels.get("button").remove(user_info);
            panels.get("button").add(mainButtonBox, BorderLayout.NORTH);

            frame.remove(panels.get("Information"));
            frame.remove(panels.get("Instructors"));
            frame.remove(panels.get("Profile"));
            frame.remove(panels.get("Student"));
            frame.remove(panels.get("Registrations"));
            FrameConfig.setBackground(frame, "AdminScreen/background.png");
            ((AdminScreen) frame).resetFrame(panels.get("button"), panels.get("Main"));
        }

        // If the button clicked is Add Announcement, Remove all the panels and add the announcement panel
        else if (buttonClicked.equals("View Alerts"))
        {

            frame.remove(panels.get("Profile"));
            frame.remove(panels.get("Instructors"));
            frame.remove(panels.get("Information"));
            frame.remove(panels.get("Student"));
            frame.remove(panels.get("Main"));
            frame.remove(panels.get("Registrations"));
            FrameConfig.setBackground(frame, "AdminScreen/backgroundBlurred.png");
            ((AdminScreen) frame).resetFrame(panels.get("button"), panels.get("Alerts"));
        }
        // If the button clicked is View Students Or Manage Students, Replace button panel and add the view students panel
        else if (buttonClicked.equals("Manage Users") || buttonClicked.equals("Edit Information"))
        {
            panels.get("button").remove(mainButtonBox);
            panels.get("button").add(user_info, BorderLayout.NORTH);

            frame.remove(panels.get("Profile"));
            frame.remove(panels.get("Instructors"));
            frame.remove(panels.get("Alerts"));
            frame.remove(panels.get("Student"));
            frame.remove(panels.get("Main"));
            frame.remove(panels.get("Registrations"));
            FrameConfig.setBackground(frame, "AdminScreen/backgroundBlurred.png");
            ((AdminScreen) frame).resetFrame(panels.get("button"), panels.get("Information"));
        }

        // If the button clicked is Edit Grades, Remove all the panels and add the Edit Grades panel
        else if (buttonClicked.equals("View Instructors"))
        {
            frame.remove(panels.get("Profile"));
            frame.remove(panels.get("Information"));
            frame.remove(panels.get("Alerts"));
            frame.remove(panels.get("Student"));
            frame.remove(panels.get("Main"));
            frame.remove(panels.get("Registrations"));
            FrameConfig.setBackground(frame, "AdminScreen/backgroundBlurred.png");
            ((AdminScreen) frame).resetFrame(panels.get("button"), panels.get("Instructors"));
        }

        // If the button clicked is View Profile, Remove all the panels and add the View Profile panel
        else if (buttonClicked.equals("View Students"))
        {
            frame.remove(panels.get("Profile"));
            frame.remove(panels.get("Information"));
            frame.remove(panels.get("Alerts"));
            frame.remove(panels.get("Instructors"));
            frame.remove(panels.get("Main"));
            frame.remove(panels.get("Registrations"));
            FrameConfig.setBackground(frame, "AdminScreen/backgroundBlurred.png");
            ((AdminScreen) frame).resetFrame(panels.get("button"), panels.get("Student"));
        }

        // If the button clicked is Alert Admin, Remove all the panels and add the Alert Admin panel
        else if (buttonClicked.equals("View Profile"))
        {
            frame.remove(panels.get("Student"));
            frame.remove(panels.get("Information"));
            frame.remove(panels.get("Alerts"));
            frame.remove(panels.get("Instructors"));
            frame.remove(panels.get("Main"));
            frame.remove(panels.get("Registrations"));
            FrameConfig.setBackground(frame, "AdminScreen/backgroundBlurred.png");
            ((AdminScreen) frame).resetFrame(panels.get("button"), panels.get("Profile"));
        }

        else if (buttonClicked.equals("View Registration Requests"))
        {
            frame.remove(panels.get("Student"));
            frame.remove(panels.get("Information"));
            frame.remove(panels.get("Alerts"));
            frame.remove(panels.get("Instructors"));
            frame.remove(panels.get("Main"));
            FrameConfig.setBackground(frame, "AdminScreen/backgroundBlurred.png");
            ((AdminScreen) frame).resetFrame(panels.get("button"), panels.get("Registrations"));
        }

        // If the button clicked is Logout, Dispose of this frame and go back to login screen

        else if (buttonClicked.equals("Logout"))
        {
            frame.dispose();
            new LoginScreen();
        }

        frame.revalidate();
        frame.repaint();
    }

}