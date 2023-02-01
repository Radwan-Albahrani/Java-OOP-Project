package oop.project.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
            List<Integer> count = DatabaseCon.getCountOfStudentsInCourse(courseID);
            List<Integer> max = DatabaseCon.getMaxCountofCourse(courseID);
            if (count.get(0) >= max.get(0))
            {
                JOptionPane.showMessageDialog(null, "Course is full, can not register.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try
            {
                DatabaseCon.registerCourseToStudent(courseID, ID);
                ((registerClassPanel) panel).refreshTable();
                JOptionPane.showMessageDialog(panel, "Course registered successfully", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
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
                int result = JOptionPane.showConfirmDialog(panel, "Are you sure you want to drop this course?",
                        "Drop Course", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.NO_OPTION)
                {
                    return;
                }
                DatabaseCon.dropCourseFromStudent(courseID, ID);
                ((DropClass) panel).refreshTable();
                JOptionPane.showMessageDialog(panel, "Course dropped successfully", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
