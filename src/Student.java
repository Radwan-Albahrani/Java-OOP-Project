import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Student extends User
{
    // ===================================== Variables =====================================
    public static int numberOfStudents;
    private double gpa;
    List<Courses> courses = new ArrayList<Courses>();
    public static List<String> announcements = new ArrayList<String>();

    // ===================================== Constructor =====================================
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

    // ===================================== Setter =====================================
    private void setGpa(double gpa)
    {
        this.gpa = gpa;
    }

    // ===================================== Getters =====================================
    public List<Courses> getCourses()
    {
        return courses;
    }

    public double getGpa()
    {
        calculateGPA();
        return gpa;
    }

    // ===================================== Methods =====================================
    public void calculateGPA()
    {
        // Variables
        double rawScores = 0;
        double totalCredits = 0;
        // Calculate GPA from all courses in this student
        for (Courses course : this.courses)
        {
            double coursePercents = course.getCoursePercent();
            if (coursePercents >= 95)
            {
                rawScores += 5 * course.getCreditHours();

            }
            else if (coursePercents >= 90)
            {
                rawScores += 4.75 * course.getCreditHours();
            }
            else if (coursePercents >= 85)
            {
                rawScores += 4.5 * course.getCreditHours();
            }
            else if (coursePercents >= 80)
            {
                rawScores += 4 * course.getCreditHours();
            }
            else if (coursePercents >= 75)
            {
                rawScores += 3.5 * course.getCreditHours();
            }
            else if (coursePercents >= 70)
            {
                rawScores += 3 * course.getCreditHours();
            }
            else if (coursePercents >= 65)
            {
                rawScores += 2.5 * course.getCreditHours();
            }

            else if (coursePercents >= 60)
            {
                rawScores += 2 * course.getCreditHours();
            }
            else
            {
                rawScores += 1.0 * course.getCreditHours();
            }
            totalCredits += course.getCreditHours();
        }
        double GPA = rawScores / totalCredits;
        setGpa(GPA);
    }

    @Override
    public void registerCourse(Courses course)
    {
        courses.add(course);
        course.getInstructor().addStudent(this);
    }

    public void dropCourses(Courses course)
    {
        course.getInstructor().students.remove(this);
        courses.remove(course);
    }

    // Check if the student is already registered to a course
    public boolean isRegistered(Courses courses2)
    {
        // Loop through registered courses and make sure this student isn't registered
        for (Courses course : this.courses)
        {
            if (course.getCourseName().equals(courses2.getCourseName()))
            {
                return true;
            }
        }
        return false;
    }
}
