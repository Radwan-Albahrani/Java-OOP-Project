package oop.project.screens.RegisterScreen.Panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.*;

import javax.swing.*;

import com.github.lgooddatepicker.components.*;
import com.k33ptoo.components.*;

import oop.project.components.*;
import oop.project.components.MiniComponents.EmailTextField;
import oop.project.components.MiniComponents.PhoneTextField;
import oop.project.handlers.RegisterHandler;
import oop.project.hooks.*;

public class ProfileRegisterPanel extends ThemedPanelGeneric
{
    KButton registerButton;
    JPanel wrapper;

    public void setWrapper(JPanel wrapper)
    {
        this.wrapper = wrapper;
    }

    List<JComponent> components = new ArrayList<>();

    public ProfileRegisterPanel(int Width, int Height)
    {
        // Profile Label Setup
        JLabel profileLabel = new TitleLabel("Profile");

        // Picture Setup
        JLabel picture = FrameConfig.getPicture("RegisterScreen/RegisterScreenIcon.png", 0.45);

        // Register Top Frame Setup
        JPanel registerTopFrame = new VerticalPanel(profileLabel, picture);

        // Name and Surname Label and Field Setup
        JLabel sexLabel = new JLabel("Sex");
        sexLabel.setForeground(Color.WHITE);
        sexLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        sexLabel.setHorizontalAlignment(JLabel.LEFT);
        sexLabel.setHorizontalTextPosition(JLabel.LEFT);
        sexLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);

        String[] sexTypes = {"", "Male", "Female"};
        JComboBox<String> sexType = new JComboBox<>(sexTypes);
        sexType.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        sexType.setAlignmentX(JLabel.LEFT_ALIGNMENT);

        JLabel birthdayLabel = new JLabel("Birthday");
        birthdayLabel.setForeground(Color.WHITE);
        birthdayLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        birthdayLabel.setHorizontalAlignment(JLabel.LEFT);
        birthdayLabel.setHorizontalTextPosition(JLabel.LEFT);
        birthdayLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);

        DatePicker birthdayField = new DatePicker();
        birthdayField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        birthdayField.setAlignmentX(JLabel.LEFT_ALIGNMENT);

        JComponent birthComponents[] = {sexLabel, sexType, birthdayLabel, birthdayField};
        Box birthBox = AddToBox.addToHorizontalBox(birthComponents, 2);

        // Username Label and Field Setup
        JLabel MajorLabel = new JLabel("Major");
        MajorLabel.setForeground(Color.WHITE);
        MajorLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        MajorLabel.setHorizontalAlignment(JLabel.LEFT);

        String[] majors = {"", "Engineering", "Business", "Arts", "Science", "Education", "Medicine", "Law", "Other"};
        JComboBox<String> MajorComboBox = new JComboBox<String>(majors);
        MajorComboBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        sexLabel.setHorizontalAlignment(JLabel.CENTER);
        sexLabel.setHorizontalTextPosition(JLabel.CENTER);

        // Email Label and Field Setup
        JLabel PersonalEmailLabel = new JLabel("Personal Email");
        PersonalEmailLabel.setForeground(Color.WHITE);
        PersonalEmailLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        PersonalEmailLabel.setHorizontalAlignment(JLabel.LEFT);

        EmailTextField emailField = new EmailTextField(31);
        emailField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        emailField.setHorizontalAlignment(RoundedJTextField.CENTER);

        JLabel occupation = new JLabel("Occupation");
        occupation.setForeground(Color.WHITE);
        occupation.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        occupation.setHorizontalAlignment(JLabel.LEFT);

        RoundedJTextField occupationField = new RoundedJTextField(31);
        occupationField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        occupationField.setHorizontalAlignment(RoundedJTextField.CENTER);

        JLabel phoneLabel = new JLabel("Phone Number");
        phoneLabel.setForeground(Color.WHITE);
        phoneLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        phoneLabel.setHorizontalAlignment(JLabel.LEFT);

        PhoneTextField phoneField = new PhoneTextField(31);
        phoneField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        phoneField.setHorizontalAlignment(RoundedJTextField.CENTER);

        JComponent professionalBoxComponents[] = {MajorLabel, MajorComboBox, PersonalEmailLabel, emailField, occupation,
                occupationField, phoneLabel, phoneField};
        Box professionalBox = AddToBox.addToVerticalBox(professionalBoxComponents, 1);

        // Add components
        components.add(sexType);
        components.add(birthdayField);
        components.add(MajorComboBox);
        components.add(emailField);
        components.add(occupationField);
        components.add(phoneField);

        registerButton = new BlueButton("Register");

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
        this.add(birthBox, c);
        c.gridy = 2;
        this.add(professionalBox, c);
        c.gridy = 3;
        c.insets = new Insets(10, 100, 0, 100);
        this.add(registerButton, c);
    }

    public void setHandler(RegisterHandler handler)
    {
        registerButton.addActionListener(handler);
        handler.setComponents(components);
    }

}
