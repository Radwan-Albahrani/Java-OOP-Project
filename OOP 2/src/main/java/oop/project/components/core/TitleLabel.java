package oop.project.components.core;

import javax.swing.JLabel;
import java.awt.*;

import oop.project.colors.ThemeColors;

public class TitleLabel extends JLabel
{
    public TitleLabel(String text)
    {
        super(text);
        setForeground(ThemeColors.BLACK);
        setFont(new Font("Trebuchet MS", Font.BOLD, 40));
        setHorizontalAlignment(JLabel.CENTER);
        setHorizontalTextPosition(JLabel.CENTER);
    }
}
