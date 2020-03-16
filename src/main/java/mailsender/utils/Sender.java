package mailsender.utils;

import mailsender.db.emails.Email;
import mailsender.pojo.SentEmail;
import mailsender.web.EmailLogsPage;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class Sender {

    public static void send(Email email){

        Properties props = new Properties();
        props.put("mail.smtp.host",email.getServerHost());
        props.put("mail.smtp.port", email.getServerPort());
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(email.getSenderEmail(),email.getSenderPassword());
                    }
                });

        //session.setDebug(true);
        //session.setDebugOut(System.out);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email.getSenderEmail()));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(email.getReceiverEmail()));
            message.setSubject(email.getSubject());
            message.setText(email.getContent());

            Transport.send(message);

            System.out.println("Wiadomość została wysłana: "+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));

            SentEmail sentEmail = new SentEmail();
            sentEmail.setSubject(email.getSubject());
            sentEmail.setTime(LocalDateTime.now());

            EmailLogsPage.addEmail(sentEmail);

        } catch (MessagingException e) {e.printStackTrace();}
    }
}
