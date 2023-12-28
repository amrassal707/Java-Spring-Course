package com.luv2code.springcoredemo.common;

public class SwimCoach implements Coach{
    public SwimCoach() {
        System.out.println("in swimcoach");
    }
    @Override
    public String GetDailyWorkout() {
        return "run boy run, swimcoach";
    }
}
