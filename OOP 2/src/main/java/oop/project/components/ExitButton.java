package oop.project.components;

import java.awt.Image;
import javax.swing.JButton;

import oop.project.hooks.FrameConfig;

import javax.swing.ImageIcon;

public class ExitButton extends JButton
{
    public ExitButton()
    {
        Image image = FrameConfig.getPictureWithSize("ExitIcon.png", 53, 30);
        Image imageHover = FrameConfig.getPictureWithSize("ExitHoverIcon.png", 53, 30);

        this.setIcon(new ImageIcon(image));
        this.setRolloverIcon(new ImageIcon(imageHover));
    }
}
