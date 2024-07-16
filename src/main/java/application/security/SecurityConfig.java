package application.security;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests().anyRequest().permitAll();
//        http.formLogin();
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
//        http.httpBasic();
//        http.csrf().disable();
//        return http.build();
//    }
}
