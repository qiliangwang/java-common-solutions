package commonsolutions.design.notification.repository;

import commonsolutions.design.notification.render.MailTemplate;
import commonsolutions.design.notification.render.TemplateType;

import java.util.Optional;


public interface MailTemplateRepository {

    Optional<MailTemplate> templateOf(TemplateType templateType);

    MailTemplate retrieveMailTemplate(TemplateType templateType);
}
