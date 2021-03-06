package ttps.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.*;

import ttps.model.Role;
import ttps.security.CustomAuthenticationProvider;

/**
 * Reference
 * http://docs.spring.io/spring-security/site/docs/3.2.0.RC2/reference/htmlsingle/
 * http://spring.io/blog/2013/07/03/spring-security-java-config-preview-web-security/#web-security-hellowebsecurityconfiguration
 * http://aykutakin.wordpress.com/2013/07/08/spring-security-spring-custom-authentication-provider/
 * 
 * Custom form login
 * http://www.srccodes.com/p/article/35/spring-security-custom-login-form-example
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
         	//authorizeRequests for css and javascript bootstrap
         	.antMatchers("/struts/**").permitAll()
         	.antMatchers("/tagsinputs/**").permitAll()
         	.antMatchers("/index").permitAll()
			.antMatchers("/").permitAll()
			.antMatchers("/user/register**").permitAll()
			.antMatchers("/login**").permitAll()
			.antMatchers("/logout*").permitAll()
			.antMatchers("/logout*").permitAll()
			.antMatchers("/post/view**").permitAll()
			
			
			.antMatchers("/post/create**").hasAnyAuthority(	Role.ADMIN.getAuthority(),
															Role.MODERATOR.getAuthority(),
															Role.STUDENT.getAuthority())
			
			.antMatchers("/post/edit**").hasAnyAuthority(	Role.ADMIN.getAuthority(),
															Role.MODERATOR.getAuthority(),
															Role.STUDENT.getAuthority())
															
			.antMatchers("/user/edit**").hasAuthority(	Role.ADMIN.getAuthority())
			
			.antMatchers("/user/list**").hasAnyAuthority(	Role.ADMIN.getAuthority(),
															Role.MODERATOR.getAuthority())
															
//			.antMatchers("/post/create**").hasAuthority(Role.MODERATOR.getAuthority())
//			.antMatchers("/post/create**").hasAuthority(Role.STUDENT.getAuthority())
//			.antMatchers("/post/create-processing**").hasAuthority(Role.ADMIN.getAuthority())
//			.antMatchers("/post/create-processing**").hasAuthority(Role.MODERATOR.getAuthority())
//			.antMatchers("/post/create-processing**").hasAuthority(Role.STUDENT.getAuthority())

			
			.anyRequest().permitAll()
			.and()
         .formLogin()
             .permitAll();

		 //custom form login
		 http.formLogin()
		 	.loginPage("/login").loginProcessingUrl("/login-processing")
		 	.failureUrl("/login?auth=fail").defaultSuccessUrl("/index")
		 	.usernameParameter("username")
		 	.passwordParameter("password")
		 	.and()
		 		.logout().logoutSuccessUrl("/index");

    }
}