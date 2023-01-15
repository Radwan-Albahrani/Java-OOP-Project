package oop.project.screens.InstructorScreen.Panels;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;
import com.k33ptoo.components.KButton;
import oop.project.components.*;
import oop.project.hooks.*;

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
        JLabel idLabel = new JLabel("ID: " );
        idLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        idLabel.setHorizontalAlignment(JLabel.CENTER);
        idLabel.setHorizontalTextPosition(JLabel.CENTER);


        RoundedJTextField idField = new RoundedJTextField(15);
        idField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        idField.setMinimumSize(new Dimension(400, 50));
        idField.setMaximumSize(new Dimension(400, 50));
        idField.setEditable(false);

        JComponent[] idComponents = {idLabel, idField};
        Box idBox = AddToBox.addToHorizontalBox(idComponents, 1);

        // Name Setup
        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));

        RoundedJTextField nameField = new RoundedJTextField(15);
        nameField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        nameField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        nameField.setEditable(false);
        nameField.setMinimumSize(new Dimension(400, 50));
        nameField.setMaximumSize(new Dimension(400, 50));
        nameField.setAlignmentX(LEFT_ALIGNMENT);

        JComponent[] nameComponents = {nameLabel, nameField};
        Box nameBox = AddToBox.addToHorizontalBox(nameComponents, 1);


        // Birthday Setup
        JLabel birthdayLabel = new JLabel("Birthday: ");
        birthdayLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));

        RoundedJTextField birthdayField = new RoundedJTextField(15);
        birthdayField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        birthdayField.setEditable(false);
        birthdayField.setMinimumSize(new Dimension(300, 50));
        birthdayField.setMaximumSize(new Dimension(300, 50));
        birthdayField.setAlignmentX(LEFT_ALIGNMENT);

        JComponent[] birthdayComponents = {birthdayLabel, birthdayField};
        Box birthdayBox = AddToBox.addToHorizontalBox(birthdayComponents, 1);

        // Gender Setup
        JLabel genderLabel = new JLabel("Gender: " );
        genderLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));

        RoundedJTextField genderField = new RoundedJTextField(15);
        genderField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        genderField.setEditable(false);
        genderField.setMinimumSize(new Dimension(250, 50));
        genderField.setMaximumSize(new Dimension(250, 50));
        genderField.setAlignmentX(LEFT_ALIGNMENT);

        JComponent[] genderComponents = {genderLabel, genderField};
        Box genderBox = AddToBox.addToHorizontalBox(genderComponents, 1);

        // Personal Information Box Setup
        JComponent[] nameidComponents = {idBox, nameBox};
        Box nameidBox = AddToBox.addToVerticalBox(nameidComponents, 2);

        JComponent[] birthgenderComponents = {birthdayBox, genderBox};
        Box birthgenderBox = AddToBox.addToVerticalBox(birthgenderComponents, 2);

        JComponent[] personalInfoComponents = {nameidBox, birthgenderBox};
        Box personalInfoBox = AddToBox.addToVerticalBox(personalInfoComponents, 1);

        JComponent[] pictureBoxComponents = {personalInfoBox, picture};
        Box pictureBox = AddToBox.addToVerticalBox(pictureBoxComponents, 2);

        // Work Information Setup
        // Occupation Setup
        JLabel occupationLabel = new JLabel("Occupation: " );
        occupationLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        
        RoundedJTextField occupationField = new RoundedJTextField(15);
        occupationField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        occupationField.setEditable(false);
        occupationField.setMinimumSize(new Dimension(400, 50));
        occupationField.setMaximumSize(new Dimension(400, 50));
        occupationField.setAlignmentX(LEFT_ALIGNMENT);

        JComponent[] occupationComponents = {occupationLabel, occupationField};
        Box occupationBox = AddToBox.addToHorizontalBox(occupationComponents, 1);

        // Major Setup
        JLabel majorLabel = new JLabel("Major: " );
        majorLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));

        RoundedJTextField majorField = new RoundedJTextField(15);
        majorField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        majorField.setEditable(false);
        majorField.setMinimumSize(new Dimension(400, 50));
        majorField.setMaximumSize(new Dimension(400, 50));
        majorField.setAlignmentX(LEFT_ALIGNMENT);


        JComponent[] majorComponents = {majorLabel, majorField};
        Box majorBox = AddToBox.addToHorizontalBox(majorComponents, 1);

        // Email Setup
        JLabel emailLabel = new JLabel("Emails", SwingConstants.LEFT);
        emailLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
       
        RoundedJTextField workEmailField = new RoundedJTextField(15);
        workEmailField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        workEmailField.setEditable(false);
        workEmailField.setMinimumSize(new Dimension(400, 50));
        workEmailField.setMaximumSize(new Dimension(400, 50));
        workEmailField.setAlignmentX(CENTER_ALIGNMENT);

        RoundedJTextField personalEmailField = new RoundedJTextField(15);
        personalEmailField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        personalEmailField.setEditable(false);
        personalEmailField.setMinimumSize(new Dimension(400, 50));
        personalEmailField.setMaximumSize(new Dimension(400, 50));
        personalEmailField.setAlignmentX(CENTER_ALIGNMENT);

        JComponent[] emailComponents = {emailLabel, workEmailField, personalEmailField};
        Box emailBox = AddToBox.addToHorizontalBox(emailComponents, 3);

        // Phone Setup
        JLabel phoneLabel = new JLabel("Phones", SwingConstants.LEFT);
        phoneLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));

        RoundedJTextField workPhoneField = new RoundedJTextField(15);
        workPhoneField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        workPhoneField.setEditable(false);
        workPhoneField.setMinimumSize(new Dimension(400, 50));
        workPhoneField.setMaximumSize(new Dimension(400, 50));
        workPhoneField.setAlignmentX(CENTER_ALIGNMENT);

        RoundedJTextField personalPhoneField = new RoundedJTextField(15);
        personalPhoneField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        personalPhoneField.setEditable(false);
        personalPhoneField.setMinimumSize(new Dimension(400, 50));
        personalPhoneField.setMaximumSize(new Dimension(400, 50));
        personalPhoneField.setAlignmentX(CENTER_ALIGNMENT);
        
        
        JComponent[] phoneComponents = {phoneLabel, workPhoneField, personalPhoneField};
        Box phoneBox = AddToBox.addToHorizontalBox(phoneComponents, 3);

        // Work Information Box Setup
        JComponent[] occmajorComponents = {occupationBox, majorBox};
        Box occmajorBox = AddToBox.addToVerticalBox(occmajorComponents, 2);

        JComponent[] emailphoneComponents = {emailBox, phoneBox};
        Box emailphoneBox = AddToBox.addToVerticalBox(emailphoneComponents, 2);


        // Add to Panel
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.2;
        c.weighty = 0.2;
        c.insets = new Insets(0, 20, 0, 20);
        this.add(profileLabel, c);
        c.weightx = 0.2;
        c.weighty = 0.2;
        c.gridy = 1;
        this.add(pictureBox, c);
        c.gridy = 2;
        this.add(occmajorBox, c);
        c.gridy = 3;
        this.add(emailphoneBox, c);
        c.insets = new Insets(0, 0, 0, 0);
    }
}
