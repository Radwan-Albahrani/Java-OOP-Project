package oop.project.API;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import oop.project.models.Auth;
import oop.project.models.UserModel;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseCon
{
    private static Connection connectDB()
    {
        String DATABASE_URL = "jdbc:mysql://localhost:3306/informationsystem";
        try
        {
            Connection connection = DriverManager.getConnection(DATABASE_URL, "root", "root");
            return connection;
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return null;
    }

    public static int registerUser(UserModel user)
    {
        // Get the connection
        Connection con = connectDB();

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
            e.printStackTrace();
            return 0;
        }
    }

    public static long generateID()
    {
        Connection con = connectDB();
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
            e.printStackTrace();
            return 0;
        }

    }

    public static List<UserModel> getAllWithType(String type)
    {
        // Set up the list
        List<UserModel> users = new ArrayList<>();

        // Get the connection
        Connection con = connectDB();

        // Create the statement
        try (PreparedStatement stmt = con.prepareStatement(
                """
                            SELECT User.UserID, User.Username, User.Password, User.Type, Profile.FirstName, Profile.LastName, Profile.Sex, Profile.Birthdate, Profile.Major, WorkContactDetails.Email, workcontactdetails.Phone, personalcontactdetails.Email as 'Personal Email', personalcontactdetails.Phone as 'Personal Phone'
                            FROM User
                            JOIN Profile ON User.UserID = Profile.UserID
                            JOIN WorkContactDetails ON User.UserID = WorkContactDetails.UserID
                            JOIN PersonalContactDetails ON User.UserID = PersonalContactDetails.UserID
                            Where user.Type = ?;
                        """);)
        {
            // Set the parameters
            stmt.setString(1, type);

            // Execute the statement
            ResultSet rs = stmt.executeQuery();

            // Get the results
            while (rs.next())
            {
                // Create the user from the results
                UserModel user = new UserModel();
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

                // Add the user to the list
                users.add(user);
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return users;
    }

    public static void main(String[] args)
    {
        List<UserModel> users = getAllWithType("Instructor");
        for (UserModel user : users)
        {
            System.out.println(user.toString());
        }
    }

}
