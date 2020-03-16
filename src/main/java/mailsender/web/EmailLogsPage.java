package mailsender.web;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import mailsender.db.emails.Email;
import mailsender.db.emails.EmailService;
import mailsender.pojo.SentEmail;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@SpringUI(path = "/email-log-page")
public class EmailLogsPage extends UI {

    private VerticalLayout root = new VerticalLayout();
    private EmailService emailService;
    private Grid<SentEmail> emailGrid = new Grid<>();
    private static List<SentEmail> sentEmails = new ArrayList<>();

    public static void addEmail(SentEmail sentEmail){
        sentEmails.add(sentEmail);
    }

    @Autowired
    public EmailLogsPage(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    protected void init(VaadinRequest request) {
        this.setContent(root);
        root.addComponent(new Label("SENT EMAILS"));

        emailGrid.addColumn(SentEmail::getSubject).setCaption("SUBJECT");
        emailGrid.addColumn(SentEmail::getTime).setCaption("TIME");

        emailGrid.setWidth(50, Unit.PERCENTAGE);
        emailGrid.setItems(sentEmails);
        if (sentEmails.size() > 0) {
            emailGrid.setHeightByRows(sentEmails.size());
        } else {
            emailGrid.setHeightByRows(1);
        }
        root.addComponent(emailGrid);

    }
}
