package commonsolutions.notification.entity;

import lombok.Getter;

@Getter
public class Nominator {
    private String employeeId;
    private String name;
    private String email;

    public Nominator(String employeeId, String name, String email) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
    }
}