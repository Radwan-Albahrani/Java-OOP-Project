package oop.project.screens.StudentScreen.Panels;

import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.*;

import com.k33ptoo.components.KButton;

import oop.project.API.DatabaseCon;
import oop.project.colors.ThemeColors;
import oop.project.components.buttons.CustomButtonStudent;
import oop.project.components.panels.TransparentPanel;
import oop.project.hooks.AddToBox;

public class ViewAnnouncements extends TransparentPanel
{
    List<String> announcements;
    JTextArea announcementTextArea;
    JComboBox<String> classComboBox;
    List<String> courses;
    String separator = "\n------------------------------------------------------------------------------------------------------------------\n";
    String ID = Long.toString(DatabaseCon.currentUser.getUserID());

    public ViewAnnouncements(int Width, int Height)
    {
        JLabel ViewAnnouncementsLabel = new JLabel("View Announcements");
        ViewAnnouncementsLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        classComboBox = new JComboBox<>();
        classComboBox.setPreferredSize(new Dimension(300, 50));
        classComboBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));

        courses = DatabaseCon.getCoursesOfStudent(ID);
        for (String course : courses)
        {
            classComboBox.addItem(course);
        }

        announcementTextArea = new JTextArea(22, 50);
        announcementTextArea.setLineWrap(true);
        announcementTextArea.setBackground(ThemeColors.LIGHT_GRAY);
        announcementTextArea.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
        announcementTextArea.setBorder(BorderFactory.createLineBorder(ThemeColors.LIGHT_GREY, 5));
        announcementTextArea.setEditable(false);

        JScrollPane scrollBar = new JScrollPane(announcementTextArea);
        scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollBar.setViewportView(announcementTextArea);

        KButton refreshButton = new CustomButtonStudent(" Refresh ");
        refreshButton.setPreferredSize(new Dimension(150, 50));

        JComponent[] announcementComponents = {ViewAnnouncementsLabel, classComboBox, scrollBar, refreshButton}; // Components for the Alerts Menu
        Box announcementBox = AddToBox.addToVerticalBox(announcementComponents, 1);

        this.add(announcementBox);

        if (classComboBox.getSelectedItem() != null)
        {
            announcements = DatabaseCon.getAnnouncementOfCourse(classComboBox.getSelectedItem().toString());
            for (String announcement : announcements)
            {
                announcementTextArea.append(announcement + separator);
            }
        }
        else
        {
            announcementTextArea.setText("No announcements to show");
            classComboBox.addItem("No courses to show");
        }

        refreshButton.addActionListener(e -> refreshAnnouncements());
        classComboBox.addItemListener(e -> refreshAnnouncements());
    }

    private void refreshAnnouncements()
    {
        if (classComboBox.getSelectedItem() == null)
        {
            return;
        }
        announcements = DatabaseCon.getAnnouncementOfCourse(classComboBox.getSelectedItem().toString());
        announcementTextArea.setText("");
        for (String alert : announcements)
        {
            announcementTextArea.append(alert + separator);
        }
    }

    public void refreshCourseList()
    {
        classComboBox.removeAllItems();
        List<String> courses = DatabaseCon.getCoursesOfStudent(ID);
        for (String course : courses)
        {
            classComboBox.addItem(course);
        }
    }
}
