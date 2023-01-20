package oop.project.screens.StudentScreen.Panels;

import oop.project.colors.ThemeColors;
import oop.project.components.buttons.BlueButton;
import oop.project.components.core.RoundedJTextField;
import oop.project.components.panels.TransparentPanel;
import oop.project.hooks.AddToBox;

import java.awt.*;
import javax.swing.*;
import com.k33ptoo.components.*;

public class ViewGrades extends TransparentPanel
{
    public ViewGrades(int Width, int Height)
    {
        Box studentProfile;
        Box studentquizGrade;
        Box studentmidtermGrade;
        Box studentfinalGrade;
        Box totalGrade;


        JLabel ViewGradesLabel = new JLabel("View Grades");
        ViewGradesLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        JLabel id = new JLabel("ID");
        id.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        id.setHorizontalAlignment(JLabel.CENTER);
        id.setHorizontalTextPosition(JLabel.CENTER);
        id.setAlignmentX(RIGHT_ALIGNMENT);
        id.setForeground(ThemeColors.BLUE);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setHorizontalTextPosition(JLabel.CENTER);
        name.setAlignmentX(RIGHT_ALIGNMENT);
        name.setForeground(ThemeColors.BLUE);

        JComponent [] profileComponents = {id, name};
        studentProfile = AddToBox.addToHorizontalBox(profileComponents, 1);


        JLabel quizGrade = new JLabel("quizGrade");
        quizGrade.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        quizGrade.setHorizontalAlignment(JLabel.CENTER);
        quizGrade.setHorizontalTextPosition(JLabel.CENTER);
        quizGrade.setAlignmentX(RIGHT_ALIGNMENT);
        quizGrade.setForeground(ThemeColors.BLUE);

        RoundedJTextField quizGradeField = new RoundedJTextField(10);
        quizGradeField.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        quizGradeField.setHorizontalAlignment(JTextField.CENTER);
        quizGradeField.setPreferredSize(new Dimension(100, 50));

        JComponent [] quizGradeComponents = {quizGrade, quizGradeField};
        studentquizGrade = AddToBox.addToHorizontalBox(quizGradeComponents, 1);


        JLabel midtermGrade = new JLabel("quizGrade");
        midtermGrade.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        midtermGrade.setHorizontalAlignment(JLabel.CENTER);
        midtermGrade.setHorizontalTextPosition(JLabel.CENTER);
        midtermGrade.setAlignmentX(RIGHT_ALIGNMENT);
        midtermGrade.setForeground(ThemeColors.BLUE);

        RoundedJTextField midtermGradeField = new RoundedJTextField(10);
        midtermGradeField.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        midtermGradeField.setHorizontalAlignment(JTextField.CENTER);
        midtermGradeField.setPreferredSize(new Dimension(100, 50));

        JComponent [] midtermGradeComponents = {midtermGrade, midtermGradeField};
        studentmidtermGrade = AddToBox.addToHorizontalBox(midtermGradeComponents, 1);


        JLabel finalGrade = new JLabel("quizGrade");
        finalGrade.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        finalGrade.setHorizontalAlignment(JLabel.CENTER);
        finalGrade.setHorizontalTextPosition(JLabel.CENTER);
        finalGrade.setAlignmentX(RIGHT_ALIGNMENT);
        finalGrade.setForeground(ThemeColors.BLUE);

        RoundedJTextField finalGradeField = new RoundedJTextField(10);
        finalGradeField.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        finalGradeField.setHorizontalAlignment(JTextField.CENTER);
        finalGradeField.setPreferredSize(new Dimension(100, 50));

        JComponent [] finalGradeComponents = {finalGrade, finalGradeField};
        studentfinalGrade = AddToBox.addToHorizontalBox(finalGradeComponents, 1);
        

        JLabel total = new JLabel("/100");
        total.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        total.setHorizontalAlignment(JLabel.CENTER);
        total.setHorizontalTextPosition(JLabel.CENTER);
        total.setAlignmentX(RIGHT_ALIGNMENT);
        total.setForeground(ThemeColors.BLUE);

        RoundedJTextField totalField = new RoundedJTextField(10);
        totalField.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        totalField.setHorizontalAlignment(JTextField.CENTER);
        totalField.setPreferredSize(new Dimension(100, 50));

        JComponent [] totalComponents = {total, totalField};
        totalGrade = AddToBox.addToHorizontalBox(totalComponents, 1);



        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 10);
        this.add(studentProfile, c);
        c.gridy = 1;
        this.add(studentquizGrade, c);
        c.gridy = 2;
        this.add(studentmidtermGrade, c);
        c.gridy = 3;
        this.add(studentfinalGrade, c);
        c.gridy = 4;
        this.add(totalGrade, c);


        KButton ViewGradesButton = new BlueButton(" View Grades");
        ViewGradesButton.setPreferredSize(new Dimension(150, 50));

        JComponent[] ViewGradesComponents = {ViewGradesLabel, ViewGradesButton};
        Box ViewGradesBox = AddToBox.addToVerticalBox(ViewGradesComponents, 1);

        this.add(ViewGradesBox);
    }
}
