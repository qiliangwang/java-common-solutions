package commonsolutions.design.notification.render.renderer;

import commonsolutions.design.notification.render.TemplateVariable;
import commonsolutions.design.notification.render.VariableContext;
import commonsolutions.design.notification.entity.Nominator;
import commonsolutions.design.notification.entity.Nominee;
import commonsolutions.design.notification.entity.Research;

import java.util.ArrayList;
import java.util.List;

public class ResearchNotificationRenderer extends NotificationRenderer {
    private Nominator nominator;
    private Nominee nominee;
    private Research research;

    public ResearchNotificationRenderer(String template, VariableContext context) {
        super(template, context);
    }

    @Override
    protected void setup(VariableContext context) {
        nominator = context.get(VariableContext.Names.NOMINATOR);
        nominee = context.get(VariableContext.Names.NOMINEE);
        research = context.get(VariableContext.Names.RESEARCH);
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
        return "Research Nomination Notification";
    }

    @Override
    protected List<TemplateVariable> registerVariables() {
        List<TemplateVariable> variables = new ArrayList<>();
        variables.add(TemplateVariable.with("nomineeName", nominee.getName()));
        variables.add(TemplateVariable.with("nominatorName", nominator.getName()));
        variables.add(TemplateVariable.with("url", research.url()));
        return variables;
    }
}