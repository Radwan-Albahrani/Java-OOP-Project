package oop.project.screens.RegisterScreen.Panels;

import javax.swing.*;

import com.k33ptoo.components.*;

import java.awt.*;

import oop.project.components.*;
import oop.project.handlers.GenerateUserAndEmail;
import oop.project.hooks.*;

public class RegisterPanel extends ThemedPanelGeneric
{
    public RegisterPanel(int Width, int Height)
    {
        // Register Label Setup
        JLabel registerLabel = new TitleLabel("Registration");

        // Picture Setup
        JLabel picture = FrameConfig.getPicture("RegisterScreen/RegisterScreenIcon.png", 0.4);

        // Register Top Frame Setup
        JPanel registerTopFrame = new VerticalPanel(registerLabel, picture);

        // Name and Surname Label and Field Setup
        JLabel firstNameLabel = new JLabel("First Name");
        firstNameLabel.setForeground(Color.WHITE);
        firstNameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        firstNameLabel.setHorizontalAlignment(JLabel.CENTER);
        firstNameLabel.setHorizontalTextPosition(JLabel.CENTER);

        JTextField firstNameField = new JTextField(15);
        firstNameField.setFont(new Font("Arial", Font.PLAIN, 20));
        firstNameField.setHorizontalAlignment(JTextField.CENTER);

        JLabel lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setForeground(Color.WHITE);
        lastNameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        lastNameLabel.setHorizontalAlignment(JLabel.CENTER);

        JTextField lastNameField = new JTextField(15);
        lastNameField.setFont(new Font("Arial", Font.PLAIN, 20));
        lastNameField.setHorizontalAlignment(JTextField.CENTER);

        JComponent nameBoxComponents[] = {firstNameLabel, firstNameField, lastNameLabel, lastNameField};
        Box nameBox = AddToBox.addToHorizontalBox(nameBoxComponents, 2);

        // Username Label and Field Setup
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JTextField usernameField = new JTextField(31);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 20));
        usernameField.setHorizontalAlignment(JTextField.CENTER);
        usernameField.setEditable(false);
        // Email Label and Field Setup
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JTextField emailField = new JTextField(31);
        emailField.setFont(new Font("Arial", Font.PLAIN, 20));
        emailField.setHorizontalAlignment(JTextField.CENTER);
        emailField.setEditable(false);

        JComponent userBoxComponents[] = {usernameLabel, usernameField, emailLabel, emailField};
        Box userAndEmailBox = AddToBox.addToHorizontalBox(userBoxComponents, 4);

        // Add Focus Listeners
        lastNameField.addFocusListener(new GenerateUserAndEmail(firstNameField, lastNameField, emailField, usernameField));
        firstNameField.addFocusListener(new GenerateUserAndEmail(lastNameField, firstNameField, emailField, usernameField));
        // Password Label and Field Setup
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 20));
        passwordField.setHorizontalAlignment(JTextField.CENTER);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password");
        confirmPasswordLabel.setForeground(Color.WHITE);
        confirmPasswordLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JPasswordField confirmPasswordField = new JPasswordField(10);
        confirmPasswordField.setFont(new Font("Arial", Font.PLAIN, 20));
        confirmPasswordField.setHorizontalAlignment(JTextField.CENTER);

        JComponent passwordBoxComponents[] = {passwordLabel, passwordField, confirmPasswordLabel, confirmPasswordField};
        Box authBox = AddToBox.addToHorizontalBox(passwordBoxComponents, 2);

        // User Type Setup
        String[] userTypes = {"", "Student", "Instructor", "Admin"};
        JLabel userTypeLabel = new JLabel("User Type");
        userTypeLabel.setForeground(Color.WHITE);
        userTypeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        JComboBox<String> userTypeSelection = new JComboBox<>(userTypes);
        userTypeSelection.setFont(new Font("Arial", Font.PLAIN, 20));
        // userTypeSelection.setPrototypeDisplayValue("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        JComponent userTypeBoxComponents[] = {userTypeLabel, userTypeSelection};
        Box userTypeBox = AddToBox.addToHorizontalBox(userTypeBoxComponents, 1);

        // Register Button Setup
        KButton registerButton = new BlueButton("Register");

        // JPanel for ComboBox and Register Button
        JPanel bottomPanel = new VerticalPanel(userTypeBox, registerButton);

        // Add Components to Register Panel
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(0, 100, 0, 100);
        this.add(registerTopFrame, c);
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridy = 1;
        this.add(nameBox, c);
        c.gridy = 2;
        this.add(userAndEmailBox, c);
        c.gridy = 3;
        this.add(authBox, c);
        c.gridy = 4;
        this.add(bottomPanel, c);
    }

}
