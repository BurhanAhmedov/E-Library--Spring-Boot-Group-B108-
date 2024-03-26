/*
package az.divacademy.springbootb108.config;

import static org.springframework.security.config.Customizer.withDefaults;

import az.divacademy.springbootb108.service.impl.UserInfoDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableMethodSecurity
@Configuration
public class SecurityConfig {

  @Autowired
  private UserInfoDetailsService userService;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http.authorizeHttpRequests(
            auth -> auth.requestMatchers("/api/v1/book/all", "/api/v1/book/{id}",
                    "/api/v1/user/register").permitAll()
                .anyRequest().authenticated()

        ).httpBasic(withDefaults())
        .formLogin(withDefaults())
        .csrf(AbstractHttpConfigurer::disable)
        .authenticationProvider(provider());
    return http.build();
  }

  @Bean
  public AuthenticationProvider provider() {
    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
    daoAuthenticationProvider.setUserDetailsService(userService);
    return daoAuthenticationProvider;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }


}
*/
