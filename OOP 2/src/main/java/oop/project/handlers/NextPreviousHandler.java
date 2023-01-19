package oop.project.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import oop.project.screens.InstructorScreen.Panels.EditGradesPanel;

public class NextPreviousHandler implements ActionListener
{
    /**
     *
     */
    private final JPanel editGradesPanel;
    private final JComboBox<String> idJComboBoxList;
    private int currentEntryIndex;

    public NextPreviousHandler(JPanel editGradesPanel, JComboBox<String> idJComboBoxList)
    {
        this.editGradesPanel = editGradesPanel;
        this.idJComboBoxList = idJComboBoxList;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("previous"))
        {
            if (this.currentEntryIndex > 0)
            {
                this.currentEntryIndex--;

                idJComboBoxList.setSelectedIndex(this.currentEntryIndex);
                System.err.println("Previous Button Clicked");
            }
            else if (this.currentEntryIndex == 0)
            {
                this.currentEntryIndex = idJComboBoxList.getItemCount() - 1;
                idJComboBoxList.setSelectedIndex(this.currentEntryIndex);
            }
        }
        else if (e.getActionCommand().equals("next"))
        {
            if (this.currentEntryIndex < idJComboBoxList.getItemCount() - 1)
            {
                this.currentEntryIndex++;

                idJComboBoxList.setSelectedIndex(this.currentEntryIndex);
                System.err.println("Next Button Clicked");
            }
            else if (this.currentEntryIndex == idJComboBoxList.getItemCount() - 1)
            {
                this.currentEntryIndex = 0;
                idJComboBoxList.setSelectedIndex(this.currentEntryIndex);
            }
        }
    }
}