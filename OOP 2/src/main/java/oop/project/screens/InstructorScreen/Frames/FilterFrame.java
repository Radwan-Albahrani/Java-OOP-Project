package oop.project.screens.InstructorScreen.Frames;

import javax.swing.*;
import java.awt.*;

import com.k33ptoo.components.*;

import oop.project.components.buttons.CustomButtonInstructor;
import oop.project.components.core.NavBar;
import oop.project.components.panels.ThemedPanelInstructor;
import oop.project.hooks.*;
import oop.project.handlers.FilterButtonHandler;
 
/* TODO: Allow for the following filters'
        - By ID
 *      - By First Name
 *      - By Last Name
 */


public class FilterFrame extends JFrame 
{

    KButton filterButton;

    public FilterFrame(JPanel parent)
    {
        FrameConfig.set(this, "Filter", 500, 500);
        KGradientPanel filterPanel = new ThemedPanelInstructor();

        JLabel filterLabel = new JLabel("Filter");
        filterLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        this.setLocationRelativeTo(parent);

        filterButton = new CustomButtonInstructor("Filter");    

        JLabel idLabel = new JLabel("ID");
        JTextField idField = new JTextField(10);

        JLabel firstNameLabel = new JLabel("First Name");
        JTextField firstNameField = new JTextField(10);

        JLabel lastNameLabel = new JLabel("Last Name");
        JTextField lastNameField = new JTextField(10);







        // Add to Frame
        this.setLayout(new BorderLayout()); // set the layout to border layout
        JPanel navBar = new NavBar(this, true); // Creating the nav bar
        this.add(navBar, BorderLayout.NORTH); // add the nav bar to the top





        JComponent [] components = {filterLabel, filterButton};
        Box box = AddToBox.addToHorizontalBox(components, 2);

        filterPanel.add(box);

        this.add(filterPanel);
    }

    public void setHandler(FilterButtonHandler handler)
    {
        filterButton.addActionListener(handler);
    }
}
