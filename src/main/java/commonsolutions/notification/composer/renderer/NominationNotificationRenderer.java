package commonsolutions.notification.composer.renderer;

import commonsolutions.notification.composer.TemplateVariable;
import commonsolutions.notification.composer.VariableContext;
import commonsolutions.notification.entity.*;

import java.util.ArrayList;
import java.util.List;

public class NominationNotificationRenderer extends NotificationRenderer {
    private Nominator nominator;
    private Nominee nominee;

    public NominationNotificationRenderer(String template, VariableContext context) {
        super(template, context);
    }

    @Override
    protected void setup(VariableContext context) {
        nominator = context.get(VariableContext.Names.NOMINATOR);
        nominee = context.get(VariableContext.Names.NOMINEE);
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
        return "Nomination Notification";
    }

    @Override
    protected List<TemplateVariable> registerVariables() {
        List<TemplateVariable> variables = new ArrayList<>();
        variables.add(TemplateVariable.with("nomineeName", nominee.getName()));
        variables.add(TemplateVariable.with("nominatorName", nominator.getName()));
        return variables;
    }
}