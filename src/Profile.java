import java.sql.Date;

public class Profile
{
    String name, nationality, field, additionalField, email, phoneNumber;
    int age;
    char gender;
    Date birthDate;

    // Setters
    public void setName(String name)
    {
        this.name = name;
    }

    public void setNationality(String nationality)
    {
        this.nationality = nationality;
    }

    public void setField(String field)
    {
        this.field = field;
    }

    public void setAdditionalField(String additionalField)
    {
        this.additionalField = additionalField;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setGender(char gender)
    {
        this.gender = gender;
    }

    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }

    // Getters
    public String getName()
    {
        return name;
    }

    public String getNationality()
    {
        return nationality;
    }

    public String getField()
    {
        return field;
    }

    public String getAdditionalField()
    {
        return additionalField;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public int getAge()
    {
        return age;
    }

    public char getGender()
    {
        return gender;
    }

    public Date getBirthDate()
    {
        return birthDate;
    }

}
