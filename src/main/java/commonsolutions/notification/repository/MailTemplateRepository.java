package commonsolutions.notification.repository;

import commonsolutions.notification.render.MailTemplate;
import commonsolutions.notification.render.TemplateType;

import java.util.Optional;


public interface MailTemplateRepository {

    Optional<MailTemplate> templateOf(TemplateType templateType);

    MailTemplate retrieveMailTemplate(TemplateType templateType);
}
