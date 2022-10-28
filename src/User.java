import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class User implements Serializable
{
    // V===================================== Variables =====================================
    public static int numberOfUsers = 0;
    int authorityLevel, age;
    Date creationDate, expirationDate;
    Authentication auth;
    Profile profile;

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

    // ===================================== Methods=====================================
    // Method to view profile
    public List<String> viewProfile()
    {
        // Setting up Profile
        List<String> viewProfile = new ArrayList<String>();
        viewProfile.add(profile.getName());
        viewProfile.add(profile.getPhoneNumber());
        viewProfile.add(profile.getEmail());
        viewProfile.add(profile.getField());
        viewProfile.add(profile.getAdditionalField());
        viewProfile.add(profile.getNationality());
        viewProfile.add("" + profile.getAge());
        viewProfile.add("" + profile.getBirthDate());
        viewProfile.add("" + profile.getGender().toString());

        return viewProfile;
    }

    public abstract void registerCourse(Courses course);
}
