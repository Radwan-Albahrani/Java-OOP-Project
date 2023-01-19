package oop.project.screens.AdminScreen.Panels;

import java.awt.Dimension;
import java.awt.Font;
import oop.project.colors.ThemeColors;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import oop.project.handlers.NextPreviousHandler;

import javax.swing.*;
import com.k33ptoo.components.KButton;

import oop.project.components.buttons.CustomButtonInstructor;
import oop.project.components.core.RoundedJTextField;
import oop.project.components.core.TitleLabel;
import oop.project.components.panels.TransparentPanel;
import oop.project.handlers.*;
import oop.project.hooks.*;

public class EditUserInfo extends TransparentPanel
{

    public EditUserInfo(int Width, int Height)
    {
        Box idBox;
        Box emailBox;
        Box nameBox;
        Box buttonsBox;

        JLabel Edit_User_info = new JLabel("Edit Information");
        Edit_User_info.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        // Picture Setup
        JLabel picture = FrameConfig.getPicture("/DefaultProfilePicture.png", 0.2);
        picture.setAlignmentX(CENTER_ALIGNMENT);

        // type of user JComboBox : student or instructor

        JLabel idLabel = new JLabel("ID: ");
        idLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        idLabel.setHorizontalAlignment(JLabel.CENTER);
        idLabel.setHorizontalTextPosition(JLabel.CENTER);
        idLabel.setAlignmentX(RIGHT_ALIGNMENT);
        idLabel.setForeground(ThemeColors.BLACK);

        JComboBox<String> idJComboBoxList = new JComboBox<String>();
        idJComboBoxList.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        idJComboBoxList.setMinimumSize(new Dimension(1000, 50));
        idJComboBoxList.setMaximumSize(new Dimension(1000, 50));
        idJComboBoxList.setAlignmentX(RIGHT_ALIGNMENT);
        idJComboBoxList.setPrototypeDisplayValue("XXXXXXXXXXXXXXXXX");

        for (int i = 0; i < 5; i++)
        {
            idJComboBoxList.addItem("" + i);
        }

        JComponent[] idComponents = {idLabel, idJComboBoxList};
        idBox = AddToBox.addToHorizontalBox(idComponents, 1);

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
        nameBox = AddToBox.addToHorizontalBox(nameComponents, 1);

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
        emailBox = AddToBox.addToHorizontalBox(emailComponents, 1);

        // Picture Setup
        JComponent[] idNameComponents = {idBox, emailBox, nameBox};
        Box idNameBox = AddToBox.addToVerticalBox(idNameComponents, 1);
        idNameBox.setAlignmentX(CENTER_ALIGNMENT);

        JComponent[] pictureComponents = {idNameBox, picture};
        idNameBox = AddToBox.addToHorizontalBox(pictureComponents, 1);

        // Major Box: general or majored

        // occupation box

        // Operational Buttons
        KButton nextButton = new CustomButtonInstructor("—>", 100, 50);
        nextButton.setActionCommand("next");
        nextButton.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        nextButton.setAlignmentX(LEFT_ALIGNMENT);
        KButton previousButton = new CustomButtonInstructor("<—", 100, 50);
        previousButton.setActionCommand("previous");
        previousButton.setAlignmentX(RIGHT_ALIGNMENT);
        previousButton.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        KButton cancelButton = new CustomButtonInstructor("Cancel");
        cancelButton.setAlignmentX(CENTER_ALIGNMENT);
        KButton saveButton = new CustomButtonInstructor("Save");
        saveButton.setAlignmentX(CENTER_ALIGNMENT);

        JComponent[] buttonsComponents = {previousButton, nextButton, cancelButton, saveButton};
        buttonsBox = AddToBox.addToVerticalBox(buttonsComponents, 2);
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
        this.add(idNameBox, c);
        c.insets = new Insets(0, 70, 0, 70);
        c.gridy = 2;
        this.add(buttonsBox, c);

        // Button Handlers
        cancelButton.addActionListener(new SaveChangesHandler());
        saveButton.addActionListener(new SaveChangesHandler());

        nextButton.addActionListener(
                new NextPreviousHandler(this, idJComboBoxList));

        previousButton.addActionListener(
                new NextPreviousHandler(this, idJComboBoxList));

    }
}
