package commonsolutions.notification.composer;

import commonsolutions.notification.composer.renderer.MeetingNotificationRenderer;
import commonsolutions.notification.composer.renderer.NominationNotificationRenderer;
import commonsolutions.notification.composer.renderer.NotificationRenderer;
import commonsolutions.notification.composer.renderer.ResearchNotificationRenderer;

public enum TemplateType {

    Nomination {
        public NotificationRenderer renderer(String template, VariableContext context) {
            return new NominationNotificationRenderer(template, context);
        }
    },
    Meeting {
        public NotificationRenderer renderer(String template, VariableContext context) {
            return new MeetingNotificationRenderer(template, context);
        }
    },
    Research {
        public NotificationRenderer renderer(String template, VariableContext context) {
            return new ResearchNotificationRenderer(template, context);
        }
    },
    Promotion {
        public NotificationRenderer renderer(String template, VariableContext context) {
            return new NominationNotificationRenderer(template, context);
        }
    },
    ;

    abstract NotificationRenderer renderer(String template, VariableContext context);
}