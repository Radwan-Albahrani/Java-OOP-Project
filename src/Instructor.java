import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Instructor extends User
{
    // ===================================== Variables =====================================
    public static int numberOfInstructors;

    List<Student> students = new ArrayList<Student>();
    Courses currentClass = null;

    // ===================================== Constructor =====================================
    Instructor(int authorityLevel,
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
        super(authorityLevel, username, password, name, nationality, field, additionalField, email, phoneNumber,
                birthDate, gender, age);
    }

    // ===================================== Methods =====================================
    // Method to populate students and add any lost references due to serialization
    public void populateStudents(List<Student> givenStudents)
    {
        students.clear();
        for (Student student : givenStudents)
        {
            for (Courses course : student.getCourses())
            {
                if (course.getInstructor().getCurrentClass().getCourseName().equals(currentClass.getCourseName()))
                {
                    course.setInstructor(this);
                    students.add(student);
                }
            }
        }

    }

    // Getter method
    public Courses getCurrentClass()
    {
        return currentClass;
    }

    // Method to send announcements
    public void sendAnnouncement(String announcements)
    {
        Student.announcements.add(announcements);
    }

    // Method to view students
    public List<Student> viewStudents()
    {
        return students;

    }

    // Add student to the students
    public void addStudent(Student student)
    {
        students.add(student);
    }

    // Register course for the instructor
    @Override
    public void registerCourse(Courses course)
    {
        currentClass = course;
        course.setInstructor(this);
    }
}
