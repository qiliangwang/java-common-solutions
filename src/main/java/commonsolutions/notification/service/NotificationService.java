package commonsolutions.notification.service;

import commonsolutions.notification.composer.MailTemplate;
import commonsolutions.notification.composer.TemplateType;
import commonsolutions.notification.domain.Notification;
import commonsolutions.notification.exceptions.MailTemplateException;
import commonsolutions.notification.composer.VariableContext;
import commonsolutions.notification.domain.NotificationClient;
import commonsolutions.notification.exceptions.TrainingException;
import commonsolutions.notification.exceptions.ValidDateException;
import commonsolutions.notification.repository.MailTemplateRepository;
import commonsolutions.notification.repository.TrainingRepository;
import commonsolutions.notification.repository.ValidDateRepository;

import java.util.Optional;

public class NotificationService {

    private MailTemplateRepository templateRepository;

    private NotificationClient notificationClient;

    private TrainingRepository trainingRepository;

    private ValidDateRepository validDateRepository;

    public void notifyNominee(Ticket ticket, Nominator nominator, Nominee nominee) {

        Training training = retrieveTraining(ticket);
        ValidDate validDate = retrieveValidDate(ticket);

        //build context
        VariableContext variableContext = buildVariableContext(ticket, nominator, nominee, training, validDate);
        //生成模板
        MailTemplate mailTemplate = retrieveMailTemplate();
        Notification notification = mailTemplate.compose(variableContext);
        //发送消息
        notificationClient.send(notification);
    }

    private MailTemplate retrieveMailTemplate() {
        Optional<MailTemplate> optionalMailTemplate = templateRepository.templateOf(TemplateType.Nomination);
        String mailTemplateNotFoundMessage = String.format("mail template by %s was not found.", TemplateType.Nomination);
        return optionalMailTemplate.orElseThrow(() -> new MailTemplateException(mailTemplateNotFoundMessage));
    }

    private Training retrieveTraining(Ticket ticket) {
        Optional<Training> optionalTraining = trainingRepository.trainingOf(ticket.trainingId());
        String trainingNotFoundMessage = String.format("training by id {%s} was not found.", ticket.trainingId());
        return optionalTraining.orElseThrow(() -> new TrainingException(trainingNotFoundMessage));
    }

    private ValidDate retrieveValidDate(Ticket ticket) {
        Optional<ValidDate> optionalValidDate = validDateRepository.validDateOf(ticket.trainingId(), ValidDateType.PODeadline);
        String validDateNotFoundMessage = String.format("valid date by training id {%s} was not found.", ticket.trainingId());
        return optionalValidDate.orElseThrow(() -> new ValidDateException(validDateNotFoundMessage));
    }

    private VariableContext buildVariableContext(Ticket ticket, Nominator nominator, Nominee nominee, Training training, ValidDate validDate) {
        return new VariableContext()
                .put("ticket", ticket)
                .put("training", training)
                .put("valid_date", validDate)
                .put("nominator", nominator)
                .put("nominee", nominee);
    }
}