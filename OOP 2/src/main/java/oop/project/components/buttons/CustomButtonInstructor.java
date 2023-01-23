package oop.project.components.buttons;

import oop.project.colors.ThemeColors;
import oop.project.components.core.RoundedButton;
import oop.project.hooks.FrameConfig;

import java.awt.*;
import javax.swing.*;

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

    public CustomButtonInstructor(String text, int Width, int Height)
    {
        this.setText(text);
        this.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        this.setkStartColor(ThemeColors.LIGHT_GREY);
        this.setkEndColor(ThemeColors.DARK_GREY);
        this.setkHoverStartColor(ThemeColors.DARK_GREY);
        this.setkHoverEndColor(ThemeColors.DARK_GREY);
        this.setkForeGround(ThemeColors.LAVENDER_BLUSH);
        this.setkHoverForeGround(ThemeColors.ROSE_MADDER);
        this.setPreferredSize(new Dimension(Width, Height));
        this.setMinimumSize(getPreferredSize());
        this.setMaximumSize(getPreferredSize());
        this.setkBorderRadius(30);
    }

    public CustomButtonInstructor(String text, String iconLocation)
    {
        Image image = FrameConfig.getPictureWithSize(iconLocation, 40, 40);
        JLabel icon = new JLabel(new ImageIcon(image));

        this.setLayout(new BorderLayout());
        this.add(icon, BorderLayout.WEST);
        this.setText(text);
        this.setIconTextGap(30);

        this.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        this.setkStartColor(ThemeColors.LIGHT_GREY);
        this.setkEndColor(ThemeColors.DARK_GREY);
        this.setkHoverStartColor(ThemeColors.DARK_GREY);
        this.setkHoverEndColor(ThemeColors.DARK_GREY);
        this.setkForeGround(ThemeColors.LAVENDER_BLUSH);
        this.setkHoverForeGround(ThemeColors.ROSE_MADDER);
        this.setPreferredSize(new Dimension(400, 70));
        this.setMinimumSize(getPreferredSize());
        this.setMaximumSize(getPreferredSize());
        this.setkBorderRadius(30);
    }
}
