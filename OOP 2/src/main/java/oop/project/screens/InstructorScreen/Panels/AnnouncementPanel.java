package oop.project.screens.InstructorScreen.Panels;

import oop.project.components.buttons.CustomButtonInstructor;
import oop.project.components.core.PromptedTextArea;
import oop.project.components.panels.TransparentPanel;
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
        announcementLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        JTextArea SubjectLine = new PromptedTextArea("Enter the subject of your announcement here.");
        SubjectLine.setPreferredSize(new Dimension(1000, 100));

        JTextArea announcementTextArea = new PromptedTextArea("Enter your announcement here.");
        announcementTextArea.setPreferredSize(new Dimension(1000, Height - 300));

        KButton sendAnnouncementButton = new CustomButtonInstructor(" Send ");
        sendAnnouncementButton.setPreferredSize(new Dimension(150, 50));

        JComponent[] announcementComponents = {announcementLabel, SubjectLine, announcementTextArea, sendAnnouncementButton}; // Components for the Announcement Menu
        Box announcementBox = AddToBox.addToVerticalBox(announcementComponents, 1);

        this.add(announcementBox);
    }
}
