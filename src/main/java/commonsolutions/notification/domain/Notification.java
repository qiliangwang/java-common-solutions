package commonsolutions.notification.domain;

import com.alibaba.fastjson.JSON;

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

    public String from() {
        return from;
    }

    public String to() {
        return to;
    }

    public String subject() {
        return subject;
    }

    public String body() {
        return body;
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