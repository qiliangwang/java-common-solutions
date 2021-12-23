package commonsolutions.notification.service;

import commonsolutions.notification.exceptions.TicketException;

public class Ticket {
    private TicketId id;
    private TrainingId trainingId;
    private TicketStatus ticketStatus;
    private String nomineeId;

    public Ticket(TicketId id, TrainingId trainingId) {
        this(id, trainingId, TicketStatus.Available, null);
    }

    public Ticket(TicketId id, TrainingId trainingId, TicketStatus ticketStatus) {
        this(id, trainingId, ticketStatus, null);
    }

    public Ticket(TicketId id, TrainingId trainingId, TicketStatus ticketStatus, String nomineeId) {
        this.id = id;
        this.trainingId = trainingId;
        this.ticketStatus = ticketStatus;
        this.nomineeId = nomineeId;
    }


    private void validateTicketStatus() {
        if (!ticketStatus.isAvailable()) {
            throw new TicketException("ticket is not available, cannot be nominated.");
        }
    }

    public TicketStatus status() {
        return ticketStatus;
    }

    public String nomineeId() {
        return nomineeId;
    }

    public TicketId id() {
        return this.id;
    }

    public String url() {
        return String.format("http://www.eas.com/eas/tickets/%s", this.id().value());
    }

    public TrainingId trainingId() {
        return trainingId;
    }
}