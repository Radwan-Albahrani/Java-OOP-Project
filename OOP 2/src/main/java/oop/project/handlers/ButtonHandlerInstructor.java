package oop.project.handlers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import oop.project.API.DatabaseCon;
import oop.project.components.panels.ProfilePanel;
import oop.project.hooks.FrameConfig;
import oop.project.screens.LoginScreen.LoginScreen;
import oop.project.screens.InstructorScreen.InstructorScreen;
import oop.project.screens.InstructorScreen.Panels.EditGradesPanel;
import oop.project.screens.InstructorScreen.Panels.ViewStudentsPanel;

import java.util.*;

public class ButtonHandlerInstructor implements ActionListener
{
    // Variables needed for the handler
    Map<String, JPanel> panels;
    JFrame frame;
    Box studentButtonBox;
    Box mainButtonBox;

    ResultSet rs = DatabaseCon
            .customQuery("SELECT CourseID FROM courses WHERE InstructorID = " + DatabaseCon.currentUser.getUserID() + ";");
    ArrayList<String> rsList = new ArrayList<>();

    // Constructor
    public ButtonHandlerInstructor(JFrame frame, Map<String, JPanel> panels, Box studentButtonBox,
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

        rs = DatabaseCon
                .customQuery(
                        "SELECT CourseID FROM courses WHERE InstructorID = " + DatabaseCon.currentUser.getUserID() + ";");
        try
        {
            while (rs.next())
            {
                rsList.add(rs.getString("CourseID"));
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        // if the button clicked is Main Menu, Replace button panel and add the main panel
        if (buttonClicked.equals("Main Menu") || buttonClicked.equals("Home"))
        {
            System.err.println("Main Menu button clicked - Instructor");
            panels.get("button").remove(studentButtonBox);
            panels.get("button").add(mainButtonBox, BorderLayout.NORTH);

            removePanels();

            FrameConfig.setBackground(frame, "InstructorScreen/background.png");
            ((InstructorScreen) frame).resetFrame(panels.get("button"), panels.get("main"));
        }

        // If the button clicked is Add Announcement, Remove all the panels and add the announcement panel
        else if (buttonClicked.equals("Add Announcement"))
        {
            System.err.println("Add Announcement button clicked - Instructor");

            if (rsList.isEmpty())
            {
                JOptionPane.showMessageDialog(null,
                        "You are not assigned to a course. Please register to one first send an announcement",
                        "Missing Course", JOptionPane.INFORMATION_MESSAGE);
                System.err.println("No courses found, can not view students");
                return;
            }

            removePanels();

            FrameConfig.setBackground(frame, "InstructorScreen/backgroundBlurred.png");
            ((InstructorScreen) frame).resetFrame(panels.get("button"), panels.get("announcement"));
        }
        // If the button clicked is View Students Or Manage Students, Replace button panel and add the view students panel
        else if (buttonClicked.equals("View Students") || buttonClicked.equals("Manage Students"))
        {
            // if instructor doesn't have a course, disable manage students
            System.err.println("View Students button clicked - Instructor");

            if (rsList.isEmpty())
            {
                JOptionPane.showMessageDialog(null,
                        "You are not assigned to a course. Please register to one first to view students", "Missing Course",
                        JOptionPane.INFORMATION_MESSAGE);
                System.err.println("No courses found, can not view students");
                return;
            }

            panels.get("button").remove(mainButtonBox); // Remove the main menu button box
            panels.get("button").add(studentButtonBox, BorderLayout.NORTH); // Add the student button box

            removePanels();

            ((ViewStudentsPanel) panels.get("viewStudents")).refreshTable();
            FrameConfig.setBackground(frame, "InstructorScreen/backgroundBlurred.png");
            ((InstructorScreen) frame).resetFrame(panels.get("button"), panels.get("viewStudents"));
        }

        // If the button clicked is Edit Grades, Remove all the panels and add the Edit Grades panel
        else if (buttonClicked.equals("Edit Grades"))
        {
            ((EditGradesPanel) panels.get("editGrades")).refreshUsers();
            System.err.println("Edit Grades button clicked - Instructor");
            System.err.println();

            removePanels();

            FrameConfig.setBackground(frame, "InstructorScreen/backgroundBlurred.png");
            ((InstructorScreen) frame).resetFrame(panels.get("button"), panels.get("editGrades"));
        }

        // If the button clicked is View Profile, Remove all the panels and add the View Profile panel
        else if (buttonClicked.equals("View Profile"))
        {
            System.out.println("View Profile button clicked  - Instructor");

            removePanels();

            ((ProfilePanel) panels.get("profile")).setProfile(DatabaseCon.currentUser);
            FrameConfig.setBackground(frame, "InstructorScreen/backgroundBlurred.png");
            ((InstructorScreen) frame).resetFrame(panels.get("button"), panels.get("profile"));
        }

        // If the button clicked is Alert Admin, Remove all the panels and add the Alert Admin panel
        else if (buttonClicked.equals("Alert Admin"))
        {
            System.out.println("Alert Admin button clicked  - Instructor");

            removePanels();

            FrameConfig.setBackground(frame, "InstructorScreen/backgroundBlurred.png");
            ((InstructorScreen) frame).resetFrame(panels.get("button"), panels.get("alerts"));
        }

        // If the button clicked is Logout, Dispose of this frame and go back to login screen
        else if (buttonClicked.equals("Logout"))
        {
            System.out.println("Logout button clicked - Instructor");
            DatabaseCon.Logout();
            frame.dispose();
            new LoginScreen();
        }

        frame.revalidate();
        frame.repaint();
    }

    private void removePanels()
    {
        for (JPanel panel : panels.values())
        {
            frame.remove(panel);
        }
    }
}