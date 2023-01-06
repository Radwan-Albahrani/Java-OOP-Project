package oop.project.screens.Student;

import java.awt.*;
import javax.swing.*;
import com.k33ptoo.components.*;

import oop.project.App;
import oop.project.screens.Student.Panels.*;
import oop.project.screens.components.*;
import oop.project.screens.hooks.*;
import oop.project.handlers.*;


public class Student extends JFrame
{
    public Student()
    {
        FrameConfig.set(this, "Student");

        KGradientPanel StudentMain = new StudentMain(getWidth(), getHeight());
        KGradientPanel registerClass = new registerClass(getWidth(), getHeight());
        KGradientPanel ViewAlerts = new ViewAlerts(getWidth(), getHeight());
        KGradientPanel DropClass = new DropClass(getWidth(), getHeight());
        KGradientPanel ViewGrades = new ViewGrades(getWidth(), getHeight());

        KGradientPanel[] studentPanels = {StudentMain, registerClass, ViewAlerts,DropClass,ViewGrades};

        KButton[] studentButtons = {
            new StudentMainButton("Student Main", studentPanels),
            new registerClassButton("Register Class", studentPanels),
            new ViewAlertsButton("View Alerts", studentPanels),
            new DropClassButton("Drop Class", studentPanels),
            new ViewGradesButton("View Grades", studentPanels)
        };

    }
}
