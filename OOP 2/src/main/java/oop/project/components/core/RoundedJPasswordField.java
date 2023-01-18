package oop.project.components.core;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class RoundedJPasswordField extends JPasswordField
{
    private Shape shape;

    public RoundedJPasswordField(int size)
    {
        super(size);
        setOpaque(false); // As suggested by @AVD in comment.
    }

    protected void paintComponent(Graphics g)
    {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g)
    {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
    }

    public boolean contains(int x, int y)
    {
        if (shape == null || !shape.getBounds().equals(getBounds()))
        {
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        }
        return shape.contains(x, y);
    }
}