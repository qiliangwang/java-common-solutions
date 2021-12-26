package commonsolutions.notification.entity;

import java.util.Objects;
import java.util.UUID;

public class MeetingId implements Identity {

    private String value;

    public MeetingId(String value) {
        this.value = value;
    }

    public static MeetingId from(String value) {
        return new MeetingId(value);
    }

    public static MeetingId next() {
        return new MeetingId(UUID.randomUUID().toString());
    }

    @Override
    public String value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeetingId that = (MeetingId) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}