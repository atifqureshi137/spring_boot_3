package com.isa.paniwala.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class pageController {

    @Value("${coach.name}")
    private String coachName;
    
    @Value("${team.name}")
    private String teamName;
    
    /**
     * Show team and coach name as default page.
     * @return string
     */
    @GetMapping("/")
    public String HelloWorld() {
        return String.format("teamname %s, coachn ame: %s", teamName, coachName);
    }
    
    /**
     * Work out end point.
     * @return string
     */
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "daily workout";
    }
}
