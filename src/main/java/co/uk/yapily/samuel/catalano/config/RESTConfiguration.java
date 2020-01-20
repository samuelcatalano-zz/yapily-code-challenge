package co.uk.yapily.samuel.catalano.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Samuel Catalano
 */

@Configuration
public class RESTConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}