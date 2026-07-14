import java.lang.reflect.Method;

class DummyTarget {
    public void sayHello(String name) {
        System.out.println("Hello dynamically, " + name + "!");
    }
}

public class ReflectionDemo {
    public static void main(String[] args) {
        try {
            // Load class and create instance dynamically
            Class<?> clazz = Class.forName("DummyTarget");
            Object obj = clazz.getDeclaredConstructor().newInstance();
            
            // Look up method and invoke it
            Method method = clazz.getDeclaredMethod("sayHello", String.class);
            
            System.out.println("Found method: " + method.getName());
            
            method.invoke(obj, "Reflection");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}