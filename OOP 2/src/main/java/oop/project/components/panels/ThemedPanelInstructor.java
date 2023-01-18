package oop.project.components.panels;

import com.k33ptoo.components.KGradientPanel;

import oop.project.colors.ThemeColors;

import javax.swing.BorderFactory;

public class ThemedPanelInstructor extends KGradientPanel
{
    public ThemedPanelInstructor()
    {
        this.setkStartColor(ThemeColors.LIGHT_GREY);
        this.setkEndColor(ThemeColors.DARK_GREY);
        this.setkFillBackground(true);
        this.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        this.setOpaque(false);
    }
}
