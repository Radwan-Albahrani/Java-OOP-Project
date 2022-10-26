import java.io.Serializable;

public class Courses implements Cloneable, Serializable
{
    private String courseName;
    private String courseGrade;
    private int creditHours;
    private double coursePercents;
    private Instructor instructor = null;

    public Instructor getInstructor()
    {
        return instructor;
    }

    public void setInstructor(Instructor instructor)
    {
        this.instructor = instructor;
    }

    // setters
    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }

    private void setCourseGrade(String courseGrade)
    {
        this.courseGrade = courseGrade;
    }

    public void setCreditHours(int creditHours)
    {
        this.creditHours = creditHours;
    }

    public void setCoursePercents(double coursePercents)
    {
        this.coursePercents = coursePercents;
        if (coursePercents >= 95)
        {
            setCourseGrade("A+");

        }
        else if (coursePercents >= 90)
        {
            setCourseGrade("A");
        }
        else if (coursePercents >= 85)
        {
            setCourseGrade("B+");
        }
        else if (coursePercents >= 80)
        {
            setCourseGrade("B");
        }
        else if (coursePercents >= 75)
        {
            setCourseGrade("C+");
        }
        else if (coursePercents >= 70)
        {
            setCourseGrade("C");
        }
        else if (coursePercents >= 65)
        {
            setCourseGrade("D+");
        }
        else if (coursePercents >= 60)
        {
            setCourseGrade("D");
        }
        else
        {
            setCourseGrade("F");
        }
    }

    // Getters
    public String getCourseName()
    {
        return courseName;
    }

    public String getCourseGrade()
    {
        return courseGrade;
    }

    public double getCoursePercent()
    {
        return coursePercents;
    }

    public int getCreditHours()
    {
        return creditHours;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
