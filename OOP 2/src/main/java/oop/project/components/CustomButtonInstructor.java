package oop.project.components;

import oop.project.colors.ThemeColors;

import java.awt.Font;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;

public class CustomButtonInstructor extends RoundedButton
{
    public CustomButtonInstructor(String text)
    {
        this.setText(text);
        this.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
        this.setkStartColor(ThemeColors.LIGHT_GREY);
        this.setkEndColor(ThemeColors.DARK_GREY);
        this.setkHoverStartColor(ThemeColors.DARK_GREY);
        this.setkHoverEndColor(ThemeColors.DARK_GREY);
        this.setkForeGround(ThemeColors.LAVENDER_BLUSH);
        this.setkHoverForeGround(ThemeColors.ROSE_MADDER);
        this.setPreferredSize(new Dimension(400, 60));
        this.setMinimumSize(getPreferredSize());
        this.setMaximumSize(getPreferredSize());
        this.setkBorderRadius(30);
    }

    public CustomButtonInstructor(String text, String iconLocation)
    {
        ImageIcon img = new ImageIcon(getClass().getResource(iconLocation));
        Image image = img.getImage(); 
        Image newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); 
        ImageIcon imgresized = new ImageIcon(newimg);

        this.setText(text);
        this.setIcon(imgresized);
        this.setIconTextGap(25);
        this.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        this.setkStartColor(ThemeColors.LIGHT_GREY);
        this.setkEndColor(ThemeColors.DARK_GREY);
        this.setkHoverStartColor(ThemeColors.DARK_GREY);
        this.setkHoverEndColor(ThemeColors.DARK_GREY);
        this.setkForeGround(ThemeColors.LAVENDER_BLUSH);
        this.setkHoverForeGround(ThemeColors.ROSE_MADDER);
        this.setPreferredSize(new Dimension(400, 60));
        this.setMinimumSize(getPreferredSize());
        this.setMaximumSize(getPreferredSize());
        this.setkBorderRadius(30);
    }
}