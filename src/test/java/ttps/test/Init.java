package ttps.test;


import java.util.ArrayList;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import ttps.config.WebAppConfig;
import ttps.model.*;
import ttps.service.impl.*;

public class Init {

	/**
	 * Metodo para inicializar la base de datos
	 * @param args
	 */
	public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(WebAppConfig.class);
        UserService userService = context.getBean(UserService.class);
        
        
        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(new Role("ADMIN"));
        
        userService.save(
        new User("user1"));
        
        ArrayList<Role> roles2 = new ArrayList<Role>();
        roles2.add(new Role("MODERATOR"));
        userService.save(
                new User("user2"));
                
        
        context.close();
	}

}
