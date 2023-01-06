package oop.project.handlers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;

import com.k33ptoo.components.KGradientPanel;

import oop.project.screens.LoginScreen.LoginScreen;

// TODO: use buttonPanel.remove() to remove the current panel and add the new one with an if statement assuming the button is clicked
public class ButtonHandlerInstructor implements ActionListener
{
    JFrame frame;
    KGradientPanel[] panels;
    Box studentButtonBox;
    Box mainButtonBox;

    public ButtonHandlerInstructor(JFrame frame, KGradientPanel[] panels, Box studentButtonBox, Box mainButtonBox)
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
            frame.remove(panels[1]);
            frame.remove(panels[2]);
            frame.remove(panels[3]);
            frame.remove(panels[5]);
            frame.add(panels[0], BorderLayout.CENTER);
            panels[6].remove(studentButtonBox);
            panels[6].add(mainButtonBox, BorderLayout.NORTH);
        }

        else if (buttonClicked.equals(" Add Announcement "))
        {
            frame.remove(panels[0]);
            frame.remove(panels[4]);
            frame.remove(panels[2]);
            frame.remove(panels[3]);
            frame.remove(panels[5]);
            frame.add(panels[1], BorderLayout.CENTER);
        }

        else if (buttonClicked.equals(" View Students "))
        {
            panels[6].remove(mainButtonBox);
            panels[6].add(studentButtonBox, BorderLayout.NORTH);

            frame.remove(panels[0]);
            frame.remove(panels[1]);
            frame.remove(panels[4]);
            frame.remove(panels[3]);
            frame.remove(panels[5]);
            frame.add(panels[2], BorderLayout.CENTER);
        }

        else if (buttonClicked.equals(" Edit Grades "))
        {
            frame.remove(panels[0]);
            frame.remove(panels[1]);
            frame.remove(panels[2]);
            frame.remove(panels[4]);
            frame.remove(panels[5]);
            frame.add(panels[3], BorderLayout.CENTER);
        }

        else if (buttonClicked.equals(" View Profile "))
        {
            frame.remove(panels[0]);
            frame.remove(panels[1]);
            frame.remove(panels[2]);
            frame.remove(panels[3]);
            frame.remove(panels[5]);
            frame.add(panels[4], BorderLayout.CENTER);
        }

        else if (buttonClicked.equals(" Alert Admin "))
        {
            frame.remove(panels[0]);
            frame.remove(panels[1]);
            frame.remove(panels[2]);
            frame.remove(panels[3]);
            frame.remove(panels[4]);
            frame.add(panels[5], BorderLayout.CENTER);
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