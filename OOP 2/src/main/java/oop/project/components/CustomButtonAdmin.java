package oop.project.components;

import com.k33ptoo.components.KButton;

import oop.project.colors.ThemeColors;

import java.awt.Font;
import java.awt.Dimension;
import javax.swing.border.*;

public class CustomButtonAdmin extends KButton
{
    public CustomButtonAdmin(String text)
    {
        Border border = new LineBorder(ThemeColors.BLACK, 2, true);

        this.setText(text);
        this.setFont(new Font("Arial", Font.BOLD, 20));
        this.setkStartColor(ThemeColors.BLUISH_CYAN);
        this.setkEndColor(ThemeColors.BLURPLE);
        this.setkHoverStartColor(ThemeColors.BLUISH_CYAN);
        this.setkHoverEndColor(ThemeColors.BLUISH_CYAN);
        this.setkForeGround(ThemeColors.LAVENDER_BLUSH);
        this.setkHoverForeGround(ThemeColors.ROSE_MADDER);
        this.setPreferredSize(new Dimension(400, 50));
        this.setMinimumSize(getPreferredSize());
        this.setMaximumSize(getPreferredSize());
        this.setBorder(border);
    }
}