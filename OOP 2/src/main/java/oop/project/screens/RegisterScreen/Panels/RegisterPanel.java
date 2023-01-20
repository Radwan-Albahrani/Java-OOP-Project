package oop.project.screens.RegisterScreen.Panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.util.*;

import javax.swing.*;

import com.k33ptoo.components.KButton;

import oop.project.components.buttons.BlueButton;
import oop.project.components.core.RoundedJPasswordField;
import oop.project.components.core.RoundedJTextField;
import oop.project.components.core.TitleLabel;
import oop.project.components.panels.ThemedPanelGeneric;
import oop.project.components.panels.VerticalPanel;
import oop.project.handlers.GenerateUserAndEmail;
import oop.project.handlers.RegisterHandler;
import oop.project.hooks.*;

public class RegisterPanel extends ThemedPanelGeneric
{
    KButton nextButton;
    List<String> info = new ArrayList<>();
    JPanel wrapper;

    Map<String, JComponent> components = new Hashtable<>();

    public void setWrapper(JPanel wrapper, JFrame frame)
    {
        this.wrapper = wrapper;
        HandlerSetter(components, frame.getWidth(), frame.getHeight(), frame);
    }

    public RegisterPanel(int Width, int Height, JFrame frame)
    {
        // Register Label Setup
        JLabel registerLabel = new TitleLabel("Registration");

        // Picture Setup
        JLabel picture = FrameConfig.getPicture("RegisterScreen/RegisterScreenIcon.png", 0.45);

        // Register Top Frame Setup
        JPanel registerTopFrame = new VerticalPanel(registerLabel, picture);

        // Name and Surname Label and Field Setup
        JLabel firstNameLabel = new JLabel("First Name");
        firstNameLabel.setForeground(Color.WHITE);
        firstNameLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        firstNameLabel.setHorizontalAlignment(JLabel.CENTER);
        firstNameLabel.setHorizontalTextPosition(JLabel.CENTER);

        RoundedJTextField firstNameField = new RoundedJTextField(15);
        firstNameField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        firstNameField.setHorizontalAlignment(RoundedJTextField.CENTER);

        JLabel lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setForeground(Color.WHITE);
        lastNameLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        lastNameLabel.setHorizontalAlignment(JLabel.CENTER);

        RoundedJTextField lastNameField = new RoundedJTextField(15);
        lastNameField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        lastNameField.setHorizontalAlignment(RoundedJTextField.CENTER);

        JComponent nameBoxComponents[] = {firstNameLabel, firstNameField, lastNameLabel, lastNameField};
        Box nameBox = AddToBox.addToHorizontalBox(nameBoxComponents, 2);

        // Username Label and Field Setup
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 25));

        RoundedJTextField usernameField = new RoundedJTextField(31);
        usernameField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        usernameField.setHorizontalAlignment(RoundedJTextField.CENTER);
        usernameField.setEditable(false);

        // Email Label and Field Setup
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 25));

        RoundedJTextField emailField = new RoundedJTextField(31);
        emailField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        emailField.setHorizontalAlignment(RoundedJTextField.CENTER);
        emailField.setEditable(false);

        JComponent userBoxComponents[] = {usernameLabel, usernameField, emailLabel, emailField};
        Box userAndEmailBox = AddToBox.addToHorizontalBox(userBoxComponents, 4);

        // Add Focus Listeners
        lastNameField.addFocusListener(new GenerateUserAndEmail(emailField, usernameField));
        firstNameField.addFocusListener(new GenerateUserAndEmail(emailField, usernameField));

        // Password Label and Field Setup
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 25));

        RoundedJPasswordField passwordField = new RoundedJPasswordField(15);
        passwordField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        passwordField.setHorizontalAlignment(RoundedJTextField.CENTER);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password");
        confirmPasswordLabel.setForeground(Color.WHITE);
        confirmPasswordLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 25));

        RoundedJPasswordField confirmPasswordField = new RoundedJPasswordField(10);
        confirmPasswordField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        confirmPasswordField.setHorizontalAlignment(RoundedJTextField.CENTER);

        JComponent passwordBoxComponents[] = {passwordLabel, passwordField, confirmPasswordLabel, confirmPasswordField};
        Box authBox = AddToBox.addToHorizontalBox(passwordBoxComponents, 2);

        // User Type Setup
        String[] userTypes = {"", "Student", "Instructor", "Admin"};
        JLabel userTypeLabel = new JLabel("User Type");
        userTypeLabel.setForeground(Color.WHITE);
        userTypeLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        JComboBox<String> userTypeSelection = new JComboBox<>(userTypes);
        userTypeSelection.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));

        JComponent userTypeBoxComponents[] = {userTypeLabel, userTypeSelection};
        Box userTypeBox = AddToBox.addToHorizontalBox(userTypeBoxComponents, 1);

        // Register Button Setup
        nextButton = new BlueButton("Next");

        components.put("firstName", firstNameField);
        components.put("lastName", lastNameField);
        components.put("username", usernameField);
        components.put("email", emailField);
        components.put("password", passwordField);
        components.put("confirmPassword", confirmPasswordField);
        components.put("role", userTypeSelection);

        // JPanel for ComboBox and Register Button
        JPanel bottomPanel = new VerticalPanel(userTypeBox, nextButton);

        // Add Components to Register Panel
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(0, 50, 0, 50);
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

    private void HandlerSetter(Map<String, JComponent> components, int Width, int Height, JFrame frame)
    {
        Map<String, JPanel> panels = new Hashtable<>();

        panels.put("previous", wrapper);

        nextButton.addActionListener(new RegisterHandler(components, panels, frame));
    }

}
