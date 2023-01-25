package oop.project.screens.InstructorScreen.Panels;

import oop.project.API.DatabaseCon;
import oop.project.components.buttons.CustomButtonInstructor;
import oop.project.components.core.TitleLabel;
import oop.project.components.panels.TransparentPanel;

import java.awt.Font;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.*;
import oop.project.handlers.RegisterCourseHandler;

import com.k33ptoo.components.KButton;

public class MainPanel extends TransparentPanel
{
    public MainPanel(int Width, int Height)
    {
        String courseIDQuery = """
            SELECT CourseID
            FROM courses
            WHERE InstructorID = %s;
                """.formatted(DatabaseCon.currentUser.getUserID());
        ResultSet courseIDResultSet = DatabaseCon.customQuery(courseIDQuery);
        // Change result set into string
        ArrayList<String> courseIDList = new ArrayList<>();
        // Add all the course IDs to the list
        try
        {
            while (courseIDResultSet.next())
            {
                courseIDList.add(courseIDResultSet.getString("CourseID"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        // TODO: Change to actual name
        // TODO: if the instructor is not in a course, show a message saying they are not in a course
        JLabel welcomeLabel = new TitleLabel("Welcome, [Name Here]");
        welcomeLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 50));
        this.add(welcomeLabel);

        if (courseIDList.size() == 0) // If the instructor is not in a course
        {
            System.out.println("This Instructor is not in a course - Instructor " + DatabaseCon.currentUser.getUserID());
            JLabel registerLabel = new JLabel(
                    "You are currently not registered in a course. Please click the 'Register Course' button to register in a course.");
            registerLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));

            KButton registerButton = new CustomButtonInstructor("Register Course");

            this.add(registerLabel);
            this.add(registerButton);

            // Button Handler
            registerButton.addActionListener(new RegisterCourseHandler(this));

        }
        else // If the instructor is in a course
        {
            System.out.println("This Instructor is registered in course " + courseIDList.get(0) + " - Instructor" + DatabaseCon.currentUser.getUserID());
            JLabel courseLabel = new JLabel("You are currently registered in " + courseIDList.get(0));

            // JLabel informationLabel = new JLabel("Here is some information about your course:");
            // /*
            //  * TODO: Add information about the course
            //  * Top 3 students
            //  * Average grade
            //  * Number of students
            //  * Last 3 announcements
            //  * Current achademic year, term, and week
            //  */
            courseLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));

            this.add(courseLabel);
            // this.add(informationLabel);
        }
    }
}
