package oop.project.screens.Student.Panels;

import oop.project.screens.components.BlueButton;
import oop.project.screens.components.ThemedPanel;
import oop.project.screens.hooks.AddToBox;

import java.awt.*;
import javax.swing.*;
import com.k33ptoo.components.*;

public class ViewAlerts extends ThemedPanel
{
    public ViewAlerts(int Width, int Height)
    {
        JLabel viewAlertsLabel = new JLabel("Alerts");
        viewAlertsLabel.setFont(new Font("Arial", Font.BOLD, 30));

        JTextArea viewAlertsTextArea = new JTextArea();
        viewAlertsTextArea.setPreferredSize(new Dimension(1000, 200));
        viewAlertsTextArea.setLineWrap(true);

        KButton viewAlertsButton = new BlueButton(" View Alerts");
        viewAlertsButton.setPreferredSize(new Dimension(150, 50));

        JComponent[] viewAlertsComponents = {viewAlertsLabel, viewAlertsTextArea, viewAlertsButton};
        Box viewAlertsBox = AddToBox.addToVerticalBox(viewAlertsComponents, 1);

        this.add(viewAlertsBox);
    }
}