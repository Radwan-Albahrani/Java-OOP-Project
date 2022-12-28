import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

public class OS
{
    // Writing to files based on type of object
    public static void WriteToFileStudent(List<Student> users, String filename)
    {
        // write to file
        try
        {
            FileOutputStream writeData = new FileOutputStream(filename, false);
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(users);
            writeStream.flush();
            writeStream.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void WriteToFileInstructor(List<Instructor> users, String filename)
    {
        // write to file
        try
        {
            File file = new File("./data");
            file.mkdirs();
            FileOutputStream writeData = new FileOutputStream(filename, false);
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(users);
            writeStream.flush();
            writeStream.close();

        }
        catch (Exception e)
        {

            e.printStackTrace();
        }
    }

    public static void WriteToFileAdmin(List<Admin> users, String filename)
    {
        // write to file
        try
        {
            File file = new File("./data");
            file.mkdirs();
            FileOutputStream writeData = new FileOutputStream(filename, false);
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(users);
            writeStream.flush();
            writeStream.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // Reading from files based on type of object
    public static List<Student> ReadFromFileStudents(String filename)
    {
        List<Student> students = null;
        try
        {
            File file = new File("./data");
            file.mkdirs();
            FileInputStream readData = new FileInputStream(filename);
            ObjectInputStream readStream = new ObjectInputStream(readData);

            students = (ArrayList<Student>) readStream.readObject();
            readStream.close();
        }
        catch (Exception e)
        {
            System.out.println("File \"students.ser\" not found, Creating File");
        }
        return students;
    }

    public static List<Instructor> ReadFromFileInstructors(String filename)
    {
        List<Instructor> instructors = null;
        try
        {
            FileInputStream readData = new FileInputStream(filename);
            ObjectInputStream readStream = new ObjectInputStream(readData);

            instructors = (ArrayList<Instructor>) readStream.readObject();
            readStream.close();
        }
        catch (Exception e)
        {
            System.out.println("File \"instructors.ser\" not found, Creating File");
        }
        return instructors;
    }

    public static List<Admin> ReadFromFileAdmins(String filename)
    {
        List<Admin> admins = null;
        try
        {
            FileInputStream readData = new FileInputStream(filename);
            ObjectInputStream readStream = new ObjectInputStream(readData);

            admins = (ArrayList<Admin>) readStream.readObject();
            readStream.close();
        }
        catch (Exception e)
        {
            System.out.println("File \"admins.ser\" not found, Creating File");
        }
        return admins;
    }
}
