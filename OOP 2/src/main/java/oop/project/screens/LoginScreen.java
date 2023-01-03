package oop.project.screens;

import javax.swing.*;
import java.awt.*;
import com.k33ptoo.components.*;

import oop.project.App;
import oop.project.screens.components.*;

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
        super("Login");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        // Frame Setup
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(screenWidth / 2, (int) (screenHeight / 1.2));
        setLocationRelativeTo(null);
        setResizable(false);
        Image icon = new ImageIcon(App.Path + "LoginScreen/AppIcon.jpg").getImage();
        setIconImage(icon);

        // Background Setup
        Image backgroundImage = new ImageIcon(App.Path + "LoginScreen/backgroundBlurred.png").getImage();
        int width = getWidth();
        int height = getHeight();
        int newWidth = width;
        int newHeight = height;
        Image scaledBackgroundImage = backgroundImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(scaledBackgroundImage));
        setContentPane(background);

        // Login Panel Setup
        loginPanel = new ThemedPanel();
        loginPanel.setPreferredSize(new Dimension((int) (getWidth() / 3), (int) (getHeight() / 2.2)));
        loginPanel.setSize(getPreferredSize());

        // Login Label Setup
        loginLabel = new JLabel("Student Information System");
        loginLabel.setForeground(Color.WHITE);
        loginLabel.setFont(new Font("Arial", Font.BOLD, 30));

        // Picture Setup
        Image image = new ImageIcon(App.Path + "LoginScreen/loginScreenIcon.png").getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
        newWidth = width / 3;
        newHeight = height / 3;
        Image scaledImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
        picture = new JLabel(scaledImageIcon);

        // Username Setup
        usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 20));

        // Username Field Setup
        usernameField = new JTextField(15);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 20));
        usernameField.setHorizontalAlignment(JTextField.CENTER);

        // Password Setup
        passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 20));

        // Password Field Setup
        passwordField = new JPasswordField(15);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 20));
        passwordField.setHorizontalAlignment(JTextField.CENTER);
        passwordField.setSize(300, 50);

        // Login Button Setup
        loginButton = new BlueButton("Login");

        // Register Button Setup
        registerButton = new BlueButton("Register");

        // Adding Components to Login Panel
        loginPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Login Top Panel Setup
        JPanel loginTop = new JPanel();
        loginTop.setOpaque(false);
        loginTop.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
        loginTop.setPreferredSize(new Dimension(400, 220));
        loginTop.setSize(getPreferredSize());
        loginTop.add(loginLabel);
        loginTop.add(picture);

        loginPanel.add(loginTop);
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        loginPanel.add(registerButton);

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(0, 10, 0, 10);
        constraints.fill = GridBagConstraints.NONE;
        add(loginPanel, constraints);

        setVisible(true);
    }
}
