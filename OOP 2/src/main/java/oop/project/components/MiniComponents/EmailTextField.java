package oop.project.components.MiniComponents;

import oop.project.API.DatabaseCon;
import oop.project.components.core.RoundedJTextField;

public class EmailTextField extends RoundedJTextField
{
    public EmailTextField(int size)
    {
        super(size);
    }

    public int Validate()
    {
        // Validate email using regex
        String email = getText();
        if (email.matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$"))
        {
            int result = DatabaseCon.checkEmail(email);
            return result;
        }
        return 2;
    }
}
