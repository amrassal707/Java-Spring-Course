package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // primary will mark this bean as a top priority
public class BaseballCoach implements Coach {

    @Override
    public String GetDailyWorkout(){
        return "run boy run, baseball coach";
    }

}
