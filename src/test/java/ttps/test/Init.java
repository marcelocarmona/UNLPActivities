package ttps.test;


import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import ttps.config.WebAppConfig;
import ttps.model.*;
import ttps.service.CategoryService;
import ttps.service.UserService;
import ttps.service.impl.*;

public class Init {

	/**
	 * Metodo para inicializar la base de datos
	 * @param args
	 */
	public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(WebAppConfig.class);
        
        
        UserService userService = context.getBean(UserService.class);
        CategoryService categoryService = context.getBean(CategoryService.class);

        Date date = new Date();

        
        categoryService.save(new Category("Arte"));
        categoryService.save(new Category("Música"));
        categoryService.save(new Category("Noticias"));
        categoryService.save(new Category("Deporte"));
        categoryService.save(new Category("Humor"));
        
        userService.save(new User("admin","admin",Gender.MALE,"admin@email.com",date,"argentina","profesion", Role.ADMIN,"admin","admin"));
        userService.save(new User("moderator","moderator",Gender.MALE,"moderator@email.com",date,"argentina","profesion", Role.MODERATOR,"moderator","moderator"));
        userService.save(new User("student","student",Gender.MALE,"student@email.com",date,"argentina","profesion", Role.STUDENT,"student","student"));
        userService.save(new User("guest","guest",Gender.MALE,"guest@email.com",date,"argentina","profesion", Role.GUEST,"guest","guest"));

                
        
        context.close();
	}

}
