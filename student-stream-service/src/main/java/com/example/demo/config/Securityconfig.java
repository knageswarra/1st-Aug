package com.example.demo.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

import static org.springframework.security.config.Customizer.withDefaults;


/**@EnableWebSecurity
public class Securityconfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();
	}

}**/
@EnableWebSecurity
public class Securityconfig {

	/**@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests().anyRequest().authenticated().and().httpBasic(withDefaults());
        http.cors().disable();
        http.csrf().disable();
		return http.build();
	}**/
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {

		UserDetails john = User.builder().username("john").password("{noop}test123").roles("EMPLOYEE").build();

		UserDetails mary = User.builder().username("mary").password("{noop}test123").roles("EMPLOYEE", "MANAGER")
				.build();

		UserDetails susan = User.builder().username("susan").password("{noop}test123")
				.roles("EMPLOYEE", "MANAGER", "ADMIN").build();

		return new InMemoryUserDetailsManager(john, mary, susan);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(configurer -> configurer.antMatchers(HttpMethod.GET, "/streams").hasRole("EMPLOYEE").
				antMatchers(HttpMethod.GET, "/streams/**").hasRole("EMPLOYEE")
				.antMatchers(HttpMethod.POST, "/streams").hasRole("MANAGER")
				.antMatchers(HttpMethod.PUT, "/streams").hasRole("MANAGER")
				.antMatchers(HttpMethod.DELETE, "/streams/**").hasRole("ADMIN"));
		http.httpBasic();
		http.cors().disable();
		http.csrf().disable();
		return http.build();
	}
}
