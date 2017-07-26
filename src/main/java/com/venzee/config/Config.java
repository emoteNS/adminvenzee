package com.venzee.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;

import java.util.List;

@EnableOAuth2Sso
@Configuration
public class Config extends WebSecurityConfigurerAdapter {

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

    @Bean
    public AuthoritiesExtractor authoritiesExtractor() {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        return map -> {
            if (map != null && map.containsKey("email")) {
                final String domain = ((String) map.get("email")).split("@")[1];
                logger.info("User domain: {}", domain);
                if (!"nearsoft.com".equals(domain)) {
                    logger.info("User domain not allowed: {}", domain);
                    throw new BadCredentialsException("User domain not allowed");
                }
                final List<GrantedAuthority> list = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
                return list;
            }
            return null;
        };
    }
}
