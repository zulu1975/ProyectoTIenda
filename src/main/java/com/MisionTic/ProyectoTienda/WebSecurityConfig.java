package com.MisionTic.ProyectoTienda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
   @Autowired
    private DataSource dataSource;

   @Autowired
    private BCryptPasswordEncoder passEnconder;

   @Autowired
   public void configurerSecurityGlobal(AuthenticationManagerBuilder builder) throws Exception{
        builder.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passEnconder)
                .usersByUsernameQuery("SELECT password,username,estado FROM usuarios WHERE username=?")
                .authoritiesByUsernameQuery("SELECT usuarios.username,rol.id FROM usuarios INNER JOIN rol ON usuarios.rol_id=rol.id WHERE rol.rol=?");




   }
}
