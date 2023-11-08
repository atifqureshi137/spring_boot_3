package com.isa.paniwala.rest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.paniwala.component.Coach;

@RestController
public class DemoController {

    // define a private field for the dependency
    private Coach myCoach;
    
    public DemoController(@Qualifier("cricketCoach") Coach theCoach) {
        System.out.println("DemoController theCoach :" + getClass().getSimpleName());
        this.myCoach = theCoach;
    }
    
    @GetMapping("/dailyworkout") 
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
    
    @GetMapping("/coachandteamName") 
    public String coachAndTeamName() {
        return myCoach.getCoachAndTeamName();
    }
}
