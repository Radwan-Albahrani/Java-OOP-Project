package oop.project.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class MovementButtonHandler implements ActionListener
{
    int currentEntryIndex;
    int maxEntryIndex;
    JComboBox<String> list;

    public MovementButtonHandler(JComboBox<String> list, int currentEntryIndex, int maxEntryIndex)
    {
        this.list = list;
        this.currentEntryIndex = currentEntryIndex;
        this.maxEntryIndex = maxEntryIndex;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String buttonClicked = e.getActionCommand().trim();
        if (buttonClicked.equals("—>"))
        {
            currentEntryIndex++;

            if (currentEntryIndex == maxEntryIndex) 
            {
                currentEntryIndex = 0;
            }
            list.setSelectedIndex(currentEntryIndex);
            System.err.println("Next Button Clicked");
        }
        else if (buttonClicked.equals("<—"))
        {
            currentEntryIndex--;

            if (currentEntryIndex < 0) 
            {
                currentEntryIndex = maxEntryIndex - 1;
            }
            list.setSelectedIndex(currentEntryIndex);
            System.err.println("Previous Button Clicked");
        }
    }
}
        
/*
        //TODO: Change the values of the text fields to the values of the current entry
        currentEntryIndex = list.getSelectedIndex();
      
        if (maxEntryIndex != 0 && currentEntryIndex < maxEntryIndex)
        {
             
            currentEntry = results.get(currentEntryindex);
            idTextField.setText("" + currentEntry.getAddressID());
            firstNameTextField.setText(currentEntry.getFirstName());
            lastNameTextField.setText(currentEntry.getLastName());
            emailTextField.setText(currentEntry.getEmail());
            phoneTextField.setText(currentEntry.getPhoneNumber());
            maxTextField.setText("" + numberOfEntries);
            indexTextField.setText("" + (currentEntryindex + 1));
      } 
*/
   