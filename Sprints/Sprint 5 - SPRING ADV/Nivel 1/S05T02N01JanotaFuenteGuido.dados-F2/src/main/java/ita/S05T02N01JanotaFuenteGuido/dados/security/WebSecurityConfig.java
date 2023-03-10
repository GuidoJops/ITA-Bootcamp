package ita.S05T02N01JanotaFuenteGuido.dados.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	//
	//Reemplazo de `extends WebConfigurerAdapter' (versiones anteriores de Spring)
/*	@Bean
	public SecurityFilterChain appSecurity(HttpSecurity http) throws Exception {
		http
			.cors().disable()
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // REST APIs deben ser STATELESS; por que??
			.and().formLogin().disable()
			.securityMatcher("/**")
			.authorizeHttpRequests(registry -> registry
					//.requestMatchers("/players").permitAll()
					.requestMatchers("/login").permitAll()

					.anyRequest().authenticated()
					);


		return http.build();
	}*/
	
	//UserDetailService = Administrador de credenciales de Usuario
	@Bean
	public UserDetailsService userDetalilsService() {
		UserDetails user = User.withUsername("guido")
				.password("123")
				.roles("read")
				.build();
		return new InMemoryUserDetailsManager(user);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
		return NoOpPasswordEncoder.getInstance();

	}

}
