package oop.project.handlers;

import javax.swing.*;

import oop.project.API.DatabaseCon;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class GenerateUserAndEmail implements FocusListener
{
    private JTextField firstName;
    private JTextField lastName;
    private JTextField email;
    private JTextField username;
    private long ID = DatabaseCon.generateID();

    public GenerateUserAndEmail(JTextField firstName, JTextField lastName, JTextField email, JTextField username)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
    }

    @Override
    public void focusGained(FocusEvent arg0)
    {
        String firstNameText = firstName.getText();
        String lastNameText = lastName.getText();

        if (firstNameText.length() > 0)
        {
            firstNameText = firstNameText.substring(0, 1).toUpperCase() + firstNameText.substring(1).toLowerCase();
        }
        else
        {
            firstNameText = firstNameText.toUpperCase();
        }
        if (lastNameText.length() > 0)
        {
            lastNameText = lastNameText.substring(0, 1).toUpperCase();
        }
        else
        {
            lastNameText = lastNameText.toUpperCase();
        }

        String emailText = firstNameText + "." + lastNameText
                + ID + "@University.com";
        String usernameText = firstNameText + "." + lastNameText + ID;

        email.setText(emailText);
        username.setText(usernameText);
    }

    @Override
    public void focusLost(FocusEvent arg0)
    {
        String firstNameText = firstName.getText();
        String lastNameText = lastName.getText();

        if (firstNameText.length() > 0)
        {
            firstNameText = firstNameText.substring(0, 1).toUpperCase() + firstNameText.substring(1).toLowerCase();
        }
        else
        {
            firstNameText = firstNameText.toUpperCase();
        }
        if (lastNameText.length() > 0)
        {
            lastNameText = lastNameText.substring(0, 1).toUpperCase();
        }
        else
        {
            lastNameText = lastNameText.toUpperCase();
        }

        String emailText = firstNameText + "." + lastNameText
                + ID + "@University.com";
        String usernameText = firstNameText + "." + lastNameText + ID;

        email.setText(emailText);
        username.setText(usernameText);
    }

}
