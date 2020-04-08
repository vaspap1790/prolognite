package com.athtech;

import com.athtech.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import static com.athtech.Prolognite.deploymentStage;

public class Utility {

    public static void printBoard(List<ArrayList<Position>> board) {
        System.out.println("\n");
        System.out.println("***************************************** -BOARD- *****************************************");
        System.out.println("                                                     '00'-> Obstacle, '--' -> Empty Position");
        System.out.println("\n");
        board.stream().forEach(row -> {
            String rowString = "";
            for (Position position : row) {
                rowString = rowString + position.getContent() + "  ";
            }
            System.out.println(rowString);
        });
        System.out.println("\n");
        System.out.println("*******************************************************************************************");
        System.out.println("\n");
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

    public static int evaluateTerminalStateWhite(List<ArrayList<Position>> board) {

        List<ArrayList<Integer>> possibleDefeated = new ArrayList<>();
        for(int i = 0 ; i <=5 ; i++){
            possibleDefeated.add(new ArrayList<>());
        }
        int evaluation = 0;
        int totalStrength = 0;
        int numOfPawns = 0;

        for (int row = 0; row < board.size(); row++) {

            for (int column = 0; column < board.size(); column++) {

                if (board.get(row).get(column).getContent() instanceof WhitePawn) {

                    totalStrength += ((WhitePawn) board.get(row).get(column).getContent()).getStrength();
                    numOfPawns++;
                    List<ArrayList<Integer>> possibleDefeatedMini = miniHeuristicWhite(row, column, board, ((WhitePawn) board.get(row).get(column).getContent()).getStrength());
                    for(int i = 1 ; i< possibleDefeatedMini.size(); i++){
                        for(int j = 0 ; j< possibleDefeatedMini.get(i).size(); j++){
                            possibleDefeated.get(i).add(possibleDefeatedMini.get(i).get(j));
                        }
                    }
                    evaluation += possibleDefeatedMini.get(0).get(0);
                }
            }
        }
        evaluation = evaluation + totalStrength + numOfPawns;

        for(ArrayList list : possibleDefeated){
            if(list.size()>1){
                evaluation = evaluation - (list.size()-1);
            }
        };

        return evaluation;
    }

    public static int evaluateTerminalStateBlack(List<ArrayList<Position>> board) {

        List<ArrayList<Integer>> possibleDefeated = new ArrayList<>();
        for(int i = 0 ; i <=5 ; i++){
            possibleDefeated.add(new ArrayList<>());
        }
        int evaluation = 0;
        int totalStrength = 0;
        int numOfPawns = 0;

        for (int row = 0; row < board.size(); row++) {

            for (int column = 0; column < board.size(); column++) {

                if (board.get(row).get(column).getContent() instanceof BlackPawn) {

                    totalStrength += ((BlackPawn) board.get(row).get(column).getContent()).getStrength();
                    numOfPawns++;
                    List<ArrayList<Integer>> possibleDefeatedMini = miniHeuristicBlack(row, column, board, ((BlackPawn) board.get(row).get(column).getContent()).getStrength());
                    for(int i = 1 ; i< possibleDefeatedMini.size(); i++){
                        for(int j = 0 ; j< possibleDefeatedMini.get(i).size(); j++){
                            possibleDefeated.get(i).add(possibleDefeatedMini.get(i).get(j));
                        }
                    }
                    evaluation += possibleDefeatedMini.get(0).get(0);
                }
            }
        }
        evaluation = evaluation + totalStrength + numOfPawns;

        for(ArrayList list : possibleDefeated){
            if(list.size()>1){
                evaluation = evaluation - (list.size()-1);
            }
        };

        return evaluation;
    }


    public static List<ArrayList<Integer>> miniHeuristicWhite(int positionRow, int positionColumn, List<ArrayList<Position>> board, int strength) {

        int whiteStrength = 0;
        List<ArrayList<Integer>> possibleDefeated = new ArrayList<>();
        for(int i = 0 ; i <=5 ; i++){
            possibleDefeated.add(new ArrayList<>());
        }

        for (int row = positionRow - 1; row <= positionRow + 1; row++) {
            for (int column = positionColumn - 1; column <= positionColumn + 1; column++) {

                if ((row < board.size() && row >= 0 && column < board.size() && column >= 0)&& !(positionRow == row && positionColumn == column)&& !(Math.abs(row - positionRow) == 1 && Math.abs(column - positionColumn) == 1)) {
                    if (board.get(row).get(column).getContent() instanceof BlackPawn) {
                        if (strength > ((BlackPawn) board.get(row).get(column).getContent()).getStrength()) {
                            whiteStrength += 1;
                            possibleDefeated.get(((BlackPawn) board.get(row).get(column).getContent()).getStrength()).add(((BlackPawn) board.get(row).get(column).getContent()).getStrength());
                        }
                    }
                }
            }
        }
        possibleDefeated.get(0).add(whiteStrength);
        return possibleDefeated;
    }

    public static List<ArrayList<Integer>> miniHeuristicBlack(int positionRow, int positionColumn, List<ArrayList<Position>> board, int strength) {

        int blackStrength = 0;
        List<ArrayList<Integer>> possibleDefeated = new ArrayList<>();
        for(int i = 0 ; i <=5 ; i++){
            possibleDefeated.add(new ArrayList<>());
        }

        for (int row = positionRow - 1; row <= positionRow + 1; row++) {
            for (int column = positionColumn - 1; column <= positionColumn + 1; column++) {

                if ((row < board.size() && row >= 0 && column < board.size() && column >= 0) && !(positionRow == row && positionColumn == column)&& !(Math.abs(row - positionRow) == 1 && Math.abs(column - positionColumn) == 1)) {
                    if (board.get(row).get(column).getContent() instanceof WhitePawn) {
                        if (strength > ((WhitePawn) board.get(row).get(column).getContent()).getStrength()) {
                            blackStrength += 1;
                            possibleDefeated.get(((WhitePawn) board.get(row).get(column).getContent()).getStrength()).add(((WhitePawn) board.get(row).get(column).getContent()).getStrength());
                        }
                    }
                }
            }
        }
        possibleDefeated.get(0).add(blackStrength);
        return possibleDefeated;
    }


    public static void heuristicForBlack(List<ArrayList<Position>> board, String turn) {

        int whiteStrength = evaluateTerminalStateWhite(board);
        int blackStrength = evaluateTerminalStateBlack(board);

        if(turn.equals("white")){
            whiteStrength +=1;
        }

        if(turn.equals("black")){
            blackStrength +=1;
        }

        int total = blackStrength - whiteStrength;

        System.out.println("Heuristic(Black): " + total);
    }

    public static void heuristicForWhite(List<ArrayList<Position>> board, String turn) {

        int whiteStrength = evaluateTerminalStateWhite(board);
        int blackStrength = evaluateTerminalStateBlack(board);

        if(turn.equals("white")){
            whiteStrength +=1;
        }

        if(turn.equals("black")){
            blackStrength +=1;
        }

        int total = whiteStrength - blackStrength;

        System.out.println("Heuristic(White): " + total);
    }


}
