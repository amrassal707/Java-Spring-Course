package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Lazy // go for each class and write the annotation to only initialize when needed, if many classes are there,
// then do it application.properties by writing "spring.main.lazy-initialization= true
public class BaseballCoach implements Coach {
    public BaseballCoach() {
        System.out.println("in constructor Baseball");
    }
    @Override
    public String GetDailyWorkout(){
        return "run boy run, baseball coach";
    }

}
