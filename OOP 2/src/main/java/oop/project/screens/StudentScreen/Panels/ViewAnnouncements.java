package oop.project.screens.StudentScreen.Panels;


import oop.project.components.core.PromptedTextArea;
import oop.project.components.panels.TransparentPanel;
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

        JTextArea ViewAnnouncementsTextArea = new PromptedTextArea("Announcements will be displayed here.");
        ViewAnnouncementsTextArea.setPreferredSize(new Dimension(1000, Height - 300));

        JComponent[] ViewAnnouncementsComponents = {ViewAnnouncementsLabel, ViewAnnouncementsTextArea};
        Box ViewAnnouncementsBox = AddToBox.addToVerticalBox(ViewAnnouncementsComponents, 1);

        this.add(ViewAnnouncementsBox);

    }
}