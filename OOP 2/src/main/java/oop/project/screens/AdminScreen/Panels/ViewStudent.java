package oop.project.screens.AdminScreen.Panels;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

import oop.project.components.panels.TransparentPanel;
import oop.project.hooks.*;
import oop.project.API.DatabaseCon;
import oop.project.API.DbUtils;
import oop.project.components.core.TitleLabel;

public class ViewStudent extends TransparentPanel
{
    public ViewStudent(int Width, int Height)
    {
        // Student Panel Setup (Will replace Main Panel when Student Button is clicked)
        JLabel viewStudentsLabel = new TitleLabel("The Students");
        this.add(viewStudentsLabel);

        JTable table = new JTable();
        ResultSet resultSet = DatabaseCon.getAllWithTypeRS("Student");
        table.setModel(DbUtils.resultSetToTableModel(resultSet));

        table.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        table.setDefaultEditor(Object.class, null);
        table.setDragEnabled(false);
        table.setRowHeight(40);
        table.setCellSelectionEnabled(false);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        table.getTableHeader().setReorderingAllowed(false);
        table.setAutoCreateRowSorter(true);

        JScrollPane scrollPaneTable = new JScrollPane(table);
        scrollPaneTable.setPreferredSize(new Dimension(Width - 480, Height - 100));

        JComponent[] components = {viewStudentsLabel, scrollPaneTable};
        Box ViewStudentsBox = AddToBox.addToHorizontalBoxWithSpace(components, 2);
        this.add(ViewStudentsBox);

    }
}