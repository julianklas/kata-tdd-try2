package com.kata.sls.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Home {

    private boolean userRequestedToCancelActions = false;

    private LocalDateTime dateWhereActionsHaveBeenCancelled;

    private List<Light> lights = new ArrayList<>();

    public List<Light> getLights() {
        return lights;
    }

    public void addLight(Light aLight) {
        this.lights.add(aLight);
    }

    public void setTime(LocalDateTime newTime) {

        if(userRequestedToCancelActions &&
                newTime.getDayOfMonth() == dateWhereActionsHaveBeenCancelled.getDayOfMonth()) return;


        int hour = newTime.getHour();

        boolean shouldTurnOnTheLights = hour >= 8 && hour < 23;

        lights.stream()
                .forEach( (Light l) -> {
                    if(shouldTurnOnTheLights)
                        l.turnOn();
                    else
                        l.turnOff();
                }
        );
    }

    public void cancelActionsForToday(LocalDateTime today) {
        this.userRequestedToCancelActions = true;
        this.dateWhereActionsHaveBeenCancelled = today;
    }
}
