package oop.project.handlers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;

import com.k33ptoo.components.KGradientPanel;

import oop.project.screens.LoginScreen.LoginScreen;

import java.util.*;

// TODO: use buttonPanel.remove() to remove the current panel and add the new one with an if statement assuming the button is clicked
public class ButtonHandlerInstructor implements ActionListener
{
    // Variables needed for the handler
    Dictionary<String, KGradientPanel> panels;
    JFrame frame;
    Box studentButtonBox;
    Box mainButtonBox;

    // Constructor
    public ButtonHandlerInstructor(JFrame frame, Dictionary<String, KGradientPanel> panels, Box studentButtonBox,
            Box mainButtonBox)
    {
        this.frame = frame;
        this.panels = panels;
        this.studentButtonBox = studentButtonBox;
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
            panels.get("button").remove(studentButtonBox);
            panels.get("button").add(mainButtonBox, BorderLayout.NORTH);

            frame.remove(panels.get("announcement"));
            frame.remove(panels.get("viewStudents"));
            frame.remove(panels.get("editGrades"));
            frame.remove(panels.get("alerts"));
            frame.add(panels.get("main"), BorderLayout.CENTER);
        }

        // If the button clicked is Add Announcement, Remove all the panels and add the announcement panel
        else if (buttonClicked.equals("Add Announcement"))
        {
            frame.remove(panels.get("main"));
            frame.remove(panels.get("profile"));
            frame.remove(panels.get("viewStudents"));
            frame.remove(panels.get("editGrades"));
            frame.remove(panels.get("alerts"));
            frame.add(panels.get("announcement"), BorderLayout.CENTER);
        }
        // If the button clicked is View Students Or Manage Students, Replace button panel and add the view students panel
        else if (buttonClicked.equals("View Students") || buttonClicked.equals("Manage Students"))
        {
            panels.get("button").remove(mainButtonBox);
            panels.get("button").add(studentButtonBox, BorderLayout.NORTH);

            frame.remove(panels.get("main"));
            frame.remove(panels.get("announcement"));
            frame.remove(panels.get("profile"));
            frame.remove(panels.get("editGrades"));
            frame.remove(panels.get("alerts"));
            frame.add(panels.get("viewStudents"), BorderLayout.CENTER);
        }

        // If the button clicked is Edit Grades, Remove all the panels and add the Edit Grades panel
        else if (buttonClicked.equals("Edit Grades"))
        {
            frame.remove(panels.get("main"));
            frame.remove(panels.get("announcement"));
            frame.remove(panels.get("viewStudents"));
            frame.remove(panels.get("profile"));
            frame.remove(panels.get("alerts"));
            frame.add(panels.get("editGrades"), BorderLayout.CENTER);
        }

        // If the button clicked is View Profile, Remove all the panels and add the View Profile panel
        else if (buttonClicked.equals("View Profile"))
        {
            frame.remove(panels.get("main"));
            frame.remove(panels.get("announcement"));
            frame.remove(panels.get("viewStudents"));
            frame.remove(panels.get("editGrades"));
            frame.remove(panels.get("alerts"));
            frame.add(panels.get("profile"), BorderLayout.CENTER);
        }

        // If the button clicked is Alert Admin, Remove all the panels and add the Alert Admin panel
        else if (buttonClicked.equals("Alert Admin"))
        {
            frame.remove(panels.get("main"));
            frame.remove(panels.get("announcement"));
            frame.remove(panels.get("viewStudents"));
            frame.remove(panels.get("editGrades"));
            frame.remove(panels.get("profile"));
            frame.add(panels.get("alerts"), BorderLayout.CENTER);
        }

        // If the button clicked is Logout, Dispose of this frame and go back to login screen
        // TODO dispose of stored user as well
        else if (buttonClicked.equals("Logout"))
        {
            frame.dispose();
            new LoginScreen();
        }

        frame.revalidate();
        frame.repaint();
    }
}