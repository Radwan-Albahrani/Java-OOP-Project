package oop.project.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import oop.project.screens.InstructorScreen.Frames.FilterFrame;
import oop.project.screens.InstructorScreen.Panels.ViewStudentsPanel;

public class FilterButtonHandler implements ActionListener
{
    private final JFrame filterFrame;

    public FilterButtonHandler(ViewStudentsPanel viewStudentsPanel)
    {
        this.filterFrame = new FilterFrame(viewStudentsPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String buttonClicked = e.getActionCommand().trim();
        if (buttonClicked.equals("Filter By"))
        {
            System.err.println("Filter By Button Clicked");
            ((FilterFrame) filterFrame).setHandler(this);
            filterFrame.setVisible(true);
        }
        //TODO: Add query options
    }
}
