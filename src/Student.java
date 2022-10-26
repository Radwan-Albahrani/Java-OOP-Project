import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Student extends User
{
    Student(int authorityLevel,
            String username,
            String password,
            String name,
            String nationality,
            String field,
            String additionalField,
            String email,
            String phoneNumber,
            LocalDate birthDate,
            Gender gender,
            int age)
    {
        super(authorityLevel, username, password, name, nationality, field, additionalField, email, phoneNumber, birthDate, gender, age);
    }

    public static int numberOfStudents;
    private int numberOfCourses;
    private double gpa;
    private double attendance;
    List<Courses> courses = new ArrayList<Courses>();
    public static List<String> announcements = new ArrayList<String>();

    public void setGpa(double gpa)
    {
        this.gpa = gpa;
    }

    public double getGpa()
    {
        return gpa;
    }

    public void setAttendance(double attendance)
    {
        this.attendance = attendance;
    }

    public double viewAttendance()
    {
        return attendance;
    }

    public void registerCourse(Courses course)
    {
        courses.add(course);
    }

    public void dropCourses(Courses course)
    {
        courses.remove(course);
    }

    public List<Courses> viewGrades()
    {
        return courses;
    }
}
