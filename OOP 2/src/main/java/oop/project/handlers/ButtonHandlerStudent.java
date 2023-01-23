package oop.project.handlers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;

import oop.project.API.DatabaseCon;
import oop.project.components.panels.ProfilePanel;
import oop.project.hooks.FrameConfig;
import oop.project.screens.LoginScreen.LoginScreen;
import oop.project.screens.StudentScreen.StudentScreen;

import java.util.*;

public class ButtonHandlerStudent implements ActionListener
{
    Map<String, JPanel> panels;
    JFrame frame;
    Box studentButtonBox;
    Box mainButtonBox;

    public ButtonHandlerStudent(JFrame frame, Map<String, JPanel> panels, Box studentButtonBox,
            Box mainButtonBox)
    {
        this.frame = frame;
        this.panels = panels;
        this.studentButtonBox = studentButtonBox;
        this.mainButtonBox = mainButtonBox;
    }

    @Override
    public void actionPerformed(ActionEvent E)
    {
        String buttonClicked = E.getActionCommand().trim();

        if (buttonClicked.equals("Main Menu"))
        {
            panels.get("button").remove(studentButtonBox);
            panels.get("button").add(mainButtonBox, BorderLayout.NORTH);

            removePanels();

            FrameConfig.setBackground(frame, "StudentScreen/background.png");
            ((StudentScreen) frame).resetFrame(panels.get("button"), panels.get("main"));
        }

        else if (buttonClicked.equals("Register Class") || buttonClicked.equals("Manage Classes"))
        {
            panels.get("button").remove(mainButtonBox);
            panels.get("button").add(studentButtonBox, BorderLayout.NORTH);

            removePanels();

            FrameConfig.setBackground(frame, "StudentScreen/backgroundBlurred.png");
            ((StudentScreen) frame).resetFrame(panels.get("button"), panels.get("registerClass"));
        }

        else if (buttonClicked.equals("Send Alerts"))
        {
            removePanels();
            FrameConfig.setBackground(frame, "StudentScreen/backgroundBlurred.png");
            ((StudentScreen) frame).resetFrame(panels.get("button"), panels.get("sendAlerts"));
        }

        else if (buttonClicked.equals("Drop Class"))
        {
            removePanels();
            FrameConfig.setBackground(frame, "StudentScreen/backgroundBlurred.png");
            ((StudentScreen) frame).resetFrame(panels.get("button"), panels.get("dropClass"));
        }

        else if (buttonClicked.equals("View Profile"))
        {
            removePanels();
            ((ProfilePanel) panels.get("profile")).setProfile(DatabaseCon.currentUser);
            FrameConfig.setBackground(frame, "StudentScreen/backgroundBlurred.png");
            ((StudentScreen) frame).resetFrame(panels.get("button"), panels.get("profile"));
        }

        else if (buttonClicked.equals("View Grades"))
        {
            removePanels();
            FrameConfig.setBackground(frame, "StudentScreen/backgroundBlurred.png");
            ((StudentScreen) frame).resetFrame(panels.get("button"), panels.get("viewGrades"));
        }

        else if (buttonClicked.equals("View Announcements"))
        {
            removePanels();
            FrameConfig.setBackground(frame, "StudentScreen/backgroundBlurred.png");
            ((StudentScreen) frame).resetFrame(panels.get("button"), panels.get("viewAnnouncements"));
        }

        else if (buttonClicked.equals("Logout"))
        {
            System.out.println("Logout button clicked - Instructor");
            DatabaseCon.Logout();
            frame.dispose();
            new LoginScreen();
        }

        frame.revalidate();
        frame.repaint();
    }

    private void removePanels()
    {
        for (JPanel panel : panels.values())
        {
            frame.remove(panel);
        }
    }

}
