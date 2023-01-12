package oop.project.handlers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;

import oop.project.screens.LoginScreen.LoginScreen;

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
            frame.remove(panels.get("viewAlerts"));
            frame.remove(panels.get("dropClass"));
            frame.remove(panels.get("viewGrades"));
            frame.add(panels.get("main"), BorderLayout.CENTER);
        }

        else if (buttonClicked.equals("Register Class") || buttonClicked.equals("Manage Classes"))
        {
            frame.remove(panels.get("main"));
            frame.remove(panels.get("viewAlerts"));
            frame.remove(panels.get("dropClass"));
            frame.remove(panels.get("viewGrades"));
            frame.add(panels.get("registerClass"), BorderLayout.CENTER);
        }

        else if (buttonClicked.equals("View Alerts"))
        {
            frame.remove(panels.get("main"));
            frame.remove(panels.get("registerClass"));
            frame.remove(panels.get("dropClass"));
            frame.remove(panels.get("viewGrades"));
            frame.add(panels.get("viewAlerts"), BorderLayout.CENTER);
        }

        else if (buttonClicked.equals("Drop Class"))
        {
            frame.remove(panels.get("main"));
            frame.remove(panels.get("registerClass"));
            frame.remove(panels.get("viewAlerts"));
            frame.remove(panels.get("viewGrades"));
            frame.add(panels.get("dropClass"), BorderLayout.CENTER);
        }

        else if (buttonClicked.equals("View Grades"))
        {
            frame.remove(panels.get("main"));
            frame.remove(panels.get("registerClass"));
            frame.remove(panels.get("viewAlerts"));
            frame.remove(panels.get("dropClass"));
            frame.add(panels.get("viewGrades"), BorderLayout.CENTER);
        }

        else if (buttonClicked.equals("Logout"))
        {
            frame.dispose();
            new LoginScreen();
        }

        frame.revalidate();
        frame.repaint();
    }

}
