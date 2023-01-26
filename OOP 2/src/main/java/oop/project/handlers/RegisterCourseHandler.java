package oop.project.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import oop.project.screens.InstructorScreen.Frames.RegisterCourseFrame;
import oop.project.screens.InstructorScreen.Panels.MainPanel;

public class RegisterCourseHandler implements ActionListener, ItemListener{

    private final JFrame registerCourseFrame;

    public RegisterCourseHandler(MainPanel mainPanel)
    {
        this.registerCourseFrame = new RegisterCourseFrame(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String buttonClicked = e.getActionCommand().trim();
        if (buttonClicked.equals("Register Course"))
        {
            System.err.println("Register Course Button Clicked");
            ((RegisterCourseFrame) registerCourseFrame).setHandler(this);
            registerCourseFrame.setVisible(true);
        }
        else if (buttonClicked.equals("Register"))
        {
            System.err.println("Register Button Clicked");
            registerCourseFrame.dispose();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {
        // TODO: Actually allow instructor to register course
    }
}

