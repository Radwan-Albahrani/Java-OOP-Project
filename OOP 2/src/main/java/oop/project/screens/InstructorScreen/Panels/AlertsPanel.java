package oop.project.screens.InstructorScreen.Panels;

import oop.project.components.CustomButton;
import oop.project.components.ThemedPanelInstructor;
import oop.project.hooks.AddToBox;

import javax.swing.*;

import com.k33ptoo.components.KButton;

import java.awt.*;

public class AlertsPanel extends ThemedPanelInstructor
{
    public AlertsPanel(int Width, int Height)
    {
        // Profile Panel Setup (Will replace Main Panel when Profile Button is clicked)
        JLabel alertLabel = new JLabel("Send Alert to an Admin");
        alertLabel.setFont(new Font("Arial", Font.BOLD, 30));

        JTextArea alertTextArea = new JTextArea();
        alertTextArea.setPreferredSize(new Dimension(1000, Height - 200));
        alertTextArea.setLineWrap(true);

        KButton sendAlertButton = new CustomButton(" Send ");
        sendAlertButton.setPreferredSize(new Dimension(150, 50));

        JComponent[] alertButtonComponents = {alertLabel, alertTextArea, sendAlertButton}; // Components for the Announcement Menu
        Box alertBox = AddToBox.addToVerticalBox(alertButtonComponents, 1);

        this.add(alertBox);
    }
}
