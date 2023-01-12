package oop.project.components;

import com.k33ptoo.components.KButton;

import oop.project.colors.ThemeColors;

import java.awt.Font;
import java.awt.Dimension;
import javax.swing.BorderFactory;

public class ExitButton extends KButton
{
    public ExitButton()
    {
        this.setText("X");
        this.setFont(new Font("Arial", Font.BOLD, 20));
        this.setkStartColor(ThemeColors.RED);
        this.setkEndColor(ThemeColors.DARK_RED);
        this.setkHoverStartColor(ThemeColors.ORANGE);
        this.setkHoverEndColor(ThemeColors.DARK_ORANGE);
        this.setkForeGround(ThemeColors.BLACK);
        this.setkHoverForeGround(ThemeColors.BLACK);
        this.setkBorderRadius(30);
        this.setPreferredSize(new Dimension(50, 50));
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }
}
