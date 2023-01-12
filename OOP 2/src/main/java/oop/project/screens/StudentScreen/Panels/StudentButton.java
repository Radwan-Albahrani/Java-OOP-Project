package oop.project.screens.StudentScreen.Panels;

import oop.project.handlers.ButtonHandlerStudent;
import oop.project.components.*;
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
            " Main Menu ",
            " Manage Classes ",
            " View Grades ",
            " View Alerts ",
            " Register Class ",
            " Drop Class ",
            "Logout"
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
        this.setPreferredSize(new Dimension(300, 0));

        for (int i = 0; i < ButtonNames.length; i++)
        {
            studentButtons.put(ButtonNames[i].trim(), new CustomButtonStudent(ButtonNames[i]));
        }

        JComponent[] mainButtonComponents = {
                studentButtons.get("View Alerts"),
                studentButtons.get("Manage Classes"),
                studentButtons.get("View Grades")
        };

        mainButtonBox = AddToBox.addToHorizontalBox(mainButtonComponents, 3);

        JComponent[] studentButtonComponents = {
                studentButtons.get("Main Menu"),
                studentButtons.get("Register Class"),
                studentButtons.get("Drop Class"),
        };

        studentButtonBox = AddToBox.addToHorizontalBox(studentButtonComponents, 3);

        this.setLayout(new BorderLayout());
        this.add(mainButtonBox, BorderLayout.NORTH);
        this.add(studentButtons.get("Logout"), BorderLayout.SOUTH);

    }
}
