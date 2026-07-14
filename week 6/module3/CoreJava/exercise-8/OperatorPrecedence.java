public class OperatorPrecedence {
    public static void main(String[] args) {
        int result = 10 + 5 * 2;
        System.out.println("Result of 10 + 5 * 2 is: " + result);
        System.out.println("Explanation: Multiplication (*) has higher precedence than addition (+), so 5*2 is evaluated first (10), then 10+10 = 20.");
        
        int result2 = (10 + 5) * 2;
        System.out.println("Result of (10 + 5) * 2 is: " + result2);
        System.out.println("Explanation: Parentheses override precedence, so 10+5 is evaluated first (15), then 15*2 = 30.");
    }
}