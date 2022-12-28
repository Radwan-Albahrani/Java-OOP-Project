import java.io.Serializable;
import java.time.LocalDate;

enum Gender { M, F }
public class Profile implements Serializable
{
    // ===================================== Variables =====================================
    private String name, nationality, field, additionalField, email, phoneNumber;
    private int age;
    private Gender gender;
    private LocalDate birthDate;

    // ===================================== Setters =====================================
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

    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    public void setBirthDate(LocalDate birthDate)
    {
        this.birthDate = birthDate;
    }

    // ===================================== Getters =====================================
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

    public Gender getGender()
    {
        return gender;
    }

    public LocalDate getBirthDate()
    {
        return birthDate;
    }

}
