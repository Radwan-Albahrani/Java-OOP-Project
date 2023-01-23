package oop.project.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import oop.project.API.DatabaseCon;
import oop.project.screens.AdminScreen.AdminScreen;
import oop.project.screens.InstructorScreen.InstructorScreen;
import oop.project.screens.StudentScreen.StudentScreen;

public class LoginHandler implements ActionListener
{
    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final JFrame frame;

    public LoginHandler(JTextField usernameField, JPasswordField passwordField, JFrame frame)
    {
        this.usernameField = usernameField;
        this.passwordField = passwordField;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        int result = DatabaseCon.login(username, password);
        if (result == 2)
        {
            if (DatabaseCon.currentUser.getRole().equals("Admin"))
            {
                frame.dispose();
                new AdminScreen();
            }
            else if (DatabaseCon.currentUser.getRole().equals("Instructor"))
            {
                frame.dispose();
                new InstructorScreen();
            }
            else if (DatabaseCon.currentUser.getRole().equals("Student"))
            {
                frame.dispose();
                new StudentScreen();
            }

        }
        else if (result == 1)
        {
            JOptionPane.showMessageDialog(frame, "Login Failed. User Not Activated", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        else if (result == 0)
        {
            JOptionPane.showMessageDialog(frame, "Login Failed. Incorrect Username or Password",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(frame, "Error", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}
