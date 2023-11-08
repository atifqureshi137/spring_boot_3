package com.isa.paniwala.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    @Value("${coach.name}")
    private String coachName;
    
    @Value("${team.name}")
    private String teamName;
    
    @Override
    public String getDailyWorkout() {
        return String.format("Practice bowling for 15 minutes.");
    }

    @Override
    public String getCoachAndTeamName() {
        return String.format("teamname %s, coach name: %s", teamName, coachName);
    }

}
