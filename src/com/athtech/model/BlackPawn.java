package com.athtech.model;

public class BlackPawn extends Pawn {

    private int strength;
    private Colors color;

    public BlackPawn(int strength) {
        this.strength = strength;
        this.color = Colors.BLACK;
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
        return "B" + strength;
    }
}
