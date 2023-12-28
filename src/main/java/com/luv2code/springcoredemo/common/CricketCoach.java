package com.luv2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
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

    @PostConstruct
    public void DoStuff() {
        System.out.println("IN doStuff");
    }
    @PreDestroy // once you terminate, it will be exceuted
    public void DoEnd() {
        System.out.println("IN doEnd");
    }
}
