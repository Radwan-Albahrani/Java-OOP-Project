package oop.project.handlers;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;
import java.util.*;

import javax.swing.*;

import com.github.lgooddatepicker.components.*;

import oop.project.API.DatabaseCon;
import oop.project.API.SendEmail;
import oop.project.components.MiniComponents.*;
import oop.project.models.Auth;
import oop.project.models.UserModel;
import oop.project.screens.LoginScreen.LoginScreen;
import oop.project.screens.RegisterScreen.Panels.ProfileRegisterPanel;

public class RegisterHandler implements ActionListener
{
    Map<String, JComponent> components;

    List<String> passwords = new ArrayList<>();

    public void setComponents(Map<String, JComponent> components)
    {
        this.components = components;
    }

    Map<String, String> info = new Hashtable<>();
    Map<String, String> allInfo = new Hashtable<>();

    Map<String, JPanel> panels;
    JFrame frame;

    public RegisterHandler(Map<String, JComponent> components, Map<String, JPanel> panels, JFrame frame)
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
            for (Map.Entry<String, JComponent> component : components.entrySet())
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
                        info.put("password", passwords.get(0));
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
            allInfo.putAll(info);
            info.clear();

            // Remove the current panel
            frame.remove(panels.get("previous"));
            System.err.println("Previous Panel Removed");

            // Make new panel
            ProfileRegisterPanel profile = new ProfileRegisterPanel(frame.getWidth(), frame.getHeight());
            JPanel wrapper = wrapperSetup(profile);

            // Give it the handler
            profile.setHandler(this);

