package com.athtech;

import com.athtech.model.*;

import java.util.ArrayList;
import java.util.List;

public class Prolognite {

    public static List<ArrayList<Position>> generateBoard(int dimensionsOfTheBoard) {

        List<ArrayList<Position>> board = new ArrayList<ArrayList<Position>>();

        for (int i = 0; i < dimensionsOfTheBoard; i++) {
            ArrayList<Position> row = new ArrayList<>();
            for (int j = 0; j < dimensionsOfTheBoard; j++) {
                Position position = new Position();
                position.setContent(new EmptyPosition());
                row.add(position);
            }
            board.add(row);
        }
        return board;
    }

    public static void initializeBoard(List<ArrayList<Position>> board, int numberOfObstacles){

        for (int i = 0; i < numberOfObstacles; i++) {
            int column = Utility.getRandomNumberInRange(0, board.size());
            int row = Utility.getRandomNumberInRange(0, board.size());

            while (!(board.get(row).get(column).getContent() instanceof EmptyPosition)) {
                column = Utility.getRandomNumberInRange(0, board.size());
                row = Utility.getRandomNumberInRange(0, board.size());
            }
            board.get(row).get(column).setContent(new Obstacle());
        }
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

    public static void deploymentStage(List<ArrayList<Position>> board, int moves) {
        for (int i = 1; i <= moves; i++) {
            deployNthPawn(board, "white", i);
            deployNthPawn(board, "black", i);
        }
    }

    public static void deployAPosition(List<ArrayList<Position>> board, int row, int column, String color, int strength) {
        if (color.equals("white")) {
            board.get(row).get(column).setContent(new WhitePawn(strength));
        } else {
            board.get(row).get(column).setContent(new BlackPawn(strength));
        }
    }

    public static void putAnObstacle(List<ArrayList<Position>> board, int row, int column) {
        board.get(row).get(column).setContent(new Obstacle());
    }

    public static void generateState(List<ArrayList<Position>> board,
                                     List<Integer> obstacleRows, List<Integer> obstacleColumns,
                                     List<Integer> whiteRows, List<Integer> whiteColumns, List<Integer> whiteStrengths,
                                     List<Integer> blackRows, List<Integer> blackColumns, List<Integer> blackStrengths) {

        for (int i = 0 ; i < obstacleRows.size(); i++ ){
            board.get(obstacleRows.get(i)-1).get(obstacleColumns.get(i)-1).setContent(new Obstacle());
        }

        for (int i = 0 ; i < whiteRows.size(); i++ ){
            board.get(whiteRows.get(i)-1).get(whiteColumns.get(i)-1).setContent(new WhitePawn(whiteStrengths.get(i)));
        }

        for (int i = 0 ; i < blackRows.size(); i++ ){
            board.get(blackRows.get(i)-1).get(blackColumns.get(i)-1).setContent(new BlackPawn(blackStrengths.get(i)));
        }
    }
}
