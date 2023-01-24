package oop.project.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import oop.project.API.DatabaseCon;
import oop.project.screens.AdminScreen.Panels.ViewRegistrationPanel;

public class ActivationHandler implements ActionListener
{

    JTextField textField;
    JPanel panel;

    public ActivationHandler(JTextField textField, JPanel panel)
    {
        this.textField = textField;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("Activate"))
        {
            String id = textField.getText();
            try
            {
                DatabaseCon.activateUser(id);
            }
            catch (Exception e1)
            {
                JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            textField.setText("");
            ((ViewRegistrationPanel) panel).refreshTable();
        }
        else if (e.getActionCommand().equals("Activate All"))
        {
            DatabaseCon.activateAllUsers();
            textField.setText("");
            ((ViewRegistrationPanel) panel).refreshTable();
        }
        panel.revalidate();
        panel.repaint();
    }

}
