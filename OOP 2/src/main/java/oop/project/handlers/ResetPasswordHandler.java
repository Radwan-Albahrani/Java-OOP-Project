package oop.project.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;
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
            if (newPass == confirmPass)
            {
                ResultSet rs = DatabaseCon.customQuery("SELECT Password FROM user WHERE UserID = '" + currentUser + "'");
                try
                {
                    while(rs.next())
                    {
                        oldpassword.add(rs.getString("Password"));
                    }
                }
                catch (Exception e1)
                {
                    JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    System.err.println("Error getting old password");
                    e1.printStackTrace();
                    return;
                }

                if (oldPass == oldpassword.get(0))
                {
                    DatabaseCon.customQuery("UPDATE user SET Password = '" + newPass + "' WHERE UserID = '" + currentUser + "'");
                    JOptionPane.showMessageDialog(null, "Password changed successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    System.err.println("Password changed successfully");
                    return;
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Incorrect old password", "Error", JOptionPane.ERROR_MESSAGE);
                    System.err.println("Incorrect password");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "New Password does not match with confirmation", "Error", JOptionPane.ERROR_MESSAGE);
                System.err.println("Passwords do not match");
            }
        }
    }
}