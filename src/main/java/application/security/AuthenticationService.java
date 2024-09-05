package application.security;

import application.exceptions.BadRequestException;
import application.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);


    public boolean authenticate(UserRequest userRequest) {
//        String userPassword = detailsService.loadUserByUsername("User").getPassword();
//        String adminPassword = detailsService.loadUserByUsername("Admin").getPassword();
//        userPassword = jwtDecoder.decode(userPassword).toString();
//        adminPassword = jwtDecoder.decode(adminPassword).toString();

        if(userRequest.getUsername() == null || userRequest.getPassword() == null) {
            LOGGER.info("Missing username or password ");
            throw new BadRequestException();
        }

        try {
            if (!userRequest.getUsername().equals("User") && !userRequest.getUsername().equals("Admin")) {
                LOGGER.info("Invalid username");
                throw new BadRequestException();
            }

            if (!userRequest.getPassword().equals("dummy")) {
                LOGGER.info("Invalid password");
                throw new BadRequestException();
            }
        }catch (Exception e) {
            LOGGER.error("Error");
            return false;
        }

        LOGGER.info("Authenticating user" );
        return true;
    }

}
