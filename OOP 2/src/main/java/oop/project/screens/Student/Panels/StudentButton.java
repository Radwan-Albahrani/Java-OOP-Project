package oop.project.screens.Student.Panels;


import oop.project.screens.components.BlueButton;
import oop.project.handlers.ButtonHandlerStudent;
import oop.project.screens.components.*;
import oop.project.screens.hooks.AddToBox;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import com.k33ptoo.components.*;


public class StudentButton extends ThemedPanel
{
    Dictionary<String, KButton> studentButtons = new Hashtable<String, KButton>();
    Dictionary<String, KGradientPanel> studentPanels;

    String[] Buttonnames = 
    {"Main", "Register Class", "View Alerts", "Drop Class", "View Grades"};

    JFrame frame;
    Box studentButtonBox;
    Box mainButtonBox;

    public void setPanels(Dictionary<String, KGradientPanel> studentPanels)
    {
        this.studentPanels = studentPanels;
        for (int i = 0; i < studentButtons.size(); i++)
        {
            studentButtons.get(Buttonnames[i].trim()).addActionListener(new ButtonHandlerStudent(frame, this.studentPanels, studentButtonBox, mainButtonBox));
        }
    }

    public StudentButton(JFrame frame, int Width, int Height)
    {
        this.frame = frame;
        this.setPreferredSize(new Dimension(300, 0));

        for (int i = 0; i < Buttonnames.length; i++)
        {
            studentButtons.put(Buttonnames[i].trim(), new BlueButton(Buttonnames[i]));
        }

        JComponent[] mainButtonComponents = 
        {
            studentButtons.get("Register Class"), 
            studentButtons.get("View Alerts"), 
            studentButtons.get("Drop Class"), 
            studentButtons.get("View Grades")
        };

        mainButtonBox = AddToBox.addToVerticalBox(mainButtonComponents, 4);

        JComponent[] studentButtonComponents = 
        {
            studentButtons.get("Main"),
            studentButtons.get("Register Class"),
            studentButtons.get("Drop Class"),
        };

        studentButtonBox = AddToBox.addToVerticalBox(studentButtonComponents, 3);

        this.setLayout(new BorderLayout());
        this.add(mainButtonBox, BorderLayout.CENTER);
        this.add(studentButtons.get("Logout"), BorderLayout.SOUTH);

    }
}
