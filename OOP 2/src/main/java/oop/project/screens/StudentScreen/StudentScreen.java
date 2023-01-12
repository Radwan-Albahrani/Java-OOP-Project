package oop.project.screens.StudentScreen;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import com.k33ptoo.components.*;

import oop.project.components.*;
import oop.project.hooks.*;
import oop.project.screens.StudentScreen.Panels.*;

public class StudentScreen extends JFrame
{
    public StudentScreen()
    {
        FrameConfig.set(this, "Student");

        FrameConfig.setBackground(this, "StudentScreen/background.png");

        JPanel mainPanel = new StudentMain(getWidth(), getHeight());
        KGradientPanel buttonPanel = new StudentButton(this, getWidth(), getHeight());
        JPanel registerClass = new registerClass(getWidth(), getHeight());
        JPanel viewAlerts = new ViewAlerts(getWidth(), getHeight());
        JPanel dropClass = new DropClass(getWidth(), getHeight());
        JPanel viewGrades = new ViewGrades(getWidth(), getHeight());

        Dictionary<String, JPanel> panels = new Hashtable<String, JPanel>();
        panels.put("main", mainPanel);
        panels.put("registerClass", registerClass);
        panels.put("viewAlerts", viewAlerts);
        panels.put("dropClass", dropClass);
        panels.put("viewGrades", viewGrades);

        ((StudentButton) buttonPanel).setPanels(panels);

        JPanel navBar = new NavBar(this);

        setLayout(new BorderLayout());

        add(navBar, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}
