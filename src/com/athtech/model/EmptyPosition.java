package com.athtech.model;

public class EmptyPosition extends Pawn {

    private int strength;
    private Colors color;

    public EmptyPosition() {
        this.strength = 0;
        this.color = Colors.COLORLESS;
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
        return "--";
    }
}
