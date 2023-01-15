package oop.project.screens.InstructorScreen.Panels;

import java.awt.Color;
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

        JComboBox<String> IDJComboBoxList = new JComboBox<String>();
        IDJComboBoxList.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        for (int i = 0; i < 6; i++)
        {
            IDJComboBoxList.addItem("" + i);
        }

        JComponent[] idComponents = {IDLabel, IDJComboBoxList};
        idBox = AddToBox.addToVerticalBox(idComponents, 2);
        
        
        
        // Name Setup
        //TODO: Combine First and Last Name into one field
        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        RoundedJTextField nameField = new RoundedJTextField(15);
        nameField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        nameField.setEditable(false);

        JComponent [] nameComponents = {nameLabel, nameField};
        nameBox = AddToBox.addToVerticalBox(nameComponents, 2);

        // Picture Setup
        JComponent [] idnameComponents = {idBox, nameBox};
        Box idnameBox = AddToBox.addToVerticalBox(idnameComponents, 1);

        JComponent [] pictureComponents = {idnameBox, picture};
        Box pictureBox = AddToBox.addToHorizontalBox(pictureComponents, 1);

 
        // Grades Setup
        JLabel gradesLabel = new JLabel("Grades: ");
        gradesLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        JComponent [] gradesLabelComponents = {gradesLabel};
        Box gradesLabelBox = AddToBox.addToVerticalBox(gradesLabelComponents, 1);


        JLabel quizLabel = new JLabel("Quiz Grade:");
        quizLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        RoundedJTextField quizField = new RoundedJTextField(15);
        quizField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));

        JComponent[] quizComponents = {quizLabel, quizField};
        Box quizBox = AddToBox.addToVerticalBox(quizComponents, 2);

        JLabel midtermLabel = new JLabel("Midterm Exam Grade:");
        midtermLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        RoundedJTextField midtermField = new RoundedJTextField(15);
        midtermField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));

        JComponent[] midtermComponents = {midtermLabel, midtermField};
        Box midtermBox = AddToBox.addToVerticalBox(midtermComponents, 2);
        
        JLabel finalLabel = new JLabel("Final Exam Grade:");
        finalLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));    
        RoundedJTextField finalField = new RoundedJTextField(15);
        finalField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));

        JComponent[] finalComponents = {finalLabel, finalField};
        Box finalBox = AddToBox.addToVerticalBox(finalComponents, 2);

        JLabel projectLabel = new JLabel("Project Grade:");
        projectLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        RoundedJTextField projectField = new RoundedJTextField(15);
        projectField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));

        JComponent[] projectComponents = {projectLabel, projectField};
        Box projectBox = AddToBox.addToVerticalBox(projectComponents, 2);

        JComponent[] gradeComponents = {quizBox, midtermBox, finalBox, projectBox};
        gradesBox = AddToBox.addToVerticalBox(gradeComponents, 1);

    
        // Buttons
        KButton cancelButton = new CustomButtonInstructor("Cancel");
        KButton saveButton = new CustomButtonInstructor("Save");
        JComponent[] buttonsComponents = {cancelButton, saveButton};
        buttonsBox = AddToBox.addToVerticalBox(buttonsComponents, 2);

        // Add to Panel
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(0, 50, 0, 50);
        this.add(editGradesLabel, c);
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridy = 1;
        this.add(pictureBox, c);
        c.gridy = 2;
        this.add(gradesLabelBox, c);
        c.gridy = 3;
        this.add(gradesBox, c);
        c.gridy = 4;
        this.add(buttonsBox, c);


    }
}
