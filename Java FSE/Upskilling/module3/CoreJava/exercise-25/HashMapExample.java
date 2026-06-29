import java.util.HashMap;
import java.util.Scanner;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        
        // Add some default entries
        studentMap.put(101, "Alice");
        studentMap.put(102, "Bob");
        
        System.out.print("Enter a new Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        
        studentMap.put(id, name);
        
        System.out.print("\nEnter an ID to look up: ");
        int lookupId = sc.nextInt();
        
        if (studentMap.containsKey(lookupId)) {
            System.out.println("Student found: " + studentMap.get(lookupId));
        } else {
            System.out.println("No student found with ID " + lookupId);
        }
        sc.close();
    }
}