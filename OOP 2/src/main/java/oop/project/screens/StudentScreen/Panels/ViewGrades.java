package oop.project.screens.StudentScreen.Panels;

import oop.project.colors.ThemeColors;
import oop.project.components.buttons.*;
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
        Box studentProjectGrade;
        Box totalGrade;
        Box studentGradeBox;
        Box coursesList;


        JLabel ViewGradesLabel = new JLabel("View Grades");
        ViewGradesLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        JLabel id = new JLabel("ID");
        id.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        id.setHorizontalAlignment(JLabel.CENTER);
        id.setHorizontalTextPosition(JLabel.CENTER);
        id.setAlignmentX(RIGHT_ALIGNMENT);
        id.setForeground(ThemeColors.BLACK);

        RoundedJTextField idField = new RoundedJTextField(10);
        idField.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        idField.setAlignmentX(RIGHT_ALIGNMENT);
        idField.setMinimumSize(new Dimension(400, 50));
        idField.setMaximumSize(new Dimension(400, 50));
        idField.setEditable(false);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        name.setAlignmentX(RIGHT_ALIGNMENT);
        name.setForeground(ThemeColors.BLACK);

        RoundedJTextField nameField = new RoundedJTextField(10);
        nameField.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        nameField.setAlignmentX(RIGHT_ALIGNMENT);
        nameField.setMinimumSize(new Dimension(400, 50));
        nameField.setMaximumSize(new Dimension(400, 50));
        nameField.setEditable(false);

        JComponent[] profileComponents = {id, idField, name, nameField};
        studentProfile = AddToBox.addToVerticalBox(profileComponents, 1);


        JLabel quizGrade = new JLabel("Quiz Grade");
        quizGrade.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        quizGrade.setAlignmentX(RIGHT_ALIGNMENT);
        quizGrade.setForeground(ThemeColors.BLACK);
        

        RoundedJTextField quizGradeField = new RoundedJTextField(10);
        quizGradeField.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        quizGradeField.setAlignmentX(RIGHT_ALIGNMENT);
        quizGradeField.setMinimumSize( new Dimension(100, 50));
        quizGradeField.setMaximumSize( new Dimension(100, 50));
        quizGradeField.setEditable(false);

        JLabel quizGradeLabel = new JLabel("/10");
        quizGradeLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        quizGradeLabel.setAlignmentX(RIGHT_ALIGNMENT);
        quizGradeLabel.setForeground(ThemeColors.BLACK);


        JComponent [] quizGradeComponents = {quizGrade, quizGradeField, quizGradeLabel};
        studentquizGrade = AddToBox.addToHorizontalBox(quizGradeComponents, 1);


        JLabel midtermGrade = new JLabel("Midterm Grade");
        midtermGrade.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        midtermGrade.setAlignmentX(RIGHT_ALIGNMENT);
        midtermGrade.setForeground(ThemeColors.BLACK);

        RoundedJTextField midtermGradeField = new RoundedJTextField(10);
        midtermGradeField.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        midtermGradeField.setAlignmentX(RIGHT_ALIGNMENT);
        midtermGradeField.setMinimumSize(new Dimension(100, 50));
        midtermGradeField.setMaximumSize(new Dimension(100, 50));
        midtermGradeField.setEditable(false);

        JLabel midtermGradeLabel = new JLabel("/20");
        midtermGradeLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        midtermGradeLabel.setAlignmentX(RIGHT_ALIGNMENT);
        midtermGradeLabel.setForeground(ThemeColors.BLACK);

        JComponent [] midtermGradeComponents = {midtermGrade, midtermGradeField, midtermGradeLabel};
        studentmidtermGrade = AddToBox.addToHorizontalBox(midtermGradeComponents, 1);


        JLabel finalGrade = new JLabel("Final Grade");
        finalGrade.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        finalGrade.setAlignmentX(RIGHT_ALIGNMENT);
        finalGrade.setForeground(ThemeColors.BLACK);

        RoundedJTextField finalGradeField = new RoundedJTextField(10);
        finalGradeField.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        finalGradeField.setAlignmentX(RIGHT_ALIGNMENT);
        finalGradeField.setMinimumSize(new Dimension(100, 50));
        finalGradeField.setMaximumSize(new Dimension(100, 50));
        finalGradeField.setEditable(false);

        JLabel finalGradeLabel = new JLabel("/40");
        finalGradeLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        finalGradeLabel.setAlignmentX(RIGHT_ALIGNMENT);
        finalGradeLabel.setForeground(ThemeColors.BLACK);

        JComponent [] finalGradeComponents = {finalGrade, finalGradeField, finalGradeLabel};
        studentfinalGrade = AddToBox.addToHorizontalBox(finalGradeComponents, 1);


        JLabel projectGrade = new JLabel("Project Grade");
        projectGrade.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        projectGrade.setAlignmentX(RIGHT_ALIGNMENT);
        projectGrade.setForeground(ThemeColors.BLACK);

        RoundedJTextField projectGradeField = new RoundedJTextField(10);
        projectGradeField.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        projectGradeField.setAlignmentX(RIGHT_ALIGNMENT);
        projectGradeField.setMinimumSize(new Dimension(100, 50));
        projectGradeField.setMaximumSize(new Dimension(100, 50));
        projectGradeField.setEditable(false);

        JLabel projectGradeLabel = new JLabel("/30");
        projectGradeLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        projectGradeLabel.setAlignmentX(RIGHT_ALIGNMENT);
        projectGradeLabel.setForeground(ThemeColors.BLACK);

        JComponent [] projectGradeComponents = {projectGrade, projectGradeField, projectGradeLabel};
        studentProjectGrade = AddToBox.addToHorizontalBox(projectGradeComponents, 1);


        JLabel total = new JLabel("Total:");
        total.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        total.setAlignmentX(RIGHT_ALIGNMENT);
        total.setForeground(ThemeColors.BLACK);

        RoundedJTextField totalField = new RoundedJTextField(10);
        totalField.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        totalField.setAlignmentX(RIGHT_ALIGNMENT);
        totalField.setMinimumSize(new Dimension(100, 50));
        totalField.setMaximumSize(new Dimension(100, 50));
        totalField.setEditable(false);

        JLabel totalLabel = new JLabel("/100");
        totalLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        totalLabel.setAlignmentX(RIGHT_ALIGNMENT);
        totalLabel.setForeground(ThemeColors.BLACK);

        JComponent [] totalComponents = {total, totalField, totalLabel};
        totalGrade = AddToBox.addToHorizontalBox(totalComponents, 1);


        JComponent[] gradComponents = {studentquizGrade, studentmidtermGrade, studentfinalGrade, studentProjectGrade, totalGrade};
        studentGradeBox = AddToBox.addToVerticalBox(gradComponents, 1);


        JLabel courseLabel = new JLabel("Courses");
        courseLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        courseLabel.setAlignmentX(RIGHT_ALIGNMENT);
        courseLabel.setForeground(ThemeColors.BLACK);

        JComboBox<String> courseCombo= new JComboBox();
        courseCombo.setMinimumSize(new Dimension(150, 50));
        courseCombo.setMaximumSize(new Dimension(150, 50));
        courseCombo.addItem("Course 1");
        courseCombo.addItem("Course 2");
        courseCombo.addItem("Course 3");
        courseCombo.addItem("Course 4");
        courseCombo.addItem("Course 5");

        JComponent[] courseComponents = {courseLabel, courseCombo};
        coursesList = AddToBox.addToHorizontalBox(courseComponents, 1);


        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.2;
        c.weighty = 0.2;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 30, 0, 30);
        this.add(studentProfile, c);
        c.gridy = 1;
        c.insets = new Insets(0, 330, 0, 330);
        this.add(coursesList, c);
        c.gridy = 2;
        c.insets = new Insets(0, 330, 0, 330);
        this.add(studentGradeBox, c);

    }
}
