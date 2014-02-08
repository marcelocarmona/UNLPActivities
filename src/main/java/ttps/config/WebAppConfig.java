package ttps.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Main configuration class
 * 
 * @author mclo
 *
 */
@Configuration
@Import({SpringDataConfig.class, SpringSecurityConfig.class})
public class WebAppConfig  {

}
