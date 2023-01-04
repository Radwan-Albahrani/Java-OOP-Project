package oop.project.screens;

import javax.swing.*;
import java.awt.*;
import com.k33ptoo.components.*;

import oop.project.App;
import oop.project.screens.components.*;
import oop.project.screens.hooks.*;
import oop.project.handlers.*;

public class RegisterScreen extends JFrame
{
    public RegisterScreen()
    {
        super("Register");

        // Frame Setup
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        setSize(screenWidth, screenHeight);
        setLocationRelativeTo(null);
        setResizable(false);
        Image icon = new ImageIcon(App.Path + "AppIcon.jpg").getImage();
        setIconImage(icon);

        // Background Setup
        Image backgroundImage = new ImageIcon(App.Path + "RegisterScreen/background.png").getImage();
        int width = getWidth();
        int height = getHeight();
        Image scaledBackgroundImage = backgroundImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(scaledBackgroundImage));
        setContentPane(background);

        // Register Panel Setup
        KGradientPanel registerPanel = new ThemedPanel();
        registerPanel.setPreferredSize(new Dimension((int) (getWidth() / 2), (int) (getHeight() / 1.4)));
        registerPanel.setSize(getPreferredSize());
        registerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 10));

        // Register Label Setup
        JLabel registerLabel = new JLabel("Registration");
        registerLabel.setForeground(Color.WHITE);
        registerLabel.setFont(new Font("Arial", Font.BOLD, 30));
        registerLabel.setHorizontalAlignment(JLabel.CENTER);
        registerLabel.setHorizontalTextPosition(JLabel.CENTER);

        // Picture Setup
        Image image = new ImageIcon(App.Path + "RegisterScreen/RegisterScreenIcon.png").getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
        Image scaledImage = image.getScaledInstance((int) (width / 2.5), (int) (height / 2.5), Image.SCALE_SMOOTH);
        JLabel picture = new JLabel(new ImageIcon(scaledImage));

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

        JComponent userBoxComponents[] = {usernameLabel, usernameField};
        Box userBox = AddToBox.addToHorizontalBox(userBoxComponents, 2);

        // Email Label and Field Setup
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JTextField emailField = new JTextField(31);
        emailField.setFont(new Font("Arial", Font.PLAIN, 20));
        emailField.setHorizontalAlignment(JTextField.CENTER);
        emailField.setEditable(false);

        JComponent emailBoxComponents[] = {emailLabel, emailField};
        Box emailBox = AddToBox.addToHorizontalBox(emailBoxComponents, 2);

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
        userTypeSelection.setPrototypeDisplayValue("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        JComponent userTypeBoxComponents[] = {userTypeLabel, userTypeSelection};
        Box userTypeBox = AddToBox.addToHorizontalBox(userTypeBoxComponents, 1);

        // Register Button Setup
        KButton registerButton = new BlueButton("Register");

        // JPanel for ComboBox and Register Button
        JPanel bottomPanel = new VerticalPanel(userTypeBox, registerButton);

        // Add Components to Register Panel
        registerPanel.add(registerTopFrame);
        registerPanel.add(nameBox);
        registerPanel.add(userBox);
        registerPanel.add(emailBox);
        registerPanel.add(authBox);
        registerPanel.add(bottomPanel);

        // Add Register Panel to Frame
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(0, 10, 0, 10);
        constraints.fill = GridBagConstraints.NONE;
        add(registerPanel, constraints);

        setVisible(true);
    }
}
