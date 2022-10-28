import java.io.Serializable;

public class CourseInfo implements Serializable
{
    //===================================== Variables =====================================
    public String courseName;
    public int creditHours;
    public Instructor instructor = null;
}
