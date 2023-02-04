package oop.project.screens.AdminScreen.Panels;

import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.k33ptoo.components.KButton;

import oop.project.API.DatabaseCon;
import oop.project.colors.ThemeColors;
import oop.project.components.buttons.CustomButtonAdmin;
import oop.project.components.panels.TransparentPanel;
import oop.project.hooks.AddToBox;

public class ViewAlerts extends TransparentPanel
{
    List<String> alerts;
    JTextArea alertTextArea;
    String separator = "\n-----------------------------------------------------------------------------------------------------------\n";

    public ViewAlerts(int Width, int Height)
    {

        JLabel alertsLabel = new JLabel("Inbox Alerts");
        alertsLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        alertTextArea = new JTextArea(24, 50);
        alertTextArea.setLineWrap(true);
        alertTextArea.setBackground(ThemeColors.LIGHT_GRAY);
        alertTextArea.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
        alertTextArea.setBorder(BorderFactory.createLineBorder(ThemeColors.LIGHT_GREY, 5));
        alertTextArea.setEditable(false);

        JScrollPane scrollBar = new JScrollPane(alertTextArea);
        scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollBar.setViewportView(alertTextArea);

        KButton refreshButton = new CustomButtonAdmin(" Refresh ");
        refreshButton.setPreferredSize(new Dimension(150, 50));

        KButton clearButton = new CustomButtonAdmin(" Clear ");
        clearButton.setPreferredSize(new Dimension(150, 50));

        JComponent[] alertComponents = {alertsLabel, scrollBar}; // Components for the Alerts Menu
        Box alertBox = AddToBox.addToVerticalBox(alertComponents, 1);

        JComponent[] buttonComponents = {refreshButton, clearButton}; // Components for the Buttons Menu
        Box buttonBox = AddToBox.addToHorizontalBox(buttonComponents, 1);

        this.add(alertBox);
        this.add(Box.createRigidArea(new Dimension(0, 20)));
        this.add(buttonBox);

        alerts = DatabaseCon.getAlerts();

        for (String alert : alerts)
        {
            alertTextArea.append(alert + separator);
        }

        refreshButton.addActionListener(e -> refreshAlerts());
        clearButton.addActionListener(e -> clearAlerts());
    }

    private void refreshAlerts()
    {
        alerts = DatabaseCon.getAlerts();
        alertTextArea.setText("");
        for (String alert : alerts)
        {
            alertTextArea.append(alert + separator);
        }
    }

    private void clearAlerts()
    {
        DatabaseCon.clearAlerts();
        alertTextArea.setText("");
    }

}