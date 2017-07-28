package com.venzee;

import com.venzee.model.IntegrationContext;
import com.venzee.service.IntegrationContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@RestController
@EnableOAuth2Sso
public class AdminVenzeeApplication extends WebSecurityConfigurerAdapter{

    @Autowired
    private IntegrationContextService service;

    @RequestMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }

    @RequestMapping("/integration")
    public IntegrationContext context() {return service.getIntegrationContext();}

    public static void main(String [] args){
        SpringApplication.run(AdminVenzeeApplication.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/login**", "/webjars/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and().formLogin().loginPage("/")
                .and().logout().logoutSuccessUrl("/").permitAll()
                .and().csrf().disable();
    }
}
