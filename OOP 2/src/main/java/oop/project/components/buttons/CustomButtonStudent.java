package oop.project.components.buttons;

import oop.project.colors.ThemeColors;
import oop.project.components.core.RoundedButton;
import oop.project.hooks.*;

import java.awt.*;
import javax.swing.*;

public class CustomButtonStudent extends RoundedButton
{
    public CustomButtonStudent(String text)
    {
        this.setText(text);
        this.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        this.setkStartColor(ThemeColors.GREENISH);
        this.setkEndColor(ThemeColors.LIGHT_BROWN);
        this.setkHoverStartColor(ThemeColors.GREENISH);
        this.setkHoverEndColor(ThemeColors.GREENISH);
        this.setkForeGround(ThemeColors.LAVENDER_BLUSH);
        this.setkHoverForeGround(ThemeColors.ROSE_MADDER);
        this.setPreferredSize(new Dimension(400, 70));
        this.setMinimumSize(getPreferredSize());
        this.setMaximumSize(getPreferredSize());
        this.setkBorderRadius(30);
    }

    public CustomButtonStudent(String text, String iconPath)
    {
        Image image = FrameConfig.getPictureWithSize(iconPath, 40, 40);
        JLabel icon = new JLabel(new ImageIcon(image));

        this.setLayout(new BorderLayout());
        this.add(icon, BorderLayout.WEST);
        this.setText(text);
        this.setIconTextGap(30);

        this.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        this.setkStartColor(ThemeColors.GREENISH);
        this.setkEndColor(ThemeColors.LIGHT_BROWN);
        this.setkHoverStartColor(ThemeColors.GREENISH);
        this.setkHoverEndColor(ThemeColors.GREENISH);
        this.setkForeGround(ThemeColors.LAVENDER_BLUSH);
        this.setkHoverForeGround(ThemeColors.ROSE_MADDER);
        this.setPreferredSize(new Dimension(400, 70));
        this.setMinimumSize(getPreferredSize());
        this.setMaximumSize(getPreferredSize());
        this.setkBorderRadius(30);
    }
}