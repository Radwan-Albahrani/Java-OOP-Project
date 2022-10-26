
public class Courses
{
    private String courseName;
    private String courseGrade;
    private int creditHours;
    private double coursePercents;

    //setters
    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }

    public void setCourseGrade(String courseGrade)
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
    }

    //Getters
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

    public int creditHours()
    {
        return creditHours;
    }
}
