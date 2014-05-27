package ttps.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;



/**
 * referencia
 * http://www.javacodegeeks.com/2013/05/spring-jpa-data-hibernate-mysql-maven.html
 * 
 * 
 * @author mclo
 *
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:/ttps/config/application.properties")
@ComponentScan("ttps") //para escanear servicios @component @service
@EnableJpaRepositories("ttps.repository") //spring data
public class SpringDataConfig  {
	
	 /**
	 *  representa el archivo properties usado por @PropertySource("classpath:application.properties")
	 */
	@Resource
	private Environment env;

	
    /**
     * Defines a DataSource bean, as an embedded database to which the objects are persisted.
     * 
     * @return
     */
    @Bean
    public DataSource dataSource() {
    	DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
    	driverManagerDataSource.setDriverClassName(env.getProperty("db.driver"));
    	driverManagerDataSource.setUrl(env.getProperty("db.url"));
    	driverManagerDataSource.setUsername(env.getProperty("db.username"));
    	driverManagerDataSource.setPassword(env.getProperty("db.password"));
    	return driverManagerDataSource;
    	
//        return new EmbeddedDatabaseBuilder().setType(H2).build();
    }
    
    /**
     * Defines a LocalContainerEntityManagerFactoryBean that is ultimately used to create a proxy bean
     * that implements the EntityManagerFactory interface. It is the bean through which JPA operations will be performed.
     * Note that this factory bean’s packagesToScan property is set to look for entities in the package named "ttps.model".
     * This makes it possible to work with JPA without defining a "persistence.xml" file.
     * 
     * 
     * @param dataSource
     * @param jpaVendorAdapter
     * @return
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
        lef.setDataSource(dataSource);
        lef.setJpaVendorAdapter(jpaVendorAdapter);
        lef.setPackagesToScan("ttps.model");
        lef.setJpaProperties(additionalProperties());
        return lef;
    }

    private Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.setProperty("hibernate.hbm2ddl.import_files",env.getProperty("hibernate.hbm2ddl.import_files"));
        return properties;
	}

	/**
     * Defines a Hibernate-based JPA vendor adapter bean for use by the EntityManagerFactory bean
     * 
     * @return
     */
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(Boolean.parseBoolean(env.getProperty("hibernate.show_sql")));
        hibernateJpaVendorAdapter.setGenerateDdl(Boolean.parseBoolean(env.getProperty("hibernate.generateDdl")));
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        return hibernateJpaVendorAdapter;
    }

    /**
     * Defines a JpaTransactionManager bean for transactional persistence
     * 
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager();
    }
    

}
