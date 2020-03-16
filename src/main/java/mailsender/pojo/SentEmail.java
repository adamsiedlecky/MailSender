package mailsender.pojo;

import java.time.LocalDateTime;

public class SentEmail {

    private String subject;
    private LocalDateTime time;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
