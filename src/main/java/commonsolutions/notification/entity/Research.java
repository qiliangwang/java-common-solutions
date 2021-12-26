package commonsolutions.notification.entity;

import lombok.Getter;

@Getter
public class Research {
    private ResearchId researchId;
    private String nomineeId;

    public Research() {
        this(null);
    }

    public Research(String nomineeId) {
        this(ResearchId.next(), nomineeId);
    }

    public Research(ResearchId researchId, String nomineeId) {
        this.researchId = researchId;
        this.nomineeId = nomineeId;
    }

    public String url() {
        return String.format("http://www.ice.com/research/%s", this.getResearchId().value());
    }
}