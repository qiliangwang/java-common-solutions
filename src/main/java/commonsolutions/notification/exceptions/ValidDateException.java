package commonsolutions.notification.exceptions;

import commonsolutions.notification.exceptions.DomainException;

public class ValidDateException extends DomainException {
    public ValidDateException(String message) {
        super(message);
    }
}