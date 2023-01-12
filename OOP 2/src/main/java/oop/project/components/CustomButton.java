package oop.project.components;

import com.k33ptoo.components.KButton;

import oop.project.colors.ThemeColors;

import java.awt.Font;
import java.awt.Dimension;
import javax.swing.border.*;

public class CustomButton extends KButton
{
    public CustomButton(String text)
    {
        Border border = new LineBorder(ThemeColors.BLACK, 2, true);

        this.setText(text);
        this.setFont(new Font("Arial", Font.BOLD, 20));
        this.setkStartColor(ThemeColors.MIDDLE_BLUE_COLOR);
        this.setkEndColor(ThemeColors.TIFFANY_BLUE);
        this.setkHoverStartColor(ThemeColors.MIDDLE_BLUE_COLOR);
        this.setkHoverEndColor(ThemeColors.BLURPLE);
        this.setkForeGround(ThemeColors.LAVENDER_BLUSH);
        this.setkHoverForeGround(ThemeColors.ROSE_MADDER);
        this.setPreferredSize(new Dimension(150, 50));
        this.setBorder(border);
    }
}