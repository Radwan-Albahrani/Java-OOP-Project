package oop.project.screens.AdminScreen.Panels;

import javax.swing.*;

import com.k33ptoo.components.*;

import oop.project.API.DatabaseCon;
import oop.project.API.DbUtils;
import oop.project.components.buttons.CustomButtonAdmin;
import oop.project.components.core.PromptedTextField;
import oop.project.components.core.TitleLabel;
import oop.project.components.panels.TransparentPanel;
import oop.project.handlers.ActivationHandler;
import oop.project.hooks.AddToBox;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class ViewRegistrationPanel extends TransparentPanel
{
    ResultSet resultSet;
    JTable table;
    PromptedTextField searchField;

    public ViewRegistrationPanel(int Width, int Height)
    {
        // Registration Panel Setup
        JLabel registrationsLabel = new TitleLabel("The registrations");
        registrationsLabel.setAlignmentX(CENTER_ALIGNMENT);

        table = new JTable();
        resultSet = DatabaseCon.getAllUsersWithStatusRS("Inactive");
        table.setModel(DbUtils.resultSetToTableModel(resultSet));

        table.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        table.setDragEnabled(false);
        table.setDefaultEditor(Object.class, null);
        table.setRowHeight(40);
        table.setCellSelectionEnabled(false);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        table.setAutoCreateRowSorter(true);
        table.setAlignmentX(CENTER_ALIGNMENT);
        table.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent evt)
            {
                setID();
            }
        });

        JScrollPane scrollPaneTable = new JScrollPane(table);
        scrollPaneTable.setPreferredSize(new Dimension(Width - 480, Height - 500));
        scrollPaneTable.setMinimumSize(new Dimension(Width - 480, Height - 500));
        scrollPaneTable.setMaximumSize(new Dimension(Width - 480, Height - 500));

        searchField = new PromptedTextField("Enter ID here");
        searchField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        searchField.setMinimumSize(new Dimension(300, 50));
        searchField.setPreferredSize(new Dimension(300, 50));
        searchField.setMaximumSize(new Dimension(300, 50));
        searchField.setAlignmentX(CENTER_ALIGNMENT);

        JComponent[] searchComponents = {searchField};
        Box searchBox = AddToBox.addToHorizontalBox(searchComponents, 1);

        KButton approveButton = new CustomButtonAdmin("Activate");
        KButton approveAll = new CustomButtonAdmin("Activate All");

        JComponent[] approveComponents = {approveButton, approveAll};
        Box approveBox = AddToBox.addToHorizontalBox(approveComponents, 2);

        JComponent[] components = {registrationsLabel, scrollPaneTable};
        Box registrationsBox = AddToBox.addToHorizontalBoxWithSpace(components, 2);

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 0, 0, 0);
        this.add(registrationsBox, c);
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(0, 200, 0, 200);
        this.add(searchBox, c);
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(100, 350, 0, 350);
        this.add(approveBox, c);
        approveButton.addActionListener(new ActivationHandler((JTextField) searchField, this));
        approveAll.addActionListener(new ActivationHandler((JTextField) searchField, this));
    }

    public void refreshTable()
    {
        resultSet = DatabaseCon.getAllUsersWithStatusRS("Inactive");
        table.setModel(DbUtils.resultSetToTableModel(resultSet));
    }

    private void setID()
    {
        String id = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
        searchField.setText(id);
        searchField.setForeground(Color.BLACK);
    }
}
