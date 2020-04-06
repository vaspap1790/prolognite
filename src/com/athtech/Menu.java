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
            System.out.println("-For Question 1 of the Handout, type ..................................................'1'-");
            System.out.println("-For Question 2 of the Handout, type ..................................................'2'-");
            System.out.println("-If you want to end the application, type .............................................'0'-");
            System.out.println("\n");
            System.out.println("*******************************************************************************************");

            input = Main.scanner.nextLine();

            switch(input) {
                case "0":
                    break;
                case "1":
                    question1();
                    break;
                case "2":
                    question2();
                    break;
                default:
                    System.out.println("\nInvalid input. Try again.\n");
            }
        } while(!"0".equals(input));

        System.out.println("\n******************************* You ended the application *********************************");
    }

    public static void question1() throws ParseException {

        String input;

        do {
        System.out.println("\n");
        System.out.println("*******************************************************************************************");
        System.out.println("**                                   -- QUESTION 1 --                                    **");
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

    public static void question2() throws ParseException {

        String input;

        do {
        System.out.println("\n");
        System.out.println("*******************************************************************************************");
        System.out.println("**                                 -- QUESTION 2 --                                      **");
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
}
