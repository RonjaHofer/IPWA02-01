package de.iu.ghostNetFishing.security;

import de.iu.ghostNetFishing.service.PersonenDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, PersonenDetailService personenDetailService) throws Exception {
        http
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/netzmeldung") // POST auf /netzmeldung ohne CSRF
                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/index", "/registrieren", "/login", "/info", "/netzmeldung", "/weltkarte",
                                "/datenbank", "/styles.css", "/logo.png", "/js/**")
                        .permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/datenbank", true)
                        .permitAll()
                )
                .logout(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
