package oop.project.screens.InstructorScreen.Panels;

import oop.project.components.TransparentPanel;
import java.awt.Font;
import oop.project.components.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import com.k33ptoo.components.KButton;

/*TODO:     Have radio buttons for the course to select
    *       Have a button to register the course
    *       
    *
*/
public class RegisterCoursePanel extends TransparentPanel{

    //TODO: Actually implement this
    public RegisterCoursePanel()
    {

        JLabel courseLabel = new JLabel("Course");
        courseLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        this.add(courseLabel);

        //Create a way to store the courses and use a for loop to create the radio buttons
        JRadioButton course1 = new JRadioButton("Course 1");
        JRadioButton course2 = new JRadioButton("Course 2");
        JRadioButton course3 = new JRadioButton("Course 3");
        JRadioButton course4 = new JRadioButton("Course 4");
        add(course1);
        add(course2);
        add(course3);
        add(course4);

        ButtonGroup group = new ButtonGroup();
        group.add(course1);
        group.add(course2);
        group.add(course3);
        group.add(course4);

        KButton registerButton = new CustomButtonInstructor("Register");
        this.add(registerButton);

        ButtonHandler handler = new ButtonHandler();
        registerButton.addActionListener(handler);


    }

    private class ButtonHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {

        }
    }

    private class RadioButtonHandler implements ItemListener
    {
        @Override
        public void itemStateChanged(ItemEvent e)
        {

        }
    }
}

