package oop.project.screens.InstructorScreen.Panels;

import java.awt.Dimension;
import java.awt.Font;
import oop.project.colors.ThemeColors;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;
import com.k33ptoo.components.KButton;

import oop.project.components.buttons.CustomButtonInstructor;
import oop.project.components.core.RoundedJTextField;
import oop.project.components.core.TitleLabel;
import oop.project.components.panels.TransparentPanel;
import oop.project.handlers.*;
import oop.project.hooks.*;

public class EditGradesPanel extends TransparentPanel
{

    // TODO: Could add a next and a back button to go through the students
    public EditGradesPanel(int Width, int Height)
    {
        Box idBox;
        Box emailBox;
        Box nameBox;
        Box gradesBox;
        Box buttonsBox;

        // Label Setup
        JLabel editGradesLabel = new TitleLabel("Edit Students Grades");

        // Picture Setup
        JLabel picture = FrameConfig.getPicture("/DefaultProfilePicture.png", 0.2);
        picture.setAlignmentX(CENTER_ALIGNMENT);

        // ID
        // TODO: ID is a list of the students in the class
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
        for (int i = 0; i < 6; i++)
        {
            idJComboBoxList.addItem("" + i);
        }

        JComponent[] idComponents = {idLabel, idJComboBoxList};
        idBox = AddToBox.addToHorizontalBox(idComponents, 1);

        // Name Setup
        // TODO: Combine First and Last Name into one field
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

        // Email Setup
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

        // Grades Setup
        JLabel quizLabel = new JLabel("Quiz Grade:");
        quizLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        quizLabel.setAlignmentX(LEFT_ALIGNMENT);
        quizLabel.setForeground(ThemeColors.BLACK);

        RoundedJTextField quizField = new RoundedJTextField(15);
        quizField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        quizField.setAlignmentX(RIGHT_ALIGNMENT);
        quizField.setMinimumSize(new Dimension(110, 50));
        quizField.setMaximumSize(new Dimension(110, 50));

        JLabel quizGrade = new JLabel("/10");
        quizGrade.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        quizGrade.setAlignmentX(RIGHT_ALIGNMENT);
        quizGrade.setForeground(ThemeColors.BLACK);

        JComponent[] quizComponents = {quizLabel, quizField, quizGrade};
        Box quizBox = AddToBox.addToHorizontalBox(quizComponents, 1);

        JLabel midtermLabel = new JLabel("Midterm Exam Grade:");
        midtermLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        midtermLabel.setAlignmentX(LEFT_ALIGNMENT);
        midtermLabel.setForeground(ThemeColors.BLACK);

        RoundedJTextField midtermField = new RoundedJTextField(15);
        midtermField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        midtermField.setAlignmentX(RIGHT_ALIGNMENT);
        midtermField.setMinimumSize(new Dimension(110, 50));
        midtermField.setMaximumSize(new Dimension(110, 50));

        JLabel midtermGrade = new JLabel("/20");
        midtermGrade.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        midtermGrade.setAlignmentX(RIGHT_ALIGNMENT);
        midtermGrade.setForeground(ThemeColors.BLACK);

        JComponent[] midtermComponents = {midtermLabel, midtermField, midtermGrade};
        Box midtermBox = AddToBox.addToHorizontalBox(midtermComponents, 1);

        JLabel finalLabel = new JLabel("Final Exam Grade:");
        finalLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        finalLabel.setAlignmentX(LEFT_ALIGNMENT);
        finalLabel.setForeground(ThemeColors.BLACK);

        RoundedJTextField finalField = new RoundedJTextField(15);
        finalField.setMinimumSize(new Dimension(110, 50));
        finalField.setMaximumSize(new Dimension(110, 50));
        finalField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        finalField.setAlignmentX(RIGHT_ALIGNMENT);

        JLabel finalGrade = new JLabel("/40");
        finalGrade.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        finalGrade.setAlignmentX(RIGHT_ALIGNMENT);
        finalGrade.setForeground(ThemeColors.BLACK);

        JComponent[] finalComponents = {finalLabel, finalField, finalGrade};
        Box finalBox = AddToBox.addToHorizontalBox(finalComponents, 1);

        JLabel projectLabel = new JLabel("Project Grade:");
        projectLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        projectLabel.setAlignmentX(LEFT_ALIGNMENT);
        projectLabel.setForeground(ThemeColors.BLACK);

        RoundedJTextField projectField = new RoundedJTextField(15);
        projectField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        projectField.setAlignmentX(RIGHT_ALIGNMENT);
        projectField.setMinimumSize(new Dimension(110, 50));
        projectField.setMaximumSize(new Dimension(110, 50));

        JLabel projectGrade = new JLabel("/30");
        projectGrade.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        projectGrade.setAlignmentX(RIGHT_ALIGNMENT);
        projectGrade.setForeground(ThemeColors.BLACK);

        JComponent[] projectComponents = {projectLabel, projectField, projectGrade};
        Box projectBox = AddToBox.addToHorizontalBox(projectComponents, 1);

        JLabel totalLabel = new JLabel("Total Grade:");
        totalLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
        totalLabel.setAlignmentX(LEFT_ALIGNMENT);
        totalLabel.setForeground(ThemeColors.BLACK);

        RoundedJTextField totalField = new RoundedJTextField(15);
        totalField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        totalField.setAlignmentX(RIGHT_ALIGNMENT);
        totalField.setMinimumSize(new Dimension(100, 50));
        totalField.setMaximumSize(new Dimension(100, 50));
        totalField.setEditable(false);

        JLabel totalGrade = new JLabel("/100");
        totalGrade.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        totalGrade.setAlignmentX(RIGHT_ALIGNMENT);
        totalGrade.setForeground(ThemeColors.BLACK);

        JComponent[] totalComponents = {totalLabel, totalField, totalGrade};
        Box totalBox = AddToBox.addToHorizontalBox(totalComponents, 1);

        JComponent[] gradesComponents = {quizBox, midtermBox, finalBox, projectBox, totalBox};
        gradesBox = AddToBox.addToVerticalBox(gradesComponents, 1);

        // Buttons
        KButton cancelButton = new CustomButtonInstructor("Cancel");
        cancelButton.setAlignmentX(CENTER_ALIGNMENT);
        KButton saveButton = new CustomButtonInstructor("Save");
        saveButton.setAlignmentX(CENTER_ALIGNMENT);

        JComponent[] buttonsComponents = {cancelButton, saveButton};
        buttonsBox = AddToBox.addToVerticalBox(buttonsComponents, 2);

        // Add to Panel
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.2;
        c.weighty = 0.2;
        c.insets = new Insets(0, 50, 0, 50);
        this.add(editGradesLabel, c);
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridy = 1;
        c.insets = new Insets(0, 30, 0, 30);
        this.add(idNameBox, c);
        c.insets = new Insets(0, 300, 0, 350);
        c.gridy = 2;
        this.add(gradesBox, c);
        c.insets = new Insets(0, 100, 0, 100);
        c.gridy = 3;
        this.add(buttonsBox, c);

        // Button Handlers
        cancelButton.addActionListener(new SaveChangesHandler());
        saveButton.addActionListener(new SaveChangesHandler());
    }
}
