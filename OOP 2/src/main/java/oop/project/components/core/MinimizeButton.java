package oop.project.components.core;

import java.awt.Image;
import javax.swing.JButton;

import oop.project.hooks.FrameConfig;

import javax.swing.ImageIcon;

public class MinimizeButton extends JButton
{
    public MinimizeButton()
    {
        Image image = FrameConfig.getPictureWithSize("NavBar/MinimizeIcon.png", 53, 30);
        Image imageHover = FrameConfig.getPictureWithSize("NavBar/MinimizeHoverIcon.png", 53, 30);

        this.setIcon(new ImageIcon(image));
        this.setRolloverIcon(new ImageIcon(imageHover));
    }
}
