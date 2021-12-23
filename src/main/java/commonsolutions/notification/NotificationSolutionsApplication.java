package commonsolutions.notification;

import commonsolutions.notification.composer.MailTemplate;
import commonsolutions.notification.composer.TemplateType;
import commonsolutions.notification.composer.VariableNames;
import commonsolutions.notification.composer.VariableContext;
import commonsolutions.notification.domain.Notification;
import commonsolutions.notification.service.*;

import java.time.LocalDateTime;

public class NotificationSolutionsApplication {

    public static void main(String[] args) {
        new NotificationSolutionsApplication().run();
    }

    /**
     *这里简单罗列一下几个场景吧（实际的业务会更加的复杂）
     *
     * 提名成功
     *
     * ```
     * 看看二（名花二十一），您好：
     * 恭喜您被提名参与本次晋升！
     * ```
     *
     * 参加晋升会议
     *
     * ```
     * 哈哈五（名花十九），您好： (评委 )
     * 何久度（啊一） 邀请您参加 看八（名花二十一）（被提名人） 的晋升会议，以下是合议的时间与地点，希望您能准时出席。
     * 时间：2021/12/23 11:51 - 16:51
     * 地点：上海市 普陀区 近铁城市广场北座 17楼
     * ```
     *
     * 调研邮件
     *
     * ```
     * 看八（名花二十一），您好：（被提名人信息）
     * 刚参加完晋升面试，感觉如何？一路走来希望您有收获，有成长。
     * 诚邀您对本次晋升评审安排进行评价，以指导后续晋升工作调优。所有评价反馈匿名使用，请您放心填写！感谢亲的支持！
     * 点此评价：
     * ```
     *
     * 晋升成功
     *
     * ```
     * 却书是（花名五），您好：
     * 恭喜你晋升啦！
     * ```
     */
    public void run() {

        //分为这几个场景吧 1. 提名成功
        Nominator nominator = createNominator();
        Nominee nominee = createNominee();
        TrainingId trainingId = TrainingId.next();
        Training training = createTraining(trainingId);
        ValidDate validDate = createValidDate(trainingId);
        Ticket ticket = createTicket();

        String template = buildTemplate();
        VariableContext context = buildVariableContext(nominator, nominee, validDate, training, ticket);

        MailTemplate mailTemplate = new MailTemplate(template, TemplateType.Nomination);
        Notification notification = mailTemplate.compose(context);
        System.out.println(notification);
    }

    /**
     * 提名成功
     * 看看二（花名），您好：
     * 恭喜您被参与本次晋升！
     */
    private void nomiSuccess(){

    }

    /**
     * 提名成功
     * 看看二（花名），您好：
     * 恭喜您被参与本次晋升！
     */
    private void openInterview() {

    }

    private Ticket createTicket() {
        return new Ticket(TicketId.next(), TrainingId.next());
    }

    private Training createTraining(TrainingId trainingId) {
        CourseId courseId = CourseId.next();
        LocalDateTime beginTime = LocalDateTime.of(2020, 1, 8, 9, 0);
        LocalDateTime endTime = LocalDateTime.of(2020, 1, 9, 17, 0);
        String place = "London Room";
        return new Training(trainingId, "ddd", "ddd training", beginTime, endTime, place, courseId);
    }

    private ValidDate createValidDate(TrainingId trainingId) {
        LocalDateTime poDeadline = LocalDateTime.of(2019, 12, 20, 0, 0);
        return new ValidDate(trainingId, poDeadline, ValidDateType.PODeadline);
    }

    private Nominee createNominee() {
        return new Nominee("201001010011", "zhangyi", "zhangyi@eas.com");
    }

    private Nominator createNominator() {
        return new Nominator("200901010010", "bruce", "bruce@eas.com", TrainingRole.Coordinator);
    }

    private VariableContext buildVariableContext(Nominator nominator, Nominee nominee, ValidDate validDate, Training training, Ticket ticket) {
        return new VariableContext()
                .put(VariableNames.TICKET, ticket)
                .put(VariableNames.TRAINING, training)
                .put(VariableNames.VALID_DATE, validDate)
                .put(VariableNames.NOMINATOR, nominator)
                .put(VariableNames.NOMINEE, nominee);
    }

    private String buildTemplate() {
        return "Hi $nomineeName$:\n" +
                "We are glad to notify that you are nominated by $nominatorName$ to attend the training. Please click the link as below to confirm this nomination before the deadline $deadline$:\n" +
                "$url$\n" +
                "\n" +
                "Here is the basic information of training:\n" +
                "Title: $title$\n" +
                "Description: $description$\n" +
                "Begin time: $beginTime$\n" +
                "End time: $endTime$\n" +
                "Place: $place$\n" +
                "\n" +
                "Thanks! We're excited to have you in the training.\n" +
                "EAS Team";
    }

}

