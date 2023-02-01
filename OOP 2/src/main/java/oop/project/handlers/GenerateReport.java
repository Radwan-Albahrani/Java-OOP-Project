package oop.project.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import java.io.*;

public class GenerateReport implements ActionListener
{
    JTable table;
    String path;

    public GenerateReport(JTable table, String path)
    {
        this.table = table;
        this.path = path;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String buttonClicked = e.getActionCommand().trim();
        if (buttonClicked.equals("Generate Report"))
        {
            try
            {
                exportTable(table, path);
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Report Generated!", "Success!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void exportTable(JTable table, String path) throws IOException
    {
        try
        {
            String pathWithoutFile = path.substring(0, path.lastIndexOf("/"));
            File file = new File(pathWithoutFile);
            file.mkdirs();
            file = new File(path);
            if (file.createNewFile())
            {
                System.err.println("File created: " + file.getName());
            }
            else
            {
                System.err.println("File already exists.");
            }

            TableModel model = table.getModel();
            FileWriter out = new FileWriter(file);
            for (int i = 0; i < model.getColumnCount(); i++)
            {
                out.write(model.getColumnName(i) + ",");
            }

            out.write("\n");

            for (int i = 0; i < model.getRowCount(); i++)
            {
                for (int j = 0; j < model.getColumnCount(); j++)
                {
                    out.write(model.getValueAt(i, j).toString() + ",");
                }
                out.write("\n");
            }

            out.close();
            System.out.println("write out to: " + file);
        }
        catch (IOException e)
        {
            System.out.println("An error occurred while creating the file at " + path + "." + e.getMessage());
            e.printStackTrace();
        }
    }
}
