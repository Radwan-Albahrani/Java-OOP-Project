package oop.project.screens.InstructorScreen.Panels;

import oop.project.colors.ThemeColors;
import oop.project.components.CustomButton;
import oop.project.components.TransparentPanel;
import oop.project.hooks.AddToBox;

import javax.swing.*;

import com.k33ptoo.components.*;

import java.awt.*;

public class AnnouncementPanel extends TransparentPanel
{
    public AnnouncementPanel(int Width, int Height)
    {
        // Announcement Panel Setup (Will replace Main Panel when Announcement Button is clicked)
        JLabel announcementLabel = new JLabel("Send an Announcement to your Students");
        announcementLabel.setFont(new Font("Arial", Font.BOLD, 30));

        JTextArea announcementTextArea = new JTextArea();
        announcementTextArea.setPreferredSize(new Dimension(1000, Height - 200));
        announcementTextArea.setLineWrap(true);
        announcementTextArea.setBackground(ThemeColors.LIGHT_GRAY);
        announcementTextArea.setFont(new Font("Arial", Font.PLAIN, 30));
        announcementTextArea.setBorder(BorderFactory.createLineBorder(ThemeColors.LIGHT_GREY, 5));

        KButton sendAnnouncementButton = new CustomButton(" Send ");
        sendAnnouncementButton.setPreferredSize(new Dimension(150, 50));

        JComponent[] announcementComponents = {announcementLabel, announcementTextArea, sendAnnouncementButton}; // Components for the Announcement Menu
        Box announcementBox = AddToBox.addToVerticalBox(announcementComponents, 1);

        this.add(announcementBox);
    }
}
