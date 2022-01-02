package commonsolutions.design.notification.render;


import commonsolutions.design.notification.render.renderer.NotificationRenderer;
import commonsolutions.design.notification.domain.Notification;

public class MailTemplate {
    private String template;
    private TemplateType templateType;

    public MailTemplate(String template, TemplateType templateType) {
        this.template = template;
        this.templateType = templateType;
    }

    public Notification render(VariableContext context) {
        NotificationRenderer notificationRenderer = this.templateType.renderer(template, context);
        return notificationRenderer.render();
    }
}