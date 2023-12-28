package com.luv2code.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// rest controller is a controller that doesn't require responsebody
public class DemoController {

    private Coach mycoach;

    @Autowired // inject the dependency required // optional if only once constructor is there

    public DemoController(Coach coach){
        mycoach=coach;
    }



    @GetMapping ("getdailyworkout")
    public String getdailyworkout(){
        return mycoach.GetDailyWorkout();
    }
}
