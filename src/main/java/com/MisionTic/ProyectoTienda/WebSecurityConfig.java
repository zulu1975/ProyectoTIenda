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


     // @Override
      /**protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/index").permitAll()
                .antMatchers("/views/enterprise/crear").hasAnyRole("USER")
                .antMatchers("/views/transaction/crear").hasAnyRole("USER")
                .antMatchers("/views/employe/crear").hasAnyRole("USER")
                .antMatchers("/views/enterprise/editar/{id}").hasAnyRole("USER")
                .antMatchers("/views/transaction/edit/{id}").hasAnyRole("USER")
                .antMatchers("/views/employe/editar/{id}").hasAnyRole("USER")
                .antMatchers("/views/enterprise/eliminar/{id}").hasAnyRole("USER")
                .antMatchers("/views/transaction/delete/{id}").hasAnyRole("USER")
                .antMatchers("/views/employe/eliminar/{id}").hasAnyRole("USER")
                //.antMatchers("/views/enterprise/").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll();
     } **/
    @Autowired
   public void configurerSecurityGlobal(AuthenticationManagerBuilder builder) throws Exception{
        builder.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passEncoder)
                .usersByUsernameQuery("SELECT username, password, estado FROM usuarios WHERE username=?")
                .authoritiesByUsernameQuery("SELECT u.username, r.rol FROM rol r INNER JOIN usuarios u ON r.user_id = u.id WHERE u.username=?");




   }
}
