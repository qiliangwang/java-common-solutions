package commonsolutions.design.notification.domain;

import lombok.Getter;

@Getter
public class Notification {
    private String from;
    private String to;
    private String subject;
    private String body;

    public Notification(String from, String to, String subject, String body) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    @Override
    public String toString() {
        return "Notification:\n" +
                "{\n" +
                "from='" + from +",\n"+
                "to='" + to +",\n" +
                "subject='" + subject + ",\n" +
                "body='" + body + "}";
    }
}