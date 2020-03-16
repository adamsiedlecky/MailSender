package mailsender;

import mailsender.db.emails.Email;
import mailsender.utils.Sender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Main {

    // account used for only for tests
    // for WP POCZTA you need to set IMAP on in options

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
//        Email email = new Email();
//
//        email.setContent("");
//        email.setSubject("Adam Siedlecki");
//        email.setReceiverEmail("asiedlecki12@wp.pl");
//        email.setSenderEmail("asiedlecki12@wp.pl");
//        email.setSenderPassword("");
//        email.setSenderPassword("qwerty123");
//        email.setServerHost("smtp.wp.pl");
//        email.setServerPort(465);
//
//
//
//        for (int i = 0; i <50 ; i++) {
//            Sender.send(email);
//        }
    }
}

