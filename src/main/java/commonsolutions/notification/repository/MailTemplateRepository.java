package commonsolutions.notification.repository;

import commonsolutions.notification.composer.MailTemplate;
import commonsolutions.notification.composer.TemplateType;

import java.util.Optional;


public interface MailTemplateRepository {
    Optional<MailTemplate> templateOf(TemplateType templateType);
}
