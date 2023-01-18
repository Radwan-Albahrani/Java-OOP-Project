package oop.project.components.core;

import javax.swing.JTextArea;

import oop.project.colors.ThemeColors;
import oop.project.handlers.PromptsHandler;

import javax.swing.BorderFactory;
import java.awt.Font;

public class PromptedTextArea extends JTextArea
{
    public PromptedTextArea(String text)
    {
        this.setLineWrap(true);
        this.setBackground(ThemeColors.LIGHT_GRAY);
        this.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
        this.setBorder(BorderFactory.createLineBorder(ThemeColors.LIGHT_GREY, 5));
        this.setText(text);
        this.setForeground(ThemeColors.LIGHT_GREY);
        this.addFocusListener(new PromptsHandler(text, this));
    }

}
