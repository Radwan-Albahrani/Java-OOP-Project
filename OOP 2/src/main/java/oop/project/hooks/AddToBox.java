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
            if (jComponent == null)
            {
                System.out.println("Component at position " + counter + " is null");
                continue;
            }
            verticalBox.add(Box.createVerticalStrut(10));
            verticalBox.add(jComponent);
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
            if (jComponent == null)
            {
                System.out.println("Component at position " + counter + " is null");
                continue;
            }
            horizontalBox.add(jComponent);
            counter++;
            if (counter == numberOfComponentsPerRow)
            {
                verticalBox.add(Box.createVerticalStrut(10));
                verticalBox.add(horizontalBox);
                horizontalBox = Box.createHorizontalBox();
                counter = 0;
            }
        }
        return verticalBox;
    }

    public static Box addToHorizontalBoxWithSpace(JComponent[] component, int numberOfComponentsPerColumn)
    {
        int counter = 0;
        Box horizontalBoxWithSpace = Box.createHorizontalBox();
        Box verticalBoxWithSpace = Box.createVerticalBox();
        for (JComponent jComponent : component)
        {
            if (jComponent == null)
            {
                System.out.println("Component at position " + counter + " is null");
                continue;
            }
            verticalBoxWithSpace.add(Box.createVerticalStrut(10));
            verticalBoxWithSpace.add(jComponent);
            if (counter != numberOfComponentsPerColumn - 1)
            {
                verticalBoxWithSpace.add(Box.createVerticalStrut(10));
            }
            counter++;
            if (counter == numberOfComponentsPerColumn)
            {
                horizontalBoxWithSpace.add(verticalBoxWithSpace);
                horizontalBoxWithSpace.add(Box.createHorizontalStrut(10));
                verticalBoxWithSpace = Box.createVerticalBox();
                counter = 0;
            }
        }
        return horizontalBoxWithSpace;
    }
}
