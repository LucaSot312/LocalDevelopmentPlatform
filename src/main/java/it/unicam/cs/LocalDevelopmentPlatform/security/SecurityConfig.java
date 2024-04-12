package it.unicam.cs.LocalDevelopmentPlatform.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers("/**").permitAll()
                //TODO dopo aver messo secured i metodi di tutti tranne turista se non funziona rimetti il tag turista
                // al controller base e anche qui per lasciare quei 4 metodi base disponibili
                .anyRequest().authenticated()
                .and()
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults());
        return http.build();

    }

}
