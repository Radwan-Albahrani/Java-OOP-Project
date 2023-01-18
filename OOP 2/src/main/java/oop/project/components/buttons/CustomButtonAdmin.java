package oop.project.components.buttons;

import oop.project.colors.ThemeColors;
import oop.project.components.core.RoundedButton;

import java.awt.Font;
import java.awt.Dimension;

public class CustomButtonAdmin extends RoundedButton
{
    public CustomButtonAdmin(String text)
    {

        this.setText(text);
        this.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        this.setkStartColor(ThemeColors.BLUISH_CYAN);
        this.setkEndColor(ThemeColors.BLURPLE);
        this.setkHoverStartColor(ThemeColors.BLUISH_CYAN);
        this.setkHoverEndColor(ThemeColors.BLUISH_CYAN);
        this.setkForeGround(ThemeColors.LAVENDER_BLUSH);
        this.setkHoverForeGround(ThemeColors.ROSE_MADDER);
        this.setPreferredSize(new Dimension(400, 50));
        this.setMinimumSize(getPreferredSize());
        this.setMaximumSize(getPreferredSize());
        this.setkBorderRadius(30);
    }
}