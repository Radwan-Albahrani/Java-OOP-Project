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
        JLabel viewStudentsLabel = new TitleLabel("The instructors");
        viewStudentsLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        this.add(viewStudentsLabel);

        Box viewInstructorsBox;

        String[] Attributes = {"ID", "First Name", "Last Name", "Department number", "sections he/she teaches",
        };

        Object[][] Data = {
                {1, "will", "Smith", 213, "7M4"},
                {2, "joe", "Doe", 213, "2M2"},
                {3, "khaladin", "Black", 213, "4M3"},
                {4, "jasnah", "White", 213, "1M4"},
                {5, "teft", "Brown", 213, "8M1"},
                {1, "Dalinar", "Smith", 213, "7M5"},
                {2, "Black", "Doe", 213, "7M2"},
                {3, "Logan", "Black", 213, "7M4"},
                {4, "Fitz", "White", 213, "8M2"},
                {1, "Chade", "Smith", 213, "1M4"},
                {2, "Kettricken", "Doe", 213, "8M4"},
                {3, "Burich", "Black", 213, "7M5"},
                {4, "Saemon", "White", 213, "8M4"},
                {1, "Guthwulf", "Smith", 213, "7M1"},
                {2, "Deornoth", "Doe", 213, "3M4"},
                {3, "Elias", "Black", 213, "3M1"},
                {4, "Marya", "White", 213, "7M4"},
                {1, "Gwenyth", "Smith", 213, "7M1"},
                {2, "Tiamak", "Doe", 213, "7M2"},
                {3, "Jamie", "Black", 213, "5M3"},
                {4, "Jane", "White", 213, "4M5"},

        };

        // JTable table = new JTable(Data, Attributes)
        // {
        // public boolean editCellAt(int row, int column, java.util.EventObject e)
        // {
        // return false;
        // }
        // };

        JTable table = new JTable();
        ResultSet resultSet = DatabaseCon.getAllWithTypeRS("Instructor");
        table.setModel(DbUtils.resultSetToTableModel(resultSet));

        table.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        table.setDragEnabled(false);
        table.setRowHeight(40);
        table.setCellSelectionEnabled(false);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPaneTable = new JScrollPane(table);
        scrollPaneTable.setPreferredSize(new Dimension(Width - 480, Height - 100));

        JComponent[] components = {viewStudentsLabel, scrollPaneTable};
        viewInstructorsBox = AddToBox.addToHorizontalBoxWithSpace(components, 2);
        this.add(viewInstructorsBox);

    }
}
