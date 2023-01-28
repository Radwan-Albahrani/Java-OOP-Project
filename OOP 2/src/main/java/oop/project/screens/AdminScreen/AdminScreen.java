package oop.project.screens.AdminScreen;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.Hashtable;

import com.k33ptoo.components.*;

import oop.project.components.core.NavBar;
import oop.project.components.panels.ProfilePanel;
import oop.project.hooks.*;
import oop.project.screens.AdminScreen.Panels.*;

public class AdminScreen extends JFrame
{

    public AdminScreen()
    {

        FrameConfig.set(this, "Admin"); // creating the Admin Frame

        FrameConfig.setBackground(this, "AdminScreen/background.png");

        JPanel main_interface = new AdminInterface(getWidth(), getHeight());
        JPanel edit_info = new EditUserInfo(getWidth(), getHeight(), main_interface);
        JPanel view_profile = new ProfilePanel(getWidth(), getHeight(), 0);
        JPanel view_student = new ViewStudents(getWidth(), getHeight());
        JPanel view_Instructors = new ViewInstructors(getWidth(), getHeight());
        JPanel view_Alerts = new ViewAlerts(getWidth(), getHeight());
        KGradientPanel pButtonPanel = new AdminButtonPanel(this, getWidth(), getHeight());
        JPanel viewRegistrations = new ViewRegistrationPanel(getWidth(), getHeight());
        JPanel viewCourses = new CoursesPanel(getWidth(), getHeight());
        JPanel addCourses = new AddCoursesPanel(getWidth(), getHeight());

        Map<String, JPanel> Map_panel = new Hashtable<>();

        Map_panel.put("Main", main_interface);
        Map_panel.put("Information", edit_info);
        Map_panel.put("Profile", view_profile);
        Map_panel.put("Student", view_student);
        Map_panel.put("Instructors", view_Instructors);
        Map_panel.put("Alerts", view_Alerts);
        Map_panel.put("button", pButtonPanel);
        Map_panel.put("Registrations", viewRegistrations);
        Map_panel.put("Courses", viewCourses);
        Map_panel.put("AddCourses", addCourses);

        ((AdminButtonPanel) pButtonPanel).insertingPanels(Map_panel);

        setLayout(new BorderLayout());
        JPanel navBar = new NavBar(this, false);

        add(navBar, BorderLayout.NORTH);
        add(main_interface, BorderLayout.CENTER);
        add(pButtonPanel, BorderLayout.WEST);

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
