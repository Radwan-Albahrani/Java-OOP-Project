package oop.project.screens.InstructorScreen.Panels;

import oop.project.components.TransparentPanel;

import javax.swing.*;
import java.awt.*;

public class EditGradesPanel extends TransparentPanel
{
    public EditGradesPanel(int Width, int Height)
    {
        JLabel editGradesLabel = new JLabel("Edit Grades");
        editGradesLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        this.add(editGradesLabel);

        
    }
}
