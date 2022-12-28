import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class User implements Serializable
{
    // V===================================== Variables =====================================
    public static int numberOfUsers = 0;
    private Date creationDate, expirationDate;
    private Authentication auth;
    private Profile profile;

    // ===================================== Constructor =====================================
    User(int authorityLevel, String username, String password, String name, String nationality, String field,
            String additionalField, String email, String phoneNumber, LocalDate birthDate, Gender gender, int age) // user login
    {
        // Setting up Authentication
        auth = new Authentication();
        auth.setUsername(username);
        auth.setPassword(password);
        auth.setUserID(numberOfUsers++);
        auth.setAuthorityLevel(authorityLevel);

        // Setting up Profile
        profile = new Profile();
        profile.setName(name);
        profile.setPhoneNumber(phoneNumber);
        profile.setEmail(email);
        profile.setField(field);
        profile.setAdditionalField(additionalField);
        profile.setAge(age);
        profile.setBirthDate(birthDate);
        profile.setNationality(nationality);
        profile.setGender(gender);
        creationDate = new Date(System.currentTimeMillis());
        expirationDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 365);

    }

    // ===================================== Getters =====================================
    public Date getCreationDate()
    {
        return creationDate;
    }

    public Date getExpirationDate()
    {
        return expirationDate;
    }

    public Authentication getAuth()
    {
        return auth;
    }

    public Profile getProfile()
    {
        return profile;
    }


    // ===================================== Methods=====================================
    // Method to view profile
    public List<String> viewProfile()
    {
        // Setting up Profile
        List<String> viewProfile = new ArrayList<String>();
        viewProfile.add(
                ConsoleColors.PURPLE + "=============================================================================================" + ConsoleColors.RESET);
        viewProfile.add(ConsoleColors.BLACK + "Name: " + ConsoleColors.RESET + profile.getName());
        viewProfile.add(ConsoleColors.BLACK + "Age: " + ConsoleColors.RESET + profile.getAge());
        viewProfile.add(ConsoleColors.BLACK + "Gender: " + ConsoleColors.RESET + profile.getGender().toString());
        viewProfile.add(ConsoleColors.BLACK + "Nationality: " + ConsoleColors.RESET + profile.getNationality());
        viewProfile.add(ConsoleColors.BLACK + "Phone Number: " + ConsoleColors.RESET + profile.getPhoneNumber());
        viewProfile.add(ConsoleColors.BLACK + "Email: " + ConsoleColors.RESET + profile.getEmail());
        viewProfile.add(ConsoleColors.BLACK + "Birthday: " + ConsoleColors.RESET + profile.getBirthDate());
        viewProfile.add(ConsoleColors.BLACK + "Field: " + ConsoleColors.RESET + profile.getField());
        viewProfile.add(ConsoleColors.BLACK + "Additional Field: " + ConsoleColors.RESET + profile.getAdditionalField());
        viewProfile.add(
                ConsoleColors.PURPLE + "============================================================================================" + ConsoleColors.RESET);

        return viewProfile;
    }

    public abstract void registerCourse(Courses course);

    // Method to Display Profile
    public void displayProfile() throws InterruptedException
    {
        List<String> profile = this.viewProfile();
        System.out.println(ConsoleColors.BLUE + "Your Profile: " + ConsoleColors.RESET);
        for (String s : profile)
        {
            System.out.println(s);
        }
        Thread.sleep(2000);
    }

    // Request Change from Admin
    public void requestChange()
    {
        System.out.print("Type out an email to the admin for a change request: ");
        String email = Main.scanner.nextLine();
        email = "From: " + this.profile.getName() + "\nEmail: " + this.profile.getEmail() + "\nID: "
                + this.auth.getUserID() + "\nRequest: " + email;
        for (Admin admin : Main.admins)
        {
            admin.alerts.add(email);
        }
        System.out.println("Change Requested Successfully");
    }
}
