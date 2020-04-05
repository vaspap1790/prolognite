package com.athtech.model;

public class Position {

    private Pawn content;

    public Position() {
        this.content = new EmptyPosition();
    }

    public Pawn getContent() {
        return content;
    }

    public void setContent(Pawn content) {
        this.content = content;
    }
}
