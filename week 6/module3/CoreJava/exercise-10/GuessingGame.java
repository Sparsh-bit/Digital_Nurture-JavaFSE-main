import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int target = rand.nextInt(100) + 1; // 1 to 100
        
        Scanner sc = new Scanner(System.in);
        int guess = 0;
        
        System.out.println("I'm thinking of a number between 1 and 100. Guess it!");
        
        while (guess != target) {
            System.out.print("Your guess: ");
            guess = sc.nextInt();
            
            if (guess > target) {
                System.out.println("Too high!");
            } else if (guess < target) {
                System.out.println("Too low!");
            } else {
                System.out.println("You got it! The number was " + target);
            }
        }
        sc.close();
    }
}