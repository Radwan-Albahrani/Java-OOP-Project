package oop.project.components.buttons;

import com.k33ptoo.components.KButton;

import oop.project.colors.ThemeColors;

import java.awt.Font;
import java.awt.Dimension;
import javax.swing.BorderFactory;

public class BlueButton extends KButton
{
    public BlueButton(String text)
    {
        this.setText(text);
        this.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        this.setkStartColor(ThemeColors.POWDER_BLUE);
        this.setkEndColor(ThemeColors.MEDIUM_SEA_GREEN);
        this.setkHoverStartColor(ThemeColors.DARK_POWDER_BLUE);
        this.setkHoverEndColor(ThemeColors.MEDIUM_SEA_GREEN);
        this.setkForeGround(ThemeColors.LIGHT_KHAKI);
        this.setkHoverForeGround(ThemeColors.KHAKI);
        this.setkBorderRadius(30);
        this.setPreferredSize(new Dimension(150, 50));
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }
}
