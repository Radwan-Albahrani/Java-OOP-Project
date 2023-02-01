package oop.project.screens.AdminScreen.Panels;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

import com.k33ptoo.components.*;

import oop.project.components.buttons.CustomButtonAdmin;
import oop.project.components.panels.TransparentPanel;
import oop.project.handlers.GenerateReport;
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

        KButton reportButton = new CustomButtonAdmin("Generate Report");
        reportButton.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        reportButton.setPreferredSize(new Dimension(150, 50));
        reportButton.setAlignmentX(CENTER_ALIGNMENT);

        JComponent[] components = {viewInstructorsLabel, scrollPaneTable, reportButton};
        viewInstructorsBox = AddToBox.addToVerticalBox(components, 1);
        this.add(viewInstructorsBox);

        // Button Handler
        reportButton.addActionListener(new GenerateReport(table, "./reports/Admin/Admin - InstructorReport.csv"));
    }

    public void refreshTable()
    {
        resultSet = DatabaseCon.getAllWithTypeRS("Instructor");
        table.setModel(DbUtils.resultSetToTableModel(resultSet));
    }
}
