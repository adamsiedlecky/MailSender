package mailsender.utils.scheduler;


import mailsender.db.emails.Email;
import mailsender.db.emails.EmailService;
import mailsender.utils.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {

    private EmailService emailService;

    @Autowired
    public EmailScheduler(EmailService emailService) {
        this.emailService = emailService;
    }

    @Scheduled(cron = "0 59 7 * * MON-FRI")
    public void executeTask() {

//        if(emailService.count()==0){
//            Email email = new Email();
//            email.setContent("");
//            email.setSubject("Adam Siedlecki");
//            email.setReceiverEmail("asiedlecki12@wp.pl");
//            email.setSenderEmail("asiedlecki12@wp.pl");
//            email.setSenderPassword("");
//            email.setSenderPassword("qwerty123");
//            email.setServerHost("smtp.wp.pl");
//            email.setServerPort(465);
//            emailService.saveAndFlush(email);
//        }

        for(Email email : emailService.findAll()){
            Sender.send(email);
        }
    }

}
