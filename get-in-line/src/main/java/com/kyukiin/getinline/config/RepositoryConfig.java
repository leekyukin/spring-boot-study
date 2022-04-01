package com.kyukiin.getinline.config;

import com.kyukiin.getinline.domain.Event;
import com.kyukiin.getinline.repository.EventRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean
    public EventRepository eventRepository() {
        return new EventRepository() {};
    }

}
