import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

enum Evaluation{
    EXCELLENT, GOOD, AVERAGE, BAD, VERY_BAD;
}

public class Instructor extends User {
    Instructor(int authorityLevel, String username, String password, String name, String nationality, String field, String additionalField, String email,
            String phoneNumber, LocalDate birthDate, Gender gender, int age)
    {
        super(authorityLevel, username, password, name, nationality, field, additionalField, email, phoneNumber, birthDate, gender, age);
    }
    public static int numberOfInstructors = 0;
    double salary;
    Course currentClass;
    List<Student> students = new ArrayList<Student>();
    Evaluation evaluation;

    public void sendAnnouncement()
    {
        // TODO do announcement yes thumbsup
    }
    public void setAttendance()
    {
        // Student.setAttendance();
    }


}
