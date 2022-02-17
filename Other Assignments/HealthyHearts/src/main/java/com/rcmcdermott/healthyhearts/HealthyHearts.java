
package com.rcmcdermott.healthyhearts;

import java.util.Scanner;

public class HealthyHearts {
    public  static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        
        // Variables
        String userInput;
        int age;
        
        System.out.println("Enter your age: ");
        userInput = inputReader.nextLine();
        age = Integer.parseInt(userInput);
        
        int minRange = (int)(0.5 * (220 - age));
        int maxRange = (int)(0.85 * (220 - age));
        
        System.out.println("Your max heart rate is: " + (220 - age) + " BPM");
        System.out.println("Your target HR Zone is " 
                            + minRange + "-" 
                            + maxRange +" BPM");
    }
}
