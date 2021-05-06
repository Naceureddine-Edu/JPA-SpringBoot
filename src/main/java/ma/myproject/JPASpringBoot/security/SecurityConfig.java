package ma.myproject.JPASpringBoot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		PasswordEncoder passwordEncoder = passwordEncoder();
		
		auth.inMemoryAuthentication().withUser("user1")
		.password(passwordEncoder.encode("1234")).roles("USER");
		
		auth.inMemoryAuthentication().withUser("admin")
		.password(passwordEncoder.encode("1234")).roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//http.formLogin().loginPage("/login"); Notre Propre page de login
		http.formLogin(); // utiliser la page login fournit par default
		
		http.authorizeRequests().antMatchers("/form**/**",
					"/ajouterPatient**/**","/modifierPatient**/**","supprimerPatient**/**")
					.hasRole("ADMIN");
		
		// toute les actions http require une identification
				http.authorizeRequests().anyRequest().authenticated();
				
		// Pour se proteger des attaques cross site request forgerie(.disable pour la desactiver)		
				http.csrf();
				
				http.exceptionHandling().accessDeniedPage("/nonAuthoriser");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
