package oop.project.screens.Student.Panels;

import oop.project.screens.components.BlueButton;
import oop.project.screens.components.ThemedPanel;
import oop.project.screens.hooks.AddToBox;

import java.awt.*;
import javax.swing.*;
import com.k33ptoo.components.*;


public class registerClass extends ThemedPanel
{
    public registerClass(int Width, int Height)
    {
        JLabel registerClassLabel = new JLabel("Register Class");
        registerClassLabel.setFont(new Font("Arial", Font.BOLD, 30));

        JTextArea registerClassTextArea = new JTextArea();
        registerClassTextArea.setPreferredSize(new Dimension(1000, 200));
        registerClassTextArea.setLineWrap(true);

        KButton registerClassButton = new BlueButton(" Register ");
        registerClassButton.setPreferredSize(new Dimension(150, 50));

        JComponent[] registerClassComponents = {registerClassLabel, registerClassTextArea, registerClassButton}; // Components for the Announcement Menu
        Box registerClassBox = AddToBox.addToVerticalBox(registerClassComponents, 1);

        this.add(registerClassBox);
    }
}
