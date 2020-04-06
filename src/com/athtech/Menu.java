package com.athtech;

import java.text.ParseException;

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

            switch(input) {
                case "0":
                    break;
                case "1":
                    question2();
                    break;
                case "2":
                    question4();
                    break;
                default:
                    System.out.println("\nInvalid input. Try again.\n");
            }
        } while(!"0".equals(input));

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
        System.out.println("The  size of the game tree for the Deployment phase is calculated with this formula:       ");
        System.out.println("(pseudocode)                                                                               ");
        System.out.println("\n");
        System.out.println("initialPossiblePositionsToDeploy = dimensionsOfTheBoard^2 - numberOfObstacles              ");
        System.out.println("totalNumberOfDeploymentMoves = 2 * numberOfPawnsForEachPlayer                              ");
        System.out.println("sizeOfTheDeploymentTree = 1                                                                ");
        System.out.println("move = 1                                                                                   ");
        System.out.println("\n");
        System.out.println("while move <= totalNumberOfDeploymentMoves   {                                             ");
        System.out.println("sizeOfTheDeploymentTree = sizeOfTheDeploymentTree * initialPossiblePositionsToDeploy       ");
        System.out.println("initialPossiblePositionsToDeploy--                                                         ");
        System.out.println("move++    }                                                                                ");
        System.out.println("\n");
        System.out.println("For example for 5x5 board, 5 obstacles, 5 armies for each player:                          ");
        System.out.println("\n");
        System.out.println("initialPossiblePositionsToDeploy = 5^2 - 5 = 20                                            ");
        System.out.println("totalNumberOfDeploymentMoves = 2 * 5 = 10                                                  ");
        System.out.println("\n");
        System.out.println("sizeOfTheDeploymentTree = 20*19*18*17*16*15*14*13*12*11                                    ");
        System.out.println("\n");
        System.out.println("-If you want to calculate the Deployment tree of a game, type .........................'1'-");
        System.out.println("-If you want to return to Main Menu, type .............................................'0'-");
        System.out.println("\n");
        System.out.println("*******************************************************************************************");

        input = Main.scanner.nextLine();
            switch(input) {
                case "0":
                    break;
                case "1":
                    calculateTheDeplTreeOfAGame();
                    break;
                default:
                    System.out.println("\nInvalid input. Try again.\n");
            }
        } while(!"0".equals(input));
    }

    public static void question4() throws ParseException {

        String input;

        do {
        System.out.println("\n");
        System.out.println("*******************************************************************************************");
        System.out.println("**                                 -- QUESTION 4 --                                      **");
        System.out.println("*******************************************************************************************");
        System.out.println("\n");
        System.out.println("-For Question 1 of the Handout, type ..................................................'1'-");
        System.out.println("-For Question 2 of the Handout, type ..................................................'2'-");
        System.out.println("-If you want to return to Main Menu, type .............................................'0'-");
        System.out.println("\n");
        System.out.println("*******************************************************************************************");

        input = Main.scanner.nextLine();
            switch(input) {
                case "0":
                    break;
                case "1":
                    break;
                case "2":
                    question2();
                    break;
                default:
                    System.out.println("\nInvalid input. Try again.\n");
            }
        } while(!"0".equals(input));
    }

    public static void calculateTheDeplTreeOfAGame(){

        String input;
        int dimensionsOfTheGame = 1;
        int numberOfObstacles = 1;
        int numberOfPawnsForEachPlayer = 1;

        do {
            System.out.println("\n");
            System.out.println("Specify the dimensions of the board (preferably <10 to avoid stack overflow) or type 'back' to cancel.");
            input = Main.scanner.nextLine();
            switch(input) {
                case "back":
                    break;
                default:
                    try{
                        dimensionsOfTheGame = Integer.parseInt(input);
                        System.out.println("Specify the number of obstacles or type 'back' to cancel.                                      ");
                        input = Main.scanner.nextLine();
                        switch(input) {
                            case "back":
                                break;
                            default:
                                try {
                                    numberOfObstacles = Integer.parseInt(input);
                                    System.out.println("Specify the number of pawns for each player or type 'back' to cancel.                       ");
                                    input = Main.scanner.nextLine();
                                    switch(input) {
                                        case "back":
                                            break;
                                        default:
                                            try {
                                                numberOfPawnsForEachPlayer = Integer.parseInt(input);
                                                Utility.findTheSizeOfTheDeploymentTree(dimensionsOfTheGame,numberOfObstacles,numberOfPawnsForEachPlayer);
                                            }catch (Exception e){

                                            }
                                            break;
                                    }

                                }
                                catch (Exception e){

                                }
                                break;
                        }
                    }
                    catch (Exception e){

                    }
                    break;
            }

        }
        while(!"back".equals(input));
    }
}
