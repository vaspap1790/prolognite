package com.athtech;

import com.athtech.model.Position;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {

//        System.out.println("*****************************************************************************************");
//        System.out.println("** 06/04/2020                                                      Athens Tech College **");
//        System.out.println("**                                                                                     **");
//        System.out.println("**                                                                                     **");
//        System.out.println("**             - Artificial Intelligence Techniques Coursework Handout 1 -             **");
//        System.out.println("**                                                                                     **");
//        System.out.println("**                             Papadimitrakopoulos Vasilis                             **");
//        System.out.println("**                                                                                     **");
//        System.out.println("*****************************************************************************************");
//
//        Menu.mainMenu();

        int dimensionsOfTheGame = 5;
        int numberOfObstacles = 5;

        List<ArrayList<Position>> board = Prolognite.generateBoard(dimensionsOfTheGame);

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

        Prolognite.generateState(board,obstacleRowsT1,obstacleColumnsT1,whiteRowsT1,whiteColumnsT1,strengths,blackRowsT1,blackColumnsT1,strengths);
//        Prolognite.generateState(board,obstacleRowsT2,obstacleColumnsT2,whiteRowsT2,whiteColumnsT2,strengths,blackRowsT2,blackColumnsT2,strengthsT2black);
//        Prolognite.generateState(board,obstacleRowsT3,obstacleColumnsT3,whiteRowsT3,whiteColumnsT3,strengths,blackRowsT3,blackColumnsT3,strengthsT3black);
        Utility.printBoard(board);

        Utility.heuristicForBlack(board,"black");
    }
}
