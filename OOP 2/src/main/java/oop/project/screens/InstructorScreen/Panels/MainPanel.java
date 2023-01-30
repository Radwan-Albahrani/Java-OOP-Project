package oop.project.screens.InstructorScreen.Panels;

import oop.project.API.DatabaseCon;
import oop.project.API.DbUtils;
import oop.project.colors.ThemeColors;
import oop.project.components.buttons.CustomButtonInstructor;
import oop.project.components.core.PromptedTextField;
import oop.project.components.core.TitleLabel;
import oop.project.components.panels.TransparentPanel;
import oop.project.handlers.RegisterCourseHandler;
import oop.project.hooks.AddToBox;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import com.k33ptoo.components.KButton;

public class MainPanel extends TransparentPanel
{
    JTable table;
    ResultSet resultSet;
    String ID = Long.toString(DatabaseCon.currentUser.getUserID());
    String separator = "\n------------------------------------------------------------------------------------------------------------------\n";
    List<String> announcements;
    JLabel announcementLabel;
    JTextArea announcementTextArea;
    PromptedTextField searchField;

    public MainPanel(int Width, int Height)
    {
        String courseIDQuery = """
                SELECT CourseID, CourseName, CreditHours
                FROM courses
                WHERE InstructorID = %s;
                    """.formatted(ID);
        ResultSet courseIDResultSet = DatabaseCon.customQuery(courseIDQuery);
        // Change result set into string
        ArrayList<String> courseIDList = new ArrayList<>();
        ArrayList<String> courseNameList = new ArrayList<>();
        ArrayList<String> courseCreditsList = new ArrayList<>();

        // Add all the course IDs to the list
        try
        {
            while (courseIDResultSet.next())
            {
                courseIDList.add(courseIDResultSet.getString("CourseID"));
                courseNameList.add(courseIDResultSet.getString("CourseName"));
                courseCreditsList.add(courseIDResultSet.getString("CreditHours"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        JLabel welcomeLabel = new TitleLabel(
                "<html> Welcome, " + DatabaseCon.currentUser.getFirstName() + " " + DatabaseCon.currentUser.getLastName()
                        + "</html>");
        welcomeLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

        if (courseIDList.size() == 0) // If the instructor is not in a course
        {
            System.out.println("This Instructor is not in a course - User: " + ID);
            JLabel registerLabel = new JLabel(
                    "<html> You are currently not registered in a course. Please choose one of the following courses then click the 'Register Course' button to register in a course. </html>");
            registerLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
            registerLabel.setForeground(Color.BLACK);

            table = new JTable();
            resultSet = DatabaseCon.getUnassignedCourses();
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
            table.setAlignmentX(CENTER_ALIGNMENT);
            table.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseClicked(MouseEvent evt)
                {
                    setID();
                }
            });

            JScrollPane scrollPaneTable = new JScrollPane(table);
            scrollPaneTable.setPreferredSize(new Dimension(Width - 480, Height - 500));
            scrollPaneTable.setMinimumSize(new Dimension(Width - 480, Height - 500));
            scrollPaneTable.setMaximumSize(new Dimension(Width - 480, Height - 500));

            searchField = new PromptedTextField("Enter ID here");
            searchField.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
            searchField.setMinimumSize(new Dimension(300, 50));
            searchField.setPreferredSize(new Dimension(300, 50));
            searchField.setMaximumSize(new Dimension(300, 50));
            searchField.setAlignmentX(CENTER_ALIGNMENT);

            KButton registerButton = new CustomButtonInstructor("Register Course");
            registerButton.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
            registerButton.setBounds(Width / 2 - 100, Height / 2 - 100, 200, 50);
            registerButton.setHorizontalAlignment(JButton.CENTER);
            registerButton.setVerticalAlignment(JButton.BOTTOM);

            JComponent[] searchComponents = {searchField};
            Box searchBox = AddToBox.addToHorizontalBox(searchComponents, 1);

            JComponent[] registerComponents = {registerButton};
            Box registerBox = AddToBox.addToHorizontalBox(registerComponents, 1);

            JComponent[] components = {welcomeLabel, registerLabel, scrollPaneTable};
            Box registrationsBox = AddToBox.addToVerticalBox(components, 1);

            this.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.BOTH;
            c.gridx = 0;
            c.gridy = 0;
            c.insets = new Insets(0, 0, 0, 0);
            this.add(registrationsBox, c);
            c.gridx = 0;
            c.gridy = 1;
            c.insets = new Insets(50, 200, 0, 200);
            this.add(searchBox, c);
            c.gridx = 0;
            c.gridy = 2;
            c.insets = new Insets(50, 350, 0, 350);
            this.add(registerBox, c);

            // Button Handler
            registerButton.addActionListener(new RegisterCourseHandler(searchField, ID, this));

        }
        else // If the instructor is in a course
        {
            String courseID = courseIDList.get(0);
            String courseName = courseNameList.get(0);
            String courseCredits = courseCreditsList.get(0);

            String countStudentsQuery = """
                    SELECT COUNT(*) AS NoOfStudents
                    FROM studentcourses
                    WHERE CourseID = '%s';
                        """.formatted(courseID);
            ResultSet countStudentsRS = DatabaseCon.customQuery(countStudentsQuery);
            ArrayList<String> countStudentsList = new ArrayList<>();
            try
            {
                while (countStudentsRS.next())
                {
                    countStudentsList.add(countStudentsRS.getString("NoOfStudents"));
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            System.err.println("This Instructor is registered in course " + courseID + " - User: " + ID);
            JLabel courseInfoLabel = new JLabel(
                    "<html><br> You are currently assigned to " + courseID + " - " + courseName + " with " + courseCredits
                            + " credits.<br> There are " + countStudentsList.get(0) + " students in the course </html>");
            courseInfoLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
            courseInfoLabel.setForeground(Color.BLACK);

            // Information about the course
            announcementLabel = new JLabel("Here are your recent announcements:");
            announcementLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
            announcementLabel.setForeground(Color.BLACK);

            announcementTextArea = new JTextArea(15, 50);
            announcementTextArea.setLineWrap(true);
            announcementTextArea.setBackground(ThemeColors.LIGHT_GRAY);
            announcementTextArea.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
            announcementTextArea.setBorder(BorderFactory.createLineBorder(ThemeColors.LIGHT_GREY, 5));
            announcementTextArea.setEditable(false);

            JScrollPane scrollBar = new JScrollPane(announcementTextArea);
            scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollBar.setViewportView(announcementTextArea);

            KButton refreshButton = new CustomButtonInstructor(" Refresh ");
            refreshButton.setPreferredSize(new Dimension(150, 50));

            JComponent[] announcementComponents = {welcomeLabel, courseInfoLabel, announcementLabel, scrollBar,
                    refreshButton}; // Components for the Alerts Menu
            Box announcementBox = AddToBox.addToVerticalBox(announcementComponents, 1);

            this.add(announcementBox);

            announcements = DatabaseCon.getAnnouncementOfCourse(courseID);

            for (String announcement : announcements)
            {
                announcementTextArea.append(announcement + separator);
            }

            refreshButton.addActionListener(e -> refreshAnnouncements(courseID));
        }
    }

    private void refreshAnnouncements(String courseID)
    {
        announcements = DatabaseCon.getAnnouncementOfCourse(courseID);
        announcementTextArea.setText("");
        for (String announcement : announcements)
        {
            announcementTextArea.append(announcement + separator);
        }

    }

    public void refreshPanel()
    {
        this.removeAll();
        this.revalidate();
        this.repaint();
        this.add(new MainPanel(getWidth(), getHeight()));
    }

    private void setID()
    {
        String id = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
        searchField.setText(id);
        searchField.setForeground(Color.BLACK);
    }
}
