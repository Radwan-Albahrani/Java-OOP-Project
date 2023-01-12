package oop.project.screens.AdminScreen;




import oop.project.screens.AdminScreen.panels.*;

import javax.swing.*;
import java.awt.*;
import com.k33ptoo.components.*;
import oop.project.components.*;
import oop.project.hooks.*;

public class AdminScreen extends JFrame
{

    public AdminScreen()
    {
        FrameConfig.set(this, "Admin"); // creating the Admin Frame 

        AdminInterface main_interface = new AdminInterface(getWidth(),getHeight());
        EditUserInfo edit_info = new EditUserInfo(getWidth(),getHeight());
        ViewProfile view_profile = new ViewProfile(getWidth(), getHeight());
        ViewStudent view_student  = new ViewStudent(getWidth(), getHeight());
        ViewInstructors view_Instructors = new ViewInstructors(getWidth(), getHeight());
        AdminInterface admin_AdminInterface = new AdminInterface(getWidth(), getHeight());
        ViewAlerts view_Alerts = new ViewAlerts(getWidth(),getHeight());

        add(main_interface);
        add(edit_info);
        add(view_profile);
        add(view_student);
        add(view_Instructors);
        add(admin_AdminInterface);
        add(view_Alerts);





        // Adding Panel to Frame
        JPanel navBar = new NavBar(this); // Creating the nav bar
        add(navBar, BorderLayout.NORTH); // add the nav bar to the top
        
        setVisible(true);

    }



    
}
