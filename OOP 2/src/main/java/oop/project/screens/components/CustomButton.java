package oop.project.screens.components;

import com.k33ptoo.components.KButton;

import oop.project.screens.colors.ThemeColors;

import java.awt.Font;
import java.awt.Dimension;
import javax.swing.border.*;

public class CustomButton extends KButton
{   
    public CustomButton(String text)
    {
        Border border = new LineBorder(ThemeColors.BLACK, 2, true);

        this.setText(text);
        this.setFont(new Font("Arial", Font.BOLD, 20));
        this.setkStartColor(ThemeColors.DARK_POWDER_BLUE);
        this.setkEndColor(ThemeColors.MEDIUM_SEA_GREEN); 
        this.setkHoverStartColor(ThemeColors.DARK_POWDER_BLUE);
        this.setkHoverEndColor(ThemeColors.DARK_SEA_GREEN);
        this.setkForeGround(ThemeColors.LIGHT_KHAKI);
        this.setkHoverForeGround(ThemeColors.KHAKI);
        this.setPreferredSize(new Dimension(150, 50));
        this.setBorder(border);
    }
}
