package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    public CricketCoach(){
        System.out.println("in constructor Cricket");
    }
    @Override
    public String GetDailyWorkout() {

        return "run boy run, cricketcoach";
    }
}
