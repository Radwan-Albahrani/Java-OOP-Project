package oop.project.screens.InstructorScreen.Frames;

import javax.swing.*;
import java.awt.*;

import com.k33ptoo.components.*;
import oop.project.components.*;
import oop.project.handlers.ResetPasswordHandler;
import oop.project.hooks.*;

public class ResetPasswordFrame extends JFrame
{
    KButton submitButton;
    boolean added = false;

    public ResetPasswordFrame(JPanel parent)
    {
        FrameConfig.set(this, "Reset Password", 500, 300);

        // Panels
        KGradientPanel resetPasswordPanel = new ThemedPanelInstructor();

        JLabel oldPasswordLabel = new JLabel("Old Password", SwingConstants.CENTER);
        oldPasswordLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        RoundedJTextField oldPasswordField = new RoundedJTextField(15);
        JLabel newPasswordLabel = new JLabel("New Password", SwingConstants.CENTER);
        newPasswordLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        RoundedJTextField newPasswordField = new RoundedJTextField(15);
        JLabel confirmPasswordLabel = new JLabel("Confirm Password", SwingConstants.CENTER);
        confirmPasswordLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        RoundedJTextField confirmPasswordField = new RoundedJTextField(15);
        submitButton = new CustomButtonInstructor("Submit");

        // Add to Frame
        this.setLayout(new BorderLayout()); // set the layout to border layout
        JPanel navBar = new NavBar(this, true); // Creating the nav bar
        this.add(navBar, BorderLayout.NORTH); // add the nav bar to the top

        JComponent[] resetPasswordComponents = {oldPasswordLabel, oldPasswordField, newPasswordLabel,
                newPasswordField, confirmPasswordLabel, confirmPasswordField, submitButton};
        Box resetPasswordBox = AddToBox.addToVerticalBox(resetPasswordComponents, 1);

        resetPasswordPanel.add(resetPasswordBox);
        this.add(resetPasswordPanel);
        this.setLocationRelativeTo(parent);
    }

    public void setHandler(ResetPasswordHandler handler)
    {
        if (!added)
        {
            submitButton.addActionListener(handler);
            added = true;
        }
    }
}
