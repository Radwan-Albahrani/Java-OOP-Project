package oop.project.screens.AdminScreen.Panels;

import java.awt.Dimension;
import java.awt.Font;
import oop.project.colors.ThemeColors;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;
import com.k33ptoo.components.KButton;

import oop.project.components.buttons.CustomButtonAdmin;
import oop.project.components.core.RoundedJTextField;
import oop.project.components.core.TitleLabel;
import oop.project.components.panels.TransparentPanel;
import oop.project.handlers.*;
import oop.project.hooks.*;

public class AddCoursesPanel extends TransparentPanel
{
    public AddCoursesPanel(int Width, int Height)
    {
        JLabel createCourseLabel = new TitleLabel("Create Course");
        createCourseLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        JLabel idLabel = new JLabel("ID: ");
        idLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        idLabel.setAlignmentX(LEFT_ALIGNMENT);
        idLabel.setForeground(ThemeColors.BLACK);

        RoundedJTextField idTextField = new RoundedJTextField(20);
        idTextField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        idTextField.setEditable(true);
        idTextField.setMinimumSize(new Dimension(400, 50));
        idTextField.setMaximumSize(new Dimension(400, 50));
        idTextField.setAlignmentX(RIGHT_ALIGNMENT);

        JComponent[] idComponents = {idLabel, idTextField};
        Box idBox = AddToBox.addToHorizontalBox(idComponents, 1);

        // type of user Box
        JLabel courseNameLabel = new JLabel("Name: ");
        courseNameLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        courseNameLabel.setAlignmentX(LEFT_ALIGNMENT);
        courseNameLabel.setForeground(ThemeColors.BLACK);

        RoundedJTextField courseNameField = new RoundedJTextField(20);
        courseNameField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        courseNameField.setEditable(true);
        courseNameField.setMinimumSize(new Dimension(400, 50));
        courseNameField.setMaximumSize(new Dimension(400, 50));
        courseNameField.setAlignmentX(RIGHT_ALIGNMENT);

        JComponent[] courseNameComponents = {courseNameLabel, courseNameField};
        Box courseNameBox = AddToBox.addToHorizontalBox(courseNameComponents, 1);

        // Email Box
        JLabel creditHoursLabel = new JLabel("Credit Hours: ", SwingConstants.LEFT);
        creditHoursLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        creditHoursLabel.setAlignmentX(LEFT_ALIGNMENT);
        creditHoursLabel.setForeground(ThemeColors.BLACK);

        RoundedJTextField creditHoursField = new RoundedJTextField(15);
        creditHoursField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        creditHoursField.setEditable(true);
        creditHoursField.setMinimumSize(new Dimension(400, 50));
        creditHoursField.setMaximumSize(new Dimension(400, 50));
        creditHoursField.setAlignmentX(RIGHT_ALIGNMENT);

        JComponent[] creditHoursComponents = {creditHoursLabel, creditHoursField};
        Box creditHoursBox = AddToBox.addToHorizontalBox(creditHoursComponents, 1);

        // Username Box
        JLabel maxCapacityLabel = new JLabel("Max Capacity: ");
        maxCapacityLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        maxCapacityLabel.setAlignmentX(LEFT_ALIGNMENT);
        maxCapacityLabel.setForeground(ThemeColors.BLACK);

        RoundedJTextField maxCapacityField = new RoundedJTextField(15);
        maxCapacityField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        maxCapacityField.setEditable(true);
        maxCapacityField.setMinimumSize(new Dimension(400, 50));
        maxCapacityField.setMaximumSize(new Dimension(400, 50));
        maxCapacityField.setAlignmentX(RIGHT_ALIGNMENT);

        JComponent[] capacityComponents = {maxCapacityLabel, maxCapacityField};
        Box capacityField = AddToBox.addToHorizontalBox(capacityComponents, 1);

        // User info Box setup
        JComponent[] userInfoComponents = {idBox, courseNameBox, creditHoursBox, capacityField};
        Box courseInfoBox = AddToBox.addToVerticalBox(userInfoComponents, 1);
        courseInfoBox.setAlignmentX(CENTER_ALIGNMENT);

        // Create button
        KButton createButton = new CustomButtonAdmin("Create");
        createButton.setAlignmentX(CENTER_ALIGNMENT);

        // Add to Panel
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.2;
        c.weighty = 0.2;
        c.insets = new Insets(0, 50, 0, 50);
        this.add(createCourseLabel, c);
        c.insets = new Insets(200, 100, 0, 200);
        c.gridy = 1;
        this.add(courseInfoBox, c);
        c.insets = new Insets(100, 450, 100, 450);
        c.gridy = 2;
        this.add(createButton, c);

        createButton.addActionListener(
                new CreateCourseHandler(idTextField, courseNameField, creditHoursField, maxCapacityField));
    }
}
