
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
            if (instructor.getCurrentClass() != null)
            {
                allCourses.add(instructor.currentClass);
            }
        }
    }

    // Method to create courses and add them to the list of all courses
    public static void createCourse(String courseName, int creditHours)
    {
        Courses course = new Courses();
        course.courseInfo.setCourseName(course, courseName);
        course.courseInfo.setCreditHours(course, creditHours);
        Admin.allCourses.add(course);

    }

    // Method to edit a course name and credit hours for a given course
    public static void editCourse(Courses selectedCourse, String courseName, int creditHours)
    {
        selectedCourse.courseInfo.setCourseName(selectedCourse, courseName);
        selectedCourse.courseInfo.setCreditHours(selectedCourse, creditHours);
    }

    // Method to delete a course from the list of all courses
    public static void deleteCourse(Courses course) throws InterruptedException
    {
        // Null check
        if (course == null)
        {
            System.out.println("Course not found");
            return;
        }

        // If course has instructor
        if (course.courseInfo.getInstructor() != null)
        {
            // Get All students from the instructor
            List<Student> studentsWithCourse = course.getCourseInfo().getInstructor().getStudents();
            // Remove the course from the students
            for (Student student : studentsWithCourse)
            {
                // Find course in list of courses
                for (Courses studentCourse : student.getCourses())
                {
                    if (studentCourse.getCourseInfo().getCourseName().equals(course.getCourseInfo().getCourseName())
                            && studentCourse.getCourseInfo().getInstructor().equals(course.getCourseInfo().getInstructor()))
                    {
                        student.getCourses().remove(studentCourse);
                        break;
                    }
                }

            }

            // Remove the course from the instructor
            course.courseInfo.getInstructor().setCurrentClass(null);
            course.courseInfo.setInstructor(null);

            // Remove Course from Admin
            Admin.allCourses.remove(course);

            // Inform User
            System.out.println(ConsoleColors.GREEN + "Course deleted successfully" + ConsoleColors.RESET);
            Thread.sleep(1000);
        }
        else
        {
            Admin.allCourses.remove(course);
            System.out.println(ConsoleColors.GREEN + "Course deleted successfully" + ConsoleColors.RESET);
            Thread.sleep(1000);
        }
    }

    // Method to edit dob
    public void editProfile(User userToEdit, LocalDate dob, int age)
    {
        userToEdit.profile.setBirthDate(dob);
        userToEdit.profile.setAge(age);
    }

    // Method to edit any other profile value
    public void editProfile(User userToEdit, int editChoiceExact, String newValue)
    {
        switch (editChoiceExact)
        {
            case 1:
                userToEdit.profile.setName(newValue);
                userToEdit.profile.setEmail(newValue + userToEdit.auth.getUserID() + "@university.com");
                userToEdit.auth.setUsername(newValue + userToEdit.auth.getUserID());
                break;
            case 2:
                userToEdit.profile.setNationality(newValue);
                break;
            case 3:
                userToEdit.profile.setPhoneNumber(newValue);
                break;
            case 5:
                userToEdit.profile.setField(newValue);
                break;
            case 6:
                userToEdit.profile.setAdditionalField(newValue);
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    // Method to view Alerts
    public void viewAlerts()
    {
        // If alerts is empty, tell user there are no alerts
        if (this.alerts.isEmpty())
        {
            System.out.println("There are no alerts!");
        }
        else
        {
            // Print all alerts
            System.out.println("Alerts: \n");
            for (String alert : this.alerts)
            {
                System.out.println(alert);
            }
        }
    }

}
