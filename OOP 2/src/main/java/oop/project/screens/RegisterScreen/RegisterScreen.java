package oop.project.screens.RegisterScreen;

import javax.swing.*;
import java.awt.*;
import com.k33ptoo.components.*;

import oop.project.components.*;
import oop.project.hooks.*;
import oop.project.screens.RegisterScreen.Panels.RegisterPanel;

public class RegisterScreen extends JFrame
{
    public RegisterScreen()
    {
        // Frame Setup
        FrameConfig.set(this, "Register");

        // Background Setup
        FrameConfig.setBackground(this, "RegisterScreen/Background.png");

        // Register Panel Setup
        KGradientPanel registerPanel = new RegisterPanel(getWidth(), getHeight());

        // Add Register Panel Wrapper
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new GridBagLayout());
        wrapper.setOpaque(false);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(getHeight() / 8, getWidth() / 3, getHeight() / 8, getWidth() / 3);
        constraints.fill = GridBagConstraints.BOTH;
        wrapper.add(registerPanel, constraints);

        setLayout(new BorderLayout());
        JPanel navBar = new NavBar(this);
        add(navBar, BorderLayout.NORTH);
        add(wrapper, BorderLayout.CENTER);

        setVisible(true);
    }
}
