package oop.project.screens.InstructorScreen.Panels;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.plaf.synth.SynthSeparatorUI;

import oop.project.components.buttons.CustomButtonInstructor;
import oop.project.components.core.TitleLabel;
import com.k33ptoo.components.KButton;
import oop.project.components.panels.TransparentPanel;
import oop.project.handlers.FilterButtonHandler;
import oop.project.hooks.*;
import java.awt.*;

import oop.project.models.UserModel;
import oop.project.API.*;

/* View Students Panel
TODO: Get Data from database and display it in the table
*/

public class ViewStudentsPanel extends TransparentPanel
{
    Box viewStudentsBox;

    public ViewStudentsPanel(int Width, int Height)
    {

        UserModel user = new UserModel();
        user = DatabaseCon.currentUser;
        String userID = Long.toString(user.getUserID());

        // Student Panel Setup (Will replace Main Panel when Student Button is clicked)
        JLabel viewStudentsLabel = new TitleLabel("Here are all the students");
        viewStudentsLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        this.add(viewStudentsLabel);


        ResultSet tablers = DatabaseCon.customQuery("SELECT UserID, FirstName, LastName, Sex, TotalGrade as 'Total Course Grade' " +
                                                "FROM studentcourses, profile " +
                                                "WHERE StudID = UserID && CourseID IN (SELECT CourseID FROM courses WHERE InstructorID = " + userID + ");");
        JTable table = new JTable();
        table.setModel(DbUtils.resultSetToTableModel(tablers));

        table.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        table.setDragEnabled(false);
        table.setRowHeight(40);
        table.setCellSelectionEnabled(false);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        table.setAutoCreateRowSorter(true);

        JScrollPane scrollPaneTable = new JScrollPane(table);
        scrollPaneTable.setPreferredSize(new Dimension(Width - 460, Height - 200));
        scrollPaneTable.setAlignmentX(CENTER_ALIGNMENT);

        KButton filterButton = new CustomButtonInstructor("Filter By");
        filterButton.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        filterButton.setPreferredSize(new Dimension(150, 50));
        filterButton.setAlignmentX(CENTER_ALIGNMENT);


        JComponent[] components = {viewStudentsLabel, scrollPaneTable, filterButton};
        viewStudentsBox = AddToBox.addToVerticalBox(components, 1);
        this.add(viewStudentsBox);

        //Button Handler
        filterButton.addActionListener(new FilterButtonHandler(this));
    }



}
