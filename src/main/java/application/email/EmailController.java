package application.email;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService service;

    @GetMapping()
    public List<EmailResponse> getAll() {
        return this.service.getAll().stream().map(EmailResponse::new).collect(Collectors.toList());
    }
    
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public EmailResponse addEmail(@RequestBody EmailRequest request) {
        return new EmailResponse(this.service.createNewEmail(request));
    }

    @GetMapping("/{id}")
    public EmailResponse getEmailById(@PathVariable Long id) {
        return new EmailResponse(this.service.getEmail(id));
    }

    @PutMapping("/{id}")
    public EmailResponse updateEmail(@PathVariable Long id, @RequestBody EmailRequest request) {
        return new EmailResponse(this.service.updateEmail(id, request));
    }

    @DeleteMapping("/{id}")
    public void deleteEmail(@PathVariable Long id) {
        this.service.deleteEmail(id);
    }

}
