package api;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class SendEmail {

    public SendEmail() {
    }

    public static void sendEmail(String recipient, String subject, String body) {
        //provide recipient's email ID
        String to = recipient;

        //provide sender's email ID
        String from = "helpdesk@lapr4.com";

        //provide Mailtrap's username
        final String username = "4422b04f2fd465";

        //provide Mailtrap's password
        final String password = "c8e7be503dc7ad";

        //provide Mailtrap's host address
        String host = "smtp.mailtrap.io";

        //configure Mailtrap's SMTP server details
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        //create the Session object
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            //create a MimeMessage object
            Message message = new MimeMessage(session);

            //set From email field
            message.setFrom(new InternetAddress(from));

            //set To email field
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            //set email subject field
            message.setSubject(subject);

            //set the content of the email message
            message.setText(body);

            //send the email message
            Transport.send(message);

            System.out.println("Email Message Sent Successfully");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
