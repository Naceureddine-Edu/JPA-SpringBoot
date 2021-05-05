package ma.myproject.JPASpringBoot.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("user1").password("{noop}1234").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("ADMIN");
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//http.formLogin().loginPage("/login"); Notre Propre page de login
		http.formLogin(); // utiliser la page login fournit par default
		
		// toute les actions http require une identification
		http.authorizeRequests().anyRequest().authenticated();
	}
}
