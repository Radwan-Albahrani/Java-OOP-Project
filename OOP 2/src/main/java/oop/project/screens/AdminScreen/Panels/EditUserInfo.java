package oop.project.screens.AdminScreen.Panels;

import java.awt.Dimension;
import java.awt.Font;
import oop.project.colors.ThemeColors;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import oop.project.handlers.NextPreviousHandler;

import javax.swing.*;
import com.k33ptoo.components.KButton;

import oop.project.components.buttons.CustomButtonAdmin;
import oop.project.components.core.RoundedJTextField;
import oop.project.components.core.TitleLabel;
import oop.project.components.panels.TransparentPanel;
import oop.project.handlers.*;
import oop.project.hooks.*;

public class EditUserInfo extends TransparentPanel
{

    public EditUserInfo(int Width, int Height)
    {

        JLabel Edit_User_info = new TitleLabel("Edit Information");
        Edit_User_info.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        // Picture Setup
        JLabel picture = FrameConfig.getPicture("/DefaultProfilePicture.png", 0.2);
        picture.setAlignmentX(CENTER_ALIGNMENT);

        JLabel idLabel = new JLabel("ID: ");
        idLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        idLabel.setAlignmentX(RIGHT_ALIGNMENT);
        idLabel.setForeground(ThemeColors.BLACK);

        JComboBox<String> idJComboBoxList = new JComboBox<String>();
        idJComboBoxList.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        idJComboBoxList.setMinimumSize(new Dimension(1000, 50));
        idJComboBoxList.setMaximumSize(new Dimension(1000, 50));
        idJComboBoxList.setAlignmentX(RIGHT_ALIGNMENT);
        idJComboBoxList.setPrototypeDisplayValue("XXXXXXXXXXXXXXXXX");

        // TODO fill jcombobox with real info
        for (int i = 0; i < 5; i++)
        {
            idJComboBoxList.addItem("" + i);
        }

        JComponent[] idComponents = {idLabel, idJComboBoxList};
        Box idBox = AddToBox.addToHorizontalBox(idComponents, 1);

        // type of user Box
        JLabel typeOfUserLabel = new JLabel("Type of User: ");
        typeOfUserLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        typeOfUserLabel.setAlignmentX(RIGHT_ALIGNMENT);
        typeOfUserLabel.setForeground(ThemeColors.BLACK);

        RoundedJTextField typeOfUserTextField = new RoundedJTextField(20);
        typeOfUserTextField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        typeOfUserTextField.setEditable(false);
        typeOfUserTextField.setMinimumSize(new Dimension(400, 50));
        typeOfUserTextField.setMaximumSize(new Dimension(400, 50));
        typeOfUserTextField.setAlignmentX(RIGHT_ALIGNMENT);

        JComponent[] typeOfUserComponents = {typeOfUserLabel, typeOfUserTextField};
        Box typeOfUserBox = AddToBox.addToHorizontalBox(typeOfUserComponents, 1);

        // Email Box
        JLabel emailLabel = new JLabel("Email: ", SwingConstants.LEFT);
        emailLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        emailLabel.setAlignmentX(RIGHT_ALIGNMENT);
        emailLabel.setForeground(ThemeColors.BLACK);

        RoundedJTextField emailField = new RoundedJTextField(15);
        emailField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        emailField.setEditable(false);
        emailField.setMinimumSize(new Dimension(400, 50));
        emailField.setMaximumSize(new Dimension(400, 50));
        emailField.setAlignmentX(RIGHT_ALIGNMENT);

        JComponent[] emailComponents = {emailLabel, emailField};
        Box emailBox = AddToBox.addToHorizontalBox(emailComponents, 1);

        // Username Box
        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        usernameLabel.setAlignmentX(RIGHT_ALIGNMENT);
        usernameLabel.setForeground(ThemeColors.BLACK);

        RoundedJTextField usernameField = new RoundedJTextField(15);
        usernameField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        usernameField.setEditable(false);
        usernameField.setMinimumSize(new Dimension(400, 50));
        usernameField.setMaximumSize(new Dimension(400, 50));
        usernameField.setAlignmentX(RIGHT_ALIGNMENT);

        JComponent[] usernameComponents = {usernameLabel, usernameField};
        Box usernameBox = AddToBox.addToHorizontalBox(usernameComponents, 1);

        // Name Box
        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        nameLabel.setAlignmentX(RIGHT_ALIGNMENT);
        nameLabel.setForeground(ThemeColors.BLACK);

        RoundedJTextField nameField = new RoundedJTextField(15);
        nameField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        nameField.setEditable(false);
        nameField.setMinimumSize(new Dimension(400, 50));
        nameField.setMaximumSize(new Dimension(400, 50));
        nameField.setAlignmentX(RIGHT_ALIGNMENT);

        JComponent[] nameComponents = {nameLabel, nameField};
        Box nameBox = AddToBox.addToHorizontalBox(nameComponents, 1);

        // Major Box
        JLabel majorLabel = new JLabel("Major: ");
        majorLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        majorLabel.setAlignmentX(RIGHT_ALIGNMENT);
        majorLabel.setForeground(ThemeColors.BLACK);

        RoundedJTextField majorField = new RoundedJTextField(15);
        majorField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        majorField.setEditable(false);
        majorField.setMinimumSize(new Dimension(400, 50));
        majorField.setMaximumSize(new Dimension(400, 50));
        majorField.setAlignmentX(RIGHT_ALIGNMENT);

        JComponent[] majorComponents = {majorLabel, majorField};
        Box majorBox = AddToBox.addToHorizontalBox(majorComponents, 1);

        // Occupation box
        JLabel occupationLabel = new JLabel("Occupation: ");
        occupationLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        occupationLabel.setAlignmentX(RIGHT_ALIGNMENT);
        occupationLabel.setForeground(ThemeColors.BLACK);

        RoundedJTextField occupationField = new RoundedJTextField(15);
        occupationField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        occupationField.setEditable(false);
        occupationField.setMinimumSize(new Dimension(400, 50));
        occupationField.setMaximumSize(new Dimension(400, 50));
        occupationField.setAlignmentX(RIGHT_ALIGNMENT);

        JComponent[] occupationComponents = {occupationLabel, occupationField};
        Box occupationBox = AddToBox.addToHorizontalBox(occupationComponents, 1);

        // User info Box setup
        JComponent[] userInfoComponents = {idBox, typeOfUserBox, emailBox, usernameBox, nameBox, majorBox, occupationBox};
        Box userInfoBox = AddToBox.addToVerticalBox(userInfoComponents, 1);
        userInfoBox.setAlignmentX(CENTER_ALIGNMENT);

        JComponent[] pictureComponents = {userInfoBox, picture};
        userInfoBox = AddToBox.addToHorizontalBox(pictureComponents, 1);

        // Operational Buttons
        KButton nextButton = new CustomButtonAdmin("—>", 100, 50);
        nextButton.setActionCommand("next");
        nextButton.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        nextButton.setAlignmentX(LEFT_ALIGNMENT);
        KButton previousButton = new CustomButtonAdmin("<—", 100, 50);
        previousButton.setActionCommand("previous");
        previousButton.setAlignmentX(RIGHT_ALIGNMENT);
        previousButton.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        // Cancel Save Buttons
        KButton cancelButton = new CustomButtonAdmin("Cancel");
        cancelButton.setAlignmentX(CENTER_ALIGNMENT);
        KButton saveButton = new CustomButtonAdmin("Save");
        saveButton.setAlignmentX(CENTER_ALIGNMENT);

        JComponent[] buttonsComponents = {previousButton, nextButton, cancelButton, saveButton};
        Box buttonsBox = AddToBox.addToVerticalBox(buttonsComponents, 2);
        buttonsBox.setAlignmentX(CENTER_ALIGNMENT);

        // Add to Panel
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.2;
        c.weighty = 0.2;
        c.insets = new Insets(0, 50, 0, 50);
        this.add(Edit_User_info, c);
        c.insets = new Insets(0, 0, 0, 0);
        c.gridy = 1;
        this.add(userInfoBox, c);
        c.insets = new Insets(0, 70, 0, 70);
        c.gridy = 2;
        this.add(buttonsBox, c);

        // Button Handlers
        cancelButton.addActionListener(new SaveChangesHandler());
        saveButton.addActionListener(new SaveChangesHandler());

        nextButton.addActionListener(
                new NextPreviousHandler(idJComboBoxList));

        previousButton.addActionListener(
                new NextPreviousHandler(idJComboBoxList));

    }
}
