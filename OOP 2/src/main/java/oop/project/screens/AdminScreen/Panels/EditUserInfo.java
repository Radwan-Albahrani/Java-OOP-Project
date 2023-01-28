package oop.project.screens.AdminScreen.Panels;

import java.awt.Dimension;
import java.awt.Font;

import oop.project.API.DatabaseCon;
import oop.project.colors.ThemeColors;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

import oop.project.handlers.NextPreviousHandler;

import javax.swing.*;
import com.k33ptoo.components.KButton;

import oop.project.components.buttons.CustomButtonAdmin;
import oop.project.components.core.RoundedJTextField;
import oop.project.components.core.TitleLabel;
import oop.project.components.panels.TransparentPanel;
import oop.project.hooks.*;
import oop.project.models.UserModel;

public class EditUserInfo extends TransparentPanel
{
    List<UserModel> users;
    int currentEntryIndex;
    RoundedJTextField nameField;
    JComboBox<String> idJComboBoxList;
    RoundedJTextField birthDateField;
    RoundedJTextField genderField;
    RoundedJTextField occupationField;
    RoundedJTextField majorField;
    RoundedJTextField workEmailField;
    RoundedJTextField personalEmailField;
    RoundedJTextField workPhoneField;
    RoundedJTextField personalPhoneField;

