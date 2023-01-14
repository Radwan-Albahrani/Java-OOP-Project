package oop.project.components;

import java.awt.Image;
import javax.swing.JButton;

import oop.project.hooks.FrameConfig;

import javax.swing.ImageIcon;

public class ExitButton extends JButton
{
    public ExitButton()
    {
        Image image = FrameConfig.getPictureWithSize("ExitIcon.png", 45, 25);
        Image imageHover = FrameConfig.getPictureWithSize("ExitHoverIcon.png", 45, 25);

        this.setIcon(new ImageIcon(image));
        this.setRolloverIcon(new ImageIcon(imageHover));
    }
}
