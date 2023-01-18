package oop.project.components.panels;

import com.k33ptoo.components.KGradientPanel;

import oop.project.colors.ThemeColors;

import javax.swing.BorderFactory;

public class ThemedPanelAdmin extends KGradientPanel
{
    public ThemedPanelAdmin()
    {
        this.setkStartColor(ThemeColors.BLUISH_CYAN);
        this.setkEndColor(ThemeColors.PINKISH_MAGENTA);
        this.setkFillBackground(true);
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.setOpaque(false);
    }
}
