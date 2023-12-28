package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    public TennisCoach(){
        System.out.println("in constructor tennis");
    }
    @Override
    public String GetDailyWorkout() {
        return "run boy run, tenniscoach";
    }
}
