package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class TrackCoach implements Coach {
    public TrackCoach() {
        System.out.println("in constructor Track");
    }

    @Override
    public String GetDailyWorkout() {
        return "run boy run, Trackcoach";
    }
}
