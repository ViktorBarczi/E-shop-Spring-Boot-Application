package application.security;

import java.time.Instant;
import java.util.stream.Collectors;

import application.exceptions.BadRequestException;
import application.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
public class JwtAuthenticationResource {

    private JwtEncoder jwtEncoder;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    public JwtAuthenticationResource(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    @PostMapping("/authenticate")
    public JwtRespose authenticate(@RequestBody UserRequest userRequest) {
        if(userRequest.getUsername() == null || userRequest.getPassword() == null) {
            LOGGER.info("Missing username or password");
            throw new BadRequestException();
        }
        if(!userRequest.getUsername().equals("User") && !userRequest.getUsername().equals("Admin")) {
            LOGGER.info("Invalid username");
            throw new BadRequestException();
        }

        if(!userRequest.getPassword().equals("dummy")){
            LOGGER.info("Invalid password");
            throw new BadRequestException();
        }

        LOGGER.info("Authenticating user" );
        return new JwtRespose(createToken());
    }

    private String createToken() {
        var claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plusSeconds(2))
                .subject("User") //authentication.getName()
                .claim("scope", createScope())
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims))
                .getTokenValue();
    }

    private String createScope() {
//        return authentication.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.joining(" "));
        return "User Admin";
    }

}

record JwtRespose(String token) {}
