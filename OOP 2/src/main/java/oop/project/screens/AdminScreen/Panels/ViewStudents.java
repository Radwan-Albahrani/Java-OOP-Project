package oop.project.screens.AdminScreen.Panels;

import javax.swing.*;

import com.k33ptoo.components.KButton;

import java.awt.*;
import java.sql.ResultSet;

import oop.project.components.buttons.CustomButtonAdmin;
import oop.project.components.panels.TransparentPanel;
import oop.project.handlers.GenerateReport;
import oop.project.hooks.*;
import oop.project.API.DatabaseCon;
import oop.project.API.DbUtils;
import oop.project.components.core.TitleLabel;

public class ViewStudents extends TransparentPanel
{
    JTable table = new JTable();
    ResultSet resultSet;

    public ViewStudents(int Width, int Height)
    {
        // Student Panel Setup (Will replace Main Panel when Student Button is clicked)
        JLabel viewStudentsLabel = new TitleLabel("The Students");

        table = new JTable();
        resultSet = DatabaseCon.getAllWithTypeRS("Student");
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
        scrollPaneTable.setPreferredSize(new Dimension(Width - 480, Height - 200));

        KButton reportButton = new CustomButtonAdmin("Generate Report");
        reportButton.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        reportButton.setPreferredSize(new Dimension(150, 50));
        reportButton.setAlignmentX(CENTER_ALIGNMENT);

        JComponent[] components = {viewStudentsLabel, scrollPaneTable, reportButton};
        Box ViewStudentsBox = AddToBox.addToVerticalBox(components, 1);
        this.add(ViewStudentsBox);

        // Button Handler
        reportButton.addActionListener(new GenerateReport(table, "./reports/Admin/Admin - StudentReport.csv"));
    }

    public void refreshTable()
    {
        resultSet = DatabaseCon.getAllWithTypeRS("Student");
        table.setModel(DbUtils.resultSetToTableModel(resultSet));
    }
}