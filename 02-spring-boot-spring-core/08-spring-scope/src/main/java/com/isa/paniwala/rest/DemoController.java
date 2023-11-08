package com.isa.paniwala.rest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.paniwala.component.Coach;

@RestController
public class DemoController {

    // define a private field for the dependency
    private Coach myCoach;
    private Coach anotherCoach;
    
    public DemoController(@Qualifier("cricketCoach") Coach theCoach, @Qualifier("cricketCoach") Coach anotherCoach) {
        System.out.println("DemoController theCoach :" + getClass().getSimpleName());
        System.out.println("DemoController anotherCoach:" + getClass().getSimpleName());
        this.myCoach = theCoach;
        this.anotherCoach = anotherCoach;
    }
    
    @GetMapping("/dailyworkout") 
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
    
    @GetMapping("/coachandteamName") 
    public String coachAndTeamName() {
        return myCoach.getCoachAndTeamName();
    }
    
    @GetMapping("/check") 
    public String checkCoachType() {
        System.out.println("same type of coach: " + (myCoach == anotherCoach));
        return "compare type of coach. myCoach == anotherCoach : " + (myCoach == anotherCoach);
    }
}
