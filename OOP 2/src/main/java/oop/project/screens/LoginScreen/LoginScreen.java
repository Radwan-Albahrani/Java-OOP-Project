package oop.project.screens.LoginScreen;

import javax.swing.*;

import java.awt.*;

import oop.project.components.core.NavBar;
import oop.project.components.panels.ThemedPanelGeneric;
import oop.project.hooks.*;
import oop.project.screens.LoginScreen.Panels.LoginPanel;

public class LoginScreen extends JFrame
{

    public LoginScreen()
    {
        // Frame Setup
        FrameConfig.set(this, "Login");

        // Background Setup
        FrameConfig.setBackground(this, "LoginScreen/background.png");

        // Login Panel Setup
        ThemedPanelGeneric loginPanel = new LoginPanel(this, getWidth(), getHeight());

        // Login Panel Wrapper Setup
        JPanel loginPanelWrapper = new JPanel();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(getHeight() / 5, (int) (getWidth() / 3.8), getHeight() / 5,
                (int) (getWidth() / 3.8));
        constraints.fill = GridBagConstraints.BOTH;
        loginPanelWrapper.setOpaque(false);
        loginPanelWrapper.setLayout(new GridBagLayout());
        loginPanelWrapper.add(loginPanel, constraints);

        JPanel navBar = new NavBar(this);
        setLayout(new BorderLayout());
        add(navBar, BorderLayout.NORTH);
        add(loginPanelWrapper, BorderLayout.CENTER);

        setVisible(true);
    }
}
