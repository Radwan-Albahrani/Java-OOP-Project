package oop.project.components.panels;

import com.k33ptoo.components.KGradientPanel;

import oop.project.colors.ThemeColors;

import javax.swing.BorderFactory;

public class ThemedPanelStudent extends KGradientPanel
{
    public ThemedPanelStudent()
    {
        this.setkStartColor(ThemeColors.GREENISH);
        this.setkEndColor(ThemeColors.LIGHT_BROWN);
        this.setkFillBackground(true);
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.setOpaque(false);
    }
}
