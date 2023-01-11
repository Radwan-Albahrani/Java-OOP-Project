package oop.project.screens.Student;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import com.k33ptoo.components.*;

import oop.project.screens.Student.Panels.*;
import oop.project.screens.components.*;
import oop.project.screens.hooks.*;


public class StudentScreen extends JFrame
{
    public StudentScreen()
    {
        FrameConfig.set(this, "Student");

        KGradientPanel mainPanel = new StudentMain(getWidth(), getHeight());
        KGradientPanel buttonPanel = new StudentButton(this, getWidth(), getHeight());
        KGradientPanel registerClass = new registerClass(getWidth(), getHeight());
        KGradientPanel viewAlerts = new ViewAlerts(getWidth(), getHeight());
        KGradientPanel dropClass = new DropClass(getWidth(), getHeight());
        KGradientPanel viewGrades = new ViewGrades(getWidth(), getHeight());

        Dictionary<String, KGradientPanel> panels = new Hashtable<String, KGradientPanel>();
        panels.put("main", mainPanel);
        panels.put("registerClass", registerClass);
        panels.put("viewAlerts", viewAlerts);
        panels.put("dropClass", dropClass);
        panels.put("viewGrades", viewGrades);

        ((StudentButton) buttonPanel).setPanels(panels);

        JPanel navBar =  new NavBar(this);

        add(navBar, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);


        setVisible(true);
    }
}
