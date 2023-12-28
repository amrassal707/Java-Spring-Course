package com.luv2code.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // creates new instance each time you inject
public class CricketCoach implements Coach {
    public CricketCoach(){
        System.out.println("in constructor Cricket");
    }
    @Override
    public String GetDailyWorkout() {

        return "run boy run, cricketcoach";
    }
}
