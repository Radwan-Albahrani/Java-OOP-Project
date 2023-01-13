package oop.project.components;

import javax.swing.JLabel;

public class TitleLabel extends JLabel
{
    public TitleLabel(String text)
    {
        super(text);
        setForeground(java.awt.Color.WHITE);
        setFont(new java.awt.Font("Trebuchet MS", java.awt.Font.BOLD, 30));
        setHorizontalAlignment(JLabel.CENTER);
        setHorizontalTextPosition(JLabel.CENTER);
    }
}
