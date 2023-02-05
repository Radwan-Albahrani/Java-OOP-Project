package oop.project.screens.InstructorScreen.Panels;

import java.awt.Font;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.*;
import oop.project.components.buttons.CustomButtonInstructor;
import oop.project.components.core.TitleLabel;
import com.k33ptoo.components.KButton;
import oop.project.components.panels.TransparentPanel;
import oop.project.handlers.GenerateReport;
import oop.project.hooks.*;
import java.awt.*;

import oop.project.models.UserModel;
import oop.project.API.*;

public class ViewStudentsPanel extends TransparentPanel
{
    Box viewStudentsBox;
    JTable table;

    public ViewStudentsPanel(int Width, int Height)
    {
        try
        {
            UserModel user = new UserModel();
            user = DatabaseCon.currentUser;
            String userID = Long.toString(user.getUserID());

            // Student Panel Setup (Will replace Main Panel when Student Button is clicked)
            JLabel viewStudentsLabel = new TitleLabel("Here are all the students");
            viewStudentsLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
            this.add(viewStudentsLabel);

            ResultSet students = DatabaseCon.getStudentsOfInstructor(userID);
            table = new JTable();
            table.setModel(DbUtils.resultSetToTableModel(students));

            table.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
            table.setDragEnabled(false);
            table.setDefaultEditor(Object.class, null);
            table.setRowHeight(40);
            table.setCellSelectionEnabled(false);
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            table.getTableHeader().setReorderingAllowed(false);
            table.getTableHeader().setFont(new Font("Trebuchet MS", Font.BOLD, 18));
            table.setAutoCreateRowSorter(true);

            JScrollPane scrollPaneTable = new JScrollPane(table);
            scrollPaneTable.setPreferredSize(new Dimension(Width - 460, Height - 200));
            scrollPaneTable.setAlignmentX(CENTER_ALIGNMENT);

            KButton reportButton = new CustomButtonInstructor("Generate Report");
            reportButton.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
            reportButton.setPreferredSize(new Dimension(150, 50));
            reportButton.setAlignmentX(CENTER_ALIGNMENT);

            JComponent[] components = {viewStudentsLabel, scrollPaneTable, reportButton};
            viewStudentsBox = AddToBox.addToVerticalBox(components, 1);
            this.add(viewStudentsBox);

            // Report Generation
            String reportTableQuery = """
                    SELECT UserID, FirstName, LastName, Sex, courses.CourseID, CourseName, QuizGrade, MidtermGrade, FinalGrade, ProjectGrade, TotalGrade
                    FROM studentcourses, profile, courses
                    WHERE StudID = UserID && courses.CourseID IN (SELECT CourseID FROM courses WHERE InstructorID = %s);
                        """
                    .formatted(userID);

            ResultSet reportResultSet = DatabaseCon.customQuery(reportTableQuery);
            JTable reportTableJTable = new JTable();
            reportTableJTable.setModel(DbUtils.resultSetToTableModel(reportResultSet));

            String courseIDQuery = """
                    SELECT CourseID
                    FROM courses
                    WHERE InstructorID = %s;
                        """.formatted(userID);
            ResultSet courseIDResultSet = DatabaseCon.customQuery(courseIDQuery);
            // Change result set into string
            ArrayList<String> courseIDList = new ArrayList<>();
            // Add all the course IDs to the list
            try
            {
                while (courseIDResultSet.next())
                {
                    courseIDList.add(courseIDResultSet.getString("CourseID"));
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            // Button Handler
            reportButton.addActionListener(new GenerateReport(reportTableJTable, "./reports/Instructors/"
                    + userID + " - " + courseIDList.get(0) + " - Student Report.csv"));
        }
        catch (Exception e)
        {
            System.err.println(
                    "Instructor is not assigned to any courses. Must be assigned to at least one course to view students.");
        }

    }

    public void refreshTable()
    {
        try
        {
            UserModel user = new UserModel();
            user = DatabaseCon.currentUser;
            String userID = Long.toString(user.getUserID());

            ResultSet students = DatabaseCon.getStudentsOfInstructor(userID);
            table.setModel(DbUtils.resultSetToTableModel(students));
        }
        catch (Exception e)
        {
            System.err.println(
                    "Instructor is not assigned to any courses. Must be assigned to at least one course to view students.");
        }
    }

}
