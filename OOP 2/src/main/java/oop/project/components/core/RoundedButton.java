package oop.project.components.core;

import com.k33ptoo.components.KButton;

import oop.project.colors.ThemeColors;

import java.awt.*;
import java.awt.geom.*;

public class RoundedButton extends KButton
{
    private Shape shape;

    public RoundedButton()
    {
        setOpaque(false); // As suggested by @AVD in comment.
    }

    protected void paintComponent(Graphics g)
    {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g2.setColor(ThemeColors.BLACK);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
    }

    public boolean contains(int x, int y)
    {
        if (shape == null || !shape.getBounds().equals(getBounds()))
        {
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
        }
        return shape.contains(x, y);
    }
}
