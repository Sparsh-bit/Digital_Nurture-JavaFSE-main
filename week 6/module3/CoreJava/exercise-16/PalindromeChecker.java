import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String original = sc.nextLine();
        
        // Remove non-alphanumeric and make lowercase
        String clean = original.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        String reversed = new StringBuilder(clean).reverse().toString();
        
        if (clean.equals(reversed)) {
            System.out.println("Yes, it's a palindrome!");
        } else {
            System.out.println("No, it is not a palindrome.");
        }
        sc.close();
    }
}