import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Student extends User
{
    Student(int authorityLevel, String username, String password, String name, String nationality, String field, String additionalField, String email,
    String phoneNumber, LocalDate birthDate, Gender gender, int age)
    {
    super(authorityLevel, username, password, name, nationality, field, additionalField, email, phoneNumber, birthDate, gender, age);
    }
    
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
