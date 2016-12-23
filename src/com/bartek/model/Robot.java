package com.bartek.model;

public class Robot {

    private final String name;
    private final int hp;
    private final int speed;
    private final String[] tactics;

    public Robot(String name, int hp, int speed, String[] robotTactics) {
        this.name = name;
        this.hp = hp;
        this.speed = speed;
        this.tactics = robotTactics;
    }

    public int getSpeed() {
        return speed;
    }

    public int getHealth() {
        return hp;
    }

    public String getName() {
        return name;
    }

    public String[] getTactics() {
        return tactics;
    }
}
