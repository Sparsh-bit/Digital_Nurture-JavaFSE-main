public class MethodOverloading {
    
    // Add two ints
    public static int add(int a, int b) {
        return a + b;
    }
    
    // Add two doubles
    public static double add(double a, double b) {
        return a + b;
    }
    
    // Add three ints
    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        System.out.println("Add 2 ints (5+10): " + add(5, 10));
        System.out.println("Add 2 doubles (5.5+2.2): " + add(5.5, 2.2));
        System.out.println("Add 3 ints (1+2+3): " + add(1, 2, 3));
    }
}