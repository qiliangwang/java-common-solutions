package commonsolutions.notification.service;

public enum TicketStatus {
    Available, WaitForConfirm, Confirm;

    public boolean isAvailable() {
        return this == Available;
    }

    public boolean isWaitForConfirm() {
        return this == WaitForConfirm;
    }
}