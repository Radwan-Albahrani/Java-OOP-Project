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
            String id = textField.getText();
            DatabaseCon.deleteCourse(id);
            textField.setText("");
            ((CoursesPanel) panel).refreshTable();
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
