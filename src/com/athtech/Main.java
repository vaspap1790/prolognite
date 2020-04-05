package com.athtech;

import com.athtech.model.Position;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int dimensionsOfTheGame = 5;
        int numberOfObstacles = 5;

        List<ArrayList<Position>> board = Prolognite.initializeBoard(dimensionsOfTheGame, numberOfObstacles);
        Prolognite.deploymentStage(board);
        Utility.printBoard(board);

    }
}
