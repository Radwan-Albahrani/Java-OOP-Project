package oop.project.screens.StudentScreen.Panels;

import oop.project.components.*;
import oop.project.hooks.*;
import java.awt.*;
import javax.swing.*;
import com.k33ptoo.components.*;

public class ViewAnnouncements extends TransparentPanel
{
    public ViewAnnouncements(int Width, int Height)
    {
        JLabel ViewAnnouncementsLabel = new JLabel("View Announcements");
        ViewAnnouncementsLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        KButton ViewAnnouncementsButton = new BlueButton(" View Announcements");
        ViewAnnouncementsButton.setPreferredSize(new Dimension(150, 50));

        JComponent[] ViewAnnouncementsComponents = {ViewAnnouncementsLabel, ViewAnnouncementsButton};
        Box ViewAnnouncementsBox = AddToBox.addToVerticalBox(ViewAnnouncementsComponents, 1);

        this.add(ViewAnnouncementsBox);
    }
}
