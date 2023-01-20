package oop.project.screens.InstructorScreen.Panels;

import java.awt.Font;
import javax.swing.*;

import oop.project.components.buttons.CustomButtonInstructor;
import oop.project.components.core.TitleLabel;
import com.k33ptoo.components.KButton;
import oop.project.components.panels.TransparentPanel;
import oop.project.handlers.FilterButtonHandler;
import oop.project.hooks.*;
import java.awt.*;

/* View Students Panel
TODO: Get Data from database and display it in the table
*/

public class ViewStudentsPanel extends TransparentPanel
{
    

    public ViewStudentsPanel(int Width, int Height)
    {
        Box viewStudentsBox;

        // Student Panel Setup (Will replace Main Panel when Student Button is clicked)
        JLabel viewStudentsLabel = new TitleLabel("Here are all the students");
        viewStudentsLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        this.add(viewStudentsLabel);

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
        table.getTableHeader().setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        // table.setAutoCreateRowSorter(true); TODO: Add sorting for each column equally either through RowSorter


        JScrollPane scrollPaneTable = new JScrollPane(table);
        scrollPaneTable.setPreferredSize(new Dimension(Width - 460, Height - 200));
        scrollPaneTable.setAlignmentX(CENTER_ALIGNMENT);

        KButton filterButton = new CustomButtonInstructor("Filter By");
        filterButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        filterButton.setPreferredSize(new Dimension(150, 50));
        filterButton.setAlignmentX(CENTER_ALIGNMENT);
        

        JComponent[] components = {viewStudentsLabel, scrollPaneTable, filterButton};
        viewStudentsBox = AddToBox.addToHorizontalBoxWithSpace(components, 3);
        this.add(viewStudentsBox);

        //Button Handler
        filterButton.addActionListener(new FilterButtonHandler(this));
    }


}
