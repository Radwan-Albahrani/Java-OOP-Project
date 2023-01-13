package oop.project.screens.StudentScreen.Panels;

import oop.project.components.BlueButton;
import oop.project.components.TransparentPanel;
import oop.project.hooks.AddToBox;

import java.awt.*;
import javax.swing.*;
import com.k33ptoo.components.*;

public class SendAlerts extends TransparentPanel
{
    public SendAlerts(int Width, int Height)
    {
        JLabel viewAlertsLabel = new JLabel("Alerts");
        viewAlertsLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        KButton SendAlertsButton = new BlueButton(" Send Alerts");
        SendAlertsButton.setPreferredSize(new Dimension(150, 50));

        JComponent[] SendAlertsComponents = {viewAlertsLabel, SendAlertsButton};
        Box SendAlertsBox = AddToBox.addToVerticalBox(SendAlertsComponents, 1);

        this.add(SendAlertsBox);
    }
}