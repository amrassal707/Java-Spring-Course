package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach mycoach;

    @Autowired // inject the dependency required // optional if only once constructor is there
    public DemoController(Coach coach) {
        mycoach= coach;
    }



    @GetMapping ("getdailyworkout")
    public String getdailyworkout(){
        return mycoach.GetDailyWorkout();
    }
}
