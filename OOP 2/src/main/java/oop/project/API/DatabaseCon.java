package oop.project.API;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DatabaseCon
{
    private static void connectDB()
    {
        String DATABASE_URL = "jdbc:mysql://localhost:3306/informationsystem";
        try (
                Connection connection = DriverManager.getConnection(DATABASE_URL, "root", "root");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM user");)
        {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            System.out.println("Database table users:");
            for (int i = 1; i <= numberOfColumns; i++)
            {
                System.out.printf("%-8s\t", metaData.getColumnName(i));
            }
            System.out.println();
            while (resultSet.next())
            {
                for (int i = 1; i <= numberOfColumns; i++)
                {
                    System.out.printf("%-8s\t", resultSet.getObject(i));
                }
                System.out.println();
            }
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        connectDB();
    }

}
