package oop.project.components;

import javax.swing.*;
import java.awt.*;

public class VerticalPanel extends JPanel
{

    public VerticalPanel(JComponent top, JComponent bottom)
    {
        this.setOpaque(false);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
        this.setPreferredSize(new Dimension(600, 250));
        this.setSize(getPreferredSize());
        this.add(top);
        this.add(bottom);
    }
}
