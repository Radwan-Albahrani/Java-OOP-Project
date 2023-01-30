package oop.project.screens.AdminScreen.Panels;

import javax.swing.*;

import com.k33ptoo.components.KButton;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import oop.project.API.DatabaseCon;
import oop.project.API.DbUtils;
import oop.project.components.buttons.CustomButtonAdmin;
import oop.project.components.core.PromptedTextField;
import oop.project.components.core.TitleLabel;
import oop.project.components.panels.TransparentPanel;
import oop.project.handlers.DeleteCourseHandler;
import oop.project.hooks.AddToBox;

public class CoursesPanel extends TransparentPanel
{
    JTable table;
    ResultSet resultSet;
    PromptedTextField searchField;

    public CoursesPanel(int Width, int Height)
    {
        JLabel viewCoursesLabel = new TitleLabel("All courses");
        viewCoursesLabel.setAlignmentX(CENTER_ALIGNMENT);

        table = new JTable();
        resultSet = DatabaseCon.getAllCourses();
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

        KButton deleteButton = new CustomButtonAdmin("Delete");

        JComponent[] approveComponents = {deleteButton};
        Box deleteBox = AddToBox.addToHorizontalBox(approveComponents, 1);

        JComponent[] components = {viewCoursesLabel, scrollPaneTable};
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
        c.insets = new Insets(100, 200, 0, 200);
        this.add(searchBox, c);
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(100, 350, 0, 350);
        this.add(deleteBox, c);

        deleteButton.addActionListener(new DeleteCourseHandler(searchField, this));
    }

    public void refreshTable()
    {
        resultSet = DatabaseCon.getAllCourses();
        table.setModel(DbUtils.resultSetToTableModel(resultSet));
    }

    private void setID()
    {
        String id = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
        searchField.setText(id);
        searchField.setForeground(Color.BLACK);
    }
}
