package oop.project.screens.InstructorScreen.Panels;

import oop.project.components.RoundedJTextField;
import oop.project.components.TransparentPanel;
import oop.project.hooks.*;
import javax.swing.*;
import java.awt.*;

public class EditGradesPanel extends TransparentPanel
{
    public EditGradesPanel(int Width, int Height)
    {
        Box idBox;
        Box nameBox;
        Box gradesBox;
        Box buttonsBox;

        // ID
        JLabel IDLabel = new JLabel("ID: ");
        IDLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));        
        JComboBox<String> IDJComboBoxList = new JComboBox<String>();
        IDJComboBoxList.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        for (int i = 0; i < 6; i++)
        {
            IDJComboBoxList.addItem("" + i);
        }

        JComponent[] idComponents = {IDLabel, IDJComboBoxList};
        idBox = AddToBox.addToVerticalBox(idComponents, 2);
        
        
        // Name
        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        RoundedJTextField firstNameField = new RoundedJTextField(15);
        firstNameField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        firstNameField.setEditable(false);

        RoundedJTextField lastNameField = new RoundedJTextField(15);
        lastNameField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        lastNameField.setEditable(false);

        JComponent [] nameComponents = {nameLabel, firstNameField, lastNameField};
        nameBox = AddToBox.addToVerticalBox(nameComponents, 3);


       


        // Grades
        JLabel gradesLabel = new JLabel("Grades: ");
        gradesLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        JLabel quizLabel = new JLabel("\tQuiz Grade: ");
        quizLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        RoundedJTextField quizField = new RoundedJTextField(15);
        quizField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));

        JComponent[] quizComponents = {quizLabel, quizField};
        Box quizBox = AddToBox.addToVerticalBox(quizComponents, 2);

        JLabel midtermLabel = new JLabel("\tMidterm Exam Grade: ");
        midtermLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        RoundedJTextField midtermField = new RoundedJTextField(15);
        midtermField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));

        JComponent[] midtermComponents = {midtermLabel, midtermField};
        Box midtermBox = AddToBox.addToVerticalBox(midtermComponents, 2);
        
        JLabel finalLabel = new JLabel("\tFinal Exam Grade: ");
        finalLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));    
        RoundedJTextField finalField = new RoundedJTextField(15);
        finalField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));

        JComponent[] finalComponents = {finalLabel, finalField};
        Box finalBox = AddToBox.addToVerticalBox(finalComponents, 2);

        JLabel projectLabel = new JLabel("\tProject Grade:");
        projectLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        RoundedJTextField projectField = new RoundedJTextField(15);
        projectField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));

        JComponent[] projectComponents = {projectLabel, projectField};
        Box projectBox = AddToBox.addToVerticalBox(projectComponents, 2);

        JComponent[] gradeComponents = {gradesLabel, quizBox, midtermBox, finalBox, projectBox};
        gradesBox = AddToBox.addToHorizontalBox(gradeComponents, 1);

       

        // Buttons
        JButton saveButton = new JButton("Save");
        JButton cancelButton = new JButton("Cancel");
        JComponent[] buttonsComponents = {saveButton, cancelButton};
        buttonsBox = AddToBox.addToHorizontalBox(buttonsComponents, 2);

        JComponent [] c = {idBox, nameBox, gradesBox, buttonsBox};
        Box everythingBox = AddToBox.addToHorizontalBoxWithSpace(c, 1);

        this.add(everythingBox);


    }
}
