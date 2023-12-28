package com.luv2code.springcoredemo;

import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
// basic annotation used on all classes that implements a specific interface/abstract class
// comes with springboot
public class Cricketcoach implements Coach {

    @Override
    public String GetDailyWorkout() {
        return "run boy run";
    }

   
}
