package oop.project.components;

import oop.project.colors.ThemeColors;

import java.awt.Font;
import java.awt.Dimension;

public class CustomButtonStudent extends RoundedButton
{
    public CustomButtonStudent(String text)
    {
        this.setText(text);
        this.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        this.setkStartColor(ThemeColors.GREENISH);
        this.setkEndColor(ThemeColors.LIGHT_BROWN);
        this.setkHoverStartColor(ThemeColors.GREENISH);
        this.setkHoverEndColor(ThemeColors.GREENISH);
        this.setkForeGround(ThemeColors.LAVENDER_BLUSH);
        this.setkHoverForeGround(ThemeColors.ROSE_MADDER);
        this.setPreferredSize(new Dimension(400, 50));
        this.setMinimumSize(getPreferredSize());
        this.setMaximumSize(getPreferredSize());
        this.setkBorderRadius(30);
    }
}