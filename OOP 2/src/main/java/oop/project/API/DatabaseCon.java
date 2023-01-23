package oop.project.API;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import oop.project.models.Auth;
import oop.project.models.UserModel;

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
            System.err.println("Error Getting Users of Type As resultSet: " + e.getMessage());
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
        con = connectDBViews();
        String statement = """
                SELECT
                User.UserID,
                User.Username,
                User.Password
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
        try (PreparedStatement tmt = con.prepareStatement(statement);)
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
        return null;
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

    public static int Login(String username, String password)
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

    public static List<UserModel> getStudentsOfInstructorList(String userID)
    {
        List<UserModel> students = new ArrayList<UserModel>();
        ResultSet rs = getStudentsOfInstructor(userID);
        try
        {
            while (rs.next())
            {
                UserModel student = new UserModel();
                student.setUserID(rs.getLong(1));
                student.setFirstName(rs.getString(2));
                student.setLastName(rs.getString(3));
                student.setGender(rs.getString(4));
                student.setTotalGrade(rs.getDouble(5));
                students.add(student);
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error Getting Students of Instructor: " + e.getMessage());
        }



        return students;
    }

    public static void Logout()
    {
        currentUser = null;
    }

    public static void activateUser(String userID)
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
            stmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.err.println("Error Activating User: " + e.getMessage());
        }
    }

    private static void RegisterTesting(String email)
    {
        UserModel user = new UserModel();
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setEmail("TestEmail");
        user.setPersonalEmail(email);
        user.setPhoneNumber("phoneNumber");
        user.setAuth(new Auth("username", "password"));
        user.setBirthDate("2001-01-01");
        user.setMajor("major");
        user.setGender("Male");
        user.setRole("Student");
        user.setPersonalPhoneNumber("personalPhoneNumber");
        registerUser(user);

    }

    private static void ActivateAllUsers()
    {
        List<UserModel> users = getAllUsersWithStatus("Inactive");

        for (UserModel userModel : users)
        {
            activateUser(userModel.getUserID() + "");
            System.out.println(userModel.toString());
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

    public static void main(String[] args)
    {
        for (int i = 1; i < 2; i++)
        {
            RegisterTesting(i + "@university.com");
        }
        ActivateAllUsers();
    }

}
