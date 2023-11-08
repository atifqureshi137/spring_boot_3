package com.isa.paniwala.component;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

    @Value("${coach.swim.name}")
    private String coachName;
    
    @Value("${team.swim.name}")
    private String teamName;
    
    public SwimCoach() {
        System.out.println("Swim coach constructor :" + getClass().getSimpleName());
    }
    
    @Override
    public String getDailyWorkout() {
        return String.format("Swim 1km as wormup.");
    }

    @Override
    public String getCoachAndTeamName() {
        return String.format("teamname %s, coach name: %s", teamName, coachName);
    }

}
