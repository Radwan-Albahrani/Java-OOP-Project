package oop.project.screens.InstructorScreen.Panels;

import oop.project.components.TransparentPanel;
import java.awt.Font;
import oop.project.components.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import oop.project.handlers.RegisterCourseHandler;

import com.k33ptoo.components.KButton;


public class MainPanel extends TransparentPanel
{
    public MainPanel(int Width, int Height)
    {
        boolean inCourse = false;
        
        // TODO: Change to actual name
        // TODO: if the instructor is not in a course, show a message saying they are not in a course
        JLabel welcomeLabel = new TitleLabel("Welcome, [Name Here]");
        welcomeLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 50));
        this.add(welcomeLabel);
        
        if(!inCourse) //IOf the instructor is not in a course
        {
            System.out.println("This Instructor is not in a course - Instructor [UserID]");
            JLabel registerLabel = new JLabel("You are currently not registered in a course. Please click the 'Register Course' button to register in a course.");
            registerLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));

            KButton registerButton = new CustomButtonInstructor("Register Course");

            this.add(registerLabel);
            this.add(registerButton);

            // Button Handler
            registerButton.addActionListener(new RegisterCourseHandler(this));
           

        }
        else //If the instructor is in a course
        {
            System.out.println("This Instructor is registered in course [CourseID] - Instructor [UserID]");
            JLabel courseLabel = new JLabel("You are currently registered in [Course Name Here].");
            JLabel informationLabel = new JLabel("Here is some information about your course:");
            /* TODO:    Add information about the course
            *           Top 3 students
            *           Average grade
            *           Number of students
            *           Last 3 announcements
            *           Current achademic year, term, and week
            *       
             */
            courseLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));

            this.add(courseLabel);
            this.add(informationLabel);
        }
    }
}
