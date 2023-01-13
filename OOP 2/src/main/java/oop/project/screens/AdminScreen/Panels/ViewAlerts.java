package oop.project.screens.AdminScreen.Panels;

import oop.project.hooks.AddToBox;
import oop.project.colors.ThemeColors;
import oop.project.components.*;

import javax.swing.*;

import com.k33ptoo.components.*;

import java.awt.*;

public class ViewAlerts extends TransparentPanel
{
    public ViewAlerts(int Width, int Height)
    {
        JLabel alertsLabel = new JLabel("Inbox Alerts");
        alertsLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        JTextArea alertTextArea = new JTextArea();
        alertTextArea.setPreferredSize(new Dimension(1000, Height - 200));
        alertTextArea.setLineWrap(true);
        alertTextArea.setBackground(ThemeColors.LIGHT_GRAY);
        alertTextArea.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
        alertTextArea.setBorder(BorderFactory.createLineBorder(ThemeColors.LIGHT_GREY, 5));
        alertTextArea.setEditable(false);

        KButton refreshButton = new CustomButton(" Refresh ");
        refreshButton.setPreferredSize(new Dimension(150, 50));

        JComponent[] announcementComponents = {alertsLabel, alertTextArea, refreshButton}; // Components for the Alerts Menu
        Box announcementBox = AddToBox.addToVerticalBox(announcementComponents, 1);

        this.add(announcementBox);

    }
}