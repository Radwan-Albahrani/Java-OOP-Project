package oop.project.screens.StudentScreen.Panels;

import oop.project.handlers.ButtonHandlerStudent;

import oop.project.components.buttons.CustomButtonStudent;
import oop.project.components.panels.ThemedPanelStudent;
import oop.project.hooks.AddToBox;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import com.k33ptoo.components.*;

public class StudentButton extends ThemedPanelStudent
{
    Dictionary<String, KButton> studentButtons = new Hashtable<String, KButton>();
    Dictionary<String, JPanel> studentPanels;

    String[] ButtonNames = {
            " Send Alerts ",
            "View Profile",
            " View Announcements",
            " Manage Classes ",
            " View Grades ",
            " Main Menu ",
            " Select Course ",
            " Register Class ",
            " Drop Class ",
            "Logout"
    };

    String[] ButtonIcon = 
    {
        "StudentScreen/Alerts.png",
        "StudentScreen/ViewProfile.png",
        "StudentScreen/Announcements.png",
        "StudentScreen/ManageClasses.png",
        "StudentScreen/ViewGrades.png",
        "StudentScreen/MainMenu.png"
    };

    JFrame frame;
    Box studentButtonBox;
    Box mainButtonBox;

    public void setPanels(Dictionary<String, JPanel> studentPanels)
    {
        this.studentPanels = studentPanels;
        for (int i = 0; i < studentButtons.size(); i++)
        {
            studentButtons.get(ButtonNames[i].trim())
                    .addActionListener(new ButtonHandlerStudent(frame, this.studentPanels, studentButtonBox, mainButtonBox));
        }
    }

    public StudentButton(JFrame frame, int Width, int Height)
    {
        this.frame = frame;
        this.setPreferredSize(new Dimension(440, 0));

        for (int i = 0; i < ButtonNames.length; i++)
        {
            studentButtons.put(ButtonNames[i].trim(), new CustomButtonStudent(ButtonNames[i], ButtonIcon[i]));
        }
        JLabel mainTitle = new JLabel("Student Dashboard");
        mainTitle.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
        mainTitle.setForeground(Color.BLACK);
        mainTitle.setHorizontalAlignment(JLabel.CENTER);
        mainTitle.setVerticalAlignment(JLabel.CENTER);
        JComponent[] mainButtonComponents = {
                mainTitle,
                studentButtons.get("Send Alerts"),
                studentButtons.get("View Profile"),
                studentButtons.get("View Announcements"),
                studentButtons.get("Manage Classes"),
                studentButtons.get("View Grades")
        };

        mainButtonBox = AddToBox.addToHorizontalBox(mainButtonComponents, 6);
        JLabel coursesTitle = new JLabel("Manage Courses");
        coursesTitle.setFont(new Font("Trebuchet MS", Font.BOLD, 34));
        coursesTitle.setForeground(Color.BLACK);
        coursesTitle.setHorizontalAlignment(JLabel.CENTER);
        coursesTitle.setVerticalAlignment(JLabel.CENTER);
        JComponent[] studentButtonComponents = {
                coursesTitle,
                studentButtons.get("Main Menu"),
                studentButtons.get("Select Course"),
                studentButtons.get("Register Class"),
                studentButtons.get("Drop Class"),
        };

        studentButtonBox = AddToBox.addToHorizontalBox(studentButtonComponents, 5);

        this.setLayout(new BorderLayout());
        this.add(mainButtonBox, BorderLayout.NORTH);
        this.add(studentButtons.get("Logout"), BorderLayout.SOUTH);

    }
}
