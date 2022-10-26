import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Admin extends Instructor
{
    public static List<Courses> allCourses = new ArrayList<Courses>();
    public static List<String> alerts = new ArrayList<String>();

    Admin(int authorityLevel, String username, String password, String name, String nationality, String field, String additionalField, String email,
            String phoneNumber, LocalDate birthDate, Gender gender, int age)
    {
        super(authorityLevel, username, password, name, nationality, field, additionalField, email, phoneNumber, birthDate, gender, age);
    }

    public static void createCourse(String courseName, int creditHours)
    {

        Courses course = new Courses();
        course.setCourseName(courseName);
        course.setCreditHours(creditHours);

        allCourses.add(course);
    }

    public static void editCourse(Courses oldCourse, Courses newCourse)
    {
        allCourses.remove(oldCourse);
        allCourses.add(newCourse);
    }

    public static void deleteCourse(Courses course)
    {
        allCourses.remove(course);
    }

    public static void editProfile()
    {

    }

    public static void editStudentInformation()
    {

    }

    public static void editInstructorInformation()
    {

    }

    public static void displayAlerts()
    {

    }

}
