package ru.artsok.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcDaoImpl jdbcDao;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("admin").password("321").roles("ADMIN");
//        auth.inMemoryAuthentication().withUser("user").password("123").roles("USER");
        auth.userDetailsService(jdbcDao);

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/menu/admin").access("hasRole('ROLE_ADMIN')")
                .and().formLogin()
                .loginPage("/menu/login")
                .defaultSuccessUrl("/menu/welcome_page")
                .failureForwardUrl("/menu/login?error=true")
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .csrf().disable();
    }
}
