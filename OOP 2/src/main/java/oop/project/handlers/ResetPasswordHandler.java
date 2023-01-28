package oop.project.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;

import oop.project.API.DatabaseCon;
import oop.project.components.frames.ResetPasswordFrame;
import oop.project.components.panels.ProfilePanel;

public class ResetPasswordHandler implements ActionListener
{
    private final JFrame resetPasswordFrame;
    Long currentUser = DatabaseCon.currentUser.getUserID();
    String oldPass;
    String newPass;
    String confirmPass;
    ArrayList<String> oldpassword = new ArrayList<String>();

    public ResetPasswordHandler(ProfilePanel profilePanel, int type)
    {
        this.resetPasswordFrame = new ResetPasswordFrame(profilePanel, type);
    }

    public ResetPasswordHandler(char[] oldPass, char[] newPass, char[] confirmPass)
    {
        this.oldPass = oldPass.toString();
        this.newPass = newPass.toString();
        this.confirmPass = confirmPass.toString();
        this.resetPasswordFrame = null;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String buttonClicked = e.getActionCommand().trim();
        if (buttonClicked.equals("Reset Password"))
        {
            System.err.println("Reset Password Button Clicked");
            ((ResetPasswordFrame) resetPasswordFrame).setHandler(this);
            resetPasswordFrame.setVisible(true);
        }

        else if (buttonClicked.equals("Submit"))
        {
            System.err.println(oldPass);
            System.err.println(newPass);
            System.err.println(confirmPass);
            System.err.println("Submit Button Clicked");
            int result = ((ResetPasswordFrame) resetPasswordFrame).resetPassword();
            if (result == 0)
            {
                JOptionPane.showMessageDialog(resetPasswordFrame, "Password Reset Successful", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                resetPasswordFrame.dispose();
            }
            else if (result == 2)
            {
                JOptionPane.showMessageDialog(resetPasswordFrame, "Old Password Does not Match", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(resetPasswordFrame, "Password Reset Failed", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}