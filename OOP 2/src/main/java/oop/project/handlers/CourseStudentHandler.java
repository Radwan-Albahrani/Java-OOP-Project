package oop.project.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import oop.project.API.DatabaseCon;
import oop.project.screens.StudentScreen.Panels.DropClass;
import oop.project.screens.StudentScreen.Panels.registerClassPanel;

public class CourseStudentHandler implements ActionListener
{
    private JTextField searchField;
    private String ID;
    private JPanel panel;
    private int OperationType = 0;

    public CourseStudentHandler(JTextField searchField, String ID, JPanel panel, int OperationType)
    {
        this.searchField = searchField;
        this.ID = ID;
        this.panel = panel;
        this.OperationType = OperationType;
    }

    @Override
    public void actionPerformed(ActionEvent ev)
    {
        String courseID = searchField.getText();

        if (OperationType == 0)
        {
            try
            {
                DatabaseCon.registerCourseToStudent(courseID, ID);
                ((registerClassPanel) panel).refreshTable();
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (OperationType == 1)
        {
            try
            {
                DatabaseCon.dropCourseFromStudent(courseID, ID);
                ((DropClass) panel).refreshTable();
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
