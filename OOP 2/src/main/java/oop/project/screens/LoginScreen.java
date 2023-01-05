package oop.project.screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.k33ptoo.components.*;
import oop.project.screens.components.*;
import oop.project.screens.hooks.*;

public class LoginScreen extends JFrame
{
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel loginLabel;
    private KGradientPanel loginPanel;
    private KButton loginButton;
    private KButton registerButton;
    private JLabel picture;

    public LoginScreen()
    {
        // Frame Setup
        FrameConfig.set(this, "Login");

        // Background Setup
        FrameConfig.setBackground(this, "LoginScreen/background.png");

        // Login Panel Setup
        loginPanel = new ThemedPanel();
        loginPanel.setPreferredSize(new Dimension((int) (getWidth() / 3), (int) (getHeight() / 2)));
        loginPanel.setSize(getPreferredSize());
        loginPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));

        // Login Label Setup
        loginLabel = new TitleLabel("Student Information System");

        // Picture Setup
        picture = FrameConfig.getPicture("LoginScreen/LoginScreenIcon.png", 0.4);

        // Login Top Panel Setup
        JPanel LoginTopBox = new VerticalPanel(loginLabel, picture);

        // Username Label and Field Setup
        usernameLabel = new JLabel("Username: ");
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 20));

        usernameField = new JTextField(15);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 20));
        usernameField.setHorizontalAlignment(JTextField.CENTER);

        JComponent[] userComponents = {usernameLabel, usernameField};
        Box userBox = AddToBox.addToHorizontalBox(userComponents, 1);

        // Password Label and Field Setup
        passwordLabel = new JLabel("Password: ");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 20));

        passwordField = new JPasswordField(15);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 20));
        passwordField.setHorizontalAlignment(JTextField.CENTER);

        JComponent[] passComponents = {passwordLabel, passwordField};
        Box passBox = AddToBox.addToHorizontalBox(passComponents, 1);

        // Button Setup
        JPanel buttonBox = new JPanel();
        buttonBox.setOpaque(false);
        buttonBox.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Login Button Setup
        loginButton = new BlueButton("Login");

        // Register Button Setup
        registerButton = new BlueButton("Register");
        registerButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        new RegisterScreen();
                        dispose();
                    }
                });

        buttonBox.add(loginButton);
        buttonBox.add(registerButton);

        // Adding Components to Login Panel
        loginPanel.add(LoginTopBox);
        loginPanel.add(userBox);
        loginPanel.add(passBox);
        loginPanel.add(buttonBox);

        // Login Panel Wrapper Setup
        JPanel loginPanelWrapper = new JPanel();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(0, 10, 0, 10);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        loginPanelWrapper.setOpaque(false);
        loginPanelWrapper.setLayout(new GridBagLayout());
        loginPanelWrapper.add(loginPanel, constraints);

        setLayout(new BorderLayout());
        add(loginPanelWrapper, BorderLayout.CENTER);

        setVisible(true);
    }
}
