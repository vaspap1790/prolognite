package com.athtech.model;

public enum Colors {

    GRAY(0,"Gray"),
    COLORLESS(1,"Colorless"),
    WHITE(2,"White"),
    BLACK( 3,"Black");

    private String color;
    private int id;

    Colors(int id, String color) {
        this.id = id;
        this.color = color;
    }
}
