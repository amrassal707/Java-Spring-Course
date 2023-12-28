package com.luv2code.springcoredemo.config;

import com.luv2code.springcoredemo.common.Coach;
import com.luv2code.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean // bean id defaults to the method name
    // idea is take existing third party class and make it a spring bean to inject it
    // to controller or any other services
    //@Bean("Aquatic") , you can change the bean ID
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
