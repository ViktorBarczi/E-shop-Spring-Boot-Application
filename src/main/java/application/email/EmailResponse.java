package application.email;

import lombok.Getter;

@Getter
public class EmailResponse {
    private String name;
    private String email;
    private String message;

    public EmailResponse(Email email) {
        if(email==null) {
            return;
        }
        this.name = email.getName();
        this.email = email.getEmail();
        this.message = email.getMessage();
    }
}