    public EditUserInfo(int Width, int Height)
    {
        users = DatabaseCon.getAllUsersFull();

        JLabel Edit_User_info = new TitleLabel("Edit Information");
        Edit_User_info.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        // Picture Setup
        JLabel picture = FrameConfig.getPicture("/DefaultProfilePicture.png", 0.2);
        picture.setAlignmentX(CENTER_ALIGNMENT);

        // Personal Information Setup
        // ID Setup
        JLabel idLabel = new JLabel("ID");
        idLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        idLabel.setAlignmentX(CENTER_ALIGNMENT);
        idLabel.setForeground(ThemeColors.BLACK);

        idJComboBoxList = new JComboBox<String>();
        idJComboBoxList.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        idJComboBoxList.setMinimumSize(new Dimension(1000, 50));
        idJComboBoxList.setMaximumSize(new Dimension(1000, 50));
        idJComboBoxList.setAlignmentX(RIGHT_ALIGNMENT);

        idJComboBoxList.setPrototypeDisplayValue("XXXXXXXXXXXXXXXXX");
        for (int i = 0; i < users.size(); i++)
        {
            idJComboBoxList.addItem("" + users.get(i).getUserID());
        }

        JComponent[] idComponents = {idLabel, idJComboBoxList};
        Box idBox = AddToBox.addToVerticalBox(idComponents, 1);

        // Name Setup
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        nameLabel.setAlignmentX(CENTER_ALIGNMENT);
        nameLabel.setForeground(ThemeColors.BLACK);

        nameField = new RoundedJTextField(15);
        nameField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        nameField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        nameField.setMinimumSize(new Dimension(400, 50));
        nameField.setMaximumSize(new Dimension(400, 50));
        nameField.setAlignmentX(LEFT_ALIGNMENT);

        JComponent[] nameComponents = {nameLabel, nameField};
        Box nameBox = AddToBox.addToVerticalBox(nameComponents, 1);

        // BirthDate Setup
        JLabel birthDateLabel = new JLabel("Date Of Birth");
        birthDateLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        birthDateLabel.setAlignmentX(RIGHT_ALIGNMENT);
        birthDateLabel.setForeground(ThemeColors.BLACK);

        birthDateField = new RoundedJTextField(15);
        birthDateField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        birthDateField.setMinimumSize(new Dimension(400, 50));
        birthDateField.setMaximumSize(new Dimension(400, 50));
        birthDateField.setAlignmentX(LEFT_ALIGNMENT);

        JComponent[] birthDateComponents = {birthDateLabel, birthDateField};
        Box birthDateBox = AddToBox.addToVerticalBox(birthDateComponents, 1);

        // Gender Setup
        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        genderLabel.setAlignmentX(CENTER_ALIGNMENT);
        genderLabel.setForeground(ThemeColors.BLACK);

        genderField = new RoundedJTextField(15);
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

        JComponent[] birthGenderComponents = {birthDateBox, genderBox};
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

        occupationField = new RoundedJTextField(15);
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

        majorField = new RoundedJTextField(15);
        majorField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
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

        workEmailField = new RoundedJTextField(15);
        workEmailField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        workEmailField.setEditable(false);
        workEmailField.setMinimumSize(new Dimension(400, 50));
        workEmailField.setMaximumSize(new Dimension(400, 50));
        workEmailField.setAlignmentX(CENTER_ALIGNMENT);

        personalEmailField = new RoundedJTextField(15);
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

        workPhoneField = new RoundedJTextField(15);
        workPhoneField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        workPhoneField.setMinimumSize(new Dimension(400, 50));
        workPhoneField.setMaximumSize(new Dimension(400, 50));
        workPhoneField.setAlignmentX(LEFT_ALIGNMENT);

        personalPhoneField = new RoundedJTextField(15);
        personalPhoneField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        personalPhoneField.setMinimumSize(new Dimension(400, 50));
        personalPhoneField.setMaximumSize(new Dimension(400, 50));
        personalPhoneField.setAlignmentX(LEFT_ALIGNMENT);

        JComponent[] phoneComponents = {phoneLabel, workPhoneField, personalPhoneField};
        Box phoneBox = AddToBox.addToVerticalBox(phoneComponents, 1);



        // Work Information Box Setup
        JComponent[] professionalInfoComponents = {occupationBox, majorBox};
        Box professionalInfoBox = AddToBox.addToVerticalBox(professionalInfoComponents, 2);

        JComponent[] contactInfoComponents = {emailBox, phoneBox};
        Box contactInfoBox = AddToBox.addToVerticalBox(contactInfoComponents, 2);

        JComponent[] workInfoComponents = {professionalInfoBox, contactInfoBox};
        Box workInfoBox = AddToBox.addToVerticalBox(workInfoComponents, 1);


        // Operational Buttons
        KButton nextButton = new CustomButtonAdmin("—>", 100, 50);
        nextButton.setActionCommand("next");
        nextButton.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        nextButton.setAlignmentX(LEFT_ALIGNMENT);
        KButton previousButton = new CustomButtonAdmin("<—", 100, 50);
        previousButton.setActionCommand("previous");
        previousButton.setAlignmentX(RIGHT_ALIGNMENT);
        previousButton.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        //Save Buttons
        KButton saveButton = new CustomButtonAdmin("Save");
        saveButton.setAlignmentX(CENTER_ALIGNMENT);
        saveButton.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        saveButton.setMinimumSize(new Dimension(200, 50));
        saveButton.setMaximumSize(new Dimension(200, 50));
        saveButton.setAlignmentX(RIGHT_ALIGNMENT);
        saveButton.setForeground(ThemeColors.BLACK);

        JComponent[] buttonsComponents = {previousButton, nextButton};
        Box buttonsBox = AddToBox.addToVerticalBox(buttonsComponents, 2);
        buttonsBox.setAlignmentX(CENTER_ALIGNMENT);

        JComponent [] buttonsComponents2 = {buttonsBox, saveButton};
        buttonsBox = AddToBox.addToVerticalBox(buttonsComponents2, 1);


        // Add to Panel
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.2;
        c.weighty = 0.2;
        c.insets = new Insets(0, 25, 0, 25);
        this.add(Edit_User_info, c);
        c.weightx = 0.2;
        c.weighty = 0.2;
        c.gridy = 1;
        this.add(personalInfoBox, c);
        c.insets = new Insets(0, 25, 0, 300);
        c.gridy = 2;
        this.add(workInfoBox, c);
        c.gridy = 3;
        this.add(buttonsBox, c);

        // Button Handlers
        saveButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    System.err.println("Save Button Clicked");
                        Long id = users.get(currentEntryIndex).getUserID();
                        String name[] = nameField.getText().split(" ");
                        String fname = name[0];
                        String lname = name[1];
                        String birthdate = birthDateField.getText();
                        String personalemail = personalEmailField.getText();
                        String personalphone = personalPhoneField.getText();
                        String workphone = workPhoneField.getText();
                        String major = majorField.getText();
                    try
                    {
                        DatabaseCon.updateUserInfo(id, fname, lname, birthdate, major, personalphone, personalemail, workphone);
                        JOptionPane.showMessageDialog(null, "User Info updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    }
                    catch (Exception e1)
                    {
                        JOptionPane.showMessageDialog(null, "User Info could not be updated!, " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        nextButton.addActionListener(
                new NextPreviousHandler(idJComboBoxList));

        previousButton.addActionListener(
                new NextPreviousHandler(idJComboBoxList));

        idJComboBoxList.addActionListener(new ActionListener()
        {
            @Override
                public void actionPerformed(ActionEvent e) {
                setProfile(users.get(idJComboBoxList.getSelectedIndex()));
            }
        });
    }

    public void setProfile(UserModel user)
    {
        if (user == null)
        {
            System.out.println("User is null");
            return;
        }
        // Set Name
        nameField.setText(user.getFirstName() + " " + user.getLastName());

        // Set ID
        idJComboBoxList.setSelectedItem(Long.toString(user.getUserID()));

        // Set Birth Date
        birthDateField.setText(user.getBirthDate());

        // set gender
        genderField.setText(user.getGender());

        // Set Occupation
        occupationField.setText(user.getRole());

        // Set Major
        majorField.setText(user.getMajor());

        // Set Work Email
        workEmailField.setText(user.getEmail());

        // Set Personal Email
        personalEmailField.setText(user.getPersonalEmail());

        // Set Work Phone
        workPhoneField.setText(user.getPhoneNumber());

        // Set Personal Phone
        personalPhoneField.setText(user.getPersonalPhoneNumber());
    }
}
