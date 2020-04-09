package com.athtech;

import com.athtech.model.Position;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {

    public static void mainMenu() throws ParseException {
        String input;
        do {
            System.out.println("\n");
            System.out.println("*******************************************************************************************");
            System.out.println("**                                      Main Menu                                        **");
            System.out.println("*******************************************************************************************");
            System.out.println("\n");
            System.out.println("-For Question 2 of the Handout, type ..................................................'2'-");
            System.out.println("-For Question 4 of the Handout, type ..................................................'4'-");
            System.out.println("-If you want to end the application, type .............................................'0'-");
            System.out.println("\n");
            System.out.println("*******************************************************************************************");

            input = Main.scanner.nextLine();

            switch (input) {
                case "0":
                    break;
                case "2":
                    question2();
                    break;
                case "4":
                    question4();
                    break;
                default:
                    System.out.println("\nInvalid input. Try again.\n");
            }
        } while (!"0".equals(input));

        System.out.println("\n******************************* You ended the application *********************************");
    }

    public static void question2() throws ParseException {

        String input;

        do {
            System.out.println("\n");
            System.out.println("*******************************************************************************************");
            System.out.println("**                                   -- QUESTION 2 --                                    **");
            System.out.println("*******************************************************************************************");
            System.out.println("\n");
            System.out.println("The method that calculates the size of the Deployment tree has been implemented in         ");
            System.out.println("com.athtech.Utility class in findTheSizeOfTheDeploymentTree() method and it is described   ");
            System.out.println("elaborately in 'AIT-Practical-1.docx'                                                      ");
            System.out.println("\n");
            System.out.println("------------------------------------------------------------------------------------------ ");
            System.out.println("-If you want to calculate the Deployment tree of a game, type .........................'1'-");
            System.out.println("-If you want to return to Main Menu, type .............................................'0'-");
            System.out.println("\n");
            System.out.println("*******************************************************************************************");

            input = Main.scanner.nextLine();
            switch (input) {
                case "0":
                    break;
                case "1":
                    calculateTheDeplTreeOfAGame();
                    break;
                default:
                    System.out.println("\nInvalid input. Try again.\n");
            }
        } while (!"0".equals(input));
    }

    public static void question4() throws ParseException {

        String input;

        do {
            System.out.println("\n");
            System.out.println("*******************************************************************************************");
            System.out.println("**                                 -- QUESTION 4 --                                      **");
            System.out.println("*******************************************************************************************");
            System.out.println("\n");
            System.out.println("An evaluation function that indicates who has the advantage in any particular terminal     ");
            System.out.println("state has been implemented in com.athtech.Utility class in evaluateTerminalStateWhite()    ");
            System.out.println("and evaluateTerminalStateBlack() methods based on the criteria:                            ");
            System.out.println("\n");
            System.out.println("1. Number of Pawns                                                                         ");
            System.out.println("2. Pawns Total Strength                                                                    ");
            System.out.println("3. Mini Heuristic for every pawn that has been implemented in com.athtech.Utility class in ");
            System.out.println("miniHeuristicBlack() and miniHeuristicWhite() methods                                      ");
            System.out.println("4. Who's turn is to play");
            System.out.println("\n");
            System.out.println("The evaluation function and the mini heuristics are described elaborately                  ");
            System.out.println("in 'AIT-Practical-1.docx'                                                                  ");
            System.out.println("\n");
            System.out.println("------------------------------------------------------------------------------------------ ");
            System.out.println("-To create T1,T2,T3 or any random terminal state and see the Evaluation function,type..'1'-");
            System.out.println("-If you want to return to Main Menu, type .............................................'0'-");
            System.out.println("\n");
            System.out.println("*******************************************************************************************");

            input = Main.scanner.nextLine();
            switch (input) {
                case "0":
                    break;
                case "1":
                    createAndEvaluateTerminalState();
                    break;
                default:
                    System.out.println("\nInvalid input. Try again.\n");
            }
        } while (!"0".equals(input));
    }

    public static void calculateTheDeplTreeOfAGame() {

        String input;
        int dimensionsOfTheGame = 1;
        int numberOfObstacles = 1;
        int numberOfPawnsForEachPlayer = 1;

        do {
            System.out.println("\n");
            System.out.println("Specify the dimensions of the board (preferably <10 to avoid stack overflow) or type 'back' to cancel.");
            input = Main.scanner.nextLine();
            switch (input) {
                case "back":
                    break;
                default:
                    try {
                        dimensionsOfTheGame = Integer.parseInt(input);
                        System.out.println("Specify the number of obstacles or type 'back' to cancel.                                      ");
                        input = Main.scanner.nextLine();
                        switch (input) {
                            case "back":
                                break;
                            default:
                                try {
                                    numberOfObstacles = Integer.parseInt(input);
                                    System.out.println("Specify the number of pawns for each player or type 'back' to cancel.                       ");
                                    input = Main.scanner.nextLine();
                                    switch (input) {
                                        case "back":
                                            break;
                                        default:
                                            try {
                                                numberOfPawnsForEachPlayer = Integer.parseInt(input);
                                                Utility.findTheSizeOfTheDeploymentTree(dimensionsOfTheGame, numberOfObstacles, numberOfPawnsForEachPlayer);
                                            } catch (Exception e) {

                                            }
                                            break;
                                    }

                                } catch (Exception e) {

                                }
                                break;
                        }
                    } catch (Exception e) {

                    }
                    break;
            }

        }
        while (!"back".equals(input));
    }


    public static void createAndEvaluateTerminalState() {

        int dimensionsOfTheGame = 5;
        int numberOfObstacles = 5;

        List<Integer> strengths = Arrays.asList(1,2,3,4,5);
        List<Integer> strengthsT2black = Arrays.asList(2,3,4,5);
        List<Integer> strengthsT3black = Arrays.asList(1,2,3,5);

        List<Integer> obstacleRowsT1 = Arrays.asList(3,5,3,5);
        List<Integer> obstacleColumnsT1 = Arrays.asList(1,1,2,5);
        List<Integer> whiteRowsT1 = Arrays.asList(4,2,4,2,3);
        List<Integer> whiteColumnsT1 = Arrays.asList(4,4,1,1,5);
        List<Integer> blackRowsT1 = Arrays.asList(4,4,1,4,5);
        List<Integer> blackColumnsT1 = Arrays.asList(2,3,1,5,4);

        List<Integer> obstacleRowsT2 = Arrays.asList(3,5,3,5,2);
        List<Integer> obstacleColumnsT2 = Arrays.asList(1,1,2,5,2);
        List<Integer> whiteRowsT2 = Arrays.asList(4,2,4,2,3);
        List<Integer> whiteColumnsT2 = Arrays.asList(4,4,1,1,5);
        List<Integer> blackRowsT2 = Arrays.asList(4,1,4,5);
        List<Integer> blackColumnsT2 = Arrays.asList(3,1,5,4);

        List <Integer> obstacleRowsT3 = Arrays.asList(3,5,3,5,2);
        List<Integer> obstacleColumnsT3 = Arrays.asList(1,1,2,5,2);
        List<Integer> whiteRowsT3 = Arrays.asList(4,2,4,2,3);
        List<Integer> whiteColumnsT3 = Arrays.asList(4,4,1,1,5);
        List<Integer> blackRowsT3 = Arrays.asList(4,4,1,5);
        List<Integer> blackColumnsT3 = Arrays.asList(2,3,1,4);

        String input;

        do {
            System.out.println("\n");
            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.println("-To create T1 terminal state type '1' or type 'back' to cancel.                            ");
            System.out.println("-To create T2 terminal state type '2' or type 'back' to cancel.                            ");
            System.out.println("-To create T3 terminal state type '3' or type 'back' to cancel.                            ");
            System.out.println("-To create a random terminal state type '4' or type 'back' to cancel.                      ");
            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.println("\n");

            input = Main.scanner.nextLine();
            switch (input) {
                case "back":
                    break;
                case "1":
                    List<ArrayList<Position>> boardT1 = Prolognite.generateBoard(dimensionsOfTheGame);
                    Prolognite.generateState(boardT1,obstacleRowsT1,obstacleColumnsT1,whiteRowsT1,whiteColumnsT1,strengths,blackRowsT1,blackColumnsT1,strengths);
                    System.out.println("----------------------------------T1 terminal state----------------------------------------");
                    Utility.printBoard(boardT1);
                    System.out.println("-----If black team is to play-----                                                         ");
                    Utility.heuristicForBlack(boardT1,"black");
                    Utility.heuristicForWhite(boardT1,"black");
                    System.out.println("\n");
                    System.out.println("-----If white team is to play-----                                                         ");
                    Utility.heuristicForBlack(boardT1,"white");
                    Utility.heuristicForWhite(boardT1,"white");
                    break;
                case "2":
                    List<ArrayList<Position>> boardT2 = Prolognite.generateBoard(dimensionsOfTheGame);
                    Prolognite.generateState(boardT2,obstacleRowsT2,obstacleColumnsT2,whiteRowsT2,whiteColumnsT2,strengths,blackRowsT2,blackColumnsT2,strengthsT2black);
                    System.out.println("----------------------------------T2 terminal state----------------------------------------");
                    Utility.printBoard(boardT2);
                    System.out.println("-----If black team is to play-----                                                         ");
                    Utility.heuristicForBlack(boardT2,"black");
                    Utility.heuristicForWhite(boardT2,"black");
                    System.out.println("\n");
                    System.out.println("-----If white team is to play-----                                                         ");
                    Utility.heuristicForBlack(boardT2,"white");
                    Utility.heuristicForWhite(boardT2,"white");
                    break;
                case "3":
                    List<ArrayList<Position>> boardT3 = Prolognite.generateBoard(dimensionsOfTheGame);
                    Prolognite.generateState(boardT3,obstacleRowsT3,obstacleColumnsT3,whiteRowsT3,whiteColumnsT3,strengths,blackRowsT3,blackColumnsT3,strengthsT3black);
                    System.out.println("----------------------------------T3 terminal state----------------------------------------");
                    Utility.printBoard(boardT3);
                    System.out.println("-----If black team is to play-----                                                         ");
                    Utility.heuristicForBlack(boardT3,"black");
                    Utility.heuristicForWhite(boardT3,"black");
                    System.out.println("\n");
                    System.out.println("-----If white team is to play-----                                                         ");
                    Utility.heuristicForBlack(boardT3,"white");
                    Utility.heuristicForWhite(boardT3,"white");
                    break;
                case "4":
                    List<ArrayList<Position>> boardRandom = Prolognite.generateBoard(dimensionsOfTheGame);
                    Prolognite.initializeBoard(boardRandom,numberOfObstacles);
                    Prolognite.deploymentStage(boardRandom,dimensionsOfTheGame);
                    System.out.println("--------------------------------Random terminal state--------------------------------------");
                    Utility.printBoard(boardRandom);
                    System.out.println("-----If black team is to play-----                                                         ");
                    Utility.heuristicForBlack(boardRandom,"black");
                    Utility.heuristicForWhite(boardRandom,"black");
                    System.out.println("\n");
                    System.out.println("-----If white team is to play-----                                                         ");
                    Utility.heuristicForBlack(boardRandom,"white");
                    Utility.heuristicForWhite(boardRandom,"white");
                    break;
                default:
                    System.out.println("\nInvalid input. Try again.\n");
            }
        } while (!"back".equals(input)) ;
    }
}
