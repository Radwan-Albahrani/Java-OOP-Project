package oop.project.handlers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;

import com.k33ptoo.components.KGradientPanel;

import oop.project.screens.LoginScreen.LoginScreen;

import java.util.*;

public class AdminButtonHandler  implements ActionListener
{
    Dictionary<String, KGradientPanel> panels;
    JFrame frame;
    Box user_info;
    Box mainButtonBox;

    // Constructor
    public AdminButtonHandler(JFrame frame, Dictionary<String, KGradientPanel> panels, Box user_info,
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

            frame.remove(panels.get("information"));
            frame.remove(panels.get("Instructors"));
            frame.remove(panels.get("Profile"));
            frame.remove(panels.get("Student"));
            frame.add(panels.get("Main"), BorderLayout.CENTER);
        }

        // If the button clicked is Add Announcement, Remove all the panels and add the announcement panel
        else if (buttonClicked.equals("View Alerts"))
        {
            panels.get("button").remove(mainButtonBox);
            panels.get("button").add(user_info, BorderLayout.NORTH);

            frame.remove(panels.get("Profile"));
            frame.remove(panels.get("Instructors"));
            frame.remove(panels.get("Information"));
            frame.remove(panels.get("Student"));
            frame.remove(panels.get("Main"));
            frame.add(panels.get("Alerts"), BorderLayout.CENTER);
        }
        // If the button clicked is View Students Or Manage Students, Replace button panel and add the view students panel
        else if (buttonClicked.equals("Edit user profile"))
        {
            panels.get("button").remove(mainButtonBox);
            panels.get("button").add(user_info, BorderLayout.NORTH);

            frame.remove(panels.get("Profile"));
            frame.remove(panels.get("Instructors"));
            frame.remove(panels.get("Alerts"));
            frame.remove(panels.get("Student"));
            frame.remove(panels.get("Main"));
            frame.add(panels.get("Information"), BorderLayout.CENTER);
        }

        // If the button clicked is Edit Grades, Remove all the panels and add the Edit Grades panel
        else if (buttonClicked.equals("view instructors"))
        {
            frame.remove(panels.get("Profile"));
            frame.remove(panels.get("Information"));
            frame.remove(panels.get("Alerts"));
            frame.remove(panels.get("Student"));
            frame.remove(panels.get("Main"));
            frame.add(panels.get("Instructors"), BorderLayout.CENTER);
        }

        // If the button clicked is View Profile, Remove all the panels and add the View Profile panel
        else if (buttonClicked.equals("view Student"))
        {
            frame.remove(panels.get("Profile"));
            frame.remove(panels.get("Information"));
            frame.remove(panels.get("Alerts"));
            frame.remove(panels.get("Instructors"));
            frame.remove(panels.get("Main"));
            frame.add(panels.get("Student"), BorderLayout.CENTER);
        }

        // If the button clicked is Alert Admin, Remove all the panels and add the Alert Admin panel
        else if (buttonClicked.equals("view profile"))
        {
            frame.remove(panels.get("Student"));
            frame.remove(panels.get("Information"));
            frame.remove(panels.get("Alerts"));
            frame.remove(panels.get("Instructors"));
            frame.remove(panels.get("Main"));
            frame.add(panels.get("Profile"), BorderLayout.CENTER);
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
