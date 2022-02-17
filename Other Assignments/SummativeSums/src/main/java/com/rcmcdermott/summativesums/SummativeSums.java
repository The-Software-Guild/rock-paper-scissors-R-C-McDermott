
package com.rcmcdermott.summativesums;


public class SummativeSums {
    public static void main(String[] args) {
        // Variables
        int[] arrayOne = new int[] { 1, 90, -33, -55, 67, -16, 28, -55, 15 };
        int[] arrayTwo = new int[] { 999, -60, -77, 14, 160, 301 };
        int[] arrayThree = new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 
                                     90, 100, 110, 120, 130, 140, 150, 
                                     160, 170, 180, 190, 200, -99 };
                
        
        sumArray(arrayOne, "First array");
        sumArray(arrayTwo, "Second array");
        sumArray(arrayThree, "Third array");
    }
    
    public static void sumArray(int[] array, String arrayName) {
        int totalSum = 0;
        for(int i = 0; i < array.length; i++) {
            totalSum += array[i];
        }
        System.out.println("Sum of " + arrayName + ": " + totalSum);
    }
}
