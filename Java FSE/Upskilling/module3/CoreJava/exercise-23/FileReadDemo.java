import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReadDemo {
    public static void main(String[] args) {
        try {
            File myFile = new File("../exercise-22/output.txt");
            if (!myFile.exists()) {
                myFile = new File("output.txt"); // Fallback if run locally
            }
            Scanner reader = new Scanner(myFile);
            
            System.out.println("Reading contents:");
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                System.out.println(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found! Make sure you ran Exercise 22 first.");
        }
    }
}