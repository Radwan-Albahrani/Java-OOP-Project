package oop.project.screens.AdminScreen.Panels;

import oop.project.hooks.AddToBox;

import oop.project.components.*;

import javax.swing.*;

import com.k33ptoo.components.*;

import java.awt.*;

public class ViewAlerts extends ThemedPanelAdmin
{
    public ViewAlerts(int Width, int Height)
    {
        JLabel alertsLabel = new JLabel("Inbox Alerts");
        alertsLabel.setFont(new Font("Arial", Font.BOLD, 30));

        JTextArea alertTextArea = new JTextArea();
        alertTextArea.setPreferredSize(new Dimension(1000, Height - 200));
        alertTextArea.setLineWrap(true);

        KButton refreshButton = new CustomButton(" Refresh ");
        refreshButton.setPreferredSize(new Dimension(150, 50));

        JComponent[] announcementComponents = {alertsLabel, alertTextArea, refreshButton}; // Components for the Alerts Menu
        Box announcementBox = AddToBox.addToVerticalBox(announcementComponents, 1);

        this.add(announcementBox);

    }
}