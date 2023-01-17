package oop.project.screens.AdminScreen;

import javax.swing.*;
import java.awt.*;
import java.util.Dictionary;
import java.util.Hashtable;

import com.k33ptoo.components.*;

import oop.project.components.*;
import oop.project.hooks.*;
import oop.project.screens.AdminScreen.Panels.*;

public class AdminScreen extends JFrame
{

    public AdminScreen()
    {

        FrameConfig.set(this, "Admin"); // creating the Admin Frame

        FrameConfig.setBackground(this, "AdminScreen/background.png");

        JPanel main_interface = new AdminInterface(getWidth(), getHeight());
        JPanel edit_info = new EditUserInfo(getWidth(), getHeight());
        JPanel view_profile = new ViewProfile(getWidth(), getHeight());
        JPanel view_student = new ViewStudent(getWidth(), getHeight());
        JPanel view_Instructors = new ViewInstructors(getWidth(), getHeight());
        JPanel view_Alerts = new ViewAlerts(getWidth(), getHeight());
        KGradientPanel pButtonPanel = new AdminButtonPanel(this, getWidth(), getHeight());
        JPanel viewRegistrations = new ViewRegistrationPanel(getWidth(), getHeight());

        Dictionary<String, JPanel> dictionary_panel = new Hashtable<>();

        dictionary_panel.put("Main", main_interface);
        dictionary_panel.put("Information", edit_info);
        dictionary_panel.put("Profile", view_profile);
        dictionary_panel.put("Student", view_student);
        dictionary_panel.put("Instructors", view_Instructors);
        dictionary_panel.put("Alerts", view_Alerts);
        dictionary_panel.put("button", pButtonPanel);
        dictionary_panel.put("Registrations", viewRegistrations);

        ((AdminButtonPanel) pButtonPanel).insertingPanels(dictionary_panel);

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
