package oop.project.components.MiniComponents;

import oop.project.components.core.RoundedJTextField;

public class PhoneTextField extends RoundedJTextField
{
    public PhoneTextField(int size)
    {
        super(size);
    }

    public int Validate()
    {
        String text = getText();
        System.out.println("Phone: " + text);
        if (text.length() != 10)
        {
            return 1;
        }
        for (int i = 0; i < text.length(); i++)
        {
            if (!Character.isDigit(text.charAt(i)))
            {
                return 2;
            }
        }
        return 0;
    }
}
