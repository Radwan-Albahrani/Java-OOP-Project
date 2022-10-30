import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Student extends User
{
    // ===================================== Variables =====================================
    public static int numberOfStudents;
    private double gpa;
    List<Courses> courses = new ArrayList<Courses>();

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
    // Method to calculate GPA
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
                rawScores += 5 * course.getCourseInfo().getCreditHours();

            }
            else if (coursePercents >= 90)
            {
                rawScores += 4.75 * course.getCourseInfo().getCreditHours();
            }
            else if (coursePercents >= 85)
            {
                rawScores += 4.5 * course.getCourseInfo().getCreditHours();
            }
            else if (coursePercents >= 80)
            {
                rawScores += 4 * course.getCourseInfo().getCreditHours();
            }
            else if (coursePercents >= 75)
            {
                rawScores += 3.5 * course.getCourseInfo().getCreditHours();
            }
            else if (coursePercents >= 70)
            {
                rawScores += 3 * course.getCourseInfo().getCreditHours();
            }
            else if (coursePercents >= 65)
            {
                rawScores += 2.5 * course.getCourseInfo().getCreditHours();
            }

            else if (coursePercents >= 60)
            {
                rawScores += 2 * course.getCourseInfo().getCreditHours();
            }
            else
            {
                rawScores += 1.0 * course.getCourseInfo().getCreditHours();
            }
            totalCredits += course.getCourseInfo().getCreditHours();
        }
        double GPA = rawScores / totalCredits;
        setGpa(GPA);
    }

    // Method to Register a course
    @Override
    public void registerCourse(Courses course)
    {
        courses.add(course);
        course.getCourseInfo().getInstructor().addStudent(this);
    }

    // Populate Course Info
    public void populateCourseInfo()
    {
        for (Courses course : courses)
        {
            course.setCourseInfo(course.getCourseInfo().getInstructor().getCurrentClass().getCourseInfo());;
        }
    }

    // Method to drop a course
    public void dropCourse(Courses course)
    {
        course.getCourseInfo().getInstructor().getStudents().remove(this);
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

    // Method to drop a course from a student
    public void dropCourses()
    {
        // Get Courses from current user
        List<Courses> courses = this.getCourses();

        if (courses.isEmpty())
        {
            System.out.println("You are not registered in any courses!");
            return;
        }
        // List All courses
        for (int i = 0; i < courses.size(); i++)
        {
            System.out.println((i + 1) + ". " + courses.get(i).getCourseName());
        }

        // Select a course from the menu
        System.out.print("Enter the number of the course you want to drop: ");
        int choice = SIS.getInt();

        // Index Check
        while (choice < 1 || choice > courses.size())
        {
            System.out.print("Enter the number of the course you want to drop: ");
            choice = SIS.getInt();
        }

        // Drop the course
        this.dropCourse(courses.get(choice - 1));
    }

    // Method to register a course for a student
    public void registerCourse() throws CloneNotSupportedException, InterruptedException
    {
        // Get all Courses from admin class
        List<Courses> courses = new ArrayList<>();
        courses.addAll(Admin.allCourses);

        // If courses is empty exit
        if (courses.isEmpty())
        {
            System.out.println(ConsoleColors.RED + "There are no courses!" + ConsoleColors.RESET);
            return;
        }

        // Clean courses list if course has no instructor
        for (int i = 0; i < courses.size(); i++)
        {
            if (courses.get(i).getCourseInfo().getInstructor() == null)
            {
                courses.remove(i);
            }
        }

        // If courses is empty exit
        if (courses.isEmpty())
        {
            System.out.println(ConsoleColors.RED + "There are no courses!" + ConsoleColors.RESET);
            return;
        }

        // If course is already registered, remove it from list of courses
        for (int i = 0; i < courses.size(); i++)
        {
            if (this instanceof Student)
            {
                if (this.isRegistered(courses.get(i)))
                {
                    courses.remove(i);
                }
            }
        }

        // If courses is empty exit
        if (courses.isEmpty())
        {
            System.out.println(ConsoleColors.RED + "There are no courses!" + ConsoleColors.RESET);
            return;
        }

        // List All courses that have instructors
        for (int i = 0; i < courses.size(); i++)
        {
            System.out.println((i + 1) + ". " + courses.get(i).getCourseName() + " - " + courses.get(i).getCourseInfo().getInstructor().getProfile().getName());
        }

        // Select a course from the menu
        System.out.print(ConsoleColors.BLUE + "Enter the number of the course you want to register: " + ConsoleColors.RESET);
        int choice = SIS.getInt();

        // Index Check
        while (choice < 1 || choice > courses.size())
        {
            System.out.println(ConsoleColors.RED + "Invalid Choice!" + ConsoleColors.RESET);
            System.out.print(ConsoleColors.BLUE + "Enter the number of the course you want to Register: " + ConsoleColors.RESET);
            choice = SIS.getInt();
        }
        // Add course to student
        this.registerCourse((Courses) courses.get(choice - 1).clone());
        System.out.println(ConsoleColors.GREEN + "Course Registered Successfully!" + ConsoleColors.RESET);
        Thread.sleep(1000);
    }

    // Method to view all courses of a student
    public void viewCourses()
    {
        // Get all courses from the current user and print them along with grades
        List<Courses> courses = this.getCourses();

        // If no courses
        if (courses.isEmpty())
        {
            System.out.println("You are not registered in any courses!");
            return;
        }
        else
        {
            System.out.println("Your courses are: ");
            for (Courses course : courses)
            {
                System.out.println("Course name: " + course.getCourseName() + "\nCourse Percent: " + course.getCoursePercent());
            }

        }

        // Print out the GPA at the end
        System.out.println("GPA: " + this.getGpa());
    }
}
