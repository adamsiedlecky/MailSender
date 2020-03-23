package mailsender.utils.scheduler;


import mailsender.db.emails.Email;
import mailsender.db.emails.EmailService;
import mailsender.utils.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class EmailScheduler {

    private EmailService emailService;

    @Autowired
    public EmailScheduler(EmailService emailService) {
        this.emailService = emailService;
    }

    @Scheduled(cron = "0 0 10 * * MON-FRI")
    public void executeTask() {

        Random r = new Random();
        int delayMillis = r.nextInt(600000);

        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        for (Email email : emailService.findAll()) {
                            Sender.send(email);
                        }
                    }
                },
                delayMillis
        );
    }

}
