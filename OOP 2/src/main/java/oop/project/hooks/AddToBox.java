package oop.project.hooks;

import javax.swing.*;

public class AddToBox
{

    public static Box addToHorizontalBox(JComponent[] component, int numberOfComponentsPerColumn)
    {
        int counter = 0;
        Box horizontalBox = Box.createHorizontalBox();
        Box verticalBox = Box.createVerticalBox();
        for (JComponent jComponent : component)
        {
            verticalBox.add(jComponent);
            if (counter != numberOfComponentsPerColumn - 1)
            {
                verticalBox.add(Box.createVerticalStrut(10));
            }
            counter++;
            if (counter == numberOfComponentsPerColumn)
            {
                horizontalBox.add(verticalBox);
                horizontalBox.add(Box.createHorizontalStrut(10));
                verticalBox = Box.createVerticalBox();
                counter = 0;
            }
        }
        return horizontalBox;
    }

    public static Box addToVerticalBox(JComponent[] component, int numberOfComponentsPerRow)
    {
        int counter = 0;
        Box verticalBox = Box.createVerticalBox();
        Box horizontalBox = Box.createHorizontalBox();
        for (JComponent jComponent : component)
        {
            horizontalBox.add(jComponent);
            if (counter != numberOfComponentsPerRow - 1)
            {
                horizontalBox.add(Box.createHorizontalStrut(10));
            }
            counter++;
            if (counter == numberOfComponentsPerRow)
            {
                verticalBox.add(horizontalBox);
                verticalBox.add(Box.createVerticalStrut(10));
                horizontalBox = Box.createHorizontalBox();
                counter = 0;
            }
        }
        return verticalBox;
    }

}