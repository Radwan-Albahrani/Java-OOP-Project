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
    public ViewInstructors(int Width, int Height)
    {
        // Student Panel Setup (Will replace Main Panel when Student Button is clicked)
        JLabel viewInstructorsLabel = new TitleLabel("The instructors");
        this.add(viewInstructorsLabel);

        Box viewInstructorsBox;

        JTable table = new JTable();
        ResultSet resultSet = DatabaseCon.getAllWithTypeRS("Instructor");
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
        scrollPaneTable.setPreferredSize(new Dimension(Width - 480, Height - 100));

        JComponent[] components = {viewInstructorsLabel, scrollPaneTable};
        viewInstructorsBox = AddToBox.addToHorizontalBoxWithSpace(components, 2);
        this.add(viewInstructorsBox);

    }
}
