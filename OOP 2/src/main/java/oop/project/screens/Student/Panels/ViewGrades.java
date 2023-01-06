package oop.project.screens.Student.Panels;

import oop.project.screens.components.BlueButton;
import oop.project.screens.components.ThemedPanel;
import oop.project.screens.hooks.AddToBox;

import java.awt.*;
import javax.swing.*;
import com.k33ptoo.components.*;

public class ViewGrades extends ThemedPanel
{
    public ViewGrades(int Width, int Height)
    {
        JLabel ViewGradesLabel = new JLabel("View Grades");
        ViewGradesLabel.setFont(new Font("Arial", Font.BOLD, 30));
        
        KButton ViewGradesButton = new BlueButton(" View Grades");
        ViewGradesButton.setPreferredSize(new Dimension(150, 50));

        JComponent[] ViewGradesComponents = {ViewGradesLabel,ViewGradesButton};
        Box ViewGradesBox = AddToBox.addToVerticalBox(ViewGradesComponents, 1);

        this.add(ViewGradesBox);
    }
}
