package oop.project.screens.components;

import com.k33ptoo.components.KGradientPanel;

import oop.project.screens.colors.ThemeColors;

import javax.swing.BorderFactory;

public class ThemedPanel extends KGradientPanel
{
    public ThemedPanel()
    {
        this.setkStartColor(ThemeColors.POWDER_BLUE);
        this.setkEndColor(ThemeColors.MEDIUM_SEA_GREEN);
        this.setkGradientFocus(0);
        this.setkBorderRadius(70);
        this.setkFillBackground(true);
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.setOpaque(false);
    }
}