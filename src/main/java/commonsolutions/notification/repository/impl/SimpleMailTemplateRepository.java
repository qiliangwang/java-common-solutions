package commonsolutions.notification.repository.impl;

import commonsolutions.notification.render.MailTemplate;
import commonsolutions.notification.render.TemplateType;
import commonsolutions.notification.exceptions.MailTemplateException;
import commonsolutions.notification.repository.MailTemplateRepository;

import java.util.Optional;

public class SimpleMailTemplateRepository implements MailTemplateRepository {

    @Override
    public Optional<MailTemplate> templateOf(TemplateType templateType) {

        if (templateType == TemplateType.Nomination) {return buildMailTemplate(templateType, buildNominationTemplate());}

        if (templateType == TemplateType.Meeting) {return buildMailTemplate(templateType, buildMeetingTemplate());}

        if (templateType == TemplateType.Research) {return buildMailTemplate(templateType, buildResearchTemplate());}

        if (templateType == TemplateType.Promotion) {return buildMailTemplate(templateType, buildPromotionTemplate());}

        return Optional.empty();
    }

    @Override
    public MailTemplate retrieveMailTemplate(TemplateType templateType) {

        Optional<MailTemplate> mailTemplate = templateOf(templateType);

        String mailTemplateNotFoundMessage = String.format("mail template by %s was not found.", templateType);
        return mailTemplate.orElseThrow(() -> new MailTemplateException(mailTemplateNotFoundMessage));
    }

    private Optional<MailTemplate> buildMailTemplate(TemplateType templateType, String s) {
        return Optional.of(new MailTemplate(s, templateType));
    }


    private String buildNominationTemplate() {
        return "$nomineeName$，您好:\n" +
                "恭喜您被$nominatorName$提名参与本次晋升\n";
    }

    private String buildMeetingTemplate() {
        return "$nomineeName$，您好:\n" +
                "$nominatorName$ 邀请您参加晋升会议，以下是会议的时间与地点，希望您能准时出席\n" +
                "时间：$beginTime$ - $endTime$\n" +
                "地点：$place$\n";
    }

    private String buildResearchTemplate() {
        return "$nomineeName$，您好:\n" +
                "诚邀您对本次晋升评审安排进行评价,以指导后续工作。所有评价反馈匿名\n" +
                "点此评价：$url$\n";
    }


    private String buildPromotionTemplate() {
        return "$nomineeName$，您好:\n" +
                "恭喜你晋升啦！\n";
    }
}
