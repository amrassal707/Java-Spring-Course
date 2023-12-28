package com.luv2code.springboot.cruddemo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.net.http.HttpRequest;

@Configuration // lets springboot know that this class will have @Bean methods defined so spring can generate beans
public class DemoSecurityConfig {



    @Bean // spring will inject our data source autoconfig
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource); // spring security will use JDBCAUTH with our dataSource
   // follow spring security schema design, so it will be able to do all the heavy lifting for you
    }

    //authorization rules
    @Bean // it's a bean registered in spring security dependency to authorize roles
    // HTTP security  It allows configuring web based security for specific http request
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
                configurer -> configurer
                        .requestMatchers(HttpMethod.GET , "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET , "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.PUT , "/api/employees/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST , "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE , "/api/employees/**").hasRole("ADMIN")
        );
        // we are using basic auth
        httpSecurity.httpBasic();

        // disable CSRF . not required for stateless api
        httpSecurity.csrf().disable();
        return httpSecurity.build(); // return the given info above

    }
}
