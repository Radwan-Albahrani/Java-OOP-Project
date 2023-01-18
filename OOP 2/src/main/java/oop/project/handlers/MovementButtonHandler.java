package oop.project.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;


public class MovementButtonHandler implements ActionListener
{
    private int currentEntryindex;
    private int maxEntryIndex;
    private JComboBox<String> list;

    public MovementButtonHandler(JComboBox<String> list, int currentEntryIndex, int maxEntryIndex)
    {
        this.list = list;
        this.currentEntryindex = currentEntryIndex;
        this.maxEntryIndex = maxEntryIndex;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String buttonClicked = e.getActionCommand().trim();
        if (buttonClicked.equals("—>"))
        {
            currentEntryindex++;
            if (currentEntryindex == maxEntryIndex) 
            {
                currentEntryindex = 0;
            }
            list.setSelectedIndex(currentEntryindex);
            System.err.println("Next Button Clicked");
        }
        else if (buttonClicked.equals("<—"))
        {
            currentEntryindex--;
            if (currentEntryindex < 0) 
            {
                currentEntryindex = maxEntryIndex - 1;
            }
            list.setSelectedIndex(currentEntryindex);
            System.err.println("Previous Button Clicked");
        }
        System.err.println("Current Entry Index: " + currentEntryindex);
    }
}