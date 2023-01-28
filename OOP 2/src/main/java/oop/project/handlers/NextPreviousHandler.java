package oop.project.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class NextPreviousHandler implements ActionListener
{
    private final JComboBox<String> idJComboBoxList;

    public NextPreviousHandler(JComboBox<String> idJComboBoxList)
    {
        this.idJComboBoxList = idJComboBoxList;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        int currentEntryIndex = idJComboBoxList.getSelectedIndex();
        if (e.getActionCommand().equals("previous"))
        {
            if (currentEntryIndex == -1)
            {
                return;
            }
            if (currentEntryIndex > 0)
            {
                currentEntryIndex--;

                idJComboBoxList.setSelectedIndex(currentEntryIndex);
                System.err.println("Previous Button Clicked");
            }
            else
            {
                currentEntryIndex = idJComboBoxList.getItemCount() - 1;
                idJComboBoxList.setSelectedIndex(currentEntryIndex);
            }
        }
        else if (e.getActionCommand().equals("next"))
        {
            if (currentEntryIndex == -1)
            {
                return;
            }

            if (currentEntryIndex < idJComboBoxList.getItemCount() - 1)
            {
                currentEntryIndex++;

                idJComboBoxList.setSelectedIndex(currentEntryIndex);
                System.err.println("Next Button Clicked");
            }
            else
            {
                currentEntryIndex = 0;
                idJComboBoxList.setSelectedIndex(currentEntryIndex);
            }
        }
    }
}