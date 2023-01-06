package oop.project.screens.Student;

import java.awt.*;
import javax.swing.*;
import com.k33ptoo.components.*;

import oop.project.App;
import oop.project.screens.components.*;
import oop.project.screens.hooks.*;
import oop.project.handlers.*;


public class Student extends JFrame
{
    public Student()
    {
        super("Student");

        //Frame setup
        FrameConfig.set(this, "Student Screen");

        //Background setup
        FrameConfig.setBackground(this, "StudentScreen/background.png");

        //Student Panel setup
        KGradientPanel studentPanel = new ThemedPanel();
        studentPanel.setPreferredSize(new Dimension((int) (getWidth() / 2), (int) (getHeight() / 1.4)));
        studentPanel.setSize(getPreferredSize());
        studentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 10));

        //Student Label setup
        JLabel studentLabel = new JLabel("Student");
        studentLabel.setForeground(Color.WHITE);
        studentLabel.setFont(new Font("Arial", Font.BOLD, 30));
        studentLabel.setHorizontalAlignment(JLabel.CENTER);
        studentLabel.setHorizontalTextPosition(JLabel.CENTER);

        //Border Layout
        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);

        //Register Class Button setup
        KButton registerClass = new BlueButton("Register Class");

        //Drop Class Button setup
        KButton dropClass = new BlueButton("Drop Class");

        //View Alerts Button setup
        KButton viewAlerts = new BlueButton("View Alerts");
    }
}
