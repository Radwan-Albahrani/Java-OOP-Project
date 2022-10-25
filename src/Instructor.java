import java.util.ArrayList;
import java.util.List;

enum Evaluation{
    EXCELLENT, GOOD, AVERAGE, BAD, VERY_BAD;
}

public class Instructor extends User {
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
