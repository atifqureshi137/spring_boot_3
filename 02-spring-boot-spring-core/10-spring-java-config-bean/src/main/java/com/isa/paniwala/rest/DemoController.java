package com.isa.paniwala.rest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isa.paniwala.component.Coach;
import com.isa.paniwala.util.Currency;

@RestController
public class DemoController {

    // define a private field for the dependency
    private Coach myCoach;
    
    public DemoController(@Qualifier("aquatic") Coach theCoach) {
        System.out.println("DemoController theCoach :" + getClass().getSimpleName());
        this.myCoach = theCoach;
    }
    
    @PostMapping("/dailyworkout/{accountIdentifier}/{selectedCurrency}/{selectedCurrency1}") 
    public String getDailyWorkout(@PathVariable(required = true, name =  "accountIdentifier") String accountIdentifier,
            @PathVariable(required = false, name="selectedCurrency") String selectedCurrency,
            @PathVariable(required = false, name="selectedCurrency1") String selectedCurrency1) {
        System.out.println(String.format("account identified %s, selected currency %s", accountIdentifier, selectedCurrency));
        return myCoach.getDailyWorkout();
    }
    
    @GetMapping("/coachandteamName") 
    public String coachAndTeamName() {
        return myCoach.getCoachAndTeamName();
    }
    
    
}
