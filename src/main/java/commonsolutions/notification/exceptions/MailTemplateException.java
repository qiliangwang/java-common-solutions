package commonsolutions.notification.exceptions;

import commonsolutions.notification.exceptions.DomainException;

public class MailTemplateException extends DomainException {
    public MailTemplateException(String message) {
        super(message);
    }
}