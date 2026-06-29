import java.util.List;

// Record keyword creates immutable data carrier (Java 16+)
record Person(String name, int age) {}

public class RecordDemo {
    public static void main(String[] args) {
        Person p1 = new Person("Alice", 25);
        Person p2 = new Person("Bob", 16);
        Person p3 = new Person("Charlie", 30);
        
        System.out.println("Person 1: " + p1); // Auto-generated toString()
        
        List<Person> people = List.of(p1, p2, p3);
        
        System.out.println("\nAdults:");
        people.stream()
            .filter(p -> p.age() >= 18) // Auto-generated accessor methods
            .forEach(System.out::println);
    }
}