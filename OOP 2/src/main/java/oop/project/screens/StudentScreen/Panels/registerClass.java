package oop.project.screens.StudentScreen.Panels;

import oop.project.components.BlueButton;
import oop.project.components.TransparentPanel;
import oop.project.hooks.AddToBox;

import java.awt.*;
import javax.swing.*;
import com.k33ptoo.components.*;

public class registerClass extends TransparentPanel
{
    public registerClass(int Width, int Height)
    {
        JLabel registerClassLabel = new JLabel("Register ");
        registerClassLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        KButton registerClassButton = new BlueButton(" Register Class");
        registerClassButton.setPreferredSize(new Dimension(150, 50));

        JComboBox registerClassComboBox = new JComboBox();
        registerClassComboBox.setPreferredSize(new Dimension(150, 50));

        JComponent[] registerClassComponents = {registerClassLabel, registerClassComboBox, registerClassButton};
        Box registerClassBox = AddToBox.addToVerticalBox(registerClassComponents, 1);

        this.add(registerClassBox);
    }
}
