package oop.project.models;

public class UserModel
{
    private String firstName;
    private String lastName;
    private String sex;
    private String email;
    private String role;
    private String birthDate;
    private String major;
    private String phoneNumber;
    private Auth auth;

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public void setBirthDate(String birthDate)
    {
        this.birthDate = birthDate;
    }

    public void setMajor(String major)
    {
        this.major = major;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public void setAuth(Auth auth)
    {
        this.auth = auth;
    }

    public UserModel()
    {

    }

    @Override
    public String toString()
    {
        String profile = "";
        profile += "First Name: " + this.firstName + "\n";
        profile += "Last Name: " + this.lastName + "\n";
        profile += "Sex: " + this.sex + "\n";
        profile += "Email: " + this.email + "\n";
        profile += "Role: " + this.role + "\n";
        profile += "Birth Date: " + this.birthDate + "\n";
        profile += "Major: " + this.major + "\n";
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

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public Auth getAuth()
    {
        return auth;
    }

}
