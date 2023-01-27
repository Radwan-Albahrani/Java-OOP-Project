package oop.project.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveChangesHandler implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String buttonClicked = e.getActionCommand().trim();
        if (buttonClicked.equals("Save Changes") || buttonClicked.equals("Save"))
        {
            System.err.println("Save Button Clicked");
        }
        if (buttonClicked.equals("Cancel"))
        {
            System.err.println("Cancel Button Clicked");
        }
        if (buttonClicked.equals("Save Grades"))
        {
            
            System.err.println("Save Grades Button Clicked");
        }
    }
}