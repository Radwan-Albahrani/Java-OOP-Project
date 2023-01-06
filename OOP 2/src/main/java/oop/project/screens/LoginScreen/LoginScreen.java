package oop.project.screens.LoginScreen;

import javax.swing.*;

import java.awt.*;

import oop.project.screens.LoginScreen.Panels.LoginPanel;
import oop.project.screens.components.*;
import oop.project.screens.hooks.*;

public class LoginScreen extends JFrame
{

    public LoginScreen()
    {
        // Frame Setup
        FrameConfig.set(this, "Login");

        // Background Setup
        FrameConfig.setBackground(this, "LoginScreen/background.png");

        // Login Panel Setup
        ThemedPanel loginPanel = new LoginPanel(this);
        loginPanel.setPreferredSize(new Dimension((int) (getWidth() / 3), (int) (getHeight() / 2)));
        loginPanel.setSize(getPreferredSize());

        // Login Panel Wrapper Setup
        JPanel loginPanelWrapper = new JPanel();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(0, 10, 0, 10);
        constraints.fill = GridBagConstraints.NONE;
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