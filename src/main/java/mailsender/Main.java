package mailsender;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Main {

    // account used for only for tests
    // for WP POCZTA you need to set IMAP on in options
    
    public static void main(String[] args) {
        Email email = new Email();

        email.setContent("");
        email.setSubject("Adam Siedlecki");
        email.setReceiverEmail("asiedlecki12@wp.pl");
        email.setSenderEmail("asiedlecki12@wp.pl");
        email.setSenderPassword("");
        email.setSenderPassword("qwerty123");
        email.setServerHost("smtp.wp.pl");
        email.setServerPort(465);

        Sender.send(email);
    }
}

