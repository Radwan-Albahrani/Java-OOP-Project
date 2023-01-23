package oop.project.components.buttons;

import oop.project.colors.ThemeColors;
import oop.project.components.core.RoundedButton;
import oop.project.hooks.FrameConfig;

import java.awt.Font;
import java.awt.Dimension;

import java.awt.*;
import javax.swing.*;

public class CustomButtonAdmin extends RoundedButton
{
    // 1st constructor
    public CustomButtonAdmin(String text)
    {

        this.setText(text);
        this.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        this.setkStartColor(ThemeColors.BLUISH_CYAN);
        this.setkEndColor(ThemeColors.BLURPLE);
        this.setkHoverStartColor(ThemeColors.BLUISH_CYAN);
        this.setkHoverEndColor(ThemeColors.BLUISH_CYAN);
        this.setkForeGround(ThemeColors.LAVENDER_BLUSH);
        this.setkHoverForeGround(ThemeColors.ROSE_MADDER);
        this.setPreferredSize(new Dimension(400, 60));
        this.setMinimumSize(getPreferredSize());
        this.setMaximumSize(getPreferredSize());
        this.setkBorderRadius(30);
    }

    public CustomButtonAdmin(String text, int Width, int Height)
    {
        this.setText(text);
        this.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        this.setkStartColor(ThemeColors.BLUISH_CYAN);
        this.setkEndColor(ThemeColors.BLURPLE);
        this.setkHoverStartColor(ThemeColors.BLUISH_CYAN);
        this.setkHoverEndColor(ThemeColors.BLUISH_CYAN);
        this.setkForeGround(ThemeColors.LAVENDER_BLUSH);
        this.setkHoverForeGround(ThemeColors.ROSE_MADDER);
        this.setPreferredSize(new Dimension(Width, Height));
        this.setMinimumSize(getPreferredSize());
        this.setMaximumSize(getPreferredSize());
        this.setkBorderRadius(30);
    }

    // 2nd constructor
    public CustomButtonAdmin(String text, String imageLocation)
    {
        Image image = FrameConfig.getPictureWithSize(imageLocation, 40, 40);
        JLabel icon = new JLabel(new ImageIcon(image));

        // icon merging with text & positoning
        this.setLayout(new BorderLayout());
        this.add(icon, BorderLayout.WEST);
        this.setText(text);
        this.setIconTextGap(30);

        // buttons creation and customizing the style
        this.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        this.setkStartColor(ThemeColors.BLUISH_CYAN);
        this.setkEndColor(ThemeColors.BLURPLE);
        this.setkHoverStartColor(ThemeColors.BLUISH_CYAN);
        this.setkHoverEndColor(ThemeColors.BLUISH_CYAN);
        this.setkForeGround(ThemeColors.LAVENDER_BLUSH);
        this.setkHoverForeGround(ThemeColors.ROSE_MADDER);
        this.setPreferredSize(new Dimension(400, 60));
        this.setMinimumSize(getPreferredSize());
        this.setMaximumSize(getPreferredSize());
        this.setkBorderRadius(30);
    }
}