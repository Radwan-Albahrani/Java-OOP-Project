package oop.project.handlers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;

import com.k33ptoo.components.KGradientPanel;

import oop.project.screens.LoginScreen.LoginScreen;

import java.util.*;

// TODO: use buttonPanel.remove() to remove the current panel and add the new one with an if statement assuming the button is clicked
public class ButtonHandlerInstructor implements ActionListener
{
    JFrame frame;
    Dictionary<String, KGradientPanel> panels;
    Box studentButtonBox;
    Box mainButtonBox;

    public ButtonHandlerInstructor(JFrame frame, Dictionary<String, KGradientPanel> panels, Box studentButtonBox,
            Box mainButtonBox)
    {
        this.frame = frame;
        this.panels = panels;
        this.studentButtonBox = studentButtonBox;
        this.mainButtonBox = mainButtonBox;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String buttonClicked = e.getActionCommand();
        if (buttonClicked.equals(" Main Menu "))
        {
            frame.remove(panels.get("announcement"));
            frame.remove(panels.get("viewStudents"));
            frame.remove(panels.get("editGrades"));
            frame.remove(panels.get("alerts"));
            frame.add(panels.get("main"), BorderLayout.CENTER);
            panels.get("button").remove(studentButtonBox);
            panels.get("button").add(mainButtonBox, BorderLayout.NORTH);
        }

        else if (buttonClicked.equals(" Add Announcement "))
        {
            frame.remove(panels.get("main"));
            frame.remove(panels.get("profile"));
            frame.remove(panels.get("viewStudents"));
            frame.remove(panels.get("editGrades"));
            frame.remove(panels.get("alerts"));
            frame.add(panels.get("announcement"), BorderLayout.CENTER);
        }

        else if (buttonClicked.equals(" View Students ") || buttonClicked.equals(" Manage Students "))
        {
            panels.get("button").remove(mainButtonBox);
            panels.get("button").add(studentButtonBox, BorderLayout.NORTH);

            frame.remove(panels.get("main"));
            frame.remove(panels.get("announcement"));
            frame.remove(panels.get("profile"));
            frame.remove(panels.get("editGrades"));
            frame.remove(panels.get("alerts"));
            frame.add(panels.get("viewStudents"), BorderLayout.CENTER);
        }

        else if (buttonClicked.equals(" Edit Grades "))
        {
            frame.remove(panels.get("main"));
            frame.remove(panels.get("announcement"));
            frame.remove(panels.get("viewStudents"));
            frame.remove(panels.get("profile"));
            frame.remove(panels.get("alerts"));
            frame.add(panels.get("editGrades"), BorderLayout.CENTER);
        }

        else if (buttonClicked.equals(" View Profile "))
        {
            frame.remove(panels.get("main"));
            frame.remove(panels.get("announcement"));
            frame.remove(panels.get("viewStudents"));
            frame.remove(panels.get("editGrades"));
            frame.remove(panels.get("alerts"));
            frame.add(panels.get("profile"), BorderLayout.CENTER);
        }

        else if (buttonClicked.equals(" Alert Admin "))
        {
            frame.remove(panels.get("main"));
            frame.remove(panels.get("announcement"));
            frame.remove(panels.get("viewStudents"));
            frame.remove(panels.get("editGrades"));
            frame.remove(panels.get("profile"));
            frame.add(panels.get("alerts"), BorderLayout.CENTER);
        }

        else if (buttonClicked.equals(" Logout "))
        {
            frame.dispose();
            new LoginScreen();
        }

        frame.revalidate();
        frame.repaint();
    }
}