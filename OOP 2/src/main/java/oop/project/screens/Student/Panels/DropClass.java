package oop.project.screens.Student.Panels;

import oop.project.screens.components.BlueButton;
import oop.project.screens.components.ThemedPanel;
import oop.project.screens.hooks.AddToBox;

import java.awt.*;
import javax.swing.*;
import com.k33ptoo.components.*;

public class DropClass extends ThemedPanel
{
    public DropClass(int Width, int Height)
    {
        JLabel dropClassLabel = new JLabel("Drop Class");
        dropClassLabel.setFont(new Font("Arial", Font.BOLD, 30));
        this.add(dropClassLabel);

        JTextArea dropClassTextArea = new JTextArea();
        dropClassTextArea.setPreferredSize(new Dimension(1000, 200));
        dropClassTextArea.setLineWrap(true);

        KButton dropClassButton = new BlueButton("Drop Class");
        dropClassButton.setPreferredSize(new Dimension(150, 50));

        JComponent[] dropClassComponents = {dropClassLabel, dropClassTextArea, dropClassButton};
        Box dropClassBox = AddToBox.addToVerticalBox(dropClassComponents, 1);

        this.add(dropClassBox);
    }
}
