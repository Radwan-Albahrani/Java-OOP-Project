package oop.project.screens.LoginScreen.Panels;

import oop.project.components.buttons.BlueButton;
import oop.project.components.core.RoundedJPasswordField;
import oop.project.components.core.RoundedJTextField;
import oop.project.components.core.TitleLabel;
import oop.project.components.panels.ThemedPanelGeneric;
import oop.project.components.panels.VerticalPanel;
import oop.project.handlers.LoginHandler;
import oop.project.hooks.*;
import oop.project.screens.RegisterScreen.RegisterScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPanel extends ThemedPanelGeneric
{
    public LoginPanel(JFrame frame, int Width, int Height)
    {
        // Login Label Setup
        JLabel loginLabel = new TitleLabel("Student Information System");

        // Picture Setup
        JLabel picture = FrameConfig.getPicture("LoginScreen/loginScreenIcon.png", 0.4);

        // Login Top Panel Setup
        JPanel LoginTopBox = new VerticalPanel(loginLabel, picture);

        // Username Label and Field Setup
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 25));

        RoundedJTextField usernameField = new RoundedJTextField(15);
        usernameField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        usernameField.setHorizontalAlignment(JTextField.CENTER);

        JComponent[] userComponents = {usernameLabel, usernameField};
        Box userBox = AddToBox.addToHorizontalBox(userComponents, 1);

        // Password Label and Field Setup
        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 25));

        RoundedJPasswordField passwordField = new RoundedJPasswordField(15);
        passwordField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        passwordField.setHorizontalAlignment(JTextField.CENTER);

        JComponent[] passComponents = {passwordLabel, passwordField};
        Box passBox = AddToBox.addToHorizontalBox(passComponents, 1);

        // Button Setup
        JPanel buttonBox = new JPanel();
        buttonBox.setOpaque(false);
        buttonBox.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Login Button Setup
        JButton loginButton = new BlueButton("Login");

        loginButton.addActionListener(new LoginHandler(usernameField, passwordField, frame));

        // Register Button Setup
        JButton registerButton = new BlueButton("Register");
        registerButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        new RegisterScreen();
                        frame.dispose();
                    }
                });

        buttonBox.add(loginButton);
        buttonBox.add(registerButton);

        // Adding Components to Login Panel
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(0, 100, 0, 100);
        this.add(LoginTopBox, c);
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridy = 1;
        this.add(userBox, c);
        c.gridy = 2;
        this.add(passBox, c);
        c.gridy = 3;
        this.add(buttonBox, c);
    }
}
