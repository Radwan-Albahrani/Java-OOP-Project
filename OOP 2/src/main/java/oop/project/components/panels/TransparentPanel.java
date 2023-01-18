package oop.project.components.panels;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class TransparentPanel extends JPanel
{
    public TransparentPanel()
    {
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.setOpaque(false);
    }
}
