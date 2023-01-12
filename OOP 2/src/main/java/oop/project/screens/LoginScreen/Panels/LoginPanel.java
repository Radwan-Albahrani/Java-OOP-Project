package oop.project.screens.LoginScreen.Panels;

import oop.project.components.*;
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
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
        this.setPreferredSize(new Dimension((int) (Width / 3), (int) (Height / 2)));
        this.setSize(getPreferredSize());

        // Login Label Setup
        JLabel loginLabel = new TitleLabel("Student Information System");

        // Picture Setup
        JLabel picture = FrameConfig.getPicture("LoginScreen/LoginScreenIcon.png", 0.4);

        // Login Top Panel Setup
        JPanel LoginTopBox = new VerticalPanel(loginLabel, picture);

        // Username Label and Field Setup
        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JTextField usernameField = new JTextField(15);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 20));
        usernameField.setHorizontalAlignment(JTextField.CENTER);

        JComponent[] userComponents = {usernameLabel, usernameField};
        Box userBox = AddToBox.addToHorizontalBox(userComponents, 1);

        // Password Label and Field Setup
        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JTextField passwordField = new JPasswordField(15);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 20));
        passwordField.setHorizontalAlignment(JTextField.CENTER);

        JComponent[] passComponents = {passwordLabel, passwordField};
        Box passBox = AddToBox.addToHorizontalBox(passComponents, 1);

        // Button Setup
        JPanel buttonBox = new JPanel();
        buttonBox.setOpaque(false);
        buttonBox.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Login Button Setup
        JButton loginButton = new BlueButton("Login");

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
        this.add(LoginTopBox);
        this.add(userBox);
        this.add(passBox);
        this.add(buttonBox);
    }
}
