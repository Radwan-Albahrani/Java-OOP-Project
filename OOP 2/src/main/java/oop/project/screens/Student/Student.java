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

        KGradientPanel mainPanel = new StudentMain(getWidth(), getHeight());
        KGradientPanel registerClass = new registerClass(getWidth(), getHeight());
        KGradientPanel ViewAlerts = new ViewAlerts(getWidth(), getHeight());
        KGradientPanel DropClass = new DropClass(getWidth(), getHeight());
        



    }
}
