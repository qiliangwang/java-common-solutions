package commonsolutions.design.notification.render;

import commonsolutions.design.notification.render.renderer.MeetingNotificationRenderer;
import commonsolutions.design.notification.render.renderer.NominationNotificationRenderer;
import commonsolutions.design.notification.render.renderer.NotificationRenderer;
import commonsolutions.design.notification.render.renderer.ResearchNotificationRenderer;

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