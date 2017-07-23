package mywrk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import mywrk.service.MyWrkUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private MyWrkUserDetailsService userDetailsService;
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
          .authorizeRequests()
          .antMatchers("/login*").anonymous()
          .anyRequest().authenticated()
          .and()
          .formLogin()
          .loginPage("/login.html")
          .defaultSuccessUrl("/homepage.html")
          .failureUrl("/login.html?error=true")
          .and()
          .logout().logoutSuccessUrl("/login.html");
    }
}
