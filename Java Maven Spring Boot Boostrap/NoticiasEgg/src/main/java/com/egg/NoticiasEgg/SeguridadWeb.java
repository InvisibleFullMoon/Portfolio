
package com.egg.NoticiasEgg;

import com.egg.NoticiasEgg.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//Configuraciones necesarias para aplicar seguridad al sistema
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SeguridadWeb extends WebSecurityConfigurerAdapter {
    
    @Autowired
    public UsuarioServicio usuarioServicio;
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(usuarioServicio)
                .passwordEncoder(new BCryptPasswordEncoder());
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests()
                     .antMatchers("/noticias/admin").hasAnyRole("ADMIN", "PERIODISTA")
                     .antMatchers("/css/*","/js/*","/img/*","/**")
                     .permitAll()
                .and().formLogin() //formulario de login
                     .loginPage("/login") //lugar donde se encuentra el formulario de login
                     .loginProcessingUrl("/logincheck") // url con la que spring security verifica al usuario
                     .usernameParameter("email") //parametro de nombre de usuario
                     .passwordParameter("password") //parametro de contraseña del usuario
                     .defaultSuccessUrl("/") //a donde redirige la pagina cuando el inicio de sesion es exitoso
                     .permitAll()
                .and().logout()
                     .logoutUrl("/logout") //url que cierra la session
                     .logoutSuccessUrl("/login") //url donde se redirige la pagina si el logout es exitoso
                     .permitAll()
                .and().csrf()
                     .disable();
    }
}
