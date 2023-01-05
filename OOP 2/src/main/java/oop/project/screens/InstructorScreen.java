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

public class InstructorScreen extends JFrame
{
    public InstructorScreen()
    {
        // Frame Setup
        FrameConfig.set(this, "Instructor"); // Creating the frame

        KButton AnnouncementButton = new BlueButton("Add Announcement");
        AnnouncementButton.setPreferredSize(new Dimension(200, 50));
        KButton StudentButton = new BlueButton("View Students");
        KButton ProfileButton = new BlueButton("View Profile");
        KButton LogoutButton = new BlueButton("Logout");

        // Button Panel Setup
        KGradientPanel buttonPanel = new ThemedPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));

        JComponent[] buttonComponents = {AnnouncementButton, StudentButton, ProfileButton, LogoutButton};
        Box buttonBox = AddToBox.addToHorizontalBox(buttonComponents, 4);
        buttonPanel.add(buttonBox);
        // Main Panel Setup
        KGradientPanel mainPanel = new ThemedPanelStudent();

        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}
