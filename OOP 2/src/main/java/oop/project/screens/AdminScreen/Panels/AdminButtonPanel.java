package oop.project.screens.AdminScreen.Panels;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import com.k33ptoo.components.*;

import oop.project.handlers.ButtonHandlerAdmin;

import oop.project.components.buttons.CustomButtonAdmin;
import oop.project.components.panels.ThemedPanelAdmin;
import oop.project.hooks.AddToBox;

public class AdminButtonPanel extends ThemedPanelAdmin
{

    Map<String, KButton> myButtons = new Hashtable<String, KButton>();
    Map<String, JPanel> panels = new Hashtable<>();

    String[] All_buttons = {
            " Main Menu ", // done
            " View Alerts ", // done
            " Manage Users ", // done
            " Edit User Info ",
            " View Instructors ", // done
            " View Students ", // done
            " View Profile ", // done
            " Edit Information ", // done
            " Registration Requests ", // done
            " Logout ", // done
            " Courses ", // done
            " Create Course(s) ", // done,
            " View Courses ", // done
            "HOME"

    };

    String[] ButtonIconLocations = {
            "AdminScreen/MainMenu.png",
            "AdminScreen/ViewAlerts.png",
            "AdminScreen/ManageUsers.png",
            "AdminScreen/EditInfo.png",
            "AdminScreen/ViewInstructors.png",
            "AdminScreen/ViewStudents.png",
            "AdminScreen/ViewProfile.png",
            "AdminScreen/EditInfo.png",
            "AdminScreen/ViewRegisteration.png",
            "AdminScreen/Logout.png",
            "AdminScreen/Courses.png",
            "AdminScreen/AddCourses.png",
            "AdminScreen/View Courses.png",
            "AdminScreen/MainMenu.png"

    };

    JFrame frame;
    Box user_info;
    Box mainButtonBox;
    Box coursesBox;

    public void insertingPanels(Map<String, JPanel> panel)
    {
        this.panels = panel;

        for (int i = 0; i < All_buttons.length; i++)
        {
            myButtons.get(All_buttons[i].trim())
                    .addActionListener(new ButtonHandlerAdmin(frame, this.panels, user_info,
                            mainButtonBox, coursesBox));
        }

    }

    public AdminButtonPanel(JFrame frame, int Width, int Height)
    {
        // Set the frame and the panel size
        this.frame = frame;
        this.setPreferredSize(new Dimension(440, 0));

        // Add all the buttons to the Map
        for (int i = 0; i < All_buttons.length; i++)
        {
            myButtons.put(All_buttons[i].trim(), new CustomButtonAdmin(All_buttons[i], ButtonIconLocations[i]));
        }

        // Title JLabel
        JLabel mainTitle = new JLabel("Admin Dashboard");
        mainTitle.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
        mainTitle.setForeground(Color.BLACK);
        mainTitle.setHorizontalAlignment(JLabel.CENTER);
        mainTitle.setVerticalAlignment(JLabel.CENTER);

        // Buttons for the main Box
        JComponent[] mainButtonComponents = {
                mainTitle,
                myButtons.get("View Alerts"),
                myButtons.get("Manage Users"),
                myButtons.get("Courses"),
                myButtons.get("View Profile")
        };

        // Add the buttons to the mainButtonBox
        mainButtonBox = AddToBox.addToHorizontalBox(mainButtonComponents, 5);

        // Buttons for editing-users Box
        JLabel editTitle = new JLabel("Edit User Information");
        editTitle.setFont(new Font("Trebuchet MS", Font.BOLD, 34));
        editTitle.setForeground(Color.BLACK);
        editTitle.setHorizontalAlignment(JLabel.CENTER);
        editTitle.setVerticalAlignment(JLabel.CENTER);
        JComponent[] profileJComponents = {
                editTitle,
                myButtons.get("Main Menu"),
                myButtons.get("Registration Requests"),
                myButtons.get("Edit User Info"),
                myButtons.get("View Instructors"),
                myButtons.get("View Students"),
                myButtons.get("Edit Information")
        };

        // Add the buttons to the edit-users-Box
        user_info = AddToBox.addToHorizontalBox(profileJComponents, 6);

        // Buttons for courses Box
        JLabel coursesJLabel = new JLabel("Courses");
        coursesJLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
        coursesJLabel.setForeground(Color.BLACK);
        coursesJLabel.setHorizontalAlignment(JLabel.CENTER);
        coursesJLabel.setVerticalAlignment(JLabel.CENTER);

        JComponent[] coursesComponents = {
                coursesJLabel,
                myButtons.get("HOME"),
                myButtons.get("Create Course(s)"),
                myButtons.get("View Courses")

        };

        coursesBox = AddToBox.addToHorizontalBox(coursesComponents, 4);

        // Add the main box and the logout button during panel initialization
        this.setLayout(new BorderLayout());
        this.add(mainButtonBox, BorderLayout.NORTH);
        this.add(myButtons.get("Logout"), BorderLayout.SOUTH);
    }

}
