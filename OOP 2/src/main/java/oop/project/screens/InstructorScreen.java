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


package oop.project.screens;

import javax.swing.*;
import java.awt.*;
import com.k33ptoo.components.*;

import oop.project.screens.components.*;
import oop.project.screens.hooks.*;
import oop.project.handlers.*;


public class InstructorScreen extends JFrame 
{
    private JSplitPane splitPaneV; // Veritcal split pane
    private JPanel buttonPanel; // Panel for buttons
    private JPanel mainPanel;   // Panel for main content

    public InstructorScreen()
    {
        // Frame Setup
        FrameConfig.set(this, "Instructor"); // Creating the frame

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        getContentPane().add(leftPanel);

        createMainPanel();
        createButtonPanel();
        
        splitPaneV = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        leftPanel.add( splitPaneV, BorderLayout.CENTER );
        splitPaneV.setDividerLocation(100); // Setting the divider location
        splitPaneV.setDividerSize(0); // Setting the divider size
        splitPaneV.setRightComponent(buttonPanel); // Setting the left component (Button Panel)
        splitPaneV.setLeftComponent(mainPanel); // Setting the right component (Main Panel)
        
        setVisible(true);
    }

    public void createButtonPanel()
    {
        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        mainPanel.setBackground(Color.WHITE);
        

        mainPanel.add(new JButton("Add Announcement"), BorderLayout.CENTER);
        mainPanel.add(new JButton("View Students"), BorderLayout.CENTER);
        mainPanel.add(new JButton("View Profile"), BorderLayout.CENTER);
        mainPanel.add(new JButton("Logout"), BorderLayout.CENTER);
    }

    public void createMainPanel()
    {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.setBackground(Color.WHITE);
    }
}
