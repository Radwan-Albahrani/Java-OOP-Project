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
    Dictionary<String, JPanel> panels;
    JFrame frame;
    Box studentButtonBox;
    Box mainButtonBox;

    public ButtonHandlerStudent(JFrame frame, Dictionary<String, JPanel> panels, Box studentButtonBox,
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

            frame.remove(panels.get("registerClass"));
            frame.remove(panels.get("sendAlerts"));
            frame.remove(panels.get("dropClass"));
            frame.remove(panels.get("viewGrades"));
            FrameConfig.setBackground(frame, "StudentScreen/background.png");
            ((StudentScreen) frame).resetFrame(panels.get("button"), panels.get("main"));
        }

        else if (buttonClicked.equals("Register Class") || buttonClicked.equals("Manage Classes"))
        {
            panels.get("button").remove(mainButtonBox);
            panels.get("button").add(studentButtonBox, BorderLayout.NORTH);

            frame.remove(panels.get("main"));
            frame.remove(panels.get("sendAlerts"));
            frame.remove(panels.get("dropClass"));
            frame.remove(panels.get("viewGrades"));
            FrameConfig.setBackground(frame, "StudentScreen/backgroundBlurred.png");
            ((StudentScreen) frame).resetFrame(panels.get("button"), panels.get("registerClass"));
        }

        else if (buttonClicked.equals("Send Alerts"))
        {
            frame.remove(panels.get("main"));
            frame.remove(panels.get("registerClass"));
            frame.remove(panels.get("dropClass"));
            frame.remove(panels.get("viewGrades"));
            FrameConfig.setBackground(frame, "StudentScreen/backgroundBlurred.png");
            ((StudentScreen) frame).resetFrame(panels.get("button"), panels.get("sendAlerts"));
        }

        else if (buttonClicked.equals("Drop Class"))
        {
            frame.remove(panels.get("main"));
            frame.remove(panels.get("registerClass"));
            frame.remove(panels.get("sendAlerts"));
            frame.remove(panels.get("viewGrades"));
            FrameConfig.setBackground(frame, "StudentScreen/backgroundBlurred.png");
            ((StudentScreen) frame).resetFrame(panels.get("button"), panels.get("dropClass"));
        }

        else if (buttonClicked.equals("View Profile"))
        {
            frame.remove(panels.get("main"));
            frame.remove(panels.get("registerClass"));
            frame.remove(panels.get("sendAlerts"));
            frame.remove(panels.get("dropClass"));
            frame.remove(panels.get("viewGrades"));
            ((ProfilePanel) panels.get("profile")).setProfile(DatabaseCon.currentUser);
            FrameConfig.setBackground(frame, "StudentScreen/backgroundBlurred.png");
            ((StudentScreen) frame).resetFrame(panels.get("button"), panels.get("profile"));
        }

        else if (buttonClicked.equals("View Grades"))
        {
            frame.remove(panels.get("main"));
            frame.remove(panels.get("registerClass"));
            frame.remove(panels.get("sendAlerts"));
            frame.remove(panels.get("dropClass"));
            FrameConfig.setBackground(frame, "StudentScreen/backgroundBlurred.png");
            ((StudentScreen) frame).resetFrame(panels.get("button"), panels.get("viewGrades"));
        }

        else if (buttonClicked.equals("View Announcements"))
        {
            frame.remove(panels.get("main"));
            frame.remove(panels.get("registerClass"));
            frame.remove(panels.get("sendAlerts"));
            frame.remove(panels.get("dropClass"));
            frame.remove(panels.get("viewGrades"));
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

}