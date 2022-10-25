import java.util.ArrayList;
import java.util.List;

public class Instructor
{

    public static int numberOfInstructors;
    enum evaluation{};
    private double salary;
    List<Student> students = new ArrayList<Student>();
    List<Courses> currentClass= new ArrayList <Courses>();
    List<Student> viewAllGpa = new ArrayList<Student>();

    void setStudentGrade(Student student, int index, String courseGrade)
    {
        student.courses.get(index).setCourseGrade(courseGrade);
    }

    void sendAnnouncement(Student student, String announcements)
    {
        student.announcements.add(announcements);
    }

    void viewStudents(Student student)
    {
        student.course.get
    }


    void setAttendence(Student student, double attendance)
    {
        student.setAttendence(attendance);
    }

    
}
