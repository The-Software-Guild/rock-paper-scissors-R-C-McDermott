
package com.rcmcdermott.rockpaperscissors;

import java.util.Random;
import java.util.Scanner;


public class RockPaperScissors {
    public static void main(String[] args) {
        // Initialising scanner and random objects
        Scanner inputReader = new Scanner(System.in);
        Random rand = new Random();
        
        // Alter minimum and maximum number of rounds here:
        int minimumRounds = 1;
        int maximumRounds = 10;
        
        // Declaring variables
        String inputRounds;
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
        
        
        do {
            System.out.print("How many rounds would you like to play? ");
            System.out.print("(" + minimumRounds + "-" + maximumRounds + ")");
            inputRounds = inputReader.nextLine();
            numberOfRounds = Integer.parseInt(inputRounds);
            if (numberOfRounds < minimumRounds || numberOfRounds > maximumRounds) {
                System.out.println("Your input is out of range!");
            }
        } while (numberOfRounds < minimumRounds || numberOfRounds > maximumRounds);
        
        // Game loop
        while (run) {
            if (roundCounter != numberOfRounds) {
                System.out.println("Round: " + roundCounter);
                
                System.out.println("Please enter your choice: (r)ock, (p)aper or (s)cissors");
                userChoice = inputReader.nextLine();
      
                computerChoice = computerChoice(rand);
                if (userChoice.equals(computerChoice)){
                    System.out.println("It's a draw!");
                    roundCounter++;
                    drawCounter++;
                }
                else if (userChoice.equals("r") && computerChoice.equals("p")) {
                    System.out.println("You lose!");
                    roundCounter++;
                    loseCounter++;
                }
                else if (userChoice.equals("r") && computerChoice.equals("s")) {
                    System.out.println("You win!");
                    roundCounter++;
                    winCounter++;
                }
                else if (userChoice.equals("s") && computerChoice.equals("r")) {
                    System.out.println("You lose!");
                    roundCounter++;
                    loseCounter++;
                }
                else if (userChoice.equals("s") && computerChoice.equals("p")) {
                    System.out.println("You win!");
                    roundCounter++;
                    winCounter++;
                }
                else if (userChoice.equals("p") && computerChoice.equals("s")) {
                    System.out.println("You lose!");
                    roundCounter++;
                    loseCounter++;
                }
                else if (userChoice.equals("p") && computerChoice.equals("r")) {
                    System.out.println("You win!");
                    roundCounter++;
                    winCounter++;
                }
            }
            else {
                printStatsAndWinner(winCounter, drawCounter, loseCounter);
                System.out.println("Do you want to play again? (y/n)");
                playAgain = inputReader.nextLine();
                if (playAgain.equals("y")) {
                    roundCounter = 1;
                    winCounter = 0;
                    loseCounter = 0;
                    drawCounter = 0;
                    
                    do {
                        System.out.print("How many rounds would you like to play? ");
                        System.out.print("(" + minimumRounds + "-" + maximumRounds + ")");
                        inputRounds = inputReader.nextLine();
                        numberOfRounds = Integer.parseInt(inputRounds);
                        if (numberOfRounds < minimumRounds || numberOfRounds > maximumRounds) {
                            System.out.println("Your input is out of range!");
                        }
                    } while (numberOfRounds < minimumRounds || numberOfRounds > maximumRounds);  
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
    
    public static void printStatsAndWinner(int winCounter, int drawCounter, int loseCounter) {
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
    
}
