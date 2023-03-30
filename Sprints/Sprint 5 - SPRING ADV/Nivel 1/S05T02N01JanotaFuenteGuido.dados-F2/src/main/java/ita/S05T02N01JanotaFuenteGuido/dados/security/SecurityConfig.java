package ita.S05T02N01JanotaFuenteGuido.dados.security;


import ita.S05T02N01JanotaFuenteGuido.dados.security.jwt.JwtSecurityFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	//Reemplazo de `extends WebConfigurerAdapter' (versiones anteriores de Spring)
	//SecurityFilterChain -> Filtro que maneja la autorización
	@Bean
	public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
		http
				.csrf().disable()		//Deshabilita protección CSRF porque se usa JWT para autenticación y autorización
				.exceptionHandling().authenticationEntryPoint(  //Retorna UNAUTHORIZED si hay error durante proceso de autenticación
						(request, response, ex) -> {
							response.sendError(
									HttpServletResponse.SC_UNAUTHORIZED,
									ex.getMessage());
						}
				)
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Sin sesiones de usuario en servidor
				.and()
				.authorizeRequests()
				.requestMatchers("/api/auth/**").permitAll()
				.anyRequest().authenticated();
		http.addFilterBefore(jwtSecurityFilter(), UsernamePasswordAuthenticationFilter.class); 	//Filtro personalizado (donde va el token)
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





