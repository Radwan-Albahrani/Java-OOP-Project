import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Admin extends Instructor
{
    public static List<Courses> allCourses = new ArrayList<Courses>();

    Admin(int authorityLevel, String username, String password, String name, String nationality, String field, String additionalField, String email,
            String phoneNumber, LocalDate birthDate, Gender gender, int age)
    {
        super(authorityLevel, username, password, name, nationality, field, additionalField, email, phoneNumber, birthDate, gender, age);
    }

    public static void createCourse(String courseName, String courseGrade, int creditHours, double coursePercents)
    {

        Courses course = new Courses();
        course.setCourseName(courseName);
        course.setCourseGrade(courseGrade);
        course.setCreditHours(creditHours);
        course.setCoursePercents(coursePercents);

        allCourses.add(course);
    }
}
