package oop.project.screens.InstructorScreen.Frames;

import javax.swing.*;
import java.awt.*;

import com.k33ptoo.components.*;
import oop.project.components.*;
import oop.project.hooks.*;
import oop.project.handlers.RegisterCourseHandler;


/*TODO:     Have radio buttons for the course to select
    *       Have a button to register the course
    *       
    *
*/

public class RegisterCourseFrame extends JFrame{
    KButton registerButton;

    //TODO: Actually implement this
    public RegisterCourseFrame(JPanel parent)
    {
        FrameConfig.set(this, "RegisterCourse", 700, 700);
        KGradientPanel registerCoursePanel = new ThemedPanelInstructor();

        JLabel courseLabel = new JLabel("Course");
        courseLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));


        //Create a way to store the courses and use a for loop to create the radio buttons
       
     
        JRadioButton course1 = new JRadioButton("Course 1");
        course1.setSelected(true);
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

       
        JComponent[] components = {courseLabel, course1, course2, course3, course4, registerButton};

        // Add to Frame
        this.setLayout(new BorderLayout()); // set the layout to border layout
        JPanel navBar = new NavBar(this, true); // Creating the nav bar
        this.add(navBar, BorderLayout.NORTH); // add the nav bar to the top

        registerButton = new CustomButtonInstructor("Register");
        
        registerCoursePanel.add(courseLabel);
        registerCoursePanel.add(course1);
        registerCoursePanel.add(course2);
        registerCoursePanel.add(course3);
        registerCoursePanel.add(course4);
        registerCoursePanel.add(registerButton);
        

        this.add(registerCoursePanel);


    }

    public void setHandler(RegisterCourseHandler handler)
    {
        registerButton.addActionListener(handler);
    }
}

