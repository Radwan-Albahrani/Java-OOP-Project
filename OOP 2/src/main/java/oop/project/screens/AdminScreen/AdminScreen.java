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

        KGradientPanel main_interface = new AdminInterface(getWidth(), getHeight());
        KGradientPanel edit_info = new EditUserInfo(getWidth(), getHeight());
        KGradientPanel view_profile = new ViewProfile(getWidth(), getHeight());
        KGradientPanel view_student = new ViewStudent(getWidth(), getHeight());
        KGradientPanel view_Instructors = new ViewInstructors(getWidth(), getHeight());
        KGradientPanel view_Alerts = new ViewAlerts(getWidth(), getHeight());
        KGradientPanel pButtonPanel = new AdminButtonPanel(this, getWidth(), getHeight());
        KGradientPanel viewRegistrations = new ViewRegistrationPanel(getWidth(), getHeight());

        Dictionary<String, KGradientPanel> dictionary_panel = new Hashtable<String, KGradientPanel>();

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
        JPanel navBar = new NavBar(this);

        add(navBar, BorderLayout.NORTH);
        add(main_interface, BorderLayout.CENTER);
        add(pButtonPanel, BorderLayout.WEST);

        setVisible(true);

    }

}
