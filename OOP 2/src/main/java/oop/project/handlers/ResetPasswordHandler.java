package oop.project.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import oop.project.components.frames.ResetPasswordFrame;
import oop.project.components.panels.ProfilePanel;

public class ResetPasswordHandler implements ActionListener
{
    private final JFrame resetPasswordFrame;

    public ResetPasswordHandler(ProfilePanel profilePanel, int type)
    {
        this.resetPasswordFrame = new ResetPasswordFrame(profilePanel, type);
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
        else if (buttonClicked.equals("Reset"))
        {
            System.err.println("Submit Button Clicked");
            int result = ((ResetPasswordFrame) resetPasswordFrame).resetPassword();
            if (result == 0)
            {
                JOptionPane.showMessageDialog(resetPasswordFrame, "Password Reset Successful", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                resetPasswordFrame.dispose();
            }
            else if (result == 1)
            {
                JOptionPane.showMessageDialog(resetPasswordFrame, "New Passwords Do Not Match", "Error",
                        JOptionPane.ERROR_MESSAGE);
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