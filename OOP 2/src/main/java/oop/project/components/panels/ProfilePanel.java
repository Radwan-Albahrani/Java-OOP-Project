package oop.project.components.panels;

import java.awt.Dimension;
import java.awt.Font;
import oop.project.colors.ThemeColors;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;

import oop.project.components.buttons.CustomButtonInstructor;
import oop.project.components.core.RoundedJTextField;
import oop.project.components.core.TitleLabel;
import oop.project.handlers.*;
import oop.project.hooks.*;
import com.k33ptoo.components.KButton;

public class ProfilePanel extends TransparentPanel
{
    public ProfilePanel(int Width, int Height)
    {
        // Label Setup
        JLabel profileLabel = new TitleLabel("Here is your profile");

        // Picture Setup
        JLabel picture = FrameConfig.getPicture("/DefaultProfilePicture.png", 0.2);

        // Personal Information Setup
        // ID Setup
        JLabel idLabel = new JLabel("ID");
        idLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        idLabel.setAlignmentX(CENTER_ALIGNMENT);
        idLabel.setForeground(ThemeColors.BLACK);

        RoundedJTextField idField = new RoundedJTextField(15);
        idField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        idField.setMinimumSize(new Dimension(400, 50));
        idField.setMaximumSize(new Dimension(400, 50));
        idField.setEditable(false);
        idField.setAlignmentX(LEFT_ALIGNMENT);

        JComponent[] idComponents = {idLabel, idField};
        Box idBox = AddToBox.addToVerticalBox(idComponents, 1);

        // Name Setup
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        nameLabel.setAlignmentX(CENTER_ALIGNMENT);
        nameLabel.setForeground(ThemeColors.BLACK);

        RoundedJTextField nameField = new RoundedJTextField(15);
        nameField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        nameField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        nameField.setEditable(false);
        nameField.setMinimumSize(new Dimension(400, 50));
        nameField.setMaximumSize(new Dimension(400, 50));
        nameField.setAlignmentX(LEFT_ALIGNMENT);

        JComponent[] nameComponents = {nameLabel, nameField};
        Box nameBox = AddToBox.addToVerticalBox(nameComponents, 1);

        // Birthday Setup
        JLabel birthdayLabel = new JLabel("Birthday");
        birthdayLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        birthdayLabel.setAlignmentX(RIGHT_ALIGNMENT);
        birthdayLabel.setForeground(ThemeColors.BLACK);

        RoundedJTextField birthdayField = new RoundedJTextField(15);
        birthdayField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        birthdayField.setEditable(false);
        birthdayField.setMinimumSize(new Dimension(400, 50));
        birthdayField.setMaximumSize(new Dimension(400, 50));
        birthdayField.setAlignmentX(LEFT_ALIGNMENT);

        JComponent[] birthdayComponents = {birthdayLabel, birthdayField};
        Box birthdayBox = AddToBox.addToVerticalBox(birthdayComponents, 1);

        // Gender Setup
        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        genderLabel.setAlignmentX(CENTER_ALIGNMENT);
        genderLabel.setForeground(ThemeColors.BLACK);

        RoundedJTextField genderField = new RoundedJTextField(15);
        genderField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        genderField.setEditable(false);
        genderField.setMinimumSize(new Dimension(400, 50));
        genderField.setMaximumSize(new Dimension(400, 50));
        genderField.setAlignmentX(LEFT_ALIGNMENT);

        JComponent[] genderComponents = {genderLabel, genderField};
        Box genderBox = AddToBox.addToVerticalBox(genderComponents, 1);

        // Personal Information Box Setup
        JComponent[] nameIdComponents = {idBox, nameBox};
        Box nameIdBox = AddToBox.addToVerticalBox(nameIdComponents, 2);

        JComponent[] birthGenderComponents = {birthdayBox, genderBox};
        Box birthGenderBox = AddToBox.addToVerticalBox(birthGenderComponents, 2);

        JComponent[] personalInfoComponents = {nameIdBox, birthGenderBox};
        Box personalInfoBox = AddToBox.addToVerticalBox(personalInfoComponents, 1);

        JComponent[] pictureBoxComponents = {personalInfoBox, picture};
        personalInfoBox = AddToBox.addToVerticalBox(pictureBoxComponents, 2);

        // Work Information Setup
        // Occupation Setup
        JLabel occupationLabel = new JLabel("Occupation");
        occupationLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        occupationLabel.setAlignmentX(CENTER_ALIGNMENT);
        occupationLabel.setForeground(ThemeColors.BLACK);

        RoundedJTextField occupationField = new RoundedJTextField(15);
        occupationField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        occupationField.setEditable(false);
        occupationField.setMinimumSize(new Dimension(400, 50));
        occupationField.setMaximumSize(new Dimension(400, 50));
        occupationField.setAlignmentX(LEFT_ALIGNMENT);

        JComponent[] occupationComponents = {occupationLabel, occupationField};
        Box occupationBox = AddToBox.addToVerticalBox(occupationComponents, 1);

        // Major Setup
        JLabel majorLabel = new JLabel("Major");
        majorLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        majorLabel.setAlignmentX(CENTER_ALIGNMENT);
        majorLabel.setForeground(ThemeColors.BLACK);

        RoundedJTextField majorField = new RoundedJTextField(15);
        majorField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        majorField.setEditable(false);
        majorField.setMinimumSize(new Dimension(400, 50));
        majorField.setMaximumSize(new Dimension(400, 50));
        majorField.setAlignmentX(LEFT_ALIGNMENT);

        JComponent[] majorComponents = {majorLabel, majorField};
        Box majorBox = AddToBox.addToVerticalBox(majorComponents, 1);

        // Email Setup
        JLabel emailLabel = new JLabel("Emails", SwingConstants.LEFT);
        emailLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        emailLabel.setAlignmentX(CENTER_ALIGNMENT);
        emailLabel.setForeground(ThemeColors.BLACK);

        RoundedJTextField workEmailField = new RoundedJTextField(15);
        workEmailField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        workEmailField.setEditable(false);
        workEmailField.setMinimumSize(new Dimension(400, 50));
        workEmailField.setMaximumSize(new Dimension(400, 50));
        workEmailField.setAlignmentX(CENTER_ALIGNMENT);

        RoundedJTextField personalEmailField = new RoundedJTextField(15);
        personalEmailField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        personalEmailField.setMinimumSize(new Dimension(400, 50));
        personalEmailField.setMaximumSize(new Dimension(400, 50));
        personalEmailField.setAlignmentX(LEFT_ALIGNMENT);

        JComponent[] emailComponents = {emailLabel, workEmailField, personalEmailField};
        Box emailBox = AddToBox.addToVerticalBox(emailComponents, 1);

        // Phone Setup
        JLabel phoneLabel = new JLabel("Phones", SwingConstants.LEFT);
        phoneLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        phoneLabel.setAlignmentX(RIGHT_ALIGNMENT);
        phoneLabel.setForeground(ThemeColors.BLACK);

        RoundedJTextField workPhoneField = new RoundedJTextField(15);
        workPhoneField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        workPhoneField.setEditable(false);
        workPhoneField.setMinimumSize(new Dimension(400, 50));
        workPhoneField.setMaximumSize(new Dimension(400, 50));
        workPhoneField.setAlignmentX(LEFT_ALIGNMENT);

        RoundedJTextField personalPhoneField = new RoundedJTextField(15);
        personalPhoneField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        personalPhoneField.setMinimumSize(new Dimension(400, 50));
        personalPhoneField.setMaximumSize(new Dimension(400, 50));
        personalPhoneField.setAlignmentX(LEFT_ALIGNMENT);

        JComponent[] phoneComponents = {phoneLabel, workPhoneField, personalPhoneField};
        Box phoneBox = AddToBox.addToVerticalBox(phoneComponents, 1);

        // Reset Password Button
        KButton resetPasswordButton = new CustomButtonInstructor("Reset Password");
        resetPasswordButton.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        resetPasswordButton.setMinimumSize(new Dimension(200, 50));
        resetPasswordButton.setMaximumSize(new Dimension(200, 50));
        resetPasswordButton.setAlignmentX(RIGHT_ALIGNMENT);
        resetPasswordButton.setForeground(ThemeColors.BLACK);

        JComponent[] resetPasswordComponents = {resetPasswordButton};
        Box resetPasswordBox = AddToBox.addToVerticalBox(resetPasswordComponents, 1);

        // Save Changes Button
        KButton saveChangesButton = new CustomButtonInstructor("Save Changes");
        saveChangesButton.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        saveChangesButton.setMinimumSize(new Dimension(200, 50));
        saveChangesButton.setMaximumSize(new Dimension(200, 50));
        saveChangesButton.setAlignmentX(RIGHT_ALIGNMENT);
        saveChangesButton.setForeground(ThemeColors.BLACK);

        JComponent[] saveChangesComponents = {saveChangesButton};
        Box saveChangesBox = AddToBox.addToVerticalBox(saveChangesComponents, 1);

        // Work Information Box Setup
        JComponent[] professionalInfoComponents = {occupationBox, majorBox};
        Box professionalInfoBox = AddToBox.addToVerticalBox(professionalInfoComponents, 2);

        JComponent[] contactInfoComponents = {emailBox, phoneBox};
        Box contactInfoBox = AddToBox.addToVerticalBox(contactInfoComponents, 2);

        JComponent[] workInfoComponents = {professionalInfoBox, contactInfoBox};
        Box workInfoBox = AddToBox.addToVerticalBox(workInfoComponents, 1);

        JComponent[] buttonComponents = {resetPasswordBox, saveChangesBox};
        Box buttonBox = AddToBox.addToHorizontalBox(buttonComponents, 1);

        // Add to Panel
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.2;
        c.weighty = 0.2;
        c.insets = new Insets(0, 25, 0, 25);
        this.add(profileLabel, c);
        c.weightx = 0.2;
        c.weighty = 0.2;
        c.gridy = 1;
        this.add(personalInfoBox, c);
        c.insets = new Insets(0, 25, 0, 300);
        c.gridy = 2;
        this.add(workInfoBox, c);
        c.gridy = 3;
        this.add(buttonBox, c);

        // Button Handler
        resetPasswordButton.addActionListener(new ResetPasswordHandler(this));
        saveChangesButton.addActionListener(new SaveChangesHandler());
    }
}