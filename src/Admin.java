
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Admin extends Instructor
{
    // ===================================== Variables =====================================
    public static List<Courses> allCourses = new ArrayList<Courses>();
    public List<String> alerts = new ArrayList<String>();

    // ===================================== Constructor =====================================
    public Admin(int authorityLevel, String username, String password, String name, String nationality, String field, String additionalField, String email,
            String phoneNumber, LocalDate birthDate, Gender gender, int age)
    {
        super(authorityLevel, username, password, name, nationality, field, additionalField, email, phoneNumber, birthDate, gender, age);
    }

    // ===================================== Methods =====================================
    // Method to populate courses and add any lost references due to serialization
    public static void populateCourses(List<Instructor> instructors)
    {
        allCourses.clear();
        for (Instructor instructor : instructors)
        {
            if (instructor.currentClass != null)
            {
                allCourses.add(instructor.currentClass);
            }
        }
    }

    // Method to create courses and add them to the list of all courses
    public static void createCourse(String courseName, int creditHours)
    {
        Courses course = new Courses();
        course.setCourseName(courseName);
        course.setCreditHours(creditHours);
        Admin.allCourses.add(course);

    }

    // Method to edit a course name and credit hours for a given course
    public static void editCourse(Courses selectedCourse, String courseName, int creditHours)
    {
        selectedCourse.setCourseName(courseName);
        selectedCourse.setCreditHours(creditHours);
    }

    // TODO Method to delete a course from the list of all courses
    public static void deleteCourse(Courses course)
    {
        for (Admin admin : Main.admins)
        {
            admin.allCourses.remove(course);
        }

    }

    // TODO method to edit profiles of Users
    public static void editProfile()
    {

    }

}
