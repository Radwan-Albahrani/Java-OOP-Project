package oop.project.screens.InstructorScreen.Panels;

import java.awt.*;

import javax.swing.*;

import com.k33ptoo.components.*;

import oop.project.handlers.ButtonHandlerInstructor;
import oop.project.screens.components.*;
import oop.project.screens.hooks.AddToBox;

public class ButtonPanel extends ThemedPanel
{
    // Arrays
    KButton[] MainButtons;
    KGradientPanel[] panels;
    String[] ButtonNames = {
            " Main Menu ",
            " Add Announcement ",
            " View Students ",
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
    public void setPanels(KGradientPanel[] panels)
    {
        this.panels = panels;
        for (int i = 0; i < MainButtons.length; i++)
        {
            MainButtons[i]
                    .addActionListener(new ButtonHandlerInstructor(frame, this.panels, studentButtonBox, mainButtonBox));
        }
    }

    // Constructor
    public ButtonPanel(JFrame frame, int Width, int Height)
    {
        this.frame = frame;
        this.setPreferredSize(new Dimension(250, 0));
        MainButtons = new KButton[ButtonNames.length];
        for (int i = 0; i < ButtonNames.length; i++)
        {
            MainButtons[i] = new CustomButton(ButtonNames[i]);
        }
        // Box Setup
        JComponent[] mainButtonComponents = {MainButtons[1], MainButtons[2], MainButtons[5], MainButtons[6]}; // Components for the Main Menu
        mainButtonBox = AddToBox.addToHorizontalBox(mainButtonComponents, 4);

        JComponent[] studentButtonComponents = {MainButtons[0], MainButtons[3], MainButtons[4]}; // Components for the Student Menu
        studentButtonBox = AddToBox.addToHorizontalBox(studentButtonComponents, 3); // B

        // mainButtonComponents for the Main Menu
        this.setLayout(new BorderLayout());
        this.add(mainButtonBox, BorderLayout.NORTH);
        this.add(MainButtons[7], BorderLayout.SOUTH);
    }

}
