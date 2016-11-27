package com.loginpoc.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.loginpoc.demo.model.Account;
import com.loginpoc.demo.model.Role;
import com.loginpoc.demo.repositories.AccountRepository;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {
	
	@Autowired
	AccountRepository accountRepository;
	
	 @Autowired
	 PersistentTokenRepository repository;
	
	@Bean
	protected UserDetailsService userDetailsService() {

		return new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				Account account = accountRepository.findByUsername(username);
				if (account != null) {
					return new User(account.getUsername(), account.getPassword(), true, true, true, true,
							getGrantedAuthorities(account));
				}
				return null;
			}
		};
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()

				.antMatchers("/").permitAll()
				.antMatchers("/accounts").hasAuthority("ADMIN")
				.anyRequest().fullyAuthenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.usernameParameter("username")
				.permitAll()
				.and()
				.logout()
				.logoutUrl("/logout")
				.deleteCookies("remember-me")
				.logoutSuccessUrl("/login")
				.permitAll()
				.and()
				.rememberMe()
				.tokenRepository(repository);
		
		http.sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
	    .invalidSessionUrl("/login");
	}
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}
	
	private Collection<SimpleGrantedAuthority> getGrantedAuthorities(Account account) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		for(Role role : account.getRoles()){
			authorities.add(new SimpleGrantedAuthority(role.toString()));
		}
		return authorities;
	}
	
	
}
