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
        JLabel registerClassLabel = new JLabel("Register ");
        registerClassLabel.setFont(new Font("Arial", Font.BOLD, 30));

        KButton registerClassButton = new BlueButton(" Register Class");
        registerClassButton.setPreferredSize(new Dimension(150, 50));

        JComboBox registerClassComboBox = new JComboBox();
        registerClassComboBox.setPreferredSize(new Dimension(150, 50));


        JComponent[] registerClassComponents = {registerClassLabel, registerClassComboBox ,registerClassButton};
        Box registerClassBox = AddToBox.addToVerticalBox(registerClassComponents, 1);

        this.add(registerClassBox);
    }
}
