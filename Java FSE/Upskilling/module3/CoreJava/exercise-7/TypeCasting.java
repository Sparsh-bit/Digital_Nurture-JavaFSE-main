public class TypeCasting {
    public static void main(String[] args) {
        // Double to int (Narrowing)
        double myDouble = 9.99;
        int myInt = (int) myDouble; // explicit cast required
        
        System.out.println("Original double: " + myDouble);
        System.out.println("Casted to int (truncated): " + myInt);
        
        // Int to double (Widening)
        int anotherInt = 15;
        double anotherDouble = anotherInt; // implicit cast
        
        System.out.println("Original int: " + anotherInt);
        System.out.println("Casted to double: " + anotherDouble);
    }
}