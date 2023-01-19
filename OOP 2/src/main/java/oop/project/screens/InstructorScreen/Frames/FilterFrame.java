package oop.project.screens.InstructorScreen.Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.k33ptoo.components.*;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import oop.project.components.buttons.CustomButtonInstructor;
import oop.project.components.core.NavBar;
import oop.project.components.core.RoundedJTextField;
import oop.project.components.panels.ThemedPanelInstructor;
import oop.project.hooks.*;
import oop.project.handlers.FilterButtonHandler;

/* TODO: Allow for the following filters'
        - By ID
 *      - By First Name
 *      - By Last Name
 */

public class FilterFrame extends JFrame
{

    KButton filterButton;
    JComboBox<String> filterOptionsID = new JComboBox<String>();
    JComboBox<String> filterOptionsFirstName = new JComboBox<String>();
    JComboBox<String> filterOptionsLastName = new JComboBox<String>();
    JTextField idFieldBetween = new RoundedJTextField(10);
    JTextField firstNameFieldBetween = new RoundedJTextField(10);
    JTextField lastNameFieldBetween = new RoundedJTextField(10);

    public FilterFrame(JPanel parent)
    {
        idFieldBetween.setVisible(false);
        firstNameFieldBetween.setVisible(false);
        lastNameFieldBetween.setVisible(false);

        FrameConfig.set(this, "Filter by", 500, 400);
        KGradientPanel filterPanel = new ThemedPanelInstructor();
        setPreferredSize(new Dimension(350, 30));

        JLabel filterLabel = new JLabel("Filter");
        filterLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        this.setLocationRelativeTo(filterButton);

        filterButton = new CustomButtonInstructor("Filter");
        JLabel idLabel = new JLabel("ID:               ");
        idLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        JTextField idField = new RoundedJTextField(10);
        idField.setMaximumSize(getPreferredSize());
        idField.setMinimumSize(getPreferredSize());

        JLabel firstNameLabel = new JLabel("First Name: ");
        firstNameLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        JTextField firstNameField = new RoundedJTextField(10);
        firstNameField.setMaximumSize(getPreferredSize());
        firstNameField.setMinimumSize(getPreferredSize());

        JLabel lastNameLabel = new JLabel("Last Name:  ");
        lastNameLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        JTextField lastNameField = new RoundedJTextField(10);
        lastNameField.setMaximumSize(getPreferredSize());
        lastNameField.setMinimumSize(getPreferredSize());

        String[] filterOptionsArray = {"=", "!=", "<", "<=", ">", ">=", "begins with", "ends with", "contains", "between"};
        for (String option : filterOptionsArray)
        {
            filterOptionsID.addItem(option);
        }
        for (String option : filterOptionsArray)
        {
            filterOptionsFirstName.addItem(option);
        }
        for (String option : filterOptionsArray)
        {
            filterOptionsLastName.addItem(option);
        }

        filterOptionsID.setMaximumRowCount(10);
        filterOptionsFirstName.setMaximumRowCount(10);
        filterOptionsLastName.setMaximumRowCount(10);

        JComponent[] idFieldComponents = {idField, idFieldBetween};
        Box idFieldBox = AddToBox.addToVerticalBox(idFieldComponents, 1);

        JComponent[] firstNameFieldComponents = {firstNameField, firstNameFieldBetween};
        Box firstNameFieldBox = AddToBox.addToVerticalBox(firstNameFieldComponents, 1);

        JComponent[] lastNameFieldComponents = {lastNameField, lastNameFieldBetween};
        Box lastNameFieldBox = AddToBox.addToVerticalBox(lastNameFieldComponents, 1);

        JComponent[] filterComponents = {idLabel, filterOptionsID, idFieldBox, firstNameLabel, filterOptionsFirstName,
                firstNameFieldBox, lastNameLabel, filterOptionsLastName, lastNameFieldBox};
        Box filterBox = AddToBox.addToVerticalBox(filterComponents, 3);

        JLabel paddingLeft = new JLabel("");
        JLabel paddingRight = new JLabel("");
        JComponent[] spacingComponents = {paddingLeft, filterBox, paddingRight};
        Box spacingBox = AddToBox.addToHorizontalBox(spacingComponents, 1);

        filterBox.setAlignmentX(CENTER_ALIGNMENT);

        JComponent[] components = {filterLabel, spacingBox, filterButton};
        Box box = AddToBox.addToVerticalBox(components, 1);
        filterPanel.add(box);

        // Add to Frame
        this.setLayout(new BorderLayout()); // set the layout to border layout
        JPanel navBar = new NavBar(this, true); // Creating the nav bar
        this.add(navBar, BorderLayout.NORTH); // add the nav bar to the top

        this.add(filterPanel);

        // Button Handler
        filterOptionsID.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (filterOptionsID.getSelectedItem().equals("between"))
                {
                    idFieldBetween.setVisible(true);
                }
                else
                {
                    idFieldBetween.setVisible(false);
                }
                revalidate();
                repaint();
            }
        });
        filterOptionsFirstName.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (filterOptionsFirstName.getSelectedItem().equals("between"))
                {
                    firstNameFieldBetween.setVisible(true);
                }
                else
                {
                    firstNameFieldBetween.setVisible(false);
                }
                revalidate();
                repaint();
            }
        });
        filterOptionsLastName.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (filterOptionsLastName.getSelectedItem().equals("between"))
                {
                    lastNameFieldBetween.setVisible(true);
                }
                else
                {
                    lastNameFieldBetween.setVisible(false);
                }
                revalidate();
                repaint();
            }
        });

    }

    public void setHandler(FilterButtonHandler handler)
    {
        filterButton.addActionListener(handler);
    }
}
