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

    private double salary;
    List<Student> students = new ArrayList<Student>();
    List<Courses> currentClass = new ArrayList<Courses>();
    List<Student> viewAllGpa = new ArrayList<Student>();
    public Evaluation evaluation;

    public void setStudentGrade(Student student, int index, String courseGrade)
    {
        student.courses.get(index).setCourseGrade(courseGrade);
    }

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
}
