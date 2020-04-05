package com.athtech;

import com.athtech.model.*;

import java.util.ArrayList;
import java.util.List;

public class Prolognite {

    public static List<ArrayList<Position>> initializeBoard(int dimensionsOfTheBoard, int numberOfObstacles) {

        List<ArrayList<Position>> board = new ArrayList<ArrayList<Position>>();

//        Generate board
        for (int i = 0; i < dimensionsOfTheBoard; i++) {
            ArrayList<Position> row = new ArrayList<>();
            for (int j = 0; j < dimensionsOfTheBoard; j++) {
                row.add(new Position());
            }
            board.add(row);
        }

//        Populate with Obstacles
        for (int i = 0; i < numberOfObstacles; i++) {

            int column = Utility.getRandomNumberInRange(0, dimensionsOfTheBoard);
            int row = Utility.getRandomNumberInRange(0, dimensionsOfTheBoard);

            while (!(board.get(row).get(column).getContent() instanceof EmptyPosition)) {
                column = Utility.getRandomNumberInRange(0, dimensionsOfTheBoard);
                row = Utility.getRandomNumberInRange(0, dimensionsOfTheBoard);
            }

            board.get(row).get(column).setContent(new Obstacle());

        }
        return board;
    }

    public static void deployNthPawn(List<ArrayList<Position>> board, String color, int nthPawn) {

        int column = Utility.getRandomNumberInRange(0, board.size());
        int row = Utility.getRandomNumberInRange(0, board.size());

        while (!(board.get(row).get(column).getContent() instanceof EmptyPosition)) {
            column = Utility.getRandomNumberInRange(0, board.size());
            row = Utility.getRandomNumberInRange(0, board.size());
        }

        if (color.equals("black")) {
            board.get(row).get(column).setContent(new BlackPawn(nthPawn));
        } else {
            board.get(row).get(column).setContent(new WhitePawn(nthPawn));
        }
    }

    public static void deploymentStage(List<ArrayList<Position>> board , int moves) {
        for (int i = 1; i <= moves; i++) {
            deployNthPawn(board, "white", i);
            deployNthPawn(board, "black", i);
        }
    }

}
