import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CourseInfo implements Serializable
{
    // ===================================== Variables =====================================
    private String courseName;
    private int creditHours;
    private Instructor instructor = null;
    private List<String> announcements = new ArrayList<String>();

    // ===================================== Getters =====================================
    public List<String> getAnnouncements()
    {
        return announcements;
    }

    public String getCourseName()
    {
        return courseName;
    }

    public int getCreditHours()
    {
        return creditHours;
    }

    public Instructor getInstructor()
    {
        return instructor;
    }

    // ===================================== Setters =====================================
    public void setInstructor(Instructor instructor)
    {
        this.instructor = instructor;
    }

    public void setCourseName(Courses courses, String courseName)
    {
        this.courseName = courseName;
    }

    public void setCreditHours(Courses courses, int creditHours)
    {
        this.creditHours = creditHours;
    }

    // ===================================== Methods =====================================
    public void addAnnouncements(String announcements)
    {
        this.announcements.add(announcements);
    }
}
