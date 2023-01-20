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
            " View Instructors ", // done
            " View Students ", // done
            " View Profile ", // done
            " Edit Information ", // done
            " Registration Requests ", // done
            "Logout" // ,
            // "Creat Course"
            // done

    };

    String[] ButtonIconLocations = {
            "AdminScreen/MainMenu.png",
            "AdminScreen/ViewAlerts.png",
            "AdminScreen/ManageUsers.png",
            "AdminScreen/ViewInstructors.png",
            "AdminScreen/ViewStudents.png",
            "AdminScreen/ViewProfile.png",
            "AdminScreen/EditInfo.png",
            "AdminScreen/ViewRegisteration.png",
            "AdminScreen/Logout.png"
    };

    JFrame frame;
    Box user_info;
    Box mainButtonBox;

    public void insertingPanels(Map<String, JPanel> panel)
    {
        this.panels = panel;

        for (int i = 0; i < All_buttons.length; i++)
        {
            myButtons.get(All_buttons[i].trim())
                    .addActionListener(new ButtonHandlerAdmin(frame, this.panels, user_info, mainButtonBox));
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
                myButtons.get("Registration Requests"),
                myButtons.get("View Profile")
        };
        // Add the buttons to the mainButtonBox
        mainButtonBox = AddToBox.addToHorizontalBox(mainButtonComponents, 5);

        // Buttons for the student Box
        JLabel editTitle = new JLabel("Edit User Information");
        editTitle.setFont(new Font("Trebuchet MS", Font.BOLD, 34));
        editTitle.setForeground(Color.BLACK);
        editTitle.setHorizontalAlignment(JLabel.CENTER);
        editTitle.setVerticalAlignment(JLabel.CENTER);
        JComponent[] profileJComponents = {
                editTitle,
                myButtons.get("Main Menu"),
                myButtons.get("Edit Information"),
                myButtons.get("View Instructors"),
                myButtons.get("View Students"),
        };

        // Add the buttons to the studentButtonBox
        user_info = AddToBox.addToHorizontalBox(profileJComponents, 5);

        // Add the main box and the logout button during panel initialization
        this.setLayout(new BorderLayout());
        this.add(mainButtonBox, BorderLayout.NORTH);
        this.add(myButtons.get("Logout"), BorderLayout.SOUTH);
    }

}
