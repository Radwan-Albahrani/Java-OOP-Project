package oop.project.screens.AdminScreen.Panels;

import oop.project.hooks.AddToBox;
import oop.project.colors.ThemeColors;

import oop.project.components.buttons.CustomButton;
import oop.project.components.panels.TransparentPanel;

import javax.swing.*;

import com.k33ptoo.components.*;

import java.awt.*;

public class ViewAlerts extends TransparentPanel
{
    public ViewAlerts(int Width, int Height)
    {
        String sperator = "\n-----------------------------------------------------------------------------------------------------------\n";

        JLabel alertsLabel = new JLabel("Inbox Alerts");
        alertsLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        JTextArea alertTextArea = new JTextArea(24, 50);
        alertTextArea.setLineWrap(true);
        alertTextArea.setBackground(ThemeColors.LIGHT_GRAY);
        alertTextArea.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
        alertTextArea.setBorder(BorderFactory.createLineBorder(ThemeColors.LIGHT_GREY, 5));
        alertTextArea.setEditable(false);

        JScrollPane scrollBar = new JScrollPane(alertTextArea);
        scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollBar.setViewportView(alertTextArea);



        KButton refreshButton = new CustomButton(" Refresh ");
        refreshButton.setPreferredSize(new Dimension(150, 50));

        JComponent[] announcementComponents = {alertsLabel, scrollBar, refreshButton}; // Components for the Alerts Menu
        Box announcementBox = AddToBox.addToVerticalBox(announcementComponents, 1);

        this.add(announcementBox);

        
        String dumbyAlert = "Mr.Dalinar:\n Group 8M6 has required me to make a make up quiz due to some network connection issues that took place in 15/1/2023";
        String dumbyAlert2 = "Ms.jasnah:\n The midterm  grades for CIS321 have been uploaded to the main excell sheet ";
        String dumbyAlert3 = "Ms.Kittrecken:\n Our CIS 211 team would like to propose an extra, bonus quiz to the current groups due to the low average  ";
        
        String dumbyAlert4 = "Ms.Kittrecken:\n Our CIS 211 team would like to propose an extra, bonus quiz to the current groups due to the low average  ";
        String dumbyAlert5= "Mr.Khalidin:\n Our CIS 211 team would like to propose an extra, bonus quiz to the current groups due to the low average  ";
        String dumbyAlert6= "Mr.teft:\n Our CIS 211 team would like to propose an extra, bonus quiz to the current groups due to the low average  ";






        alertTextArea.append(dumbyAlert);
        alertTextArea.append(sperator);
        alertTextArea.append(dumbyAlert2);
        alertTextArea.append(sperator);
        alertTextArea.append(dumbyAlert3);
        alertTextArea.append(sperator);
        alertTextArea.append(dumbyAlert4);
        alertTextArea.append(sperator);
        alertTextArea.append(dumbyAlert5);
        alertTextArea.append(sperator);
        alertTextArea.append(dumbyAlert6);
        alertTextArea.append(dumbyAlert6);
        alertTextArea.append(dumbyAlert6);
        alertTextArea.append(dumbyAlert6);
        alertTextArea.append(dumbyAlert6);
        alertTextArea.append(dumbyAlert6);
        alertTextArea.append(dumbyAlert6);







    }
}