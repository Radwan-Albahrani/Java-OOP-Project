package oop.project.screens.InstructorScreen.Panels;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.*;
import javax.swing.*;
import com.k33ptoo.components.KButton;
import oop.project.components.*;
import oop.project.hooks.*;

public class EditGradesPanel extends TransparentPanel
{
    List<String> info = new ArrayList<>();
    JPanel wrapper;
    List<JComponent> components = new ArrayList<>();

    public void setWrapper(JPanel wrapper, JFrame frame)
    {
        this.wrapper = wrapper;
    }

    public EditGradesPanel(int Width, int Height)
    {
        Box idBox;
        Box nameBox;
        Box gradesBox;
        Box buttonsBox;

        // Label Setup
        JLabel editGradesLabel = new TitleLabel("Edit Students Grades");

        // Picture Setup
        JLabel picture = FrameConfig.getPicture("InstructorScreen/DefaultProfilePicture.png", 0.1);

        // ID
        JLabel IDLabel = new JLabel("ID: ");
        IDLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        IDLabel.setHorizontalAlignment(JLabel.CENTER);
        IDLabel.setHorizontalTextPosition(JLabel.CENTER);
        IDLabel.setAlignmentX(CENTER_ALIGNMENT);

        JComboBox<String> IDJComboBoxList = new JComboBox<String>();
        IDJComboBoxList.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        IDJComboBoxList.setMinimumSize(new Dimension(1000, 50));
        IDJComboBoxList.setMaximumSize(new Dimension(1000, 50));
        IDJComboBoxList.setAlignmentX(RIGHT_ALIGNMENT);
        IDJComboBoxList.setPrototypeDisplayValue("XXXXXXXXXXXXXXXXX");
        for (int i = 0; i < 6; i++)
        {
            IDJComboBoxList.addItem("" + i);
        }

        JComponent[] idComponents = {IDLabel, IDJComboBoxList};
        idBox = AddToBox.addToHorizontalBox(idComponents, 1);

        // Name Setup
        // TODO: Combine First and Last Name into one field
        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        nameLabel.setAlignmentX(CENTER_ALIGNMENT);

        RoundedJTextField nameField = new RoundedJTextField(15);
        nameField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        nameField.setEditable(false);
        nameField.setMinimumSize(new Dimension(1000, 50));
        nameField.setMaximumSize(new Dimension(1000, 50));
        nameField.setAlignmentX(RIGHT_ALIGNMENT);

        JComponent[] nameComponents = {nameLabel, nameField};
        nameBox = AddToBox.addToHorizontalBox(nameComponents, 1);

        // Picture Setup
        JComponent[] idNameComponents = {idBox, nameBox};
        Box idNameBox = AddToBox.addToVerticalBox(idNameComponents, 1);

        JComponent[] pictureComponents = {idNameBox, picture};
        Box pictureBox = AddToBox.addToHorizontalBox(pictureComponents, 1);

        // Grades Setup
        JLabel gradesLabel = new JLabel("Grades");
        gradesLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        JComponent[] gradesLabelComponents = {gradesLabel};
        Box gradesLabelBox = AddToBox.addToVerticalBox(gradesLabelComponents, 1);

        JLabel quizLabel = new JLabel("Quiz Grade:");
        quizLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        quizLabel.setAlignmentX(LEFT_ALIGNMENT);

        RoundedJTextField quizField = new RoundedJTextField(15);
        quizField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        quizField.setAlignmentX(RIGHT_ALIGNMENT);
        quizField.setMinimumSize(new Dimension(500, 50));
        quizField.setMaximumSize(new Dimension(500, 50));

        JComponent[] quizComponents = {quizLabel, quizField};
        Box quizBox = AddToBox.addToHorizontalBox(quizComponents, 1);

        JLabel midtermLabel = new JLabel("Midterm Exam Grade:");
        midtermLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        midtermLabel.setAlignmentX(LEFT_ALIGNMENT);

        RoundedJTextField midtermField = new RoundedJTextField(15);
        midtermField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        midtermField.setAlignmentX(RIGHT_ALIGNMENT);
        midtermField.setMinimumSize(new Dimension(500, 50));
        midtermField.setMaximumSize(new Dimension(500, 50));

        JComponent[] midtermComponents = {midtermLabel, midtermField};
        Box midtermBox = AddToBox.addToHorizontalBox(midtermComponents, 1);

        JLabel finalLabel = new JLabel("Final Exam Grade:");
        finalLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        finalLabel.setAlignmentX(LEFT_ALIGNMENT);

        RoundedJTextField finalField = new RoundedJTextField(15);
        finalField.setMinimumSize(new Dimension(500, 50));
        finalField.setMaximumSize(new Dimension(500, 50));
        finalField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        finalField.setAlignmentX(RIGHT_ALIGNMENT);

        JComponent[] finalComponents = {finalLabel, finalField};
        Box finalBox = AddToBox.addToHorizontalBox(finalComponents, 1);

        JLabel projectLabel = new JLabel("Project Grade:");
        projectLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        projectLabel.setAlignmentX(LEFT_ALIGNMENT);

        RoundedJTextField projectField = new RoundedJTextField(15);
        projectField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        projectField.setAlignmentX(RIGHT_ALIGNMENT);
        projectField.setMinimumSize(new Dimension(500, 50));
        projectField.setMaximumSize(new Dimension(500, 50));

        JComponent[] projectComponents = {projectLabel, projectField};
        Box projectBox = AddToBox.addToHorizontalBox(projectComponents, 1);

        JComponent[] gradesComponents = {quizBox, midtermBox, finalBox, projectBox};
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
        this.add(pictureBox, c);
        c.gridy = 2;
        this.add(gradesLabelBox, c);
        c.insets = new Insets(0, 0, 0, 0);
        c.gridy = 3;
        this.add(gradesBox, c);
        c.insets = new Insets(0, 50, 0, 50);
        c.gridy = 4;
        this.add(buttonsBox, c);

    }
}
