package oop.project.screens.AdminScreen.Panels;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

import oop.project.components.panels.TransparentPanel;
import oop.project.hooks.*;
import oop.project.API.DatabaseCon;
import oop.project.API.DbUtils;
import oop.project.components.core.TitleLabel;

public class ViewInstructors extends TransparentPanel
{
    JTable table = new JTable();
    ResultSet resultSet;

    public ViewInstructors(int Width, int Height)
    {
        // Instructor Panel Setup
        JLabel viewInstructorsLabel = new TitleLabel("The instructors");
        Box viewInstructorsBox;

        table = new JTable();
        resultSet = DatabaseCon.getAllWithTypeRS("Instructor");
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

        JScrollPane scrollPaneTable = new JScrollPane(table);
        scrollPaneTable.setPreferredSize(new Dimension(Width - 480, Height - 200));

        JComponent[] components = {viewInstructorsLabel, scrollPaneTable};
        viewInstructorsBox = AddToBox.addToHorizontalBoxWithSpace(components, 2);
        this.add(viewInstructorsBox);

    }

    public void refreshTable()
    {
        resultSet = DatabaseCon.getAllWithTypeRS("Instructor");
        table.setModel(DbUtils.resultSetToTableModel(resultSet));
    }
}
