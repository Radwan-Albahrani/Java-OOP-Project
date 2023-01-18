package oop.project.components.panels;

import javax.swing.*;
import java.awt.*;

public class VerticalPanel extends JPanel
{

    public VerticalPanel(JComponent top, JComponent bottom)
    {
        this.setOpaque(false);
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(10, 0, 10, 0);
        constraints.fill = GridBagConstraints.BOTH;
        this.add(top, constraints);
        constraints.insets = new Insets(10, 100, 10, 100);
        constraints.gridy = 1;
        this.add(bottom, constraints);
    }
}
