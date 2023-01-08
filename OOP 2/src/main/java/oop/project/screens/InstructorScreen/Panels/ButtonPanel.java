package oop.project.screens.InstructorScreen.Panels;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import com.k33ptoo.components.*;

import oop.project.handlers.ButtonHandlerInstructor;
import oop.project.screens.components.*;
import oop.project.screens.hooks.AddToBox;

public class ButtonPanel extends ThemedPanel
{
    // Arrays
    Dictionary<String, KButton> MainButtons = new Hashtable<String, KButton>();
    Dictionary<String, KGradientPanel> panels;
    String[] ButtonNames = {
            " Main Menu ",
            " Add Announcement ",
            " Manage Students ",
            " View Students ",
            " Edit Grades ",
            " View Profile ",
            " Alert Admin ",
            " Logout "
    };

    // Variables
    JFrame frame;
    Box studentButtonBox;
    Box mainButtonBox;

    // Button to set panel and initialize handlers
    public void setPanels(Dictionary<String, KGradientPanel> panels)
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
        this.frame = frame;
        this.setPreferredSize(new Dimension(250, 0));
        for (int i = 0; i < ButtonNames.length; i++)
        {
            MainButtons.put(ButtonNames[i].trim(), new CustomButton(ButtonNames[i]));
        }
        // Box Setup
        JComponent[] mainButtonComponents = {MainButtons.get("Add Announcement"), MainButtons.get("Manage Students"),
                MainButtons.get("View Profile"), MainButtons.get("Alert Admin")}; // Components for the Main Menu
        mainButtonBox = AddToBox.addToHorizontalBox(mainButtonComponents, 4);

        JComponent[] studentButtonComponents = {MainButtons.get("Main Menu"), MainButtons.get("View Students"),
                MainButtons.get("Edit Grades")}; // Components for the Student Menu
        studentButtonBox = AddToBox.addToHorizontalBox(studentButtonComponents, 3); // B

        // mainButtonComponents for the Main Menu
        this.setLayout(new BorderLayout());
        this.add(mainButtonBox, BorderLayout.NORTH);
        this.add(MainButtons.get("Logout"), BorderLayout.SOUTH);
    }

}
