package commonsolutions.notification.service;

import java.time.LocalDateTime;
import java.util.UUID;

public class ValidDate {
    private String id;
    private TrainingId trainingId;
    private LocalDateTime deadline;
    private ValidDateType validDateType;

    public ValidDate(TrainingId trainingId, LocalDateTime deadline, ValidDateType validDateType) {
        this(UUID.randomUUID().toString(), trainingId, deadline, validDateType);
    }

    public ValidDate(String id, TrainingId trainingId, LocalDateTime deadline, ValidDateType validDateType) {
        this.id = id;
        this.trainingId = trainingId;
        this.deadline = deadline;
        this.validDateType = validDateType;
    }

    public LocalDateTime deadline() {
        return this.deadline;
    }
}