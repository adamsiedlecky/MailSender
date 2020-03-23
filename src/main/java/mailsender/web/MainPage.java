package mailsender.web;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import mailsender.db.emails.Email;
import mailsender.db.emails.EmailService;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
public class MainPage extends UI {

    private VerticalLayout root = new VerticalLayout();
    private EmailService emailService;
    private Grid<Email> emailGrid = new Grid<>();

    @Autowired
    public MainPage(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    protected void init(VaadinRequest request) {
        this.setContent(root);
        root.addComponent(new Label("MailSender by Adam Siedlecki"));
        root.addComponent(new Label("ALL EMAILS IN THE TABLE BELOW ARE SENT AT 10:00 MON - FRI"));

        emailGrid.addColumn(Email::getId).setCaption("ID");
        emailGrid.addColumn(Email::getSubject).setCaption("SUBJECT");
        emailGrid.addColumn(Email::getContent).setCaption("CONTENT");
        emailGrid.addColumn(Email::getSenderEmail).setCaption("SENDER");
        emailGrid.addColumn(Email::getReceiverEmail).setCaption("RECEIVER");
        emailGrid.addColumn(Email::getServerHost).setCaption("SERVER HOST");
        emailGrid.addColumn(Email::getServerPort).setCaption("SERVER PORT");
        emailGrid.addColumn(Email::getSenderPassword).setCaption("PASSWORD");

        emailGrid.setWidth(90, Unit.PERCENTAGE);
        emailGrid.setItems(emailService.findAll());
        if(emailService.count()>0){
            emailGrid.setHeightByRows(emailService.count());
        }else{
            emailGrid.setHeightByRows(1);
        }

        root.addComponent(emailGrid);
        /////


        FormLayout addEmailLayout = new FormLayout();
        VerticalLayout deleteEmailLayout = new VerticalLayout();
        HorizontalLayout horiz = new HorizontalLayout(addEmailLayout, deleteEmailLayout);
        root.addComponent(horiz);

        prepareAddEmailForm(addEmailLayout);
        prepareDeleteEmailForm(deleteEmailLayout);

        root.forEach(component -> root.setComponentAlignment(component, Alignment.MIDDLE_CENTER));
    }

    private void prepareAddEmailForm(Layout layout){
        TextField idField = new TextField("ID");
        TextField receiverField = new TextField("RECEIVER EMAIL");
        TextField senderEmailField = new TextField("SENDER EMAIL");
        TextField senderPasswordField = new TextField("SENDER PASSWORD");
        TextField subjectField = new TextField("SUBJECT");
        TextField contentField = new TextField("CONTENT");
        TextField serverHostField = new TextField("SERVER HOST");
        TextField serverPortField = new TextField("SERVER PORT");
        idField.setValue("1");
        serverHostField.setValue("smtp.wp.pl");
        serverPortField.setValue("465");

        layout.addComponents(idField, receiverField, senderEmailField, senderPasswordField, subjectField,
                contentField, serverHostField, serverPortField);

        Button saveButton = new Button("SAVE");
        layout.addComponent(saveButton);
        saveButton.addClickListener(e->{
            if(idField.getValue().matches("\\d+")&&serverPortField.getValue().matches("\\d+")){
                Email email = new Email();
                email.setId(Long.parseLong(idField.getValue()));
                email.setContent(contentField.getValue());
                email.setSubject(subjectField.getValue());
                email.setReceiverEmail(receiverField.getValue());
                email.setSenderEmail(senderEmailField.getValue());
                email.setSenderPassword(senderPasswordField.getValue());
                email.setServerHost(serverHostField.getValue());
                email.setServerPort(Integer.parseInt(serverPortField.getValue()));
                emailService.saveAndFlush(email);
                Notification.show("EMAIL SAVED!");
                if(emailService.count()>0){
                    emailGrid.setHeightByRows(emailService.count());
                }else{
                    emailGrid.setHeightByRows(1);
                }
                emailGrid.setItems(emailService.findAll());
            }else{
                Notification.show("SOME VALUES ARE WRONG!");
            }
        });

        //layout.forEach(component -> layout.setComponentAlignment(component, Alignment.MIDDLE_CENTER));
    }

    private void prepareDeleteEmailForm(VerticalLayout layout){
        TextField idField = new TextField("ID of email");
        Button deleteButton = new Button("DELETE EMAIL");
        deleteButton.addClickListener(e->{
            if(idField.getValue().matches("\\d+")){
                emailService.deleteById(Long.parseLong(idField.getValue()));
                idField.setValue("");
                emailGrid.setItems(emailService.findAll());
            }else{
                Notification.show("Text is not a digit!");
            }
        });
        layout.addComponents(idField, deleteButton);
        deleteButton.setStyleName(ValoTheme.BUTTON_DANGER);
        layout.forEach(component -> layout.setComponentAlignment(component, Alignment.MIDDLE_CENTER));
    }
}
