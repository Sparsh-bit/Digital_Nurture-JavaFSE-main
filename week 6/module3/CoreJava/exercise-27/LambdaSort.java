import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaSort {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Zebra");
        list.add("Apple");
        list.add("Mango");
        list.add("Banana");
        
        // Sorting using a lambda expression based on string length, then alphabetically
        Collections.sort(list, (s1, s2) -> s1.compareTo(s2));
        
        System.out.println("Sorted List: " + list);
    }
}