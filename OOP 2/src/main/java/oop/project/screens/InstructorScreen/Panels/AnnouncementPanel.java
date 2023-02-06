package oop.project.screens.InstructorScreen.Panels;

import oop.project.API.DatabaseCon;
import oop.project.components.buttons.CustomButtonInstructor;
import oop.project.components.core.PromptedTextArea;
import oop.project.components.panels.TransparentPanel;
import oop.project.hooks.AddToBox;

import javax.swing.*;

import com.k33ptoo.components.*;

import java.awt.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AnnouncementPanel extends TransparentPanel
{
    JTextArea announcementTextArea;
    JTextArea announcementSubjectLine;

    public AnnouncementPanel(int Width, int Height)
    {
        // Announcement Panel Setup (Will replace Main Panel when Announcement Button is clicked)
        JLabel announcementLabel = new JLabel("Send an Announcement to your Students");
        announcementLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        announcementSubjectLine = new PromptedTextArea("Enter the subject of your announcement here.");
        announcementSubjectLine.setPreferredSize(new Dimension(1000, 100));

        announcementTextArea = new PromptedTextArea("Enter your announcement here.");
        announcementTextArea.setPreferredSize(new Dimension(1000, Height - 300));

        KButton sendAnnouncementButton = new CustomButtonInstructor(" Send ");
        sendAnnouncementButton.setPreferredSize(new Dimension(150, 50));

        JComponent[] announcementComponents = {announcementLabel, announcementSubjectLine, announcementTextArea,
                sendAnnouncementButton}; // Components for the Announcement Menu
        Box announcementBox = AddToBox.addToVerticalBox(announcementComponents, 1);

        this.add(announcementBox);

        sendAnnouncementButton
                .addActionListener(e -> sendAnnouncement(announcementSubjectLine.getText(), announcementTextArea.getText()));
    }

    private void sendAnnouncement(String AnnouncementSubject, String Announcement)
    {
        if (((announcementTextArea.getText()).isEmpty()) || ((announcementSubjectLine.getText()).isEmpty())
                || ((announcementTextArea.getText()).equals("Enter your announcement here."))
                || ((announcementSubjectLine.getText()).equals("Enter the subject of your announcement here.")))
        {
            JOptionPane.showMessageDialog(null, "Please Write a Title and an Announcement!", "Failed!",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        String courseIDQuery = """
                SELECT CourseID
                FROM courses
                WHERE InstructorID = %s;
                    """.formatted(DatabaseCon.currentUser.getUserID());
        ResultSet courseIDResultSet = DatabaseCon.customQuery(courseIDQuery);
        // Change result set into string
        ArrayList<String> courseIDList = new ArrayList<>();
        // Add all the course IDs to the list
        try
        {
            while (courseIDResultSet.next())
            {
                courseIDList.add(courseIDResultSet.getString("CourseID"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        StringBuilder AnnouncementBuilder = new StringBuilder();
        AnnouncementBuilder.append("Announcement from Instructor " + DatabaseCon.currentUser.getFirstName() + " "
                + DatabaseCon.currentUser.getLastName() + " - " + courseIDList.get(0) + "\n\n");
        AnnouncementBuilder.append("Subject: " + AnnouncementSubject + "\n\n");
        AnnouncementBuilder.append(Announcement + "\n\n");
        AnnouncementBuilder.append("Best Regards, \n");
        AnnouncementBuilder
                .append(DatabaseCon.currentUser.getFirstName() + " " + DatabaseCon.currentUser.getLastName() + " ("
                        + DatabaseCon.currentUser.getEmail() + ")");

        // Send Email
        Announcement = AnnouncementBuilder.toString();
        DatabaseCon.sendAnnouncement(Announcement, courseIDList.get(0));
        JOptionPane.showMessageDialog(null, "Announcement Sent!", "Success!", JOptionPane.INFORMATION_MESSAGE);
        announcementTextArea.setText("");
        announcementSubjectLine.setText("");
    }
}
