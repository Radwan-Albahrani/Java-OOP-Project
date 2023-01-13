package oop.project.screens.StudentScreen.Panels;

import oop.project.components.BlueButton;
import oop.project.components.*;
import oop.project.hooks.AddToBox;

import java.awt.*;
import javax.swing.*;
import com.k33ptoo.components.*;

public class DropClass extends TransparentPanel
{
    public DropClass(int Width, int Height)
    {
        JLabel dropClassLabel = new JLabel("Drop Class");
        dropClassLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        this.add(dropClassLabel);

        JComboBox dropClassComboBox = new JComboBox();
        dropClassComboBox.setPreferredSize(new Dimension(150, 50));

        KButton dropClassButton = new BlueButton("Drop Class");
        dropClassButton.setPreferredSize(new Dimension(150, 50));

        JComponent[] dropClassComponents = {dropClassLabel, dropClassButton};
        Box dropClassBox = AddToBox.addToVerticalBox(dropClassComponents, 1);

        this.add(dropClassBox);
    }
}
