package oop.project.components.buttons;

import oop.project.colors.ThemeColors;
import oop.project.components.core.RoundedButton;
import oop.project.hooks.FrameConfig;

import java.awt.Font;
import java.awt.*;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CustomButtonAdmin extends RoundedButton
{
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
        this.setPreferredSize(new Dimension(400, 50));
        this.setMinimumSize(getPreferredSize());
        this.setMaximumSize(getPreferredSize());
        this.setkBorderRadius(30);
    }

    public CustomButtonAdmin(String text, String iconLocation)
    {
        Image image = FrameConfig.getPictureWithSize(iconLocation, 40, 40);
        JLabel icon = new JLabel(new ImageIcon(image));

        this.setLayout(new BorderLayout());
        this.add(icon, BorderLayout.WEST);
        this.setText(text);
        this.setIconTextGap(30);

        this.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        this.setkStartColor(ThemeColors.BLUISH_CYAN);
        this.setkEndColor(ThemeColors.BLURPLE);
        this.setkHoverStartColor(ThemeColors.BLUISH_CYAN);
        this.setkHoverEndColor(ThemeColors.BLUISH_CYAN);
        this.setkForeGround(ThemeColors.LAVENDER_BLUSH);
        this.setkHoverForeGround(ThemeColors.ROSE_MADDER);
        this.setPreferredSize(new Dimension(400, 70));
        this.setMinimumSize(getPreferredSize());
        this.setMaximumSize(getPreferredSize());
        this.setkBorderRadius(30);
    }
}