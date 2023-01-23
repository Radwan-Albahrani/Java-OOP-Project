package oop.project.screens.AdminScreen.Panels;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

import oop.project.API.DatabaseCon;
import oop.project.API.DbUtils;
import oop.project.components.core.TitleLabel;
import oop.project.components.panels.TransparentPanel;
import oop.project.hooks.AddToBox;

public class CoursesPanel extends TransparentPanel
{
    public CoursesPanel(int Width, int Height)
    {
        JLabel viewCoursesLabel = new TitleLabel("All courses");
        Box viewCoursesBox;

        JTable table = new JTable();
        ResultSet resultSet = DatabaseCon.getAllCourses();
        table.setModel(DbUtils.resultSetToTableModel(resultSet));

        table.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        table.setDragEnabled(false);
        table.setRowHeight(40);
        table.setCellSelectionEnabled(false);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        table.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPaneTable = new JScrollPane(table);
        scrollPaneTable.setPreferredSize(new Dimension(Width - 480, Height - 100));

        JComponent[] components = {viewCoursesLabel, scrollPaneTable};
        viewCoursesBox = AddToBox.addToHorizontalBoxWithSpace(components, 2);
        this.add(viewCoursesBox);

    }
}
