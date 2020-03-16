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

        // scheduler provided via utils/scheduler/EmailScheduler.java
        // UI is active on localhost:80
    }
}

