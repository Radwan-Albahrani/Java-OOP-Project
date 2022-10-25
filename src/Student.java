import java.util.ArrayList;
import java.util.List;

public class Student extends User
{
    public static int numberOfStudnets;
    private int numberOfCourses;
    private double gpa;
    private double stipend;
    private double attendence;
    List<Courses> courses = new ArrayList <Courses>();
    public static List<String> announcements = new ArrayList <String>();

    public double setGpa(double gpa)
    {
        this.gpa = gpa;
    }

    public double getGpa()
    {
        return gpa;
    }

    public double setAttendence(double attendence)
    {
        this.attendence = attendence;
    }

    public double viewAttendence()
    {
        return attendence;
    }

    public void registerCourse()
    {

    }

    public static void main(String[] args) 
    {
        
    }
}
