package ttps.test;


import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

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
        
        
        UserServiceImpl userService = context.getBean(UserServiceImpl.class);
        CategoryServiceImpl categoryService = context.getBean(CategoryServiceImpl.class);


        
        categoryService.save(new Category("Arte"));
        categoryService.save(new Category("Música"));
        categoryService.save(new Category("Noticias"));
        categoryService.save(new Category("Deporte"));
        categoryService.save(new Category("Humor"));
        
        userService.save(new User("admin","admin",Gender.MALE,"admin@email.com","argentina","16/02/1988","profesion", Role.ADMIN,"admin","admin"));
        userService.save(new User("moderator","moderator",Gender.MALE,"moderator@email.com","argentina","16/02/1988","profesion", Role.MODERATOR,"moderator","moderator"));
        userService.save(new User("student","student",Gender.MALE,"student@email.com","argentina","16/02/1988","profesion", Role.STUDENT,"student","student"));
        userService.save(new User("guest","guest",Gender.MALE,"guest@email.com","argentina","16/02/1988","profesion", Role.GUEST,"guest","guest"));

                
        
        context.close();
	}

}
