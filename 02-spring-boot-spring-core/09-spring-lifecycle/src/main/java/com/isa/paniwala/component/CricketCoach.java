package com.isa.paniwala.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;



@Component
// created new instance for each injection
public class CricketCoach implements Coach {

    @Value("${coach.name}")
    private String coachName;
    
    @Value("${team.name}")
    private String teamName;
    
    public CricketCoach() {
        System.out.println("cricket coach constructor :" + getClass().getSimpleName());
    }
    
    // define our init method
    @PostConstruct
    public void doMyStartUpStuff() {
        System.out.println("Init doMyStartUpStuff: " + getClass().getSimpleName());
    }
    
    // define our destroy method
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("Init doMyCLeanStuff: " + getClass().getSimpleName());
    }
    
    @Override
    public String getDailyWorkout() {
        return String.format("Practice bowling for 15 minutes.!-!");
    }

    @Override
    public String getCoachAndTeamName() {
        return String.format("teamname %s, coach name: %s", teamName, coachName);
    }

}
