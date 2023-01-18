package oop.project.components.panels;

import com.k33ptoo.components.KGradientPanel;

import oop.project.colors.ThemeColors;

import javax.swing.BorderFactory;

public class ThemedPanelRight extends KGradientPanel
{
    public ThemedPanelRight()
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
