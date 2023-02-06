package oop.project.handlers;

import javax.swing.*;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

public class GradesFocusHandler implements FocusListener
{
    private List<JTextField> grade;
    private double maxGrade;
    private int index;
    private double totalGrade = 0;

    public GradesFocusHandler(List<JTextField> grade, double maxGrade, int index)
    {
        this.grade = grade;
        this.maxGrade = maxGrade;
        this.index = index;
    }

    @Override
    public void focusGained(FocusEvent arg0)
    {

        double currentGrade = 0;
        try
        {
            currentGrade = Double.parseDouble(grade.get(index).getText());
        }
        catch (Exception e)
        {
            grade.get(index).setText("0");
        }
        if (currentGrade > maxGrade)
            grade.get(index).setText(Double.toString(maxGrade));

        this.totalGrade = 0;
        for (int i = 0; i < 4; i++)
        {
            try
            {
                Double.parseDouble(grade.get(i).getText());
            }
            catch (Exception e)
            {
                grade.get(i).setText("0");
            }
            totalGrade += Double.parseDouble(grade.get(i).getText());
        }
        grade.get(grade.size() - 1).setText(Double.toString(totalGrade));
    }

    @Override
    public void focusLost(FocusEvent arg0)
    {
        double currentGrade = 0;
        try
        {
            currentGrade = Double.parseDouble(grade.get(index).getText());
        }
        catch (Exception e)
        {
            grade.get(index).setText("0");
        }
        if (currentGrade > maxGrade)
            grade.get(index).setText(Double.toString(maxGrade));

        this.totalGrade = 0;
        for (int i = 0; i < 4; i++)
        {
            try
            {
                Double.parseDouble(grade.get(i).getText());
            }
            catch (Exception e)
            {
                grade.get(i).setText("0");
            }
            totalGrade += Double.parseDouble(grade.get(i).getText());
        }
        grade.get(grade.size() - 1).setText(Double.toString(totalGrade));
    }

}
