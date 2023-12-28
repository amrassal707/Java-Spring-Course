package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach mycoach;
    private Coach anothercoach;
    @Autowired // inject the dependency required // optional if only once constructor is there
    public DemoController(
            @Qualifier("cricketCoach")Coach coach,
            @Qualifier("cricketCoach")Coach theAnotherCoach) {
        System.out.println("in constructor Rest Controller"); // it will create the bean first and then inject it to the rest controller that it will create after to run that line
        mycoach= coach;
        anothercoach=theAnotherCoach;
    }



    @GetMapping ("getdailyworkout")
    public String getdailyworkout(){
        return mycoach.GetDailyWorkout();
    }

    @GetMapping("check")
    public String check() {
        return "comparing beans " + (mycoach == anothercoach);
    }
}

