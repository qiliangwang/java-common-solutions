package commonsolutions.notification.render;

import commonsolutions.notification.render.renderer.MeetingNotificationRenderer;
import commonsolutions.notification.render.renderer.NominationNotificationRenderer;
import commonsolutions.notification.render.renderer.NotificationRenderer;
import commonsolutions.notification.render.renderer.ResearchNotificationRenderer;

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