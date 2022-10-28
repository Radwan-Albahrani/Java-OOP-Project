import java.io.Serializable;

public class CourseInfo implements Serializable
{
    public String courseName;
    public int creditHours;
    public Instructor instructor = null;
}
