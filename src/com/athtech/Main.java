package com.athtech;

import com.athtech.model.Position;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int dimensionsOfTheGame = 5;
        int numberOfObstacles = 5;

        List<ArrayList<Position>> board = Prolognite.initializeBoard(dimensionsOfTheGame, numberOfObstacles);
//        Prolognite.deploymentStage(board,board.size());
//        Utility.printBoard(board);
//        Utility.findThePossibleMoves(board,1);

        Utility.findTheSizeOfTheDeploymentTree(dimensionsOfTheGame,numberOfObstacles);
        System.out.println(20*19*18*17*16*15*14*13*12*11);

    }
}
