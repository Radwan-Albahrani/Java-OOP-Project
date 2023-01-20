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

package oop.project.screens.InstructorScreen;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

import com.k33ptoo.components.*;
import oop.project.screens.InstructorScreen.Panels.*;

import oop.project.components.core.NavBar;
import oop.project.components.panels.ProfilePanel;
import oop.project.hooks.*;
import java.util.*;

public class InstructorScreen extends JFrame
{
    public InstructorScreen()
    {
        // Frame Setup
        FrameConfig.set(this, "Instructor"); // Creating the frame

        FrameConfig.setBackground(this, "InstructorScreen/background.png");

        // Panels
        JPanel mainPanel = new MainPanel(getWidth(), getHeight());
        KGradientPanel buttonPanel = new ButtonPanel(this, getWidth(), getHeight());
        JPanel announcementPanel = new AnnouncementPanel(getWidth(), getHeight());
        JPanel viewStudentsPanel = new ViewStudentsPanel(getWidth(), getHeight());
        JPanel editGradesPanel = new EditGradesPanel(getWidth(), getHeight());
        JPanel profilePanel = new ProfilePanel(getWidth(), getHeight(), 1);
        JPanel alertsPanel = new AlertsPanel(getWidth(), getHeight());

        // Setting up a Map to store the panels
        Map<String, JPanel> panels = new Hashtable<>();
        panels.put("home", mainPanel);
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

    public void resetFrame(JPanel buttons, JPanel main)
    {
        setLayout(new BorderLayout());
        JPanel navBar = new NavBar(this);

        add(navBar, BorderLayout.NORTH);
        add(main, BorderLayout.CENTER);
        add(buttons, BorderLayout.WEST);
    }
}
