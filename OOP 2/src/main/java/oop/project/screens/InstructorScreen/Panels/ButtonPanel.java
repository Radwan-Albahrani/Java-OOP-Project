package oop.project.screens.InstructorScreen.Panels;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import com.k33ptoo.components.*;

import oop.project.handlers.ButtonHandlerInstructor;

import oop.project.components.buttons.CustomButtonInstructor;
import oop.project.components.panels.ThemedPanelInstructor;
import oop.project.hooks.AddToBox;

public class ButtonPanel extends ThemedPanelInstructor
{
    // Dictionaries
    Map<String, KButton> MainButtons = new Hashtable<String, KButton>();
    Map<String, JPanel> panels;

    // Array of button names
    String[] ButtonNames = {
            " Home ",
            " Main Menu ",
            " Add Announcement ",
            " Manage Students ",
            " View Students ",
            " Edit Grades ",
            " View Profile ",
            " Alert Admin ",
            " Logout "
    };

    String[] ButtonIconLocations = {
            "InstructorScreen/MainMenu.png",
            "InstructorScreen/MainMenu.png",
            "InstructorScreen/Announcements.png",
            "InstructorScreen/ManageStudents.png",
            "InstructorScreen/ViewStudents.png",
            "InstructorScreen/EditGrades.png",
            "InstructorScreen/ViewProfile.png",
            "InstructorScreen/AlertAdmin.png",
            "InstructorScreen/Logout.png"
    };

    // Variables
    JFrame frame;
    Box studentButtonBox;
    Box mainButtonBox;

    // Button to set panel and initialize handlers
    public void setPanels(Map<String, JPanel> panels)
    {
        this.panels = panels;
        for (int i = 0; i < MainButtons.size(); i++)
        {
            MainButtons.get(ButtonNames[i].trim())
                    .addActionListener(new ButtonHandlerInstructor(frame, this.panels, studentButtonBox, mainButtonBox));
        }
    }

    // Constructor
    public ButtonPanel(JFrame frame, int Width, int Height)
    {
        // Set the frame and the panel size
        this.frame = frame;
        this.setPreferredSize(new Dimension(440, 0));

        // Add all the buttons to the Map
        for (int i = 0; i < ButtonNames.length; i++)
        {
            MainButtons.put(ButtonNames[i].trim(), new CustomButtonInstructor(ButtonNames[i], ButtonIconLocations[i]));
        }

        // JLabel title

        JLabel mainTitle = new JLabel("Instructor Dashboard");
        mainTitle.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
        mainTitle.setForeground(Color.BLACK);
        mainTitle.setHorizontalAlignment(JLabel.CENTER);
        mainTitle.setVerticalAlignment(JLabel.CENTER);
        // Buttons for the main Box
        JComponent[] mainButtonComponents = {
                mainTitle,
                MainButtons.get("Home"),
                MainButtons.get("Add Announcement"),
                MainButtons.get("Manage Students"),
                MainButtons.get("View Profile"),
                MainButtons.get("Alert Admin")
        };
        // Add the buttons to the mainButtonBox
        mainButtonBox = AddToBox.addToHorizontalBoxWithSpace(mainButtonComponents, 6);

        JLabel studentTitle = new JLabel("Manage Students");
        studentTitle.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
        studentTitle.setForeground(Color.BLACK);
        studentTitle.setHorizontalAlignment(JLabel.CENTER);
        studentTitle.setVerticalAlignment(JLabel.CENTER);
        // Buttons for the student Box
        JComponent[] studentButtonComponents = {
                studentTitle,
                MainButtons.get("Main Menu"),
                MainButtons.get("View Students"),
                MainButtons.get("Edit Grades")
        };

        // Add the buttons to the studentButtonBox
        studentButtonBox = AddToBox.addToHorizontalBoxWithSpace(studentButtonComponents, 4);

        // Add the main box and the logout button during panel initialization
        this.setLayout(new BorderLayout());
        this.add(mainButtonBox, BorderLayout.NORTH);
        this.add(MainButtons.get("Logout"), BorderLayout.SOUTH);
    }
}
