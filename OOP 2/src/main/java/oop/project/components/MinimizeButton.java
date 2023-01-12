package oop.project.components;

import com.k33ptoo.components.KButton;

import oop.project.colors.ThemeColors;

import java.awt.Font;
import java.awt.Dimension;
import javax.swing.BorderFactory;

public class MinimizeButton extends KButton
{
    public MinimizeButton()
    {
        this.setText("-");
        this.setFont(new Font("Arial", Font.BOLD, 20));
        this.setkStartColor(ThemeColors.YELLOW);
        this.setkEndColor(ThemeColors.YELLOW_DARK);
        this.setkHoverStartColor(ThemeColors.WHITE);
        this.setkHoverEndColor(ThemeColors.LIGHT_GRAY);
        this.setkForeGround(ThemeColors.BLACK);
        this.setkHoverForeGround(ThemeColors.BLACK);
        this.setkBorderRadius(30);
        this.setPreferredSize(new Dimension(50, 50));
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }
}