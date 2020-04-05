package com.athtech;

import com.athtech.model.EmptyPosition;
import com.athtech.model.Position;

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

}
