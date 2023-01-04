package oop.project.handlers;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class GenerateUserAndEmail implements FocusListener
{
    private JTextField firstName;
    private JTextField lastName;
    private JTextField email;
    private JTextField username;
    private int ID;

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

        String emailText = firstNameText.toLowerCase() + "." + lastNameText.toLowerCase() + "@University.com";
        String usernameText = firstNameText.toLowerCase() + "." + lastNameText.toLowerCase() + ID;

        email.setText(emailText);
        username.setText(usernameText);
    }

    @Override
    public void focusLost(FocusEvent arg0)
    {
        String firstNameText = firstName.getText();
        String lastNameText = lastName.getText();

        String emailText = firstNameText.toLowerCase() + "." + lastNameText.toLowerCase() + "@University.com";
        String usernameText = firstNameText.toLowerCase() + "." + lastNameText.toLowerCase() + ID;

        email.setText(emailText);
        username.setText(usernameText);
    }

}
