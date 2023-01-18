package oop.project.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import oop.project.screens.InstructorScreen.Panels.EditGradesPanel;

public class NextPreviousHandler implements ActionListener
{
    /**
     *
     */
    private final EditGradesPanel editGradesPanel;
    private final JComboBox<String> idJComboBoxList;

    public NextPreviousHandler(EditGradesPanel editGradesPanel, JComboBox<String> idJComboBoxList)
    {
        this.editGradesPanel = editGradesPanel;
        this.idJComboBoxList = idJComboBoxList;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("previous"))
        {
            if (this.editGradesPanel.currentEntryIndex > 0)
            {
                this.editGradesPanel.currentEntryIndex--;

                idJComboBoxList.setSelectedIndex(this.editGradesPanel.currentEntryIndex);
                System.err.println("Previous Button Clicked");
            }
            else if (this.editGradesPanel.currentEntryIndex == 0)
            {
                this.editGradesPanel.currentEntryIndex = idJComboBoxList.getItemCount() - 1;
                idJComboBoxList.setSelectedIndex(this.editGradesPanel.currentEntryIndex);
            }
        }
        else if (e.getActionCommand().equals("next"))
        {
            if (this.editGradesPanel.currentEntryIndex < idJComboBoxList.getItemCount() - 1)
            {
                this.editGradesPanel.currentEntryIndex++;

                idJComboBoxList.setSelectedIndex(this.editGradesPanel.currentEntryIndex);
                System.err.println("Next Button Clicked");
            }
            else if (this.editGradesPanel.currentEntryIndex == idJComboBoxList.getItemCount() - 1)
            {
                this.editGradesPanel.currentEntryIndex = 0;
                idJComboBoxList.setSelectedIndex(this.editGradesPanel.currentEntryIndex);
            }
        }
    }
}