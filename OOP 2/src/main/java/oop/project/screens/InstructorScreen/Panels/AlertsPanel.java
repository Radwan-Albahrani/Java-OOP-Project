package oop.project.screens.InstructorScreen.Panels;

import oop.project.API.DatabaseCon;
import oop.project.components.buttons.CustomButtonInstructor;
import oop.project.components.core.PromptedTextArea;
import oop.project.components.panels.TransparentPanel;
import oop.project.hooks.AddToBox;

import java.awt.*;
import javax.swing.*;
import com.k33ptoo.components.*;

public class AlertsPanel extends TransparentPanel
{
    JTextArea alertTextArea;

    public AlertsPanel(int Width, int Height)
    {
        // Profile Panel Setup (Will replace Main Panel when Profile Button is clicked)
        JLabel alertLabel = new JLabel("Send Alert to an Admin");
        alertLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        alertTextArea = new PromptedTextArea("Enter your alert to the admin here.");
        alertTextArea.setPreferredSize(new Dimension(1000, Height - 200));

        KButton sendAlertButton = new CustomButtonInstructor(" Send ");
        sendAlertButton.setPreferredSize(new Dimension(150, 50));

        JComponent[] alertButtonComponents = {alertLabel, alertTextArea, sendAlertButton}; // Components for the Announcement Menu
        Box alertBox = AddToBox.addToVerticalBox(alertButtonComponents, 1);

        this.add(alertBox);

        sendAlertButton.addActionListener(e -> sendAlert(alertTextArea.getText()));
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
        AlertBuilder.append("Alert from Instructor: " + DatabaseCon.currentUser.getFirstName() + " "
                + DatabaseCon.currentUser.getLastName() + " (" + DatabaseCon.currentUser.getUserID() + ")\n\n");
        AlertBuilder.append(Alert + "\n\n");
        AlertBuilder.append("Best Regards, \n");
        AlertBuilder.append(DatabaseCon.currentUser.getFirstName() + " " + DatabaseCon.currentUser.getLastName() + " ("
                + DatabaseCon.currentUser.getUserID() + ")");

        // Send Email
        Alert = AlertBuilder.toString();
        DatabaseCon.sendAlert(Alert);
        JOptionPane.showMessageDialog(null, "Alert Sent!", "Success!", JOptionPane.INFORMATION_MESSAGE);
        alertTextArea.setText("");
    }
}
