package commonsolutions.notification.composer;


import commonsolutions.notification.domain.Notification;

public class MailTemplate {
    private String template;
    private TemplateType templateType;

    public MailTemplate(String template, TemplateType templateType) {
        this.template = template;
        this.templateType = templateType;
    }

    public Notification compose(VariableContext context) {
        NotificationComposer notificationComposer = this.templateType.composer(template, context);
        return notificationComposer.compose();
    }
}