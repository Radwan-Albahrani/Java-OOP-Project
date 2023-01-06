package oop.project.screens.hooks;

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

    public static Box addToVerticalBox(JComponent[] registerClassComponents, int i) {
        return null;
    }

}
