package oop.project.screens.RegisterScreen;

import javax.swing.*;
import java.awt.*;
import com.k33ptoo.components.*;

import oop.project.components.core.NavBar;
import oop.project.hooks.*;
import oop.project.screens.RegisterScreen.Panels.*;

public class RegisterScreen extends JFrame
{
    public RegisterScreen()
    {
        // Frame Setup
        FrameConfig.set(this, "Register");

        // Background Setup
        FrameConfig.setBackground(this, "RegisterScreen/Background.png");

        // Register Panel Setup
        KGradientPanel registerPanel = new RegisterPanel(getWidth(), getHeight(), this);

        // Add Register Panel Wrapper
        JPanel wrapper = wrapperSetup(registerPanel);

        setLayout(new BorderLayout());
        JPanel navBar = new NavBar(this);
        add(navBar, BorderLayout.NORTH);
        add(wrapper, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel wrapperSetup(JPanel panel)
    {
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new GridBagLayout());
        wrapper.setOpaque(false);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(this.getHeight() / 16, this.getWidth() / 3, this.getHeight() / 16,
                this.getWidth() / 3);
        constraints.fill = GridBagConstraints.BOTH;
        ((RegisterPanel) panel).setWrapper(wrapper, this);
        wrapper.add(panel, constraints);
        return wrapper;
    }
}
