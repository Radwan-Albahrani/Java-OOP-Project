package oop.project.components;

import com.k33ptoo.components.KButton;

import oop.project.colors.ThemeColors;

import java.awt.Font;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import java.awt.Image;
import javax.swing.ImageIcon;

public class ExitButton extends KButton
{
    public ExitButton()
    {
        ImageIcon img = new ImageIcon(getClass().getResource("/images/ExitIcon.png"));
        Image image = img.getImage(); // transform it 
        Image newimg = image.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        ImageIcon imgresized = new ImageIcon(newimg);  // transform it back

        this.setIcon(imgresized);
        this.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        this.setkStartColor(ThemeColors.RED);
        this.setkEndColor(ThemeColors.DARK_RED);
        this.setkHoverStartColor(ThemeColors.ORANGE);
        this.setkHoverEndColor(ThemeColors.DARK_ORANGE);
        this.setkForeGround(ThemeColors.BLACK);
        this.setkHoverForeGround(ThemeColors.BLACK);;
        this.setPreferredSize(new Dimension(50, 50));
        this.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
    }
}
