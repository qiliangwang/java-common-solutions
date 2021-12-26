package commonsolutions.notification.entity;

import lombok.Getter;

@Getter
public class Nominee {
    private String employeeId;
    private String name;
    private String email;

    public Nominee(String employeeId, String name, String email) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
    }
}