            // Add it to the Map and display it
            panels.put("profile", wrapper);
            frame.add(panels.get("profile"));
        }

        // else if button clicked is Register
        else if (buttonClicked.equals("Register"))
        {
            System.err.println("Register button clicked - Register");
            // Validate the input
            for (Map.Entry<String, JComponent> component : components.entrySet())
            {
                int result = Validation(component);
                if (result == -1)
                {
                    return;
                }
            }
            // Add the info to the list
            allInfo.putAll(info);
            info.clear();

            UserModel user = new UserModel();
            user.setFirstName(allInfo.get("firstName"));
            user.setLastName(allInfo.get("lastName"));
            user.setEmail(allInfo.get("email"));
            user.setPersonalEmail(allInfo.get("personalEmail"));
            user.setPhoneNumber(allInfo.get("phoneNumber"));
            user.setAuth(new Auth(allInfo.get("username"), allInfo.get("password")));
            user.setBirthDate(allInfo.get("dob"));
            user.setMajor(allInfo.get("major"));
            user.setGender(allInfo.get("gender"));
            user.setRole(allInfo.get("role"));

            System.out.println(user.toString());

            // Show the user that the registration was successful
            SendEmail.sendRegistrationEmail(user.getPersonalEmail(), user.getFirstName() + " " + user.getLastName());

            int result = DatabaseCon.registerUser(user);
            if (result == 1)
            {
                JOptionPane.showMessageDialog(frame,
                        "Registration Successful, Please Wait for the Admin to Activate your Account", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
                new LoginScreen();
            }
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
        constraints.insets = new Insets(frame.getHeight() / 12, frame.getWidth() / 3, frame.getHeight() / 12,
                frame.getWidth() / 3);
        constraints.fill = GridBagConstraints.BOTH;
        ((ProfileRegisterPanel) panel).setWrapper(wrapper);
        wrapper.add(panel, constraints);
        return wrapper;
    }

    private int Validation(Map.Entry<String, JComponent> component)
    {
        if (component.getValue() instanceof JTextField
                && !(component.getValue() instanceof JPasswordField || component.getValue() instanceof EmailTextField
                        || component.getValue() instanceof PhoneTextField))
        {
            if (((JTextField) component.getValue()).getText().equals(""))
            {
                JOptionPane.showMessageDialog(frame, "Please fill out all fields", "Error", JOptionPane.ERROR_MESSAGE);
                info.clear();
                passwords.clear();
                return -1;
            }
            info.put(component.getKey(), ((JTextField) component.getValue()).getText());
            return 1;
        }
        else if (component.getValue() instanceof JPasswordField)
        {
            if (((JPasswordField) component.getValue()).getPassword().length == 0)
            {
                JOptionPane.showMessageDialog(frame, "Please fill out all fields", "Error", JOptionPane.ERROR_MESSAGE);
                info.clear();
                passwords.clear();
                return -1;
            }

            // Validate Strength.
            String password = new String(((JPasswordField) component.getValue()).getPassword());
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
        else if (component.getValue() instanceof PhoneTextField)
        {
            if (((PhoneTextField) component.getValue()).getText().equals(""))
            {
                JOptionPane.showMessageDialog(frame, "Please fill out all fields", "Error", JOptionPane.ERROR_MESSAGE);
                info.clear();
                passwords.clear();
                return -1;
            }
            int result = ((PhoneTextField) component.getValue()).Validate();
            if (result != 0)
            {
                JOptionPane.showMessageDialog(frame, "Please enter a valid phone number", "Error",
                        JOptionPane.ERROR_MESSAGE);
                info.clear();
                passwords.clear();
                return -1;
            }
            info.put(component.getKey(), ((PhoneTextField) component.getValue()).getText());
            return 1;
        }
        else if (component.getValue() instanceof EmailTextField)
        {
            if (((EmailTextField) component.getValue()).getText().equals(""))
            {
                JOptionPane.showMessageDialog(frame, "Please fill out all fields", "Error", JOptionPane.ERROR_MESSAGE);
                info.clear();
                passwords.clear();
                return -1;
            }
            int result = ((EmailTextField) component.getValue()).Validate();
            if (result == 1)
            {
                JOptionPane.showMessageDialog(frame, "Email Already Registered", "Error", JOptionPane.ERROR_MESSAGE);
                info.clear();
                passwords.clear();
                return -1;
            }
            if (result != 0)
            {
                JOptionPane.showMessageDialog(frame, "Please enter a valid email", "Error", JOptionPane.ERROR_MESSAGE);
                info.clear();
                passwords.clear();
                return -1;
            }
            info.put(component.getKey(), ((EmailTextField) component.getValue()).getText());
            return 1;
        }
        else if (component.getValue() instanceof JComboBox<?>)
        {
            if (((JComboBox<?>) component.getValue()).getSelectedItem().equals(""))
            {
                JOptionPane.showMessageDialog(frame, "Please fill out all fields", "Error", JOptionPane.ERROR_MESSAGE);
                info.clear();
                passwords.clear();
                return -1;
            }
            info.put(component.getKey(), (String) ((JComboBox<?>) component.getValue()).getSelectedItem());
            return 1;
        }
        else if (component.getValue() instanceof DatePicker)
        {
            if (((DatePicker) component.getValue()).getDate() == null)
            {
                JOptionPane.showMessageDialog(frame, "Please fill out all fields", "Error", JOptionPane.ERROR_MESSAGE);
                info.clear();
                passwords.clear();
                return -1;
            }
            else if (((DatePicker) component.getValue()).getDate().isAfter(LocalDate.now()))
            {
                JOptionPane.showMessageDialog(frame, "Please enter a valid date", "Error", JOptionPane.ERROR_MESSAGE);
                info.clear();
                passwords.clear();
                return -1;
            }
            else if (((DatePicker) component.getValue()).getDate().isBefore(LocalDate.now().minusYears(100)))
            {
                JOptionPane.showMessageDialog(frame, "Please enter a valid date", "Error", JOptionPane.ERROR_MESSAGE);
                info.clear();
                passwords.clear();
                return -1;
            }
            else if (((DatePicker) component.getValue()).getDate().isAfter(LocalDate.now().minusYears(18)))
            {
                JOptionPane.showMessageDialog(frame, "You must be at least 18 years old to register", "Error",
                        JOptionPane.ERROR_MESSAGE);
                info.clear();
                passwords.clear();
                return -1;
            }
            info.put(component.getKey(), ((DatePicker) component.getValue()).getDate().toString());
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
