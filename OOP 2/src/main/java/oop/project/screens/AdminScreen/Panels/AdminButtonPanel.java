package oop.project.screens.AdminScreen.Panels;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import com.k33ptoo.components.*;

import oop.project.handlers.AdminButtonHandler;
import oop.project.components.*;
import oop.project.hooks.AddToBox;
public class AdminButtonPanel  extends ThemedPanel
{
 
    
    
        Dictionary<String, KButton> myButtons = new Hashtable<String, KButton>();
        Dictionary<String, KGradientPanel> panels = new Hashtable<String, KGradientPanel>();

        String[] All_buttons = 
        {
            "Main Menu",
            "View Alerts", 
            "Edit user profile",
            "view instructors",
            "view Student", 
            "view profile",
            "Logout"
            

        };




        JFrame frame;
        Box user_info;
        Box mainButtonBox;

       public void insertingPanels(Dictionary<String, KGradientPanel> panel) 
        {
             this.panels = panel;

            for (int i = 0; i < All_buttons.length; i++) 
              {
                myButtons.get(All_buttons[i].trim()) .addActionListener(new AdminButtonHandler(frame, this.panels, user_info, mainButtonBox));

              }

         }
         public AdminButtonPanel(JFrame frame, int Width, int Height)
    {
        // Set the frame and the panel size
        this.frame = frame;
        this.setPreferredSize(new Dimension(300, 0));

        // Add all the buttons to the dictionary
        for (int i = 0; i < All_buttons.length; i++)
        {
            myButtons.put(All_buttons[i].trim(), new CustomButton(All_buttons[i]));
        }

        // Buttons for the main Box
        JComponent[] mainButtonComponents = 
        {
                myButtons.get("View Alerts"),
                myButtons.get("Edit user profile"),
                myButtons.get("view instructors"),
                myButtons.get("view Student")
        };
        // Add the buttons to the mainButtonBox
        mainButtonBox = AddToBox.addToHorizontalBox(mainButtonComponents, 4);

        // Buttons for the student Box
        JComponent[] profileJComponents =
         {
          myButtons.get("Main Menu"),
          myButtons.get("view profile"),
          myButtons.get("Edit user profile")
         };

       

        // Add the buttons to the studentButtonBox
        user_info = AddToBox.addToHorizontalBox(profileJComponents, 3); 

        // Add the main box and the logout button during panel initialization
        this.setLayout(new BorderLayout());
        this.add(mainButtonBox, BorderLayout.NORTH);
        this.add(myButtons.get("Logout"), BorderLayout.SOUTH);
    }
        
        

}
    
    

