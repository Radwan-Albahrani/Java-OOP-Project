package oop.project.API;

import java.io.FileReader;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import com.google.gson.Gson;

public class SendEmail
{
    public static void sendEmail(String to, String emailMessage, String subject)
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

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator()
        {

            protected PasswordAuthentication getPasswordAuthentication()
            {
                Map<?, ?> secrets = readJson();

                return new PasswordAuthentication((String) secrets.get("USERNAME"), (String) secrets.get("PASSWORD"));

            }

        });

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

    public static void sendEmail(String to)
    {
        String emailMessage = """
                Dear User

                Thank you for completing your registration with our esteemed Student Information System.

                Please note that your account is not yet activated. You will receive an email once your account is activated.

                Regards,
                The SIS team
                        """;
        String subject = "Registration Successful";

        sendEmail(to, emailMessage, subject);
    }

    private static Map<?, ?> readJson()
    {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("src/main/resources/secret/secret.json"))
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