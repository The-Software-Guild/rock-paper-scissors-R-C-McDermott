
package com.rcmcdermott.rockpaperscissors;

import java.util.Random;
import java.util.Scanner;


public class RockPaperScissors {
    public static void main(String[] args) {
        // Initialising scanner and random objects
        Scanner inputReader = new Scanner(System.in);
        Random rand = new Random();
        
        // Alter minimum and maximum number of rounds here:
        final int MINIMUM_ROUNDS = 1;
        final int MAXIMUM_ROUNDS = 10;
        
        // Declaring variables
        int numberOfRounds;
        String userChoice;
        String computerChoice;
        String playAgain;
        // Initialising variables
        boolean run = true;
        int roundCounter = 1;
        int winCounter = 0;
        int loseCounter = 0;
        int drawCounter = 0;
        
        
        numberOfRounds = getNumberOfRounds(MINIMUM_ROUNDS, 
                                           MAXIMUM_ROUNDS, 
                                           inputReader);
        
        // Game loop
        while (run) {
            if (roundCounter <= numberOfRounds) {
                System.out.println("Round: " + roundCounter);
                
                // Loop to ensure correct value for choice is input
                boolean checkInput = true;
                do {
                    System.out.println("Please enter your choice: (r)ock, (p)aper or (s)cissors");
                    userChoice = inputReader.nextLine();
                    if (!(userChoice.equals("s") || userChoice.equals("r") || userChoice.equals("p"))) {
                        System.out.println("Invalid input, please try again.");
                    }
                    else {
                        checkInput = false;
                    }
                } while (checkInput);
      
                computerChoice = computerChoice(rand);
                
                // Parse choices to display on screen
                System.out.println();
                parseChoice("Player", userChoice);
                parseChoice("Computer", computerChoice);
                System.out.println();
                
                // Game conditions
                if (userChoice.equals(computerChoice)){
                    System.out.println("It's a draw!");
                    roundCounter++;
                    drawCounter++;
                }
                else if (userChoice.equals("r") && computerChoice.equals("p")) {
                    System.out.println("Computer has won this round!");
                    roundCounter++;
                    loseCounter++;
                }
                else if (userChoice.equals("r") && computerChoice.equals("s")) {
                    System.out.println("Player has won this round!");
                    roundCounter++;
                    winCounter++;
                }
                else if (userChoice.equals("s") && computerChoice.equals("r")) {
                    System.out.println("Computer has won this round!");
                    roundCounter++;
                    loseCounter++;
                }
                else if (userChoice.equals("s") && computerChoice.equals("p")) {
                    System.out.println("Player has won this round!");
                    roundCounter++;
                    winCounter++;
                }
                else if (userChoice.equals("p") && computerChoice.equals("s")) {
                    System.out.println("Computer has won this round!");
                    roundCounter++;
                    loseCounter++;
                }
                else if (userChoice.equals("p") && computerChoice.equals("r")) {
                    System.out.println("Player has won this round!");
                    roundCounter++;
                    winCounter++;
                }
            }
            
            // Executes if roundCounter exceeds numberOfRounds
            else {
                printStatsAndWinner(winCounter, drawCounter, loseCounter);
                System.out.println("Do you want to play again? (y/n)");
                playAgain = inputReader.nextLine();
                if (playAgain.equals("y")) {
                    roundCounter = 1;
                    winCounter = 0;
                    loseCounter = 0;
                    drawCounter = 0;
                    
                    numberOfRounds = getNumberOfRounds(MINIMUM_ROUNDS, 
                                                       MAXIMUM_ROUNDS, 
                                                       inputReader);  
                }
                else {
                    System.out.println("Thanks for playing!");
                    run = false;
                }
                
            }
        }
    }
    
    // Method to create a random computer choice
    public static String computerChoice(Random rand) {
        int randomChoice = rand.nextInt(3);
        String result = "";
        switch (randomChoice) {
            case 0: result += 'r';
                    break;
            case 1: result += 's';
                    break;
            case 2: result += 'p';
                    break;
        }
        return result;
    }
    
    // Method to display game statistics and determine the winner
    public static void printStatsAndWinner(int winCounter, int drawCounter, int loseCounter) {
        System.out.println();
        System.out.println("~~~~~~ Game Statistics ~~~~~~");
        System.out.println("Player win count: " + winCounter);
        System.out.println("Computer win count: " + loseCounter);
        System.out.println("Number of draws: " + drawCounter);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        if (winCounter > loseCounter) {
            System.out.println("Player has won!!");
        }
        else if (winCounter < loseCounter) {
            System.out.println("Computer has won!!");
        }
        else if (winCounter == loseCounter) {
            System.out.println("It's a draw!!");
        }
    }
    
    // Method to convert single character choices to more readable choices
    public static void parseChoice(String player, String input) {
        String result = "";
        switch (input) {
            case "r":
                result = "Rock";
                break;
            case "p":
                result = "Paper";
                break;
            case "s":
                result = "Scissors";
                break;
        }
        System.out.println(player + " has chosen " + result);
    }
    
    // Method to prompt user input for number of rounds to be played
    public static int getNumberOfRounds(int minimumRounds, int maximumRounds,
                                        Scanner inputReader) {
        int numberOfRounds;
        do {
            System.out.print("How many rounds would you like to play? ");
            System.out.print("(" + minimumRounds + "-" + maximumRounds + ")");
            String inputRounds = inputReader.nextLine();
            numberOfRounds = Integer.parseInt(inputRounds);
            if (numberOfRounds < minimumRounds || numberOfRounds > maximumRounds) {
                System.out.println("Your input is out of range!");
            }
        } while (numberOfRounds < minimumRounds || numberOfRounds > maximumRounds);
        
        return numberOfRounds;
    }
}
