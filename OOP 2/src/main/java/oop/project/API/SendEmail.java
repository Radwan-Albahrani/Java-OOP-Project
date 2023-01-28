package oop.project.API;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import com.google.gson.Gson;

public class SendEmail
{
    private static void sendEmail(String to, String emailMessage, String subject)
    {

        // Sender's email ID needs to be mentioned
        String from = "sisjavaapp@gmail.com";

        // Assuming you are sending email from through gmail smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.starttls.required", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        Session session = null;
        try
        {
            session = Session.getInstance(properties, new javax.mail.Authenticator()
            {

                protected PasswordAuthentication getPasswordAuthentication()
                {
                    Map<?, ?> secrets = readJson();

                    return new PasswordAuthentication((String) secrets.get("USERNAME"), (String) secrets.get("PASSWORD"));

                }

            });
        }
        catch (Exception e)
        {
            System.err.println("Error: " + e.getMessage());
            return;
        } // Get the Session object.// and pass username and password

        try
        {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(subject);

            // Now set the actual message
            message.setText(emailMessage);

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        }
        catch (MessagingException mex)
        {
            mex.printStackTrace();
        }

    }

    public static void sendRegistrationEmail(String to, String name)
    {
        String emailMessage = """
                Dear %s

                Thank you for completing your registration with our esteemed Student Information System.

                Please note that your account is not yet activated. You will receive an email once your account is activated.

                Regards,
                The SIS team
                        """.formatted(name);
        String subject = "Registration Successful";

        new Thread(() -> sendEmail(to, emailMessage, subject)).start();
    }

    public static void sendActivationEmail(String to, String name)
    {
        String emailMessage = """
                Dear %s

                Your account has been activated. You can now login to the Student Information System.

                Regards,
                The SIS team
                        """.formatted(name);
        String subject = "Account Activated";

        new Thread(() -> sendEmail(to, emailMessage, subject)).start();
    }

    public static void sendActivationEmailGeneric(String to)
    {
        String emailMessage = """
                Dear User

                Your account has been activated. You can now login to the Student Information System.

                Regards,
                The SIS team
                        """;
        String subject = "Account Activated";

        new Thread(() -> sendEmail(to, emailMessage, subject)).start();
    }

    public static void sendEmailWithMessage(String to, String emailMessage, String subject)
    {
        new Thread(() -> sendEmail(to, emailMessage, subject)).start();
    }

    private static Map<?, ?> readJson()
    {
        // String path = "src/main/resources/secret/secret.json";
        String path = "secret/secret.json";
        Gson gson = new Gson();
        try (InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
                BufferedReader reader = new BufferedReader(new InputStreamReader(in)))
        {
            // Convert JSON File to Java Object
            Map<?, ?> secrets = gson.fromJson(reader, Map.class);
            return secrets;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

}