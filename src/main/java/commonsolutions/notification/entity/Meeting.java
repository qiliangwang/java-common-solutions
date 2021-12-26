package commonsolutions.notification.entity;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Meeting {
    private MeetingId id;
    private String title;
    private String description;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;
    private String place;

    public Meeting(String title, String description, LocalDateTime beginTime, LocalDateTime endTime, String place) {
        this(MeetingId.from(UUID.randomUUID().toString()), title, description, beginTime, endTime, place);
    }

    public Meeting(MeetingId id, String title, String description, LocalDateTime beginTime, LocalDateTime endTime, String place) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.place = place;
    }
}