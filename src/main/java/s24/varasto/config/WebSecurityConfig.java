package s24.varasto.config;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import s24.varasto.web.UserDetailServiceImpl;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig  {
	@Autowired
	private UserDetailServiceImpl userDetailsService;

   @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.addAllowedOrigin("https://syntaxsynergy.github.io"); // URL sallittu tekemään pyyntöjä tälle palvelimelle
        corsConfig.addAllowedMethod("*"); //Antaa luvan kaikille HTTP  pyynnöille (GET, POST, etc.)
        corsConfig.addAllowedHeader("*"); // HTTP-otsikot ovar sallittuja pyynnöstä
        corsConfig.setAllowCredentials(true); // Evästeiden ja HTTP-autentikoinnin, lähettämisen pyynnöissä

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig); // CORS policy kaikille endpointeille
        return new CorsFilter(source);
    }



	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {

		http
		
		.csrf(csrf -> csrf.disable()
		)
		.authorizeHttpRequests(authorize -> authorize
		        .requestMatchers(antMatcher("/")).permitAll() 
				.requestMatchers(antMatcher("/css/**")).permitAll()
				.requestMatchers(antMatcher("/api/users/**")).permitAll()
				.requestMatchers(antMatcher("/api/asiakases")).permitAll()
				.requestMatchers(antMatcher("/api/asiakases/{id}")).permitAll()
				.requestMatchers(antMatcher("/api/tuotes")).permitAll()
				.requestMatchers(antMatcher("/api/tuotes/{id}")).permitAll()
				.requestMatchers(antMatcher("/api/tilaukses")).permitAll()
				.requestMatchers(antMatcher("/api/**")).permitAll()
				.requestMatchers(antMatcher("/tuotteetrest")).permitAll()
				.requestMatchers(antMatcher("/tuote/{id}")).permitAll()
				.requestMatchers(antMatcher("/valmistajatrest")).permitAll()
				.requestMatchers(antMatcher("/valmistaja/{id}")).permitAll()
			.anyRequest().authenticated()
		)
		
		.headers(headers -> headers
				.frameOptions(frameoptions -> 
				frameoptions.disable() 		
				)
		)
		.formLogin(formlogin -> formlogin
				.loginPage("/login")
				.defaultSuccessUrl("/index", true) //Menee index sivulle kun login on suoritettu
				.permitAll()
		)
		.logout(logout -> logout
				.permitAll()
		);
				
		return http.build();
	}
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}}