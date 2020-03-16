package mailsender.db.emails;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Email {

    @Id
    private long id;
    private String receiverEmail;
    private String senderEmail;
    private String senderPassword;
    private String subject;
    private String content;
    private String serverHost;
    private int serverPort;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getSenderPassword() {
        return senderPassword;
    }

    public void setSenderPassword(String senderPassword) {
        this.senderPassword = senderPassword;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getServerHost() {
        return serverHost;
    }

    public void setServerHost(String serverHost) {
        this.serverHost = serverHost;
    }
}
