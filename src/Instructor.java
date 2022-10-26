import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Instructor extends User {
    Instructor(int authorityLevel, String username, String password, String name, String nationality, String field,
            String additionalField, String email,
            String phoneNumber, LocalDate birthDate, Gender gender, int age) {
        super(authorityLevel, username, password, name, nationality, field, additionalField, email, phoneNumber,
                birthDate, gender, age);
    }

    public static int numberOfInstructors;

    enum evaluation {
    };

    private double salary;
    List<Student> students = new ArrayList<Student>();
    List<Courses> currentClass = new ArrayList<Courses>();
    List<Student> viewAllGpa = new ArrayList<Student>();

    void setStudentGrade(Student student, int index, String courseGrade) {
        student.courses.get(index).setCourseGrade(courseGrade);
    }

    void sendAnnouncement(Student student, String announcements) {
        student.announcements.add(announcements);
    }

    void viewStudents(Student student)
    {
        student.course.get
    }

    void setAttendence(Student student, double attendance) {
        student.setAttendence(attendance);
    }

    enum Evaluation {
        EXCELLENT, GOOD, AVERAGE, BAD, VERY_BAD;
    }

}
