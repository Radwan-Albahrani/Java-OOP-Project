package oop.project.components.MiniComponents;

import oop.project.components.RoundedJTextField;

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
        if (email.matches("^[A-Za-z0-9+_.-]+@(.+)$"))
        {
            return 0;
        }
        return 1;
    }
}
