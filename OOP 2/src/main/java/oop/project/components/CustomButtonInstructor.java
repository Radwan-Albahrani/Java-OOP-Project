package oop.project.components;

import oop.project.colors.ThemeColors;

import java.awt.Font;
import java.awt.Dimension;

public class CustomButtonInstructor extends RoundedButton
{
    public CustomButtonInstructor(String text)
    {
        this.setText(text);
        this.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        this.setkStartColor(ThemeColors.LIGHT_GREY);
        this.setkEndColor(ThemeColors.DARK_GREY);
        this.setkHoverStartColor(ThemeColors.DARK_GREY);
        this.setkHoverEndColor(ThemeColors.DARK_GREY);
        this.setkForeGround(ThemeColors.LAVENDER_BLUSH);
        this.setkHoverForeGround(ThemeColors.ROSE_MADDER);
        this.setPreferredSize(new Dimension(400, 50));
        this.setMinimumSize(getPreferredSize());
        this.setMaximumSize(getPreferredSize());
        this.setkBorderRadius(30);
    }
}