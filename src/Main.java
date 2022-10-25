import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // Variables
        String name, nationality, field, additionalField, email, phoneNumber;
        int age;
        char gender;

        User user = new User();
        System.out.print("Enter your name: ");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        boolean notParsed = false;
        while (!notParsed)
        {
            try
            {
                System.out.print("Enter date of birth in YYYY-MM-DD format: ");
                // reads the date of birth from the user
                String input = scanner.nextLine();
                LocalDate dob = LocalDate.parse(input);
                age = calculateAge(dob);
                notParsed = true;
            }
            catch (Exception e)
            {
                System.out.println("Make sure you have the proper date format");
            }
        }

        System.out.print("Enter your nationality: ");
        nationality = scanner.nextLine();
        notParsed = false;
        while (!notParsed)
        {
            try
            {
                System.out.print("Enter your phone number: ");
                phoneNumber = scanner.nextLine();
                if (phoneNumber.length() > 10)
                {
                    throw new Exception();
                }
                for (int i = 0; i < phoneNumber.length(); i++)
                {
                    if (Character.isLetter((phoneNumber.charAt(i))))
                    {
                        throw new Exception();
                    }

                }
            }
            catch (Exception e)
            {
                System.out.println("Make sure you have the proper phone number");
            }
        }
        System.out.print("Enter your phone number: ");
        phoneNumber = scanner.nextLine();

        System.out.print("Enter your gender: ");
        gender = scanner.next().charAt(0);

        email = "" + name.split(" ")[0] + User.numberOfUsers + "@university.com";
        System.out.println(email);

    }

    public static int calculateAge(LocalDate dob)
    {
        // Get local date of now
        LocalDate curDate = LocalDate.now();
        // calculates the amount of time between two dates and returns the years
        if ((dob != null) && (curDate != null))
        {
            return Period.between(dob, curDate).getYears();
        }
        else
        {
            return 0;
        }
    }
}
