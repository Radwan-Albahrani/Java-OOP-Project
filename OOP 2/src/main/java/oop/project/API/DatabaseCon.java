package oop.project.API;

import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.ImageIcon;

import java.awt.*;

import oop.project.hooks.FrameConfig;
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
            con = DriverManager.getConnection(DATABASE_URL, "JavaApp", "root");
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
            return DriverManager.getConnection(DATABASE_URL, "JavaApp", "root");
        }
        catch (SQLException sqlException)
        {
            System.err.println("Error: " + sqlException.getMessage());
        }
        return null;
    }

    public static ImageIcon getProfilePicture(String id)
    {
        con = connectDB();
        String view = "SELECT picture FROM profile WHERE userID = ?";

        // Create the statement
        try
        {
            stmt = con.prepareStatement(view);
            stmt.setString(1, id);

            // Execute the statement
            ResultSet rs = stmt.executeQuery();

            byte[] image = null;
            while (rs.next())
            {
                image = rs.getBytes("picture");
            }
            Image img = Toolkit.getDefaultToolkit().createImage(image);
            Image scaledImage = img.getScaledInstance(256, 256, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(scaledImage);
            return icon;
        }
        catch (NullPointerException e)
        {
            // Setting image as default image
            return ((FrameConfig.getPictureIcon("DefaultProfilePicture.png", 0.2)));
        }
        catch (SQLException e)
        {
            System.err.println("Error getting photo: " + e.getMessage());
        }
        return null;
    }

    public static void setProfilePicture(Blob picture, String id)
    {
        // update profile with the picture id
        con = connectDB();
        String view = "UPDATE profile SET picture = ? WHERE userID = ?";
        try
        {
            stmt = con.prepareStatement(view);
            stmt.setBlob(1, picture);
            stmt.setString(2, id);
            stmt.executeUpdate();

            System.err.println("Profile picture uploaded to database successfully!");
        }
        catch (SQLException e)
        {
            System.err.println("Error setting photo: " + e.getMessage());
        }
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

    public static int registerUser(UserModel user)
    {
        // Get the connection
        con = connectDB();

        // Create the statement
        try (CallableStatement call = con.prepareCall("CALL generate_user(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"))
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
        List<String> courses = new ArrayList<>();
        try (PreparedStatement statement = con.prepareStatement(query);)
        {
            statement.setString(1, studentID);
            ResultSet rs = statement.executeQuery();
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
                System.out.println("Error getting courses of student: " + e.getMessage());
            }
        }
    }

    public static List<String> getAnnouncementOfCourse(String courseID)
    {
        con = connectDB();
        String query = "SELECT Announcement FROM Announcements WHERE CourseID = ?";
        List<String> announcements = new ArrayList<>();
        try (PreparedStatement statement = con.prepareStatement(query);)
        {
            statement.setString(1, courseID);
            ResultSet rs = statement.executeQuery();
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
                System.out.println("Error getting announcements of course: " + e.getMessage());
            }
        }
    }

    public static int registerCourseToInstructor(String courseID, String instructorID) throws Exception
    {
        con = connectDB();
        String query = "UPDATE Courses SET InstructorID = ? WHERE CourseID = ?";
        try (PreparedStatement statement = con.prepareStatement(query);)
        {
            statement.setString(1, instructorID);
            statement.setString(2, courseID);
            int result = statement.executeUpdate();
            if (result == 0)
            {
                throw new Exception("Error registering course to instructor");
            }
            return 1;
        }
        catch (SQLException e)
        {
            System.out.println("Error registering course to instructor: " + e.getMessage());
            throw new Exception("Error registering course to instructor: " + e.getMessage());
        } finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }

    public static int registerCourseToStudent(String courseID, String studentID) throws Exception
    {
        con = connectDB();
        String query = "INSERT INTO StudentCourses (StudID, CourseID, QuizGrade, MidtermGrade, FinalGrade, ProjectGrade) VALUES (?, ?, 0, 0, 0, 0)";
        try (PreparedStatement statement = con.prepareStatement(query);)
        {
            statement.setString(1, studentID);
            statement.setString(2, courseID);
            int result = statement.executeUpdate();
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
                System.out.println("Error registering course to student: " + e.getMessage());
            }
        }
    }

    public static int dropCourseFromStudent(String courseID, String studentID)
    {
        con = connectDB();
        String query = "DELETE FROM StudentCourses WHERE StudID = ? AND CourseID = ?";
        try (PreparedStatement statement = con.prepareStatement(query);)
        {
            statement.setString(1, studentID);
            statement.setString(2, courseID);
            int result = statement.executeUpdate();
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
                System.out.println("Error dropping course from student: " + e.getMessage());
            }
        }
    }

    public static ResultSet getUnassignedCourses()
    {
        con = connectDB();
        String query = "SELECT * FROM Courses WHERE InstructorID IS NULL";
        try
        {
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            return rs;
        }
        catch (SQLException e)
        {
            System.out.println("Error getting unassigned courses: " + e.getMessage());
            return null;
        }
    }

    public static ResultSet getAvailableCourses(String studentID)
    {
        con = connectDB();
        String query = """
                SELECT * FROM Courses
                WHERE CourseID NOT IN (SELECT CourseID FROM StudentCourses WHERE StudID = ?)
                AND instructorID IS NOT NULL
                AND (SELECT COUNT(*) FROM StudentCourses WHERE CourseID = Courses.CourseID) < maxCap
                """;
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
        try (PreparedStatement statement = con.prepareStatement(query);)
        {
            statement.setString(1, announcement);
            statement.setString(2, courseID);
            statement.executeUpdate();
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
                System.out.println("Error sending announcement: " + e.getMessage());
            }
        }
    }

    public static void sendAlert(String alert)
    {
        con = connectDB();
        String query = "INSERT INTO Alerts (Alert) VALUES (?)";
        try (PreparedStatement statement = con.prepareStatement(query);)
        {
            statement.setString(1, alert);
            statement.executeUpdate();
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
                System.out.println("Error sending alert: " + e.getMessage());
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
        try (Statement statement = con.createStatement();)
        {
            ResultSet rs = statement.executeQuery("SELECT MAX(UserID) FROM User");
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
        try (PreparedStatement statement = con.prepareStatement(
                view);)
        {

            // Execute the statement
            ResultSet rs = statement.executeQuery();

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

    public static List<UserModel> getAllUsersFull()
    {
        // Set up the list
        List<UserModel> users = new ArrayList<>();

        // Get the connection
        con = connectDBViews();
        String view = "SELECT * FROM informationsystem.`view all users full`;";

        // Create the statement
        try (PreparedStatement statement = con.prepareStatement(view);)
        {

            // Execute the statement
            ResultSet rs = statement.executeQuery();

            // Get the results
            while (rs.next())
            {
                // Create the user from the results
                UserModel user = new UserModel();
                user.setUserID(rs.getLong(1));
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

    public static List<UserModel> getAllUsers()
    {
        // Set up the list
        List<UserModel> users = new ArrayList<>();

        // Get the connection
        con = connectDBViews();
        String view = "SELECT * FROM informationsystem.`view all users`;";

        // Create the statement
        try (PreparedStatement statement = con.prepareStatement(view);)
        {

            // Execute the statement
            ResultSet rs = statement.executeQuery();

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
        String query = """
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
                    """;

        // Create the statement
        try (PreparedStatement statement = con.prepareStatement(query);)
        {
            statement.setString(1, ID);

            // Execute the statement
            ResultSet rs = statement.executeQuery();

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
        try (PreparedStatement statement = con.prepareStatement(view);)
        {

            // Execute the statement
            ResultSet rs = statement.executeQuery();

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

    public static void updateUserInfo(Long userID, String fname, String lname, String birthdate, String major,
            String personalPhone, String personalEmail, String workPhone) throws Exception
    {
        con = connectDB();
        String statement = "UPDATE profile SET FirstName = ?, LastName = ?, Birthdate = ?, Major = ? WHERE UserID = ?;";

        // Create the statement
        try (PreparedStatement stmt1 = con.prepareStatement(statement);)
        {
            stmt1.setString(1, fname);
            stmt1.setString(2, lname);
            stmt1.setString(3, birthdate);
            stmt1.setString(4, major);
            stmt1.setLong(5, userID);

            stmt1.executeUpdate();

        }
        catch (SQLException e)
        {
            System.err.println("Error Saving User Info: " + e.getMessage());
            throw e;
        }

        statement = "UPDATE personalcontactdetails SET Email = ?, Phone = ? WHERE UserID = ?;";
        try (PreparedStatement stmt2 = con.prepareStatement(statement);)
        {
            stmt2.setString(1, personalEmail);
            stmt2.setString(2, personalPhone);
            stmt2.setLong(3, userID);

            stmt2.executeUpdate();

        }
        catch (SQLException e)
        {
            System.err.println("Error Saving User Info: " + e.getMessage());
            throw e;
        }
        statement = "UPDATE workcontactdetails SET Phone = ? WHERE UserID = ?;";
        try (PreparedStatement stmt3 = con.prepareStatement(statement);)
        {
            stmt3.setString(1, workPhone);
            stmt3.setLong(2, userID);

            stmt3.executeUpdate();
        }
        catch (SQLException e)
        {
            System.err.println("Error Saving User Info: " + e.getMessage());
            throw e;
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

    public static int saveGrade(Long userID, String courseID, String quizGrade, String midtermGrade, String finalGrade,
            String projectGrade)
    {
        // Get the connection
        con = connectDB();
        String query = "UPDATE studentcourses SET QuizGrade = ?, MidtermGrade = ?, FinalGrade = ?, ProjectGrade = ? WHERE StudID = ? && CourseID = ?;";

        // Create the statement
        try (PreparedStatement statement = con.prepareStatement(query);)
        {
            statement.setString(1, quizGrade);
            statement.setString(2, midtermGrade);
            statement.setString(3, finalGrade);
            statement.setString(4, projectGrade);
            statement.setLong(5, userID);
            statement.setString(6, courseID);

            statement.executeUpdate();

            return 1;

        }
        catch (SQLException e)
        {
            System.err.println("Error Saving Grade: " + e.getMessage());
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
        return 0;
    }

    public static List<StudentModel> getStudentsOfInstructorGradesList(String userID)
    {
        List<StudentModel> students = null;
        ResultSet rs = null;
        try
        {
            rs = getStudentsOfInstructorGrades(userID);
            students = new ArrayList<>();

            while (rs.next())
            {
                StudentModel student = new StudentModel();
                student.setUserID(rs.getLong(1));
                student.setCourseID(rs.getString(2));
                student.setEmail(rs.getString(3));
                student.setFirstName(rs.getString(4));
                student.setLastName(rs.getString(5));
                student.setQuizGrade(rs.getDouble(6));
                student.setMidtermGrade(rs.getDouble(7));
                student.setFinalGrade(rs.getDouble(8));
                student.setProjectGrade(rs.getDouble(9));
                student.setTotalGrade(rs.getDouble(10));
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
                if (rs != null)
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
                SELECT profile.UserID, CourseID, Email, FirstName, LastName, QuizGrade, MidtermGrade, FinalGrade, ProjectGrade, TotalGrade
                FROM user, studentcourses, profile, workcontactdetails
                WHERE user.UserID = StudID && StudID = profile.UserID && profile.UserID = workcontactdetails.UserID && CourseID IN (SELECT CourseID FROM courses WHERE InstructorID = %s) && user.status = 'Active';
                    """
                .formatted(userID);
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
                SELECT profile.UserID, FirstName, LastName, Sex, TotalGrade as 'Total Course Grade'
                FROM user, studentcourses, profile
                WHERE user.UserID = StudID && StudID = profile.UserID && CourseID IN (SELECT CourseID FROM courses WHERE InstructorID = %s) && user.status = 'Active';
                    """
                .formatted(userID);
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

    public static void clearAlerts()
    {
        String query = """
                DELETE FROM alerts;
                """;
        con = connectDB();
        try
        {
            stmt = con.prepareStatement(query);
            stmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.err.println("Error Clearing Alerts: " + e.getMessage());
        }
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
        try (PreparedStatement statement = con.prepareStatement(query))
        {
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
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
                AND BINARY user.Password = BINARY ?;
                    """;
        try (PreparedStatement statement = con.prepareStatement(query);)
        {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
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
        try (PreparedStatement statement = con.prepareStatement(query);)
        {
            statement.setString(1, userID);
            int result = statement.executeUpdate();
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
                    System.err.println("Error Activating User: " + e.getMessage());
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
        try (PreparedStatement statement = con.prepareStatement(query);)
        {
            statement.setString(1, courseID);
            statement.setString(2, courseName);
            statement.setString(3, courseCredit);
            statement.setString(4, maxCapacity);
            statement.executeUpdate();
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
        try (PreparedStatement statement = con.prepareStatement(query);)
        {
            statement.setString(1, courseID);
            int result = statement.executeUpdate();
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

    public static int checkPassword(String password)
    {
        String query = "SELECT password FROM user WHERE userID = ?;";
        con = connectDB();
        try (PreparedStatement statement = con.prepareStatement(query))
        {
            statement.setString(1, Long.toString(currentUser.getUserID()));
            ResultSet rs = statement.executeQuery();
            if (rs.next())
            {
                if (rs.getString(1).equals(password))
                {
                    return 0;
                }
                else
                {
                    return 1;
                }
            }
            else
            {
                return -1;
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error Checking Password: " + e.getMessage());
            return -1;
        }
    }

    public static int updatePassword(String password, String userID)
    {
        String query = "UPDATE user SET password = ? WHERE userID = ?;";
        con = connectDB();
        try (PreparedStatement statement = con.prepareStatement(query))
        {
            statement.setString(1, password);
            statement.setString(2, userID);
            int result = statement.executeUpdate();
            if (result == 1)
            {
                return 0;
            }
            else
            {
                return 1;
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error Updating Password: " + e.getMessage());
            return -1;
        }
    }

    public static void closeDatabase()
    {
        try
        {
            if (con != null)
            {
                con.close();
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
