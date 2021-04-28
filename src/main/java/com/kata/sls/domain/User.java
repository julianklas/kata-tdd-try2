package com.kata.sls.domain;

import java.time.LocalDateTime;

public class User {
    public void cancelTodaySchedule(Home home, LocalDateTime today) {
        home.cancelActionsForToday(today);
    }
}
