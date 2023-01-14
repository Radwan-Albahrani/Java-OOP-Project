package oop.project.components;

import java.awt.Image;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;

public class ExitButton extends JButton
{
    public ExitButton()
    {
        ImageIcon img = new ImageIcon(getClass().getResource("/images/ExitIcon.png"));
        Image image = img.getImage(); 
        Image newimg = image.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH);
        ImageIcon imgresized = new ImageIcon(newimg);

        ImageIcon imgHover = new ImageIcon(getClass().getResource("/images/ExitHoverIcon.png"));
        Image imageHover = imgHover.getImage(); 
        Image newimgHover =  imageHover.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH);
        ImageIcon imgHoverresized = new ImageIcon(newimgHover);

        this.setIcon(imgresized);
        this.setRolloverIcon(imgHoverresized);
        this.setBorder(BorderFactory.createEmptyBorder());

    }
}
