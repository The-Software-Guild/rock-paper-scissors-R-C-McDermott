
package com.rcmcdermott.doggenetics;

import java.util.Random;
import java.util.Scanner;


public class DogGenetics {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner inputReader = new Scanner(System.in);
        
        // Variables
        int newPercentage = 100;
        
        // Arrays to hold data
        String[] percentages = new String[5];
        String[] dogs = new String[] {"German Shepard", "Poodle", "Pug",
                                      "Bulldog", "Husky"};
        String[][] genetics = new String[5][2];
        
        // Main script
        inputPrompt(inputReader);
        
        System.out.println("Your dog's genetics results:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        printOutput(rand, percentages, dogs, genetics, newPercentage);
    }
    
    // Method to produce random percentages and display output
    public static void printOutput(Random rand, String[] percentages,
                                   String[] dogs, String[][] genetics,
                                   int newPercentage){
        for (int i = 0; i < 5; i++) {
            if (i < 4) {
                int randomNum = rand.nextInt(newPercentage);
                percentages[i] = Integer.toString(randomNum);
                newPercentage -= randomNum;
            }
            else {
                percentages[i] = Integer.toString(newPercentage);                
            }
            genetics[i][0] = dogs[i];
            genetics[i][1] = percentages[i];
            System.out.println(genetics[i][1] + "% - " + genetics[i][0]);
        }
    }
    
    // Method to prompt user for input
    public static void inputPrompt(Scanner inputReader) {
        System.out.println("Please enter your dog's name: ");
        String dogName = inputReader.nextLine();
        System.out.println("Well then, I have this highly reliable report on "
                         + dogName + "'s prestigious "
                         + "background right here.\n" 
                         + "\n");  
    }
}
