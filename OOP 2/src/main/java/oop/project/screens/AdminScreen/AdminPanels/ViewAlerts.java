package oop.project.screens.AdminScreen.Panels;

import oop.project.screens.hooks.AddToBox;

import oop.project.screens.components.ThemedPanelAdmin;

import javax.swing.*;
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
   
           KButton refreshButton = new CustomButton(" Send ");
           refreshButton.setPreferredSize(new Dimension(150, 50));
   
           JComponent[] announcementComponents = {alertsLabel, alertTextArea, refreshButton}; // Components for the Announcement Menu
           Box announcementBox = AddToBox.addToVerticalBox(announcementComponents, 1);
   
           this.add(announcementBox);
        





        




     




        

    }
}