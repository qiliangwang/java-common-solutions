package commonsolutions.design.notification.entity;

import java.util.Objects;
import java.util.UUID;

public class ResearchId {
    private String value;

    private ResearchId(String value) {
        this.value = value;
    }

    public static ResearchId next() {
        return new ResearchId(UUID.randomUUID().toString());
    }

    public static ResearchId from(String value) {
        return new ResearchId(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResearchId ticketId = (ResearchId) o;
        return value.equals(ticketId.value);
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