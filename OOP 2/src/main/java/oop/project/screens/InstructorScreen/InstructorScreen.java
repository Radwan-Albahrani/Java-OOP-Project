/* Instructor Screen
* Allows instructor to
*      -Join a course if they are not already in one of the given courses
*      -See the students registered in the course
*      -Add an announcement to the course
*      -Click on a student to open up a new window that allows them to add, edit, and view grades
*      -View the course announcements
*      -View the total course grades
*      -Send a message to the admin using Alerts
*/

//TODO: Current Issues:
//      - Can only switch between the panels once before not being able to switch back
//      - Need to add a way to add an announcement
//      - Need to the student view panel
//      - Need to add a way to edit grades

package oop.project.screens.InstructorScreen;

import javax.swing.*;
import java.awt.*;
import java.util.Dictionary;

import com.k33ptoo.components.*;
import oop.project.screens.InstructorScreen.Panels.*;
import oop.project.screens.components.*;
import oop.project.screens.hooks.*;
import java.util.*;

public class InstructorScreen extends JFrame
{
    public InstructorScreen()
    {
        // Frame Setup
        FrameConfig.set(this, "Instructor"); // Creating the frame

        // Panels
        KGradientPanel mainPanel = new MainPanel(getWidth(), getHeight());
        KGradientPanel buttonPanel = new ButtonPanel(this, getWidth(), getHeight());
        KGradientPanel announcementPanel = new AnnouncementPanel(getWidth(), getHeight());
        KGradientPanel viewStudentsPanel = new ViewStudentsPanel(getWidth(), getHeight());
        KGradientPanel editGradesPanel = new EditGradesPanel(getWidth(), getHeight());
        KGradientPanel profilePanel = new ProfilePanel(getWidth(), getHeight());
        KGradientPanel alertsPanel = new AlertsPanel(getWidth(), getHeight());

        // Setting up a dictionary to store the panels
        Dictionary<String, KGradientPanel> panels = new Hashtable<String, KGradientPanel>();
        panels.put("main", mainPanel);
        panels.put("announcement", announcementPanel);
        panels.put("viewStudents", viewStudentsPanel);
        panels.put("editGrades", editGradesPanel);
        panels.put("profile", profilePanel);
        panels.put("alerts", alertsPanel);
        panels.put("button", buttonPanel);

        // Setting the panels in the button panel
        ((ButtonPanel) buttonPanel).setPanels(panels);

        // Adding Panel to Frame
        JPanel navBar = new NavBar(this); // Creating the nav bar
        add(navBar, BorderLayout.NORTH); // add the nav bar to the top
        add(buttonPanel, BorderLayout.WEST); // add the button panel to the left
        add(mainPanel, BorderLayout.CENTER); // add the main panel to the center

        setVisible(true);
    }
}
