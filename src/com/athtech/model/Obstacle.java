package com.athtech.model;

public class Obstacle extends Pawn {

    private int strength;
    private Colors color;

    public Obstacle() {
        this.strength = 0;
        this.color = Colors.GRAY;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "00";
    }
}
