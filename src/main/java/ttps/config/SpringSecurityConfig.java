package ttps.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.*;

import ttps.security.CustomAuthenticationProvider;

/**
 * Reference
 * http://docs.spring.io/spring-security/site/docs/3.2.0.RC2/reference/htmlsingle/
 * http://spring.io/blog/2013/07/03/spring-security-java-config-preview-web-security/#web-security-hellowebsecurityconfiguration
 * http://aykutakin.wordpress.com/2013/07/08/spring-security-spring-custom-authentication-provider/
 * 
 * 
 * @author mclo
 *
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	CustomAuthenticationProvider customAuthenticationProvider;

    /**
     * Simple example
     *  auth
     *      .inMemoryAuthentication()
     *          .withUser("user").password("password").roles("USER");
     * 
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthenticationProvider);

    }

	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.WebSecurity)
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		//agrego para que ignore la url (probando..)
		//web.ignoring().antMatchers("/listUser");
		//web.ignoring().antMatchers("/registroInvitados");
	}
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		 http
         .csrf()
             .disable()
         .authorizeRequests()
             .antMatchers("/registroInvitados*").permitAll()
             .antMatchers("/register**").permitAll()
             .antMatchers("/login**").permitAll()
             .antMatchers("/logout*").permitAll()
             .antMatchers("/listUser*").hasAuthority("ADMIN")
             .anyRequest().authenticated()
             .and()
         .formLogin()
             .permitAll();
     

    }
}