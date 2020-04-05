package com.athtech;

import com.athtech.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.athtech.Prolognite.deploymentStage;

public class Utility {

    public static void printBoard(List<ArrayList<Position>> board) {
        board.stream().forEach(row -> {
            String rowString = "";
            for (Position position : row) {
                rowString = rowString + position.getContent() + "  ";
            }
            ;
            System.out.println(rowString);
        });
    }

    public static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min)) + min;
    }

    public static void findThePossibleMoves(List<ArrayList<Position>> board, int numberOfMove) {

        deploymentStage(board, numberOfMove);
        int counter = 0;

        for (int row = 0; row < board.size(); row++) {
            for (int column = 0; column < board.size(); column++) {
                if ((board.get(row).get(column).getContent() instanceof EmptyPosition)) {
                    counter++;
                }
            }
        }
        System.out.print(counter);
    }

    public static void findTheSizeOfTheDeploymentTree(int dimensionsOfTheBoard, int numberOfObstacles, int numOfPawnsForEachPlayer) {

        int initialPossibleMoves = ((dimensionsOfTheBoard * dimensionsOfTheBoard) - numberOfObstacles);
        int numOfDeploymentMoves = 2 * numOfPawnsForEachPlayer;
        long sizeOfTheDeploymentTree = 1;

        for (int move = 1; move <= numOfDeploymentMoves; move++) {
            sizeOfTheDeploymentTree *= initialPossibleMoves;
            initialPossibleMoves--;
        }
        System.out.println(sizeOfTheDeploymentTree);
    }

//    public static void findTheSizeOfTheDestroyTree(int dimensionsOfTheBoard, int numberOfObstacles , int numOfPawnsForEachPlayer) {
//        initialPossibleMovesForDestroyTree = numOfPawnsForEachPlayer + numberOfObstacles; not all of them possible! -> not fixed, DestroyTree < DeploymentTree
//    }

    public static String evaluateTerminalStateWhite(List<ArrayList<Position>> board) {

        int evaluation = 0;
        int totalStrength = 0;
        int numOfPawns = 0;

        for (int row = 0; row < board.size(); row++) {

            for (int column = 0; column < board.size(); column++) {

                if (board.get(row).get(column).getContent() instanceof WhitePawn) {

                    totalStrength += ((WhitePawn) board.get(row).get(column).getContent()).getStrength();
                    numOfPawns++;
                    evaluation += miniHeuristic(row,column,board,"white");
                }
            }
        }
        evaluation = evaluation + totalStrength + numOfPawns;

        return "Evaluation White: "+evaluation;
    }

    public static String evaluateTerminalStateBlack(List<ArrayList<Position>> board) {

        int evaluation = 0;
        int totalStrength = 0;
        int numOfPawns = 0;

        for (int row = 0; row < board.size(); row++) {

            for (int column = 0; column < board.size(); column++) {

                if (board.get(row).get(column).getContent() instanceof BlackPawn) {

                    totalStrength += ((BlackPawn) board.get(row).get(column).getContent()).getStrength();
                    numOfPawns++;
                    evaluation += miniHeuristic(row,column,board,"black");
                }
            }
        }
        evaluation = evaluation + totalStrength + numOfPawns;

        return "Evaluation Black: "+evaluation;
    }

    public static int miniHeuristic(int positionRow, int positionColumn, List<ArrayList<Position>> board , String color) {

        int evaluation = 0;
        int blackStrength = 0;
        int whiteStrength = 0;

        for(int row = positionRow -1 ; row <= positionRow +1 ; row++){

            for(int column = positionColumn -1 ; column <= positionColumn+1 ; column++){

                if (row < board.size() && row >= 0 && column < board.size() && column >= 0) {
                    if (board.get(row).get(column).getContent() instanceof WhitePawn) {
                        whiteStrength += ((WhitePawn) board.get(row).get(column).getContent()).getStrength();
                    }
                    if (board.get(row).get(column).getContent() instanceof BlackPawn) {
                        blackStrength += ((BlackPawn) board.get(row).get(column).getContent()).getStrength();
                    }
                }

            }

        }

        if(color.equals("white")){
            if (whiteStrength > blackStrength) {
                evaluation = 1;
            }
            if (blackStrength > whiteStrength) {
                evaluation = -1;
            }
        }

        if(color.equals("black")){
            if (whiteStrength > blackStrength) {
                evaluation = -1;
            }
            if (blackStrength > whiteStrength) {
                evaluation = 1;
            }
        }

        return evaluation;

    }


}
