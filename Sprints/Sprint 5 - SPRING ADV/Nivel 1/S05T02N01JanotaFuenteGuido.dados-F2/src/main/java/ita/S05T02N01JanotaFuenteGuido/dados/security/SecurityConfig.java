package ita.S05T02N01JanotaFuenteGuido.dados.security;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//SecurityFilterChain-> Filtro que maneja la autorizacion
//UserDetailService -> Administrador de credenciales de Usuario

@Configuration
@EnableWebSecurity
//@EnableMethodSecurity
public class SecurityConfig {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private JwtAuthEntryPoint authEntryPoint;


	//Reemplazo de `extends WebConfigurerAdapter' (versiones anteriores de Spring)
	@Bean
	public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.exceptionHandling()
				.authenticationEntryPoint(authEntryPoint)
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests()
				.requestMatchers("/api/auth/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.httpBasic();
		http.addFilterBefore(jwtSecurityFilter(), UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

	@Bean
	public AuthenticationManager authenticationManager(
			AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public JwtSecurityFilter jwtSecurityFilter(){
		return new JwtSecurityFilter();
	}


//	//**Usuarios en Memoria**
//	@Bean
//	public UserDetailsService users() {
//		UserDetails admin = User.builder()
//				.username("admin")
//				.password(passwordEncoder().encode("admin"))
//				.roles("ADMIN")
//				.build();
//
//		UserDetails user = User.builder()
//				.username("user")
//				.password(passwordEncoder().encode("user"))
//				.roles("USER")
//				.build();
//
//		return new InMemoryUserDetailsManager(admin,user);
//	}
}









