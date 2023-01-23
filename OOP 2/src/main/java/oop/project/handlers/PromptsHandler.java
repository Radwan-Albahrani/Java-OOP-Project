package oop.project.handlers;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import oop.project.colors.ThemeColors;

public class PromptsHandler implements FocusListener
{
    String text;
    JTextArea textArea;
    JTextField textField;

    public PromptsHandler(String text, JComponent textArea)
    {
        this.text = text;
        if (textArea instanceof JTextArea)
        {
            this.textArea = (JTextArea) textArea;
        }
        else if (textArea instanceof JTextField)
        {
            this.textField = (JTextField) textArea;
        }
        else
        {
            System.err.println("Error: Invalid text area type");
        }
    }

    @Override
    public void focusGained(FocusEvent arg0)
    {
        if (textArea != null)
        {
            if (textArea.getText().equals(text))
            {
                textArea.setText("");
                textArea.setForeground(ThemeColors.BLACK);
            }
        }
        else if (textField != null)
        {
            if (textField.getText().equals(text))
            {
                textField.setText("");
                textField.setForeground(ThemeColors.BLACK);
            }
        }

    }

    @Override
    public void focusLost(FocusEvent arg0)
    {
        if (textArea != null)
        {
            if (textArea.getText().isEmpty())
            {
                textArea.setForeground(ThemeColors.LIGHT_GREY);
                textArea.setText(text);
            }
        }
        else if (textField != null)
        {
            if (textField.getText().isEmpty())
            {
                textField.setForeground(ThemeColors.LIGHT_GREY);
                textField.setText(text);
            }
        }
    }
}
