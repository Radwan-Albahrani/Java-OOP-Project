package oop.project.screens.StudentScreen.Panels;

import oop.project.components.*;
import oop.project.hooks.AddToBox;

import java.awt.*;
import javax.swing.*;
import com.k33ptoo.components.*;

public class ViewAnnouncement 
{
    public ViewAnnouncement(int Width, int Height)
    {
        JLabel viewAnnouncementLabel = new JLabel("Announcements");
        viewAnnouncementLabel.setFont(new Font("Arial", Font.BOLD, 30));

        KButton viewAnnouncementButton = new BlueButton(" View Announcements");
        viewAnnouncementButton.setPreferredSize(new Dimension(150, 50));

        JComponent[] viewAnnouncementComponents = {viewAnnouncementLabel, viewAnnouncementButton};
        Box viewAnnouncementBox = AddToBox.addToVerticalBox(viewAnnouncementComponents, 1);

        this.add(viewAnnouncementBox);
    }
}
