package com.MisionTic.ProyectoTienda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
   @Autowired
    private DataSource dataSource;

   @Autowired
    private BCryptPasswordEncoder passEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().mvcMatchers("/").permitAll()
                .antMatchers("/views/enterprise/").hasAnyRole("USER")
                .antMatchers("/views/enterprise/crear").hasAnyRole("ADMIN");
    }

    @Autowired
   public void configurerSecurityGlobal(AuthenticationManagerBuilder builder) throws Exception{
        builder.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passEncoder)
                .usersByUsernameQuery("SELECT username, password, estado FROM usuarios WHERE username=?")
                .authoritiesByUsernameQuery("SELECT u.username, r.rol FROM rol r INNER JOIN usuarios u ON r.user_id = u.id WHERE u.username=?");




   }
}
