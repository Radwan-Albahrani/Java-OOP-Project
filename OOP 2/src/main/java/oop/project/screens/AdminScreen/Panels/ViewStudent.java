package oop.project.screens.AdminScreen.Panels;

import javax.swing.*;
import java.awt.*;

import oop.project.components.panels.TransparentPanel;
import oop.project.hooks.*;
import oop.project.components.core.TitleLabel;

public class ViewStudent extends TransparentPanel
{
    public ViewStudent(int Width, int Height)
    {
        // Student Panel Setup (Will replace Main Panel when Student Button is clicked)
        JLabel viewStudentsLabel = new TitleLabel("The students");
        viewStudentsLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        this.add(viewStudentsLabel);

        Box ViewStudentsBox;

        String[] columnNames = {"ID", "First Name", "Last Name", "Quiz Grade", "Midterm Grade", "Final Grade",
                "Project Grade", "Total Grade"};

        Object[][] data = { // temp data
                {1, "Kathy", "Smith", 20, 25, 40, 15, 100},
                {2, "John", "Doe", 20, 25, 40, 15, 100},
                {3, "Sue", "Black", 20, 25, 40, 15, 100},
                {4, "Jane", "White", 20, 25, 40, 15, 100},
                {5, "Joe", "Brown", 20, 25, 40, 15, 100},
                {1, "Kathy", "Smith", 20, 25, 40, 15, 100},
                {2, "John", "Doe", 20, 25, 40, 15, 100},
                {3, "Sue", "Black", 20, 25, 40, 15, 100},
                {4, "Jane", "White", 20, 25, 40, 15, 100},
                {1, "Kathy", "Smith", 20, 25, 40, 15, 100},
                {2, "John", "Doe", 20, 25, 40, 15, 100},
                {3, "Sue", "Black", 20, 25, 40, 15, 100},
                {4, "Jane", "White", 20, 25, 40, 15, 100},
                {1, "Kathy", "Smith", 20, 25, 40, 15, 100},
                {2, "John", "Doe", 20, 25, 40, 15, 100},
                {3, "Sue", "Black", 20, 25, 40, 15, 100},
                {4, "Jane", "White", 20, 25, 40, 15, 100},
                {1, "Kathy", "Smith", 20, 25, 40, 15, 100},
                {2, "John", "Doe", 20, 25, 40, 15, 100},
                {3, "Sue", "Black", 20, 25, 40, 15, 100},
                {4, "Jane", "White", 20, 25, 40, 15, 100},
        };

        JTable table = new JTable(data, columnNames)
        {
            public boolean editCellAt(int row, int column, java.util.EventObject e)
            {
                return false;
            }
        };

        table.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        table.setDragEnabled(false);
        table.setRowHeight(40);
        table.setCellSelectionEnabled(false);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPaneTable = new JScrollPane(table);
        scrollPaneTable.setPreferredSize(new Dimension(Width - 480, Height - 100));

        JComponent[] components = {viewStudentsLabel, scrollPaneTable};
        ViewStudentsBox = AddToBox.addToHorizontalBoxWithSpace(components, 2);
        this.add(ViewStudentsBox);

    }
}