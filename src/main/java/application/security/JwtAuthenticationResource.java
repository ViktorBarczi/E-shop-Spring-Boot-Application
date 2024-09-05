package application.security;

import java.time.Instant;

import application.exceptions.BadRequestException;
import application.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtAuthenticationResource {

    private final JwtEncoder jwtEncoder;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    private final UserDetailsService detailsService;
    private final JwtDecoder jwtDecoder;
    private final AuthenticationService authenticationService;

    @Autowired
    public JwtAuthenticationResource(JwtEncoder jwtEncoder, UserDetailsService authenticationManager , JwtDecoder jwtDecoder, AuthenticationService authenticationService) {
        this.jwtEncoder = jwtEncoder;
        this.detailsService = authenticationManager;
        this.jwtDecoder = jwtDecoder;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/authenticate")
    public JwtRespose authenticate(@RequestBody UserRequest userRequest) {
        if(authenticationService.authenticate(userRequest)) {
            return new JwtRespose(createToken());
        }
        else
            return null;
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
