package ec.sasf.mscomppruebaAndreVelastegui.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import ec.sasf.mscomppruebaAndreVelastegui.services.jwt.JwtRequestFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
// @PropertySource("classpath:/application.properties")
public class WebSecurityConfig {

    @Autowired
    private JwtRequestFilter requestFilter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http.csrf().disable()
        .authorizeHttpRequests()
        .requestMatchers( "/authenticate", "/company/sign-up", "/client/sign-up", "/ads", "/search/{service}").permitAll()
        .and().authorizeHttpRequests().requestMatchers("/api/**")
        .authenticated().and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .addFilterBefore( requestFilter, UsernamePasswordAuthenticationFilter.class).build();
    }

    // @Bean    
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //     return http.csrf(csrf -> csrf.disable())
    //         .authorizeHttpRequests(authorize -> authorize
    //                         .antMatchers("/authenticate", "/company/sign-up", "/client/sign-up", "/ads", "/search/{service}").permitAll()
    //                         .antMatchers("/api/**").authenticated()
    //         )
    //         .sessionManagement(session -> session
    //                         .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    //         )
    //         .addFilterBefore(requestFilter, UsernamePasswordAuthenticationFilter.class)
    //         .build();
    // }

        

    @Bean
    public AuthenticationManager authenticationManager( AuthenticationConfiguration config ) throws Exception{
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    
}
