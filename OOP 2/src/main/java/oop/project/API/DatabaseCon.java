package oop.project.API;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import oop.project.models.*;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseCon
{
    private static Connection con;
    private static PreparedStatement stmt;
    public static UserModel currentUser;

    private static Connection connectDB()
    {
        String DATABASE_URL = "jdbc:mysql://localhost:3306/informationsystem";
        try
        {
            con = DriverManager.getConnection(DATABASE_URL, "root", "root");
            return con;
        }
        catch (SQLException sqlException)
        {
            System.err.println("Error: " + sqlException.getMessage());
        }
        return null;
    }

    private static Connection connectDBViews()
    {
        String DATABASE_URL = "jdbc:mysql://localhost:3306/";
        try
        {
            Connection con = DriverManager.getConnection(DATABASE_URL, "root", "root");
            return con;
        }
        catch (SQLException sqlException)
        {
            System.err.println("Error: " + sqlException.getMessage());
        }
        return null;
    }

    public static int registerUser(UserModel user)
    {
        // Get the connection
        con = connectDB();

        // Create the statement
        try (CallableStatement call = con.prepareCall("CALL generate_user(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                Statement stmt = con.createStatement();)
        {
            // Set the parameters
            call.setString(1, user.getAuth().getUsername());
            call.setString(2, user.getAuth().getPassword());
            call.setString(3, user.getRole());
            call.setString(4, user.getFirstName());
            call.setString(5, user.getLastName());
            call.setString(6, user.getGender());
            call.setString(7, user.getBirthDate());
            call.setString(8, user.getMajor());
            call.setString(9, user.getEmail());
            call.setString(10, user.getPhoneNumber());
            call.setString(11, user.getPersonalEmail());

            // Execute the statement
            call.execute();
            return 1;

        }
        catch (SQLException e)
        {
            System.out.println("Error registering user: " + e.getMessage());
            return 0;
        }
    }

    public static List<String> getCoursesOfStudent(String studentID)
    {
        con = connectDB();
        String query = "SELECT CourseID FROM StudentCourses WHERE StudID = ?";
        List<String> courses = new ArrayList<String>();
        try (PreparedStatement stmt = con.prepareStatement(query);)
        {
            stmt.setString(1, studentID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                courses.add(rs.getString(1));
            }
            return courses;
        }
        catch (SQLException e)
        {
            System.out.println("Error getting courses of student: " + e.getMessage());
            return null;
        } finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static List<String> getAnnouncementOfCourse(String courseID)
    {
        con = connectDB();
        String query = "SELECT Announcement FROM Announcements WHERE CourseID = ?";
        List<String> announcements = new ArrayList<String>();
        try (PreparedStatement stmt = con.prepareStatement(query);)
        {
            stmt.setString(1, courseID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                announcements.add(rs.getString(1));
            }
            return announcements;
        }
        catch (SQLException e)
        {
            System.out.println("Error getting announcements of course: " + e.getMessage());
            return null;
        } finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static int registerCourseToStudent(String courseID, String studentID) throws Exception
    {
        con = connectDB();
        String query = "INSERT INTO StudentCourses (StudID, CourseID, QuizGrade, MidtermGrade, FinalGrade, ProjectGrade) VALUES (?, ?, 0, 0, 0, 0)";
        try (PreparedStatement stmt = con.prepareStatement(query);)
        {
            stmt.setString(1, studentID);
            stmt.setString(2, courseID);
            int result = stmt.executeUpdate();
            if (result == 0)
            {
                throw new Exception("Error registering course to student");
            }
            return 1;
        }
        catch (SQLException e)
        {
            System.out.println("Error registering course to student: " + e.getMessage());
            throw new Exception("Error registering course to student: " + e.getMessage());
        } finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static int dropCourseFromStudent(String courseID, String studentID)
    {
        con = connectDB();
        String query = "DELETE FROM StudentCourses WHERE StudID = ? AND CourseID = ?";
        try (PreparedStatement stmt = con.prepareStatement(query);)
        {
            stmt.setString(1, studentID);
            stmt.setString(2, courseID);
            int result = stmt.executeUpdate();
            if (result == 0)
            {
                throw new Exception("Error dropping course from student");
            }
            return 1;
        }
        catch (SQLException e)
        {
            System.out.println("Error dropping course from student: " + e.getMessage());
            return 0;
        }
        catch (Exception e)
        {
            System.out.println("Error dropping course from student: " + e.getMessage());
            return 0;
        } finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static ResultSet getAvailableCourses(String studentID)
    {
        con = connectDB();
        String query = "SELECT * FROM Courses WHERE CourseID NOT IN (SELECT CourseID FROM StudentCourses WHERE StudID = ?) AND instructorID IS NOT NULL";
        try
        {
            stmt = con.prepareStatement(query);
            stmt.setString(1, studentID);
            ResultSet rs = stmt.executeQuery();
            return rs;
        }
        catch (SQLException e)
        {
            System.out.println("Error getting available courses: " + e.getMessage());
            return null;
        }
    }

    public static void sendAnnouncement(String announcement, String courseID)
    {
        con = connectDB();
        String query = "INSERT INTO Announcements (Announcement, CourseID) VALUES (?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(query);)
        {
            stmt.setString(1, announcement);
            stmt.setString(2, courseID);
            stmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println("Error sending announcement: " + e.getMessage());
        } finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void sendAlert(String alert)
    {
        con = connectDB();
        String query = "INSERT INTO Alerts (Alert) VALUES (?)";
        try (PreparedStatement stmt = con.prepareStatement(query);)
        {
            stmt.setString(1, alert);
            stmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println("Error sending alert: " + e.getMessage());
        } finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static ResultSet getRegisteredCourses(String studentID)
    {
        con = connectDB();
        String query = "SELECT * FROM StudentCourses WHERE StudID = ?";
        try
        {
            stmt = con.prepareStatement(query);
            stmt.setString(1, studentID);
            ResultSet rs = stmt.executeQuery();
            return rs;
        }
        catch (SQLException e)
        {
            System.out.println("Error getting registered courses: " + e.getMessage());
            return null;
        }
    }

    public static long generateID()
    {
        con = connectDB();
        try (Statement stmt = con.createStatement();)
        {
            ResultSet rs = stmt.executeQuery("SELECT MAX(UserID) FROM User");
            if (rs.next())
            {
                if (rs.getLong(1) == 0)
                {
                    long currentYear = Calendar.getInstance().get(Calendar.YEAR);
                    String year = Long.toString(currentYear);
                    String firstDigit = year.substring(0, 1);
                    String lastTwoDigits = year.substring(year.length() - 2);
                    String id = firstDigit + lastTwoDigits + String.format("%07d", 1);
                    return Long.parseLong(id);
                }
                else
                {
                    long id = rs.getLong(1) + 1;
                    return id;
                }
            }
            else
            {
                return 0;
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error generating ID: " + e.getMessage());
            return 0;
        } finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

    }

    public static List<UserModel> getAllWithType(String type)
    {
        // Set up the list
        List<UserModel> users = new ArrayList<>();

        // Get the connection
        con = connectDBViews();
        String view = "SELECT * FROM informationsystem.`view all " + type + "`;";

        // Create the statement
        try (PreparedStatement stmt = con.prepareStatement(
                view);)
        {

            // Execute the statement
            ResultSet rs = stmt.executeQuery();

            // Get the results
            while (rs.next())
            {
                // Create the user from the results
                UserModel user = new UserModel();
                user.setUserID(rs.getLong(1));
                user.setFirstName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setGender(rs.getString(4));
                user.setBirthDate(rs.getString(5));
                user.setMajor(rs.getString(6));
                user.setEmail(rs.getString(6));
                user.setPhoneNumber(rs.getString(8));

                // Add the user to the list
                users.add(user);
            }

        }
        catch (SQLException e)
        {
            System.err.println("Error Getting Users of Type: " + e.getMessage());
        } finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                System.err.println("Error Closing Database: " + e.getMessage());
            }
        }
        return users;
    }

    public static ResultSet customQuery(String query)
    {
        // Get the connection
        con = connectDB();
        String view = query;

        // Create the statement
        try
        {
            stmt = con.prepareStatement(view);

            // Execute the statement
            ResultSet rs = stmt.executeQuery();
            return rs;

        }
        catch (SQLException e)
        {
            System.err.println("Error with Custom Query: " + e.getMessage());
        }
        return null;
    }

    public static ResultSet getAllWithTypeRS(String type)
    {

        // Get the connection
        con = connectDBViews();
        String view = "SELECT * FROM informationsystem.`view all " + type + "`;";

        // Create the statement
        try
        {
            stmt = con.prepareStatement(view);

            // Execute the statement
            ResultSet rs = stmt.executeQuery();
            return rs;

        }
        catch (SQLException e)
        {
            System.err.println("Error Getting Users of Type As resultSet: " + e.getMessage());
        }
        return null;
    }

    public static ResultSet getAllCourses()
    {

        // Get the connection
        con = connectDB();
        String view = "SELECT * FROM courses;";

        // Create the statement
        try
        {
            stmt = con.prepareStatement(view);

            // Execute the statement
            ResultSet rs = stmt.executeQuery();
            return rs;

        }
        catch (SQLException e)
        {
            System.err.println("Error Getting Courses ResultSet: " + e.getMessage());
        }
        return null;
    }

    public static List<UserModel> getAllUsers()
    {
        // Set up the list
        List<UserModel> users = new ArrayList<>();

        // Get the connection
        con = connectDBViews();
        String view = "SELECT * FROM informationsystem.`view all users`;";

        // Create the statement
        try (PreparedStatement stmt = con.prepareStatement(view);)
        {

            // Execute the statement
            ResultSet rs = stmt.executeQuery();

            // Get the results
            while (rs.next())
            {
                // Create the user from the results
                UserModel user = new UserModel();
                user.setUserID(rs.getLong(1));
                user.setFirstName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setGender(rs.getString(4));
                user.setBirthDate(rs.getString(5));
                user.setMajor(rs.getString(6));
                user.setEmail(rs.getString(6));
                user.setPhoneNumber(rs.getString(8));

                // Add the user to the list
                users.add(user);
            }

        }
        catch (SQLException e)
        {
            System.err.println("Error Getting All Users: " + e.getMessage());
        } finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                System.err.println("Error Closing Database: " + e.getMessage());
            }
        }
        return users;
    }

    public static ResultSet getAllUsersRS()
    {

        // Get the connection
        con = connectDBViews();
        String view = "SELECT * FROM informationsystem.`view all users`;";

        // Create the statement
        try
        {
            stmt = con.prepareStatement(view);
            // Execute the statement
            ResultSet rs = stmt.executeQuery();
            return rs;

        }
        catch (SQLException e)
        {
            System.err.println("Error Getting Users of Type as ResultSet: " + e.getMessage());
        }
        return null;
    }

    public static UserModel getOneUser(String ID)
    {
        // Set up the list
        UserModel user = new UserModel();

        // Get the connection
        con = connectDB();
        String statement = """
                SELECT User.UserID,
                User.Username,
                User.Password,
                User.Type,
                Profile.FirstName,
                Profile.LastName,
                Profile.Sex,
                Profile.Birthdate,
                Profile.Major,
                WorkContactDetails.Email,
                workcontactdetails.Phone,
                personalcontactdetails.Email as 'Personal Email',
                personalcontactdetails.Phone as 'Personal Phone',
                User.Status
                FROM User INNER JOIN Profile ON User.UserID = Profile.UserID
                    INNER JOIN WorkContactDetails ON User.UserID = WorkContactDetails.UserID
                    INNER JOIN PersonalContactDetails ON User.UserID = PersonalContactDetails.UserID
                WHERE User.UserID = ?;
                    """;;

        // Create the statement
        try (PreparedStatement stmt = con.prepareStatement(statement);)
        {
            stmt.setString(1, ID);

            // Execute the statement
            ResultSet rs = stmt.executeQuery();

            // Get the results
            while (rs.next())
            {
                // Create the user from the results
                user.setUserID(rs.getLong(1));
                user.setAuth(new Auth(rs.getString(2), rs.getString(3)));
                user.setRole(rs.getString(4));
                user.setFirstName(rs.getString(5));
                user.setLastName(rs.getString(6));
                user.setGender(rs.getString(7));
                user.setBirthDate(rs.getString(8));
                user.setMajor(rs.getString(9));
                user.setEmail(rs.getString(10));
                user.setPhoneNumber(rs.getString(11));
                user.setPersonalEmail(rs.getString(12));
                user.setPersonalPhoneNumber(rs.getString(13));
                user.setStatus(rs.getString(14));
                return user;
            }

        }
        catch (SQLException e)
        {
            System.err.println("Error Getting One User: " + e.getMessage());
        } finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                System.err.println("Error Closing Database: " + e.getMessage());
            }
        }
        return user;
    }

    public static List<UserModel> getAllUsersWithStatus(String status)
    {
        // Set up the list
        List<UserModel> users = new ArrayList<>();

        // Get the connection
        con = connectDBViews();
        String view = "SELECT * FROM informationsystem.`view all " + status + " users`;";

        // Create the statement
        try (PreparedStatement stmt = con.prepareStatement(
                view);)
        {

            // Execute the statement
            ResultSet rs = stmt.executeQuery();

            // Get the results
            while (rs.next())
            {
                // Create the user from the results
                UserModel user = new UserModel();
                user.setUserID(rs.getLong(1));
                user.setFirstName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setGender(rs.getString(4));
                user.setBirthDate(rs.getString(5));
                user.setMajor(rs.getString(6));
                user.setEmail(rs.getString(6));
                user.setPhoneNumber(rs.getString(8));

                // Add the user to the list
                users.add(user);
            }

        }
        catch (SQLException e)
        {
            System.err.println("Error Getting Users of Status: " + e.getMessage());
        } finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return users;
    }

    public static ResultSet getAllUsersWithStatusRS(String status)
    {
        // Get the connection
        con = connectDBViews();
        String view = "SELECT * FROM informationsystem.`view all " + status + " users`;";

        // Create the statement
        try
        {
            stmt = con.prepareStatement(view);

            // Execute the statement
            ResultSet rs = stmt.executeQuery();
            return rs;

        }
        catch (SQLException e)
        {
            System.err.println("Error Getting Users of Status as ResultSet: " + e.getMessage());
        }
        return null;
    }

    public static List<StudentModel> getStudentsOfInstructorGradesList(String userID)
    {
        List<StudentModel> students = null;
        ResultSet rs = null;
        try
        {
            rs = getStudentsOfInstructorGrades(userID);
            students = new ArrayList<StudentModel>();

            while (rs.next())
            {
                StudentModel student = new StudentModel();
                student.setUserID(rs.getLong(1));
                student.setFirstName(rs.getString(2));
                student.setLastName(rs.getString(3));
                student.setQuizGrade(rs.getDouble(4));
                student.setMidtermGrade(rs.getDouble(5));
                student.setFinalGrade(rs.getDouble(6));
                student.setProjectGrade(rs.getDouble(7));
                student.setTotalGrade(rs.getDouble(8));
                students.add(student);
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error Getting Students of Instructor's Grades: " + e.getMessage());
        } finally
        {
            try
            {
                rs.close();
            }
            catch (SQLException e)
            {
                System.err.println("Error Closing ResultSet: " + e.getMessage());
            }
        }
        return students;
    }

    public static ResultSet getStudentsOfInstructorGrades(String userID)
    {
        String query = """
                SELECT UserID, FirstName, LastName, QuizGrade, MidtermGrade, FinalGrade, ProjectGrade, TotalGrade
                FROM studentcourses, profile
                WHERE StudID = UserID && CourseID IN (SELECT CourseID FROM courses WHERE InstructorID = %s);
                    """.formatted(userID);
        con = connectDB();
        try
        {
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            return rs;
        }
        catch (SQLException e)
        {
            System.err.println("Error Getting Students of Instructor: " + e.getMessage());
        }
        return null;
    }

    public static ResultSet getStudentsOfInstructor(String userID)
    {
        String query = """
                SELECT UserID, FirstName, LastName, Sex, TotalGrade as 'Total Course Grade'
                FROM studentcourses, profile
                WHERE StudID = UserID && CourseID IN (SELECT CourseID FROM courses WHERE InstructorID = %s);
                    """.formatted(userID);
        con = connectDB();
        try
        {
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            return rs;
        }
        catch (SQLException e)
        {
            System.err.println("Error Getting Students of Instructor: " + e.getMessage());
        }
        return null;
    }

    public static List<String> getAlerts()
    {
        List<String> alerts = new ArrayList<>();
        String query = """
                SELECT Alert FROM alerts;
                """;
        con = connectDB();
        try
        {
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                alerts.add(rs.getString(1));
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error Getting Alerts: " + e.getMessage());
        }
        return alerts;
    }

    public static int checkEmail(String email)
    {
        con = connectDB();
        String query = """
                SELECT COUNT(*)
                FROM User
                JOIN PersonalContactDetails ON User.UserID = PersonalContactDetails.UserID
                WHERE PersonalContactDetails.Email = ?
                """;
        try (PreparedStatement stmt = con.prepareStatement(query))
        {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
        catch (SQLException e)
        {
            System.err.println("Error Checking Email: " + e.getMessage());
        }
        return 0;
    }

    public static int login(String username, String password)
    {
        con = connectDB();
        String query = """
                SELECT User.UserID,
                User.Username,
                User.Type,
                Profile.FirstName,
                Profile.LastName,
                Profile.Sex,
                Profile.Birthdate,
                Profile.Major,
                WorkContactDetails.Email,
                workcontactdetails.Phone,
                personalcontactdetails.Email as 'Personal Email',
                personalcontactdetails.Phone as 'Personal Phone',
                user.Status
                FROM User
                JOIN Profile ON User.UserID = Profile.UserID
                JOIN WorkContactDetails ON User.UserID = WorkContactDetails.UserID
                JOIN PersonalContactDetails ON User.UserID = PersonalContactDetails.UserID
                Where user.Username = ?
                AND user.Password = ?;
                    """;
        try (PreparedStatement stmt = con.prepareStatement(query);)
        {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                if (rs.getString(13).equals("Active"))
                {
                    UserModel user = new UserModel();
                    user.setUserID(rs.getLong(1));
                    user.setAuth(new Auth(rs.getString(2), "HIDDEN"));
                    user.setRole(rs.getString(3));
                    user.setFirstName(rs.getString(4));
                    user.setLastName(rs.getString(5));
                    user.setGender(rs.getString(6));
                    user.setBirthDate(rs.getString(7));
                    user.setMajor(rs.getString(8));
                    user.setEmail(rs.getString(9));
                    user.setPhoneNumber(rs.getString(10));
                    user.setPersonalEmail(rs.getString(11));
                    user.setPersonalPhoneNumber(rs.getString(12));
                    user.setStatus(rs.getString(13));
                    currentUser = user;
                    return 2;
                }
                else
                {
                    return 1;
                }
            }
            else
            {
                return 0;
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error Logging in: " + e.getMessage());
            return -1;
        } finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                System.err.println("Error Closing Database: " + e.getMessage());
            }
        }
    }

    public static void Logout()
    {
        currentUser = null;
    }

    public static void activateUser(String userID) throws Exception
    {
        con = connectDB();
        String query = """
                UPDATE User
                SET Status = 'Active'
                WHERE UserID = ?;
                """;
        try (PreparedStatement stmt = con.prepareStatement(query);)
        {
            stmt.setString(1, userID);
            int result = stmt.executeUpdate();
            if (result == 0)
            {
                throw new Exception("Error Activating User: No User Found");
            }
            UserModel user = getOneUser(userID);
            SendEmail.sendActivationEmail(user.getPersonalEmail(), user.getFirstName() + " " + user.getLastName());
        }
        catch (SQLException e)
        {
            throw new Exception("Error Activating User: " + e.getMessage());
        }

    }

    public static void activateAllUsers()
    {
        List<UserModel> users = getAllUsersWithStatus("Inactive");
        if (users != null)
        {
            for (UserModel userModel : users)
            {
                try
                {
                    activateUser(userModel.getUserID() + "");
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void createCourse(String courseID, String courseName, String courseCredit, String maxCapacity)
            throws SQLException
    {
        con = connectDB();
        String query = """
                INSERT INTO Courses (CourseID, CourseName, CreditHours, MaxCap)
                VALUES (?, ?, ?, ?);
                """;
        try (PreparedStatement stmt = con.prepareStatement(query);)
        {
            stmt.setString(1, courseID);
            stmt.setString(2, courseName);
            stmt.setString(3, courseCredit);
            stmt.setString(4, maxCapacity);
            stmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.err.println("Error Creating Course: " + e.getMessage());
            throw e;
        }
    }

    public static void deleteCourse(String courseID) throws Exception
    {
        con = connectDB();
        String query = """
                DELETE FROM Courses
                WHERE CourseID = ?;
                """;
        try (PreparedStatement stmt = con.prepareStatement(query);)
        {
            stmt.setString(1, courseID);
            int result = stmt.executeUpdate();
            if (result == 0)
            {
                throw new Exception("Error Deleting Course: No Course Found");
            }
        }
        catch (SQLException e)
        {
            throw new Exception("Error Deleting Course: " + e.getMessage());
        }
    }

    public static void closeDatabase()
    {
        try
        {
            con.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    // /// Testing Functions --------------------------------------------------------------------------------
    // private static void RegisterTesting(String email)
    // {
    // UserModel user = new UserModel();
    // user.setFirstName("firstName");
    // user.setLastName("lastName");
    // user.setEmail("TestEmail");
    // user.setPersonalEmail(email);
    // user.setPhoneNumber("phoneNumber");
    // user.setAuth(new Auth("username", "password"));
    // user.setBirthDate("2001-01-01");
    // user.setMajor("major");
    // user.setGender("Male");
    // user.setRole("Instructor");
    // user.setPersonalPhoneNumber("personalPhoneNumber");
    // registerUser(user);

    // }

    // public static void main(String[] args)
    // {
    // UserModel user = getOneUser("1");
    // }

}
