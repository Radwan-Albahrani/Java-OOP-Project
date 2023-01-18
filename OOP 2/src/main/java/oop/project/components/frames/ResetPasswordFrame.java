package oop.project.components.frames;

import javax.swing.*;
import java.awt.*;

import com.k33ptoo.components.*;

import oop.project.components.buttons.CustomButtonAdmin;
import oop.project.components.buttons.CustomButtonInstructor;
import oop.project.components.core.NavBar;
import oop.project.components.core.RoundedJTextField;
import oop.project.components.panels.ThemedPanelAdmin;
import oop.project.components.panels.ThemedPanelInstructor;
import oop.project.handlers.ResetPasswordHandler;
import oop.project.hooks.*;

public class ResetPasswordFrame extends JFrame
{
    KButton submitButton;
    boolean added = false;
    KGradientPanel resetPasswordPanel;

    public ResetPasswordFrame(JPanel parent, int type)
    {
        FrameConfig.set(this, "Reset Password", 500, 300);

        // Set the type of the buttons and panel
        setButtonsType(type);
        setPanelType(type);

        JLabel oldPasswordLabel = new JLabel("Old Password", SwingConstants.CENTER);
        oldPasswordLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        RoundedJTextField oldPasswordField = new RoundedJTextField(15);
        JLabel newPasswordLabel = new JLabel("New Password", SwingConstants.CENTER);
        newPasswordLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        RoundedJTextField newPasswordField = new RoundedJTextField(15);
        JLabel confirmPasswordLabel = new JLabel("Confirm Password", SwingConstants.CENTER);
        confirmPasswordLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        RoundedJTextField confirmPasswordField = new RoundedJTextField(15);

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

    private void setPanelType(int type)
    {
        if (type == 0)
        {
            resetPasswordPanel = new ThemedPanelAdmin();
        }
        else if (type == 1)
        {
            resetPasswordPanel = new ThemedPanelInstructor();
        }
        // else if(buttonsType == 2)
        // {
        // resetPasswordPanel = new ThemedPanelStudent();
        // }
    }

    public void setHandler(ResetPasswordHandler handler)
    {
        if (!added)
        {
            submitButton.addActionListener(handler);
            added = true;
        }
    }

    public void setButtonsType(int buttonsType)
    {
        if (buttonsType == 0)
        {
            submitButton = new CustomButtonAdmin("Submit");
        }
        else if (buttonsType == 1)
        {
            submitButton = new CustomButtonInstructor("Submit");
        }
        // else if(buttonsType == 2)
        // {
        // submitButton = new CustomButtonInstructor("Reset");
        // }
    }
}
