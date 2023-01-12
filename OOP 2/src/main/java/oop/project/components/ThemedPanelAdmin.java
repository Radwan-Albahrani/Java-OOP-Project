package oop.project.components;

import com.k33ptoo.components.KGradientPanel;

import oop.project.colors.ThemeColors;

import javax.swing.BorderFactory;

public class ThemedPanelAdmin extends KGradientPanel
{
    public ThemedPanelAdmin()
    {
        this.setkStartColor(ThemeColors.KHAKI);
        this.setkEndColor(ThemeColors.LIGHT_KHAKI);
        this.setkGradientFocus(0);
        this.setkBorderRadius(70);
        this.setkFillBackground(true);
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.setOpaque(false);
    }
}
