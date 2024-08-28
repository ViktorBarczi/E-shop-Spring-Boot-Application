package application.security;

import java.time.Instant;
import java.util.stream.Collectors;

import application.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtAuthenticationResource {

    private JwtEncoder jwtEncoder;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    public JwtAuthenticationResource(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    @PostMapping("/authenticate")
    public JwtRespose authenticate(Authentication authentication) {
        LOGGER.info("Authenticating user" );
        return new JwtRespose(createToken(authentication));
    }

    private String createToken(Authentication authentication) {
        var claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plusSeconds(2))
                .subject(authentication.getName())
                .claim("scope", createScope(authentication))
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims))
                .getTokenValue();
    }

    private String createScope(Authentication authentication) {
        return authentication.getAuthorities().stream()
                .map(a -> a.getAuthority())
                .collect(Collectors.joining(" "));
    }

}

record JwtRespose(String token) {}
