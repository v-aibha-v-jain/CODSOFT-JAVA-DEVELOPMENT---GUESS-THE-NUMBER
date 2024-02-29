package Guess_the_number;

import java.util.Random;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int target = random.nextInt(101);
        int maxAttempts = 10;
        System.out.println("Enter your guess : ");
        int num = scanner.nextInt();
        boolean playAgain = true;

        while (playAgain) {
            if(num==target) {
            	System.out.println("Great you guessed it right!!! The number was "+target);
            	playAgain = false;
            }
            else {
            	if(num>target) {
            		System.out.println("The number you entered was too high!!");
            		System.out.println("Enter your guess : ");
            		num = scanner.nextInt();
            	}
            	else {
            		System.out.println("The number you entered was too low!!");
            		System.out.println("Enter your guess : ");
            		num = scanner.nextInt();
            	}
            	maxAttempts--;
            }
            if(maxAttempts==1) {
            	playAgain = false;
            	System.out.println("You failed to guess the number!!!");
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
