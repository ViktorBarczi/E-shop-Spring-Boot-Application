package application.email;

import application.product.IProductRepository;
import application.product.Product;
import application.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService implements  IEmailService{

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    private final IEmailRepository repository;

    public EmailService(IEmailRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Email> getAll() {
        return repository.findAll();
    }

    @Override
    public Email createNewEmail(EmailRequest request) {
        Email newEmail = new Email();
        newEmail.setEmail(request.getEmail());
        newEmail.setName(request.getName());
        newEmail.setMessage(request.getMessage());
        LOGGER.info("New email added");
        return repository.save(newEmail);
    }

    @Override
    public Email getEmail(Long id) {
        LOGGER.info("Get email with id {}", id);
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Email updateEmail(Long id, EmailRequest request) {
        Email email = repository.findById(id).orElseThrow();
        email.setEmail(request.getEmail());
        email.setName(request.getName());
        email.setMessage(request.getMessage());
        LOGGER.info("Email {} updated",id);
        return email;
    }

    @Override
    public void deleteEmail(Long id) {
        Email email = repository.findById(id).orElseThrow();
        repository.delete(email);
        LOGGER.info("Email {} deleted",id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
        LOGGER.info("All emails deleted");
    }


}
