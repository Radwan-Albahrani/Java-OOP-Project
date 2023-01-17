package oop.project.screens.StudentScreen.Panels;

import oop.project.components.BlueButton;
import oop.project.components.TransparentPanel;
import oop.project.hooks.AddToBox;

import java.awt.*;
import javax.swing.*;
import com.k33ptoo.components.*;

public class ProfileStudent extends TransparentPanel
{
    public ProfileStudent(int Width, int Height)
    {
        JLabel profileLabel = new JLabel("Profile");
        profileLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        JLabel studentId = new JLabel("Student ID");
        studentId.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        studentId.setAlignmentX(CENTER_ALIGNMENT);
        studentId.setForeground(Color.BLACK);

        JTextField studentIdField = new JTextField(15);
        studentIdField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        studentIdField.setMinimumSize(new Dimension(400, 50));
        studentIdField.setMaximumSize(new Dimension(400, 50));
        studentIdField.setEditable(false);
        studentIdField.setAlignmentX(LEFT_ALIGNMENT);

        JComponent[] studentIdComponents = {studentId, studentIdField};
        Box studentIdBox = AddToBox.addToVerticalBox(studentIdComponents, 1);


        JLabel studentName = new JLabel("Student Name");
        studentName.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        studentName.setAlignmentX(CENTER_ALIGNMENT);
        studentName.setForeground(Color.BLACK);

        JTextField studentNameField = new JTextField(15);
        studentNameField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        studentNameField.setEditable(false);
        studentNameField.setMinimumSize(new Dimension(400, 50));
        studentNameField.setMaximumSize(new Dimension(400, 50));
        studentNameField.setAlignmentX(LEFT_ALIGNMENT);

        JComponent[] studentNameComponents = {studentName, studentNameField};
        Box studentNameBox = AddToBox.addToVerticalBox(studentNameComponents, 1);


        JLabel studentEmail = new JLabel("Student Email");
        studentEmail.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        studentEmail.setAlignmentX(CENTER_ALIGNMENT);
        studentEmail.setForeground(Color.BLACK);

        JTextField studentEmailField = new JTextField(15);
        studentEmailField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        studentEmailField.setEditable(false);
        studentEmailField.setMinimumSize(new Dimension(400, 50));
        studentEmailField.setMaximumSize(new Dimension(400, 50));
        studentEmailField.setAlignmentX(LEFT_ALIGNMENT);

        JComponent[] studentEmailComponents = {studentEmail, studentEmailField};
        Box studentEmailBox = AddToBox.addToVerticalBox(studentEmailComponents, 1);


        JLabel studentPhone = new JLabel("Student Phone");
        studentPhone.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        studentPhone.setAlignmentX(CENTER_ALIGNMENT);
        studentPhone.setForeground(Color.BLACK);

        JTextField studentPhoneField = new JTextField(15);
        studentPhoneField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        studentPhoneField.setEditable(false);
        studentPhoneField.setMinimumSize(new Dimension(400, 50));
        studentPhoneField.setMaximumSize(new Dimension(400, 50));
        studentPhoneField.setAlignmentX(LEFT_ALIGNMENT);

        JComponent[] studentPhoneComponents = {studentPhone, studentPhoneField};
        Box studentPhoneBox = AddToBox.addToVerticalBox(studentPhoneComponents, 1);
        

        JLabel studentGender = new JLabel("Gender");
        studentGender.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        studentGender.setAlignmentX(CENTER_ALIGNMENT);
        studentGender.setForeground(Color.BLACK);

        JTextField studentGenderField = new JTextField(15);
        studentGenderField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        studentGenderField.setEditable(false);
        studentGenderField.setMinimumSize(new Dimension(400, 50));
        studentGenderField.setMaximumSize(new Dimension(400, 50));
        studentGenderField.setAlignmentX(LEFT_ALIGNMENT);

        JComponent [] studentGenderComponents = {studentGender, studentGenderField};
        Box studentGenderBox = AddToBox.addToVerticalBox(studentGenderComponents, 1);


        JLabel studentDOB = new JLabel("Date of Birth");
        studentDOB.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        studentDOB.setAlignmentX(CENTER_ALIGNMENT);
        studentDOB.setForeground(Color.BLACK);

        JTextField studentDOBField = new JTextField(15);
        studentDOBField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        studentDOBField.setEditable(false);
        studentDOBField.setMinimumSize(new Dimension(400, 50));
        studentDOBField.setMaximumSize(new Dimension(400, 50));
        studentDOBField.setAlignmentX(LEFT_ALIGNMENT);

        JComponent[] studentDOBComponents = {studentDOB, studentDOBField};
        Box studentDOBBox = AddToBox.addToVerticalBox(studentDOBComponents, 1);
        

        //Major
        JLabel studentMajor = new JLabel("Major");
        studentMajor.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        studentMajor.setAlignmentX(CENTER_ALIGNMENT);
        studentMajor.setForeground(Color.BLACK);

        JTextField studentMajorField = new JTextField(15);
        studentMajorField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        studentMajorField.setEditable(false);
        studentMajorField.setMinimumSize(new Dimension(400, 50));
        studentMajorField.setMaximumSize(new Dimension(400, 50));
        studentMajorField.setAlignmentX(LEFT_ALIGNMENT);

        JComponent[] studentMajorComponents = {studentMajor, studentMajorField};
        Box studentMajorBox = AddToBox.addToVerticalBox(studentMajorComponents, 1);


        this.setLayout(new GridBagLayout());
        GridBagConstraints s = new GridBagConstraints();
        s.fill = GridBagConstraints.BOTH;
        s.gridx = 0;
        s.gridy = 0;
        s.weightx = 1;
        s.weighty = 1;
        s.insets = new Insets(0, 10, 0, 10);
        this.add(studentIdBox, s);
        
        s.gridx = 1;
        s.gridy = 0;
        s.weightx = 1;
        s.weighty = 1;
        s.insets = new Insets(0, 10, 0, 10);
        this.add(studentNameBox, s);

        s.gridx = 0;
        s.gridy = 1;
        s.weightx = 1;
        s.weighty = 1;
        s.insets = new Insets(0, 10, 0, 10);
        this.add(studentEmailBox, s);

        s.gridx = 1;
        s.gridy = 1;
        s.weightx = 1;
        s.weighty = 1;
        s.insets = new Insets(0, 10, 0, 10);
        this.add(studentPhoneBox, s);

        s.gridx = 0;
        s.gridy = 2;
        s.weightx = 1;
        s.weighty = 1;
        s.insets = new Insets(0, 10, 0, 10);
        this.add(studentGenderBox, s);

        s.gridx = 1;
        s.gridy = 2;
        s.weightx = 1;
        s.weighty = 1;
        s.insets = new Insets(0, 10, 0, 10);
        this.add(studentDOBBox, s);

        s.gridx = 0;
        s.gridy = 3;
        s.weightx = 1;
        s.weighty = 1;
        s.insets = new Insets(0, 10, 0, 10);
        this.add(studentMajorBox, s);     
    }
}
