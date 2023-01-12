package oop.project.screens.InstructorScreen.Panels;

import oop.project.components.ThemedPanelInstructor;

import javax.swing.*;
import java.awt.*;

public class EditGradesPanel extends ThemedPanelInstructor
{
    public EditGradesPanel(int Width, int Height)
    {
        JLabel editGradesLabel = new JLabel("Edit Grades");
        editGradesLabel.setFont(new Font("Arial", Font.BOLD, 30));
        this.add(editGradesLabel);
    }
}
