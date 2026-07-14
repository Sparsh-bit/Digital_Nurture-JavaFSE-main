public class PatternSwitch {
    
    // Pattern matching for switch (Java 21)
    public static void checkType(Object obj) {
        String result = switch (obj) {
            case Integer i -> "It's an Integer with value: " + i;
            case String s -> "It's a String of length: " + s.length();
            case Double d -> "It's a Double with value: " + d;
            default -> "Unknown type";
        };
        System.out.println(result);
    }

    public static void main(String[] args) {
        checkType(42);
        checkType("Hello World");
        checkType(3.14);
        checkType(new Object());
    }
}