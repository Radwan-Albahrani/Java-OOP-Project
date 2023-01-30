package oop.project.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import oop.project.API.DatabaseCon;
import oop.project.screens.AdminScreen.Panels.CoursesPanel;

public class DeleteCourseHandler implements ActionListener
{

    JTextField textField;
    JPanel panel;

    public DeleteCourseHandler(JTextField textField, JPanel panel)
    {
        this.textField = textField;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("Delete"))
        {
            int result = JOptionPane.showConfirmDialog(panel, "Are you sure you want to delete this course?",
                    "Delete Course", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.NO_OPTION)
            {
                return;
            }
            String id = textField.getText();
            try
            {
                DatabaseCon.deleteCourse(id);
                textField.setText("");
                ((CoursesPanel) panel).refreshTable();
                JOptionPane.showMessageDialog(panel, "Course deleted successfully", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            catch (Exception e1)
            {
                JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (e.getActionCommand().equals("Activate All"))
        {
            DatabaseCon.activateAllUsers();
            textField.setText("");
            ((CoursesPanel) panel).refreshTable();
        }
        panel.revalidate();
        panel.repaint();
    }

}
