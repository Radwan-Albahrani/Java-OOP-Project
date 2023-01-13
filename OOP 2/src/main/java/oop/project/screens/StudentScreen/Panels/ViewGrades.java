package oop.project.screens.StudentScreen.Panels;

import oop.project.components.BlueButton;
import oop.project.components.TransparentPanel;
import oop.project.hooks.AddToBox;

import java.awt.*;
import javax.swing.*;
import com.k33ptoo.components.*;

public class ViewGrades extends TransparentPanel
{
    public ViewGrades(int Width, int Height)
    {
        JLabel ViewGradesLabel = new JLabel("View Grades");
        ViewGradesLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        KButton ViewGradesButton = new BlueButton(" View Grades");
        ViewGradesButton.setPreferredSize(new Dimension(150, 50));

        JComponent[] ViewGradesComponents = {ViewGradesLabel, ViewGradesButton};
        Box ViewGradesBox = AddToBox.addToVerticalBox(ViewGradesComponents, 1);

        this.add(ViewGradesBox);
    }
}
