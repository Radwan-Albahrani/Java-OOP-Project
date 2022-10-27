import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

enum Evaluation
{
    EXCELLENT, GOOD, AVERAGE, BAD, VERY_BAD;
}

public class Instructor extends User
{
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

    public static int numberOfInstructors;

    List<Student> students = new ArrayList<Student>();
    Courses currentClass = null;

    public void populateStudents(List<Student> givenStudents)
    {
        students.clear();
        for (Student student : givenStudents)
        {
            for (Courses course : student.viewCourses())
            {
                if (course.getInstructor().getCurrentClass().getCourseName().equals(currentClass.getCourseName()))
                {
                    course.setInstructor(this);
                    students.add(student);
                }
            }
        }

    }

    public Courses getCurrentClass()
    {
        return currentClass;
    }

    List<Student> viewAllGpa = new ArrayList<Student>();
    public Evaluation evaluation;

    public void sendAnnouncement(String announcements)
    {
        Student.announcements.add(announcements);
    }

    public List<Student> viewStudents()
    {
        return students;

    }

    public void setAttendance(Student student, double attendance)
    {
        student.setAttendance(attendance);
    }

    public void addStudent(Student student)
    {
        students.add(student);
    }

    @Override
    public void registerCourse(Courses course)
    {
        currentClass = course;
        course.setInstructor(this);
    }
}
