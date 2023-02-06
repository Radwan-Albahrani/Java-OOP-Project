package oop.project.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import oop.project.screens.InstructorScreen.Panels.MainPanel;
import oop.project.API.DatabaseCon;

public class RegisterCourseHandler implements ActionListener
{

    private JTextField searchField;
    private String ID;
    private JPanel panel;

    public RegisterCourseHandler(JTextField searchField, String ID, JPanel panel)
    {
        this.searchField = searchField;
        this.ID = ID;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String buttonClicked = e.getActionCommand().trim();
        if (buttonClicked.equals("Register Course"))
        {
            String courseID = searchField.getText();
            try
            {
                DatabaseCon.registerCourseToInstructor(courseID, ID);
                ((MainPanel) panel).refreshPanel();
                JOptionPane.showMessageDialog(null, "Course " + courseID + " Registered Successfully", "Successful",
                        JOptionPane.INFORMATION_MESSAGE);
                System.err.println("Course Registered Successfully - " + ID + " into " + courseID);
            }
            catch (Exception e1)
            {
                JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
