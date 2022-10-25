import java.util.ArrayList;
import java.util.List;

public class Student extends User
{
    public static int numberOfStudnets;
    private int numberOfCourses;
    private double gpa;
    private double stipend;
    private double attendance; 
    List<Courses> courses = new ArrayList <Courses>();
    List<announcements> announcements = new ArrayList <announcements>();

    public double setGpa(double gpa)
    {
        this.gpa = gpa;
    }

    public double getGpa()
    {
        return gpa;
    }

    public double viewAttendance()
    {
        return attendance;
    }

    public void registerCourse()
    {
        
    }










    public static void main(String[] args) 
    {
        
    }
}
