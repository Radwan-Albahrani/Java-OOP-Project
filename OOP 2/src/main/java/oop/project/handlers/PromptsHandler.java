package oop.project.handlers;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextArea;

import oop.project.colors.ThemeColors;

public class PromptsHandler implements FocusListener
{
    String text;
    JTextArea textArea;

    public PromptsHandler(String text, JTextArea textArea)
    {
        this.text = text;
        this.textArea = textArea;
    }

    @Override
    public void focusGained(FocusEvent arg0)
    {
        if (textArea.getText().equals(text))
        {
            textArea.setText("");
            textArea.setForeground(ThemeColors.BLACK);
        }

    }

    @Override
    public void focusLost(FocusEvent arg0)
    {

        if (textArea.getText().isEmpty())
        {
            textArea.setForeground(ThemeColors.LIGHT_GREY);
            textArea.setText(text);
        }
    }
}
