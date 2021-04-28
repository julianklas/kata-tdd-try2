package com.kata.sls.domain;

public class Light {

    private boolean isOn;

    public void turnOn() {
        this.isOn = true;
    }

    public boolean isOn() {
        return this.isOn;
    }

    public void turnOff() {
        this.isOn = false;
    }
}
