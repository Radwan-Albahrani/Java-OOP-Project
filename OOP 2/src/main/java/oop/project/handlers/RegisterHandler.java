package oop.project.handlers;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

import com.github.lgooddatepicker.components.*;

import oop.project.components.MiniComponents.*;
import oop.project.models.Auth;
import oop.project.models.UserModel;
import oop.project.screens.LoginScreen.LoginScreen;
import oop.project.screens.RegisterScreen.Panels.ProfileRegisterPanel;

public class RegisterHandler implements ActionListener
{
    List<JComponent> components;

    List<String> passwords = new ArrayList<>();

    public void setComponents(List<JComponent> components)
    {
        this.components = components;
    }

    List<String> info = new ArrayList<>();
    List<String> allInfo = new ArrayList<>();

    Dictionary<String, JPanel> panels;
    JFrame frame;

    public RegisterHandler(List<JComponent> components, Dictionary<String, JPanel> panels, JFrame frame)
    {
        this.components = components;
        this.panels = panels;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        // Get the clicked button
        String buttonClicked = e.getActionCommand().trim();

        // If the button clicked is Next
        if (buttonClicked.equals("Next"))
        {
            System.err.println("Next button clicked - Register");
            // Validate the input
            for (JComponent component : components)
            {
                int result = Validation(component);
                if (result == -1)
                {
                    return;
                }
                if (passwords.size() == 2)
                {
                    if (passwords.get(0).equals(passwords.get(1)))
                    {
                        info.add(passwords.get(0));
                        passwords.clear();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(frame, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
                        passwords.clear();
                        info.clear();
                        return;
                    }
                }
            }

            // Add the info to the list
            allInfo.addAll(info);
            info.clear();

            // Remove the current panel
            frame.remove(panels.get("previous"));
            System.err.println("Previous button clicked - Register");

            // Make new panel
            ProfileRegisterPanel profile = new ProfileRegisterPanel(frame.getWidth(), frame.getHeight());
            JPanel wrapper = wrapperSetup(profile);

            // Give it the handler
            profile.setHandler(this);

            // Add it to the dictionary and display it
            panels.put("profile", wrapper);
            frame.add(panels.get("profile"));
        }

        // else if button clicked is Register
        else if (buttonClicked.equals("Register"))
        {
            System.err.println("Register button clicked - Register");
            // Validate the input
            for (JComponent component : components)
            {
                int result = Validation(component);
                if (result == -1)
                {
                    return;
                }
            }
            // Add the info to the list
            allInfo.addAll(info);
            info.clear();

            UserModel user = new UserModel(allInfo.get(0), allInfo.get(1), allInfo.get(6), allInfo.get(3), allInfo.get(9),
                    allInfo.get(5), allInfo.get(7), allInfo.get(8), allInfo.get(10), allInfo.get(11),
                    new Auth(allInfo.get(2), allInfo.get(4)));

            System.out.println(user.toString());

            // Show the user that the registration was successful
            JOptionPane.showMessageDialog(frame, "Registration Successful", "Success", JOptionPane.INFORMATION_MESSAGE);

            // TODO: Add the info to the database
            frame.dispose();
            new LoginScreen();
        }

        frame.revalidate();
        frame.repaint();
    }

    private JPanel wrapperSetup(ProfileRegisterPanel panel)
    {
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new GridBagLayout());
        wrapper.setOpaque(false);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(frame.getHeight() / 16, frame.getWidth() / 3, frame.getHeight() / 16,
                frame.getWidth() / 3);
        constraints.fill = GridBagConstraints.BOTH;
        ((ProfileRegisterPanel) panel).setWrapper(wrapper);
        wrapper.add(panel, constraints);
        return wrapper;
    }

    private int Validation(JComponent component)
    {
        if (component instanceof JTextField && !(component instanceof JPasswordField || component instanceof EmailTextField
                || component instanceof PhoneTextField))
        {
            if (((JTextField) component).getText().equals(""))
            {
                JOptionPane.showMessageDialog(frame, "Please fill out all fields");
                info.clear();
                passwords.clear();
                return -1;
            }
            info.add(((JTextField) component).getText());
            return 1;
        }
        else if (component instanceof JPasswordField)
        {
            if (((JPasswordField) component).getPassword().length == 0)
            {
                JOptionPane.showMessageDialog(frame, "Please fill out all fields");
                info.clear();
                passwords.clear();
                return -1;
            }

            // Validate Strength.
            String password = new String(((JPasswordField) component).getPassword());
            if (passwords.size() == 0)
            {
                int validateStrength = validateStrength(password);
                if (validateStrength == -1)
                {
                    return -1;
                }
                passwords.add(password);
                return 1;
            }
            else
            {
                passwords.add(password);
                return 1;
            }
        }
        else if (component instanceof EmailTextField)
        {
            if (((EmailTextField) component).getText().equals(""))
            {
                JOptionPane.showMessageDialog(frame, "Please fill out all fields");
                info.clear();
                passwords.clear();
                return -1;
            }
            int result = ((EmailTextField) component).Validate();
            if (result != 0)
            {
                JOptionPane.showMessageDialog(frame, "Please enter a valid email address");
                info.clear();
                passwords.clear();
                return -1;
            }
            info.add(((EmailTextField) component).getText());
            return 1;
        }
        else if (component instanceof PhoneTextField)
        {
            if (((PhoneTextField) component).getText().equals(""))
            {
                JOptionPane.showMessageDialog(frame, "Please fill out all fields");
                info.clear();
                passwords.clear();
                return -1;
            }
            int result = ((PhoneTextField) component).Validate();
            if (result != 0)
            {
                JOptionPane.showMessageDialog(frame, "Please enter a valid phone number");
                info.clear();
                passwords.clear();
                return -1;
            }
            info.add(((PhoneTextField) component).getText());
            return 1;
        }
        else if (component instanceof JComboBox<?>)
        {
            if (((JComboBox<?>) component).getSelectedItem().equals(""))
            {
                JOptionPane.showMessageDialog(frame, "Please fill out all fields");
                info.clear();
                passwords.clear();
                return -1;
            }
            info.add((String) ((JComboBox<?>) component).getSelectedItem());
            return 1;
        }
        else if (component instanceof DatePicker)
        {
            ((DatePicker) component).validate();
            if (((DatePicker) component).getDate() == null)
            {
                JOptionPane.showMessageDialog(frame, "Please fill out all fields");
                info.clear();
                passwords.clear();
                return -1;
            }
            info.add(((DatePicker) component).getDate().toString());
            return 1;
        }
        return 0;
    }

    public int validateStrength(String password)
    {
        if (password.length() < 8)
        {
            JOptionPane.showMessageDialog(frame, "Password must be at least 8 characters long");
            info.clear();
            passwords.clear();
            return -1;
        }
        if (!password.matches(".*[A-Z].*"))
        {
            JOptionPane.showMessageDialog(frame, "Password must contain at least one uppercase letter");
            info.clear();
            passwords.clear();
            return -1;
        }
        if (!password.matches(".*[a-z].*"))
        {
            JOptionPane.showMessageDialog(frame, "Password must contain at least one lowercase letter");
            info.clear();
            passwords.clear();
            return -1;
        }
        if (!password.matches(".*[0-9].*"))
        {
            JOptionPane.showMessageDialog(frame, "Password must contain at least one number");
            info.clear();
            passwords.clear();
            return -1;
        }
        if (!password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*"))
        {
            JOptionPane.showMessageDialog(frame, "Password must contain at least one special character");
            info.clear();
            passwords.clear();
            return -1;
        }
        return 1;
    }

}
