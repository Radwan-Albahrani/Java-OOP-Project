import java.time.LocalDate;

public class Student extends User {

    Student(int authorityLevel, String username, String password, String name, String nationality, String field, String additionalField, String email,
            String phoneNumber, LocalDate birthDate, Gender gender, int age)
    {
        super(authorityLevel, username, password, name, nationality, field, additionalField, email, phoneNumber, birthDate, gender, age);
    }

}
