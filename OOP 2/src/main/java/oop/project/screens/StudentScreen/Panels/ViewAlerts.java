package oop.project.screens.StudentScreen.Panels;

import oop.project.components.BlueButton;
import oop.project.components.TransparentPanel;
import oop.project.hooks.AddToBox;

import java.awt.*;
import javax.swing.*;
import com.k33ptoo.components.*;

public class ViewAlerts extends TransparentPanel
{
    public ViewAlerts(int Width, int Height)
    {
        JLabel viewAlertsLabel = new JLabel("Alerts");
        viewAlertsLabel.setFont(new Font("Arial", Font.BOLD, 30));

        KButton viewAlertsButton = new BlueButton(" View Alerts");
        viewAlertsButton.setPreferredSize(new Dimension(150, 50));

        JComponent[] viewAlertsComponents = {viewAlertsLabel, viewAlertsButton};
        Box viewAlertsBox = AddToBox.addToVerticalBox(viewAlertsComponents, 1);

        this.add(viewAlertsBox);
    }
}