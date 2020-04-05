package com.athtech;

import com.athtech.model.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utility {

    public static void printBoard(List<ArrayList<Position>> board) {
        board.stream().forEach(row -> {
            String rowString = "";
            for(Position position : row ) {
                rowString = rowString + position.getContent() + "  ";
            };
            System.out.println(rowString);
        });
    }

    public static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) ) + min;
    }
}
