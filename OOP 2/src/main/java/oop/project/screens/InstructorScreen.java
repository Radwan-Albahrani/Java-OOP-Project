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

package oop.project.screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.k33ptoo.components.*;

import oop.project.screens.components.*;
import oop.project.screens.hooks.*;

public class InstructorScreen extends JFrame
{
    // Panel Setup
    KGradientPanel buttonPanel = new ThemedPanel(); // Panel for the buttons
    KGradientPanel mainPanel = new ThemedPanelStudent(); // Panel for the main screen
    KGradientPanel announcementPanel = new ThemedPanelStudent(); // Panel for the announcement screen
    KGradientPanel viewStudentsPanel = new ThemedPanelStudent(); // Panel for the view students screen
    KGradientPanel editGradesPanel = new ThemedPanelStudent(); // Panel for the edit grades screen
    KGradientPanel profilePanel = new ThemedPanelStudent(); // Panel for the profile screen

    // Button Setup
    KButton MenuButton = new CustomButton("Main Menu"); // Button to go back to the main menu
    KButton AnnouncementButton = new CustomButton("Add Announcement"); // Button to add an announcement
    KButton StudentButton = new CustomButton("View Students"); // Button to view the students
    KButton StudentViewButton = new CustomButton("View Students"); // Button to view the students
    KButton editGradeButton = new CustomButton("Edit Grades"); // Button to edit grades
    KButton ProfileButton = new CustomButton("View Profile"); // Button to view profile
    KButton LogoutButton = new CustomButton("Logout"); // Button to logout

    // Box Setup
    JComponent[] mainButtonComponents = {AnnouncementButton, StudentButton, ProfileButton}; // Components for the Main Menu
    Box mainButtonBox = AddToBox.addToHorizontalBox(mainButtonComponents, 3); // Box for the Main Menu
    JComponent[] studentButtonComponents = {MenuButton, StudentViewButton, editGradeButton}; // Components for the Student Menu
    Box studentButtonBox = AddToBox.addToHorizontalBox(studentButtonComponents, 3); // Box for the Student Menu

    public InstructorScreen()
    {
        // Frame Setup
        FrameConfig.set(this, "Instructor"); // Creating the frame

        // Left Button Panel Setup (Will be shown by default)
        AnnouncementButton.setPreferredSize(new Dimension(250, 50));
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.setPreferredSize(new Dimension(250, 0));

        // Main Panel Setup (Will be shown by default)
        JLabel welcomeLabel = new JLabel("Welcome, Instructor"); // TODO: Change to actual name
        // TODO: if the instructor is not in a course, show a message saying they are not in a course
        // and give them the option to join a course
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        mainPanel.add(welcomeLabel);
        // mainButtonComponents for the Main Menu
        buttonPanel.add(mainButtonBox, BorderLayout.NORTH);
        buttonPanel.add(LogoutButton, BorderLayout.SOUTH);

        // Announcement Panel Setup (Will replace Main Panel when Announcement Button is clicked)
        JLabel announcementLabel = new JLabel("Please add an announcement");
        KButton sendButton = new CustomButton("Send");
        sendButton.setPreferredSize(new Dimension(100, 50));
        JTextField announcementTextField = new JTextField();
        announcementTextField.setPreferredSize(new Dimension(200, 50));
        announcementLabel.setFont(new Font("Arial", Font.BOLD, 30));
        announcementPanel.add(announcementLabel);
        announcementPanel.add(announcementTextField); // TODO: Add a textfield to add the announcement
        announcementPanel.add(sendButton);

        // Student Panel Setup (Will replace Main Panel when Student Button is clicked)
        JLabel viewStudentsLabel = new JLabel("Here are all the students");
        viewStudentsLabel.setFont(new Font("Arial", Font.BOLD, 30));
        viewStudentsPanel.add(viewStudentsLabel);

        JLabel editGradesLabel = new JLabel("Edit Grades");
        editGradesLabel.setFont(new Font("Arial", Font.BOLD, 30));
        editGradesPanel.add(editGradesLabel);

        // Profile Panel Setup (Will replace Main Panel when Profile Button is clicked)
        JLabel profileLabel = new JLabel("Here is your profile");
        profileLabel.setFont(new Font("Arial", Font.BOLD, 30));
        profilePanel.add(profileLabel);

        // Adding the panels to the frame
        JPanel navBar = new NavBar(this);
        add(navBar, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.WEST); // add the button panel to the left
        add(mainPanel, BorderLayout.CENTER); // add the main panel to the center

        setVisible(true);

        // Action Listeners
        ButtonHandler handler = new ButtonHandler(this);
        MenuButton.addActionListener(handler);
        AnnouncementButton.addActionListener(handler);
        StudentButton.addActionListener(handler);
        ProfileButton.addActionListener(handler);
        LogoutButton.addActionListener(handler);
    }

    // TODO: use buttonPanel.remove() to remove the current panel and add the new one with an if statement assuming the button is clicked

    public class ButtonHandler implements ActionListener
    {
        JFrame frame;

        ButtonHandler(JFrame frame)
        {
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            String buttonClicked = e.getActionCommand();
            if (buttonClicked.equals("Main Menu"))
            {
                remove(announcementPanel);
                remove(viewStudentsPanel);
                remove(editGradesPanel);
                add(mainPanel, BorderLayout.CENTER);
                buttonPanel.remove(studentButtonBox);
                buttonPanel.add(mainButtonBox, BorderLayout.NORTH);
            }

            else if (buttonClicked.equals("Add Announcement"))
            {
                remove(mainPanel);
                remove(profilePanel);
                remove(viewStudentsPanel);
                remove(editGradesPanel);
                add(announcementPanel, BorderLayout.CENTER);
            }

            else if (buttonClicked.equals("View Students"))
            {
                buttonPanel.remove(mainButtonBox);
                buttonPanel.add(studentButtonBox, BorderLayout.NORTH);

                remove(mainPanel);
                remove(announcementPanel);
                remove(profilePanel);
                remove(editGradesPanel);
                add(viewStudentsPanel, BorderLayout.CENTER);
            }

            else if (buttonClicked.equals("Edit Grades"))
            {
                remove(mainPanel);
                remove(announcementPanel);
                remove(viewStudentsPanel);
                remove(profilePanel);
                add(editGradesPanel, BorderLayout.CENTER);
            }

            else if (buttonClicked.equals("View Profile"))
            {
                remove(mainPanel);
                remove(announcementPanel);
                remove(viewStudentsPanel);
                remove(editGradesPanel);
                add(profilePanel, BorderLayout.CENTER);
            }

            else if (buttonClicked.equals("Logout"))
            {
                dispose();
                new LoginScreen();
            }

            frame.revalidate();
            frame.repaint();
        }
    }
}
