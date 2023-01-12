package oop.project.components;

import com.k33ptoo.components.KGradientPanel;

import oop.project.colors.ThemeColors;

import javax.swing.BorderFactory;

public class ThemedPanelStudent extends KGradientPanel
{
    public ThemedPanelStudent()
    {
        this.setkStartColor(ThemeColors.A_LITTLE_GREY);
        this.setkEndColor(ThemeColors.FLOOR_GREY);
        this.setkGradientFocus(0);
        this.setkBorderRadius(70);
        this.setkFillBackground(true);
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.setOpaque(false);
    }
}
