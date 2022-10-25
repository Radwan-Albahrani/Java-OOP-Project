import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class User
{
    public static int numberOfUsers = 0;
    int authorityLevel, age;
    Date creationDate, expirationDate;
    Authentication auth;
    Profile profile;

    public Date getCreationDate()
    {
        return creationDate;
    }

    public Date getExpirationDate()
    {
        return expirationDate;
    }

    public void register(int authorityLevel, String username, String password, String name, String nationality, String bloodType, String field,
            String additionalField, String email, String phoneNumber, Date birthDate, char gender) // user login
    {
        // Setting up Authentication
        auth.setUsername(username);
        auth.setPassword(password);
        auth.setUserID(numberOfUsers++);
        auth.setAuthorityLevel(authorityLevel);

        // Setting up Profile
        profile.setName(name);
        profile.setPhoneNumber(phoneNumber);
        profile.setEmail(email);
        profile.setField(field);
        profile.setAdditionalField(additionalField);
        profile.setAge(age);
        profile.setBirthDate(birthDate);
        profile.setNationality(nationality);
        profile.setGender(gender);

    }

    public List<String> viewProfile() // allow to view profile
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
        viewProfile.add("" + profile.getGender());

        return viewProfile;
    }

    {

    }

    public void requestChange() // request change from admin
    {
        // TODO create request change method
    }
}
