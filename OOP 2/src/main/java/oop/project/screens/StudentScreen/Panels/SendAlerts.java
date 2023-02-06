package oop.project.screens.StudentScreen.Panels;

import oop.project.API.DatabaseCon;
import oop.project.components.buttons.CustomButtonStudent;
import oop.project.components.core.PromptedTextArea;
import oop.project.components.panels.TransparentPanel;
import oop.project.hooks.AddToBox;

import java.awt.*;
import javax.swing.*;
import com.k33ptoo.components.*;

public class SendAlerts extends TransparentPanel
{
    JTextArea sendAlertsTextArea;

    public SendAlerts(int Width, int Height)
    {
        JLabel sendAlertsLabel = new JLabel("Alerts");
        sendAlertsLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        sendAlertsTextArea = new PromptedTextArea("Enter your alert text to the admin here.");
        sendAlertsTextArea.setPreferredSize(new Dimension(1000, Height - 200));

        KButton SendAlertsButton = new CustomButtonStudent(" Send ");
        SendAlertsButton.setPreferredSize(new Dimension(150, 50));

        JComponent[] SendAlertsComponents = {sendAlertsLabel, sendAlertsTextArea, SendAlertsButton};
        Box SendAlertsBox = AddToBox.addToVerticalBox(SendAlertsComponents, 1);

        this.add(SendAlertsBox);

        SendAlertsButton.addActionListener(e -> sendAlert(sendAlertsTextArea.getText()));
    }

    private void sendAlert(String Alert)
    {
        if (Alert.equals("") || Alert.equals("Enter your alert to the admin here."))
        {
            JOptionPane.showMessageDialog(null, "Please enter an alert!", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Format Alert to be Email like
        // Send Alert to Admin
        StringBuilder AlertBuilder = new StringBuilder();
        AlertBuilder.append("Alert from Student: " + DatabaseCon.currentUser.getFirstName() + " "
                + DatabaseCon.currentUser.getLastName() + " (" + DatabaseCon.currentUser.getUserID() + ")\n\n");
        AlertBuilder.append(Alert + "\n\n");
        AlertBuilder.append("Best Regards, \n");
        AlertBuilder.append(DatabaseCon.currentUser.getFirstName() + " " + DatabaseCon.currentUser.getLastName() + " ("
                + DatabaseCon.currentUser.getUserID() + ")");

        // Send Email
        Alert = AlertBuilder.toString();
        DatabaseCon.sendAlert(Alert);
        JOptionPane.showMessageDialog(null, "Alert Sent!", "Success!", JOptionPane.INFORMATION_MESSAGE);
        sendAlertsTextArea.setText("");
    }
}