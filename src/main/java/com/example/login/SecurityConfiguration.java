package com.example.login;

import com.example.login.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    public UserDetailsService userDetailsService;

   @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests((requests) -> {
                    ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.anyRequest()).authenticated();
                });
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());

        return (SecurityFilterChain)http.build();


    }



   /* @Bean

    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.withUsername("user1").password("{noop}aaisha").roles("USER").build();
        UserDetails user2 = User.withUsername("guest").password("{noop}maryam").roles("USER").build();
        UserDetails Admin = User.withUsername("Admin").password("{noop}admin").roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user1, user2, Admin);

    }
*/

  /*  @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(new BCryptPasswordEncoder(8));
        UserDetailsService userDetailsservice;
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }*/

}
