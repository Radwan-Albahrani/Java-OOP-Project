package oop.project.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import oop.project.screens.InstructorScreen.Frames.ResetPasswordFrame;
import oop.project.screens.InstructorScreen.Panels.ProfilePanel;

public class ResetPasswordHandler implements ActionListener
{

    private final JFrame resetPasswordFrame;

    public ResetPasswordHandler(ProfilePanel profilePanel)
    {
        this.resetPasswordFrame = new ResetPasswordFrame(profilePanel);
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
            System.err.println("Submit Button Clicked");
            resetPasswordFrame.dispose();
        }
    }
}