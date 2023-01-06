package oop.project.screens.Student.Panels;

import javax.swing.Box;

import com.k33ptoo.components.KButton;

import oop.project.screens.components.*;
import oop.project.screens.hooks.AddToBox;

public class StudentButtonPanel 
{
    KButton[] studentButtons;
    String[] ButtonNames = {" Student Main "," Register Class "," View Alerts "," Drop Class "," View Grades "};

    public StudentButtonPanel()
    {
        studentButtons = new KButton[ButtonNames.length];
        for (int i = 0; i < ButtonNames.length; i++)
        {
            studentButtons[i] = new BlueButton(ButtonNames[i]);
        }
    }

    
}
