package oop.project.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import oop.project.API.DatabaseCon;

public class CreateCourseHandler implements ActionListener
{
    JTextField id;
    JTextField name;
    JTextField credit;
    JTextField maxCap;

    public CreateCourseHandler(JTextField id, JTextField name, JTextField credit, JTextField maxCap)
    {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.maxCap = maxCap;
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        String id = this.id.getText();
        String name = this.name.getText();
        String credit = this.credit.getText();
        String maxCap = this.maxCap.getText();

        try
        {
            validation(id, name, credit, maxCap);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try
        {
            DatabaseCon.createCourse(id, name, credit, maxCap);
            this.id.setText("");
            this.name.setText("");
            this.credit.setText("");
            this.maxCap.setText("");
            JOptionPane.showMessageDialog(null, "Course created successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void validation(String id, String name, String credit, String maxCap) throws Exception
    {
        // INPUT VALIDATION
        if (id.equals(""))
        {
            throw new Exception("Please enter a course ID");
        }
        if (name.equals(""))
        {
            throw new Exception("Please enter a course name");
        }
        if (credit.equals(""))
        {
            throw new Exception("Please enter a course credit");
        }
        if (maxCap.equals(""))
        {
            throw new Exception("Please enter a course max capacity");
        }

        // REGEX ID is only letters and numbers
        if (!id.matches("[a-zA-Z]{2,4}-[0-9]{3}"))
        {
            throw new Exception("Course ID must be in the format XXX-123 or XX-123 OR XXXX-123");
        }

        // REGEX NAME is only letters
        if (!name.matches("[a-zA-Z ]+"))
        {
            throw new Exception("Course name must only contain letters");
        }

        // REGEX CREDIT is only numbers
        if (!credit.matches("[0-9]+"))
        {
            throw new Exception("Course credit must only contain numbers");
        }

        // REGEX MAX CAP is only numbers
        if (!maxCap.matches("[0-9]+"))
        {
            throw new Exception("Course max capacity must only contain numbers");
        }
    }

}
