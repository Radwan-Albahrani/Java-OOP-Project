package oop.project.models;

public class UserModel
{
    private String firstName;
    private String lastName;
    private String sex;
    private String email;
    private String personalEmail;
    private String role;
    private String birthDate;
    private String major;
    private String occupation;
    private String phoneNumber;
    private Auth auth;

    public UserModel(String firstName, String lastName, String sex, String email, String personalEmail, String role,
            String birthDate, String major, String occupation, String phoneNumber, Auth auth)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.email = email;
        this.personalEmail = personalEmail;
        this.role = role;
        this.birthDate = birthDate;
        this.major = major;
        this.occupation = occupation;
        this.phoneNumber = phoneNumber;
        this.auth = auth;
    }

    @Override
    public String toString()
    {
        String profile = "";
        profile += "First Name: " + this.firstName + "\n";
        profile += "Last Name: " + this.lastName + "\n";
        profile += "Sex: " + this.sex + "\n";
        profile += "Email: " + this.email + "\n";
        profile += "Personal Email: " + this.personalEmail + "\n";
        profile += "Role: " + this.role + "\n";
        profile += "Birth Date: " + this.birthDate + "\n";
        profile += "Major: " + this.major + "\n";
        profile += "Occupation: " + this.occupation + "\n";
        profile += "Phone Number: " + this.phoneNumber + "\n";
        profile += "Username: " + this.auth.getUsername() + "\n";
        profile += "Password: " + this.auth.getPassword() + "\n";
        return profile;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getSex()
    {
        return sex;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPersonalEmail()
    {
        return personalEmail;
    }

    public String getRole()
    {
        return role;
    }

    public String getBirthDate()
    {
        return birthDate;
    }

    public String getMajor()
    {
        return major;
    }

    public String getOccupation()
    {
        return occupation;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public Auth getAuth()
    {
        return auth;
    }

}
