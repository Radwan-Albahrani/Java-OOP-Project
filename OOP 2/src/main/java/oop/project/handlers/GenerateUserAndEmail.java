package oop.project.handlers;

import javax.swing.*;

import oop.project.API.DatabaseCon;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class GenerateUserAndEmail implements FocusListener
{
    private JTextField email;
    private JTextField username;
    private long ID;

    public GenerateUserAndEmail(JTextField email, JTextField username)
    {
        try
        {
            this.ID = DatabaseCon.generateID();
        }
        catch (Exception e)
        {
            System.err.println("Error: " + e.getMessage());
        }
        this.ID = DatabaseCon.generateID();
        this.email = email;
        this.username = username;
    }

    @Override
    public void focusGained(FocusEvent arg0)
    {

        String emailText = ID + "@University.com";
        String usernameText = Long.toString(ID);
        email.setText(emailText);
        username.setText(usernameText);
    }

    @Override
    public void focusLost(FocusEvent arg0)
    {

        String emailText = ID + "@University.com";
        String usernameText = Long.toString(ID);
        email.setText(emailText);
        username.setText(usernameText);
    }

}
