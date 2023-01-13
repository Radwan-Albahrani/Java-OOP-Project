package oop.project.components;

import com.k33ptoo.components.KButton;

import oop.project.colors.ThemeColors;

import java.awt.Font;
import java.awt.Dimension;
import javax.swing.border.*;

public class CustomButtonInstructor extends KButton
{
    public CustomButtonInstructor(String text)
    {
        Border border = new LineBorder(ThemeColors.BLACK, 2, true);

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
        this.setBorder(border);
    }
}