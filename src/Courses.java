import java.io.Serializable;

public class Courses implements Cloneable, Serializable
{
    // ===================================== Variables =====================================
    private CourseInfo courseInfo = new CourseInfo();
    private String courseGrade;
    private double coursePercents;

    // ===================================== Setters =====================================
    private void setCourseGrade(String courseGrade)
    {
        this.courseGrade = courseGrade;
    }

    public void setCourseInfo(CourseInfo courseInfo)
    {
        this.courseInfo = courseInfo;
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

    // ===================================== Getters =====================================
    public String getCourseName()
    {
        return courseInfo.getCourseName();
    }

    public String getCourseGrade()
    {
        return courseGrade;
    }

    public double getCoursePercent()
    {
        return coursePercents;
    }

    public CourseInfo getCourseInfo()
    {
        return courseInfo;
    }
    // ===================================== Methods =====================================
    // Cloning method
    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
