package br.cesed.si.lsi.security.springsecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Matheus").password("{noop}teste123").roles("CORRENTISTA");
        auth.inMemoryAuthentication().withUser("Henrique").password("{noop}teste123").roles("CORRENTISTA", "GERENTE");
        auth.inMemoryAuthentication().withUser("Silva").password("{noop}teste123").roles("CORRENTISTA", "GERENTE");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().
        
                realmName("spring-app").
                and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
                and().csrf().disable().
                authorizeRequests().antMatchers("/guest/**").permitAll().
                anyRequest().authenticated();
    }
}
