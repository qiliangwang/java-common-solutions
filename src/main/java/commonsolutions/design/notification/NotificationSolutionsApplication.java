package commonsolutions.design.notification;

import commonsolutions.design.notification.render.MailTemplate;
import commonsolutions.design.notification.render.TemplateType;
import commonsolutions.design.notification.render.VariableContext;
import commonsolutions.design.notification.domain.Notification;
import commonsolutions.design.notification.repository.MailTemplateRepository;
import commonsolutions.design.notification.repository.impl.SimpleMailTemplateRepository;
import commonsolutions.design.notification.entity.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public class NotificationSolutionsApplication {
    private Nominator nominator;
    private Nominee nominee;
    private Meeting meeting;
    private Research research;

    private MailTemplateRepository mailTemplateRepository;

    public static void main(String[] args) {
        new NotificationSolutionsApplication().run();
    }

    public void run() {
        setUp();
        Nomination();
        Meeting();
        Research();
        Promotion();
    }

    private Nominee createNominee() {
        return new Nominee("E111", "张三", "zhangsan@ice.com");
    }

    private Nominator createNominator() {
        return new Nominator("E222", "李四", "lisi@ice.com");
    }

    private Meeting createMeeting() {
        LocalDateTime beginTime = LocalDateTime.of(2021, 12, 1, 9, 0);
        LocalDateTime endTime = LocalDateTime.of(2020, 12, 1, 17, 0);
        String place = "上海";
        return new Meeting("晋升会议", "晋升会议请带好材料准时参加", beginTime, endTime, place);
    }

    private Research createResearch() {
        return new Research(ResearchId.from("r123"), nominee.getEmployeeId());
    }

    private void setUp() {
        nominator = createNominator();
        nominee = createNominee();
        meeting = createMeeting();
        research = createResearch();
        mailTemplateRepository = new SimpleMailTemplateRepository();
    }

    private void Nomination(){
        MailTemplate mailTemplate = mailTemplateRepository.retrieveMailTemplate(TemplateType.Nomination);
        VariableContext context = buildNominationContext(nominator, nominee);
        Notification notification = mailTemplate.render(context);
        log.info("{}", notification);
    }

    private void Meeting() {
        MailTemplate mailTemplate = mailTemplateRepository.retrieveMailTemplate(TemplateType.Meeting);
        VariableContext context = buildMeetingContext(nominator, nominee);
        Notification notification = mailTemplate.render(context);
        log.info("{}", notification);
    }

    private void Research(){
        MailTemplate mailTemplate = mailTemplateRepository.retrieveMailTemplate(TemplateType.Research);
        VariableContext context = buildResearchContext(nominator, nominee);
        Notification notification = mailTemplate.render(context);
        log.info("{}", notification);
    }

    private void Promotion() {
        MailTemplate mailTemplate = mailTemplateRepository.retrieveMailTemplate(TemplateType.Promotion);
        VariableContext context = buildPromotionContext(nominator, nominee);
        Notification notification = mailTemplate.render(context);
        log.info("{}", notification);
    }

    private VariableContext buildNominationContext(Nominator nominator, Nominee nominee) {
        return new VariableContext()
                .put(VariableContext.Names.NOMINATOR, nominator)
                .put(VariableContext.Names.NOMINEE, nominee);
    }

    private VariableContext buildMeetingContext(Nominator nominator, Nominee nominee) {
        return new VariableContext()
                .put(VariableContext.Names.NOMINATOR, nominator)
                .put(VariableContext.Names.NOMINEE, nominee)
                .put(VariableContext.Names.MEETING, meeting);
    }

    private VariableContext buildResearchContext(Nominator nominator, Nominee nominee) {
        return new VariableContext()
                .put(VariableContext.Names.NOMINATOR, nominator)
                .put(VariableContext.Names.NOMINEE, nominee)
                .put(VariableContext.Names.RESEARCH, research);
    }

    private VariableContext buildPromotionContext(Nominator nominator, Nominee nominee) {
        return new VariableContext()
                .put(VariableContext.Names.NOMINATOR, nominator)
                .put(VariableContext.Names.NOMINEE, nominee);
    }



}

