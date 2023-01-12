package oop.project.screens.AdminScreen;




import oop.project.screens.AdminScreen.Panels.*;

import javax.swing.*;
import java.awt.*;
import com.k33ptoo.components.*;
import oop.project.screens.components.*;
import oop.project.screens.hooks.*;

public class AdminScreen extends JFrame
{

    public AdminScreen()
    {
        FrameConfig.set(this, "Admin"); // creating the Admin Frame 

        AdminInterface main_interface = new AdminInterface(getWidth(),getHeight());
        EditUserInfo edit_info = new EditUserInfo(getWidth(),getHeight());
        



        
























        // Adding Panel to Frame
        JPanel navBar = new NavBar(this); // Creating the nav bar
        add(navBar, BorderLayout.NORTH); // add the nav bar to the top
        
        setVisible(true);

    }



    
}
