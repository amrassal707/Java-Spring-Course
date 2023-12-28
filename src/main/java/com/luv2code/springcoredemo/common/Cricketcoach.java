package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class Cricketcoach implements Coach {

    @Override
    public String GetDailyWorkout() {
        return "run boy run!!!";
    }
}
