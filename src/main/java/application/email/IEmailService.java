package application.email;

import application.product.Product;

import java.util.List;


public interface IEmailService {
    List<Email> getAll();
    Email createNewEmail(EmailRequest request);
    Email getEmail(Long id);
    Email updateEmail(Long id, EmailRequest request);
    void deleteEmail(Long id);
    void deleteAll();
}
