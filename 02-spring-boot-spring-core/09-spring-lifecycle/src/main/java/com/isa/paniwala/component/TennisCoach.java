package com.isa.paniwala.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    @Value("${coach.name}")
    private String coachName;
    
    @Value("${team.name}")
    private String teamName;
    
    public TennisCoach() {
        System.out.println("TennisCoach coach constructor :" + getClass().getSimpleName());
    }
    
    @Override
    public String getDailyWorkout() {
        return String.format("Practice tennis for 15 minutes.!-!");
    }

    @Override
    public String getCoachAndTeamName() {
        return String.format("teamname %s, coach name: %s", teamName, coachName);
    }
}