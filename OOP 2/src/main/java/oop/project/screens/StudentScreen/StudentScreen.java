package oop.project.screens.StudentScreen;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import com.k33ptoo.components.*;

import oop.project.components.core.NavBar;
import oop.project.components.panels.ProfilePanel;
import oop.project.hooks.*;
import oop.project.screens.StudentScreen.Panels.*;

public class StudentScreen extends JFrame
{
    public StudentScreen()
    {
        FrameConfig.set(this, "Student");

        FrameConfig.setBackground(this, "StudentScreen/Background.png");

        JPanel mainPanel = new StudentMain(getWidth(), getHeight());
        KGradientPanel buttonPanel = new StudentButton(this, getWidth(), getHeight());
        JPanel profile = new ProfilePanel(getWidth(), getHeight(), 2);
        JPanel registerClass = new registerClassPanel(getWidth(), getHeight());
        JPanel sendAlerts = new SendAlerts(getWidth(), getHeight());
        JPanel dropClass = new DropClass(getWidth(), getHeight());
        JPanel viewGrades = new ViewGrades(getWidth(), getHeight());
        JPanel viewAnnouncements = new ViewAnnouncements(getWidth(), getHeight());

        Map<String, JPanel> panels = new Hashtable<String, JPanel>();
        panels.put("main", mainPanel);
        panels.put("profile", profile);
        panels.put("registerClass", registerClass);
        panels.put("sendAlerts", sendAlerts);
        panels.put("viewAnnouncements", viewAnnouncements);
        panels.put("dropClass", dropClass);
        panels.put("viewGrades", viewGrades);
        panels.put("button", buttonPanel);

        ((StudentButton) buttonPanel).setPanels(panels);

        JPanel navBar = new NavBar(this);

        setLayout(new BorderLayout());

        add(navBar, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void resetFrame(JPanel buttons, JPanel main)
    {
        setLayout(new BorderLayout());
        JPanel navBar = new NavBar(this);

        add(navBar, BorderLayout.NORTH);
        add(main, BorderLayout.CENTER);
        add(buttons, BorderLayout.WEST);
    }
}
