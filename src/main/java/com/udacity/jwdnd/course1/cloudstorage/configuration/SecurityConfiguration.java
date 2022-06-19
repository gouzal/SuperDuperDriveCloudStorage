package com.udacity.jwdnd.course1.cloudstorage.configuration;

import com.udacity.jwdnd.course1.cloudstorage.service.AuthService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final AuthService authService;

    public SecurityConfiguration(AuthService authService) {
        this.authService = authService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(this.authService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/signup", "/css/**", "/js/**", "/h2/**").permitAll()
                .anyRequest().authenticated();

        http.formLogin()
                .loginPage("/login")
                .permitAll().and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .clearAuthentication(true)
                .permitAll();
        http.formLogin()
                .defaultSuccessUrl("/home", true)
                .failureUrl("/login?error=true");
        http.csrf()
                .ignoringAntMatchers("/h2/**");
        http.headers().frameOptions().sameOrigin();

//      http.formLogin()
//                .defaultSuccessUrl("/home", true);
//	http.csrf().disable();
    }

}
