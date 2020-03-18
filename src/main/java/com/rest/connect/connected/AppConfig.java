package com.rest.connect.connected;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class AppConfig {
    
    @Bean
    public MessageSource messageSource() {
    	ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        return messageSource;
    }

}
