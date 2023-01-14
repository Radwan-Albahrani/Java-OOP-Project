package oop.project.components;

import java.awt.Image;
import javax.swing.JButton;

import oop.project.hooks.FrameConfig;

import javax.swing.ImageIcon;

public class MinimizeButton extends JButton
{
    public MinimizeButton()
    {
        Image image = FrameConfig.getPictureWithSize("MinimizeIcon.png", 45, 24);
        Image imageHover = FrameConfig.getPictureWithSize("MinimizeHoverIcon.png", 45, 24);

        this.setIcon(new ImageIcon(image));
        this.setRolloverIcon(new ImageIcon(imageHover));
    }
}
