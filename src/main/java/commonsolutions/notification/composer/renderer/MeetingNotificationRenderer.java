package commonsolutions.notification.composer.renderer;

import commonsolutions.notification.composer.TemplateVariable;
import commonsolutions.notification.composer.VariableContext;
import commonsolutions.notification.entity.*;

import java.util.ArrayList;
import java.util.List;

public class MeetingNotificationRenderer extends NotificationRenderer {
    private Nominator nominator;
    private Nominee nominee;
    private Meeting meeting;

    public MeetingNotificationRenderer(String template, VariableContext context) {
        super(template, context);
    }

    @Override
    protected void setup(VariableContext context) {
        nominator = context.get(VariableContext.Names.NOMINATOR);
        nominee = context.get(VariableContext.Names.NOMINEE);
        meeting = context.get(VariableContext.Names.MEETING);
    }

    @Override
    protected String renderFrom() {
        return "ice@ice.com";
    }

    @Override
    protected String renderTo() {
        return nominee.getEmail();
    }

    @Override
    protected String renderSubject() {
        return "Ticket Nomination Notification";
    }

    @Override
    protected List<TemplateVariable> registerVariables() {
        List<TemplateVariable> variables = new ArrayList<>();
        variables.add(TemplateVariable.with("nomineeName", nominee.getName()));
        variables.add(TemplateVariable.with("nominatorName", nominator.getName()));
        variables.add(TemplateVariable.with("beginTime", meeting.getBeginTime().toString()));
        variables.add(TemplateVariable.with("endTime", meeting.getEndTime().toString()));
        variables.add(TemplateVariable.with("place", meeting.getPlace()));
        return variables;
    }
}