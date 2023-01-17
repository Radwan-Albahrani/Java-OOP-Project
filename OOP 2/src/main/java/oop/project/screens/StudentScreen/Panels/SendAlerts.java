package oop.project.screens.StudentScreen.Panels;

import oop.project.components.*;
import oop.project.hooks.AddToBox;

import java.awt.*;
import javax.swing.*;
import com.k33ptoo.components.*;

public class SendAlerts extends TransparentPanel
{
    public SendAlerts(int Width, int Height)
    {
        JLabel sendAlertsLabel = new JLabel("Alerts");
        sendAlertsLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        JTextArea sendAlertsTextArea = new PromptedTextArea("Enter your alert to the admin here.");
        sendAlertsTextArea.setPreferredSize(new Dimension(1000, Height - 200));

        KButton SendAlertsButton = new BlueButton(" Send ");
        SendAlertsButton.setPreferredSize(new Dimension(150, 50));

        JComponent[] SendAlertsComponents = {sendAlertsLabel, SendAlertsButton};
        Box SendAlertsBox = AddToBox.addToVerticalBox(SendAlertsComponents, 1);

        this.add(SendAlertsBox);
    }
}