import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Instructor extends User
{
    // ===================================== Variables =====================================
    public static int numberOfInstructors;
    private List<Student> students = new ArrayList<Student>();

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

    // ===================================== Setters =====================================

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }

    Courses currentClass = null;

    public void setCurrentClass(Courses currentClass)
    {
        this.currentClass = currentClass;
    }

    // ===================================== Getters =====================================
    public List<Student> getStudents()
    {
        return students;
    }

    // Getter method
    public Courses getCurrentClass()
    {
        return currentClass;
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
                if (course.getCourseInfo().getInstructor().getCurrentClass().getCourseName().equals(currentClass.getCourseName()))
                {
                    course.getCourseInfo().setInstructor(this);
                    students.add(student);
                }
            }
        }

    }

    // Method to send announcements
    public void sendAnnouncement(String announcements)
    {
        this.getCurrentClass().getCourseInfo().addAnnouncements(announcements);
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
        course.getCourseInfo().setInstructor(this);
    }

    // Send announcements
    public void sendAnnouncements()
    {
        if (this.getCurrentClass() == null)
        {
            System.out.println("You are not currently teaching any courses!");
        }
        else
        {
            System.out.print("Enter your announcement: ");
            String announcement = Main.scanner.nextLine();
            announcement = "From: " + this.getProfile().getName() + "\nEmail: " + this.getProfile().getEmail() + "\nCourse: " + this.getCurrentClass().getCourseName()
                    + "\nAnnouncement: " + announcement + "\n\n";
            this.sendAnnouncement(announcement);
            System.out.println("Announcement sent successfully!");
        }
    }

    // Select a course for instructor
    public void selectCourse()
    {
        while (true)
        {
            if (this.getCurrentClass() != null)
            {
                System.out.println("You are already teaching a class");
                break;
            }

            // Get All courses
            List<Courses> allCourses = new ArrayList<>();
            allCourses.addAll(Admin.allCourses);

            // If courses is empty then there are no courses to register in
            if (allCourses.isEmpty())
            {
                System.out.println("There are no courses to register in!");
                break;
            }

            // Clean out all courses so that the instructor is not in the list
            for (int i = 0; i < allCourses.size(); i++)
            {
                if (allCourses.get(i).getCourseInfo().getInstructor() != null)
                {
                    allCourses.remove(i);
                }
            }

            // If courses is empty then there are no courses to register in
            if (allCourses.isEmpty())
            {
                System.out.println("There are no courses to register in!");
                break;
            }

            // Display the rest of the courses
            for (int i = 0; i < allCourses.size(); i++)
            {
                System.out.println(i + 1 + ". " + allCourses.get(i).getCourseName());
            }

            // Selecting A course
            System.out.print("\n\nEnter the course number to register: ");
            int courseNumber = SIS.getInt();

            // Index Check
            while (courseNumber < 1 || courseNumber > allCourses.size())
            {
                System.out.println("Invalid Choice");
                System.out.print("Enter the number of the course you want Register: ");
                courseNumber = SIS.getInt();
            }
            this.registerCourse(allCourses.get(courseNumber - 1));
            System.out.println("Course Registered Successfully!");
            break;
        }
    }

    // Set student Grades
    public void setStudentGrades()
    {
        while (true)
        {
            // Select a student from the available students
            List<Student> students = this.viewStudents();

            // Get class
            Courses currentClass = this.getCurrentClass();

            // Check if students is empty
            if (students.isEmpty())
            {
                System.out.println("You are not teaching any students!");
                break;
            }
            // List all students
            for (int i = 0; i < students.size(); i++)
            {
                System.out.println(i + 1 + ". " + students.get(i).getProfile().getName());
            }

            // Select a student
            System.out.print("Select a student: ");
            int studentIndex = SIS.getInt();
            // Index Check While loop
            while (studentIndex < 1 || studentIndex > students.size())
            {
                System.out.println("Please enter a valid student number!");
                System.out.print("Select a student: ");
                studentIndex = SIS.getInt();
            }
            Student selectedStudent = students.get(studentIndex - 1);

            // Ask what grade to set
            System.out.print("Enter the Percentage grade: ");
            Double grade = SIS.getDouble();

            // Check if grade is between 0 and 100. If not, ask again
            while (grade < 0 || grade > 100)
            {
                System.out.println("Enter the Percentage grade (Must be between 0 and 100): ");
                grade = SIS.getDouble();
            }

            // Search for that class in student and set its grade
            for (Courses course : selectedStudent.courses)
            {
                if (course.getCourseName().equals(currentClass.getCourseName()))
                {
                    course.setCoursePercents(grade);
                    break;
                }
            }
            System.out.println("Grade set successfully!");
            break;
        }
    }

    // Display All Students for instructor
    public void displayAllStudents()
    {
        while (true)
        {
            // Display All Students the instructor is teaching
            List<Student> students = this.viewStudents();
            if (students.isEmpty())
            {
                System.out.println("You are not teaching any students!");
                break;
            }
            for (int i = 0; i < students.size(); i++)
            {
                System.out.println(i + 1 + ". " + students.get(i).getProfile().getName() + " " + students.get(i).getAuth().getUserID());
            }

            // Selecting A student
            System.out.print("Enter the student number to view grades: ");
            int studentNumber = SIS.getInt();

            // Index Check
            while (studentNumber < 1 || studentNumber > students.size())
            {
                System.out.println("Invalid Choice!");
                System.out.print("Enter the number of the student you want to view: ");
                studentNumber = SIS.getInt();
            }

            // Display the student grades for the course the instructor is teaching
            Student selectedStudent = students.get(studentNumber - 1);
            for (Courses course : selectedStudent.courses)
            {
                if (course.getCourseInfo().getInstructor() == this)
                {
                    System.out.println("Course: " + course.getCourseName());
                    System.out.println("Grade: " + course.getCourseGrade());
                }

            }
            break;

        }
    }
}
