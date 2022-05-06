package tn.pi.spring.secutiry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.AllArgsConstructor;
import tn.pi.spring.service.AppUserService;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private final UserDetailsService  userDetailsService;
	private final BCryptPasswordEncoder  bCryptPasswordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		/*CustomAuthentificationFilter customAuthentificationFilter = new CustomAuthentificationFilter(authenticationManagerBean());
		customAuthentificationFilter.setFilterProcessesUrl("/SpringMVC/login");*/
		// http
	        //.logout()
	        //.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"));
	http.csrf().disable();
	http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	http.authorizeRequests().antMatchers("/registration/**").permitAll(); 
	http.authorizeRequests().antMatchers("/login/**").permitAll();
	//http.authorizeRequests().antMatchers(HttpMethod.GET,"/user/getUsers/**").hasAnyAuthority("USER");
	//http.authorizeRequests().antMatchers(HttpMethod.GET,"/user/findByEmail/**").hasAnyAuthority("Parent");
	//http.authorizeRequests().anyRequest().authenticated();
    //http.addFilter(new CustomAuthentificationFilter(authenticationManager()));
	//http.addFilterBefore(new CustomAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);
	}
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManager();
	}
	
	
	/*@Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(daoAuthenticationProvider());
	    } 
	 @Bean
	    public DaoAuthenticationProvider daoAuthenticationProvider() {
	        DaoAuthenticationProvider provider =
	                new DaoAuthenticationProvider();
	        provider.setPasswordEncoder(bCryptPasswordEncoder); 
	        provider.setUserDetailsService(appUserService);
	        return provider;
	    }
	*/
	   /* @Bean
	    public HttpFirewall defaultHttpFirewall() {
	        return new DefaultHttpFirewall();
	    }*/
}

