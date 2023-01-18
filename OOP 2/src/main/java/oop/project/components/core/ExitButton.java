package oop.project.components.core;

import java.awt.Image;
import javax.swing.JButton;

import oop.project.hooks.FrameConfig;

import javax.swing.ImageIcon;

public class ExitButton extends JButton
{
    public ExitButton()
    {
        Image image = FrameConfig.getPictureWithSize("NavBar/ExitIcon.png", 53, 30);
        Image imageHover = FrameConfig.getPictureWithSize("NavBar/ExitHoverIcon.png", 53, 30);

        this.setIcon(new ImageIcon(image));
        this.setRolloverIcon(new ImageIcon(imageHover));
    }
}
