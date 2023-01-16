package oop.project.handlers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;

import oop.project.hooks.FrameConfig;
import oop.project.screens.LoginScreen.LoginScreen;
import oop.project.screens.InstructorScreen.InstructorScreen;

import java.util.*;

public class ButtonHandlerInstructor implements ActionListener
{
    // Variables needed for the handler
    Dictionary<String, JPanel> panels;
    JFrame frame;
    Box studentButtonBox;
    Box mainButtonBox;

    // Constructor
    public ButtonHandlerInstructor(JFrame frame, Dictionary<String, JPanel> panels, Box studentButtonBox,
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
            System.err.println("Main Menu button clicked - Instructor");
            panels.get("button").remove(studentButtonBox);
            panels.get("button").add(mainButtonBox, BorderLayout.NORTH);

            frame.remove(panels.get("announcement"));
            frame.remove(panels.get("viewStudents"));
            frame.remove(panels.get("editGrades"));
            frame.remove(panels.get("alerts"));
            
            FrameConfig.setBackground(frame, "InstructorScreen/background.png");
            ((InstructorScreen) frame).resetFrame(panels.get("button"), panels.get("main"));
        }

        // If the button clicked is Add Announcement, Remove all the panels and add the announcement panel
        else if (buttonClicked.equals("Add Announcement"))
        {
            System.err.println("Add Announcement button clicked - Instructor");
            frame.remove(panels.get("main"));
            frame.remove(panels.get("profile"));
            frame.remove(panels.get("viewStudents"));
            frame.remove(panels.get("editGrades"));
            frame.remove(panels.get("alerts"));
            FrameConfig.setBackground(frame, "InstructorScreen/backgroundBlurred.png");
            ((InstructorScreen) frame).resetFrame(panels.get("button"), panels.get("announcement"));
        }
        // If the button clicked is View Students Or Manage Students, Replace button panel and add the view students panel
        else if (buttonClicked.equals("View Students") || buttonClicked.equals("Manage Students"))
        {
            System.err.println("View Students button clicked - Instructor");
            panels.get("button").remove(mainButtonBox);
            panels.get("button").add(studentButtonBox, BorderLayout.NORTH);

            frame.remove(panels.get("main"));
            frame.remove(panels.get("announcement"));
            frame.remove(panels.get("profile"));
            frame.remove(panels.get("editGrades"));
            frame.remove(panels.get("alerts"));
            FrameConfig.setBackground(frame, "InstructorScreen/backgroundBlurred.png");
            ((InstructorScreen) frame).resetFrame(panels.get("button"), panels.get("viewStudents"));
        }

        // If the button clicked is Edit Grades, Remove all the panels and add the Edit Grades panel
        else if (buttonClicked.equals("Edit Grades"))
        {
            System.err.println("Edit Grades button clicked - Instructor");
            System.err.println();
            frame.remove(panels.get("main"));
            frame.remove(panels.get("announcement"));
            frame.remove(panels.get("viewStudents"));
            frame.remove(panels.get("profile"));
            frame.remove(panels.get("alerts"));
            FrameConfig.setBackground(frame, "InstructorScreen/backgroundBlurred.png");
            ((InstructorScreen) frame).resetFrame(panels.get("button"), panels.get("editGrades"));
        }

        // If the button clicked is View Profile, Remove all the panels and add the View Profile panel
        else if (buttonClicked.equals("View Profile"))
        {
            System.out.println("View Profile button clicked  - Instructor");
            frame.remove(panels.get("main"));
            frame.remove(panels.get("announcement"));
            frame.remove(panels.get("viewStudents"));
            frame.remove(panels.get("editGrades"));
            frame.remove(panels.get("alerts"));
            FrameConfig.setBackground(frame, "InstructorScreen/backgroundBlurred.png");
            ((InstructorScreen) frame).resetFrame(panels.get("button"), panels.get("profile"));
        }

        // If the button clicked is Alert Admin, Remove all the panels and add the Alert Admin panel
        else if (buttonClicked.equals("Alert Admin"))
        {
            System.out.println("Alert Admin button clicked  - Instructor");
            frame.remove(panels.get("main"));
            frame.remove(panels.get("announcement"));
            frame.remove(panels.get("viewStudents"));
            frame.remove(panels.get("editGrades"));
            frame.remove(panels.get("profile"));
            FrameConfig.setBackground(frame, "InstructorScreen/backgroundBlurred.png");
            ((InstructorScreen) frame).resetFrame(panels.get("button"), panels.get("alerts"));
        }

        
        // If the button clicked is Logout, Dispose of this frame and go back to login screen
        // TODO dispose of stored user as well
        else if (buttonClicked.equals("Logout"))
        {
            System.out.println("Logout button clicked - Instructor");
            frame.dispose();
            new LoginScreen();
        }

        frame.revalidate();
        frame.repaint();
    }
